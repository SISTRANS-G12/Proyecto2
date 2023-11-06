package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.ConsumoPK;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ConsumosController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired  
    private ServicioRepository servicioRepository;

    //CREATE
    @GetMapping("/consumos/new")
    public String consumoForm(Model model){
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        model.addAttribute("servicios", consumoRepository.darConsumos());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute("Habitaciones_id") int Habitaciones_id,
                                 @ModelAttribute("Servicios_id") int Servicios_id,
                                 @ModelAttribute("fecha_consumo") String fecha_consumo, 
                                 @ModelAttribute("fecha_reservacion") String fecha_reservacion,
                                 @ModelAttribute("empleado_registro") String empleado_registro) { 

        Habitacion habitacion = habitacionRepository.darHabitacion(Habitaciones_id);
        Servicio servicio = servicioRepository.darServicio(Servicios_id);
        ConsumoPK pk = new ConsumoPK(habitacion, servicio, fecha_consumo, fecha_reservacion, empleado_registro);
        Consumo consumo = new Consumo();
        consumo.setPk(pk);
        consumoRepository.insertarConsumo(consumo.getPk().getHabitaciones_id().getId(),
                                          consumo.getPk().getServicios_id().getId(),
                                          consumo.getPk().getFecha_consumo(),
                                          consumo.getPk().getFecha_reservacion(),
                                          consumo.getPk().getEmpleado_registro());

        return "redirect:/consumos";
    }

    //READ
    @GetMapping("/consumos")
    public String consumos(Model model){
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return model.toString();
    }



}
