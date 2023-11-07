package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired  
    private ServicioRepository servicioRepository;

    //CREATE
    @GetMapping("/consumos/new")
    public String consumoForm(Model model){
        model.addAttribute("consumo", new Consumo());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        model.addAttribute("servicios", servicioRepository.darServicios());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo) { 
        consumoRepository.insertarConsumo(consumo.getHabitaciones_id().getId(),
                                          consumo.getServicios_id().getId(),
                                          consumo.getFecha_consumo(),
                                          consumo.getFecha_reservacion(),
                                          consumo.getEmpleado_registro());

        return "redirect:/consumos";
    }

    //READ
    @GetMapping("/consumos")
    public String consumos(Model model){
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "consumos";
    }

    //UPDATE
    @GetMapping("/consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable("id") long id, Model model){
        Consumo consumo = consumoRepository.darConsumo(id);
        if(consumo != null){
            model.addAttribute("consumo", consumo);
            model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
            model.addAttribute("servicios", servicioRepository.darServicios());
            return "consumoEditar";
        } else{
            return "redirect:/consumos";
        }
    }

    @PostMapping("/consumos/{id}/edit/save")
    public String consumoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Consumo consumo){
        consumoRepository.actualizarConsumo(id,
                                            consumo.getHabitaciones_id().getId(),
                                            consumo.getServicios_id().getId(),
                                            consumo.getFecha_consumo(),
                                            consumo.getFecha_reservacion(),
                                            consumo.getEmpleado_registro());
        return "redirect:/consumos";
    }

    //DELETE
    @GetMapping("/consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") int id){
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos";
    }



}
