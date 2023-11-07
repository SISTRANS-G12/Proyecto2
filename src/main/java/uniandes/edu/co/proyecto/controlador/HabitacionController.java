package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionRepository habitacionRepository;
    
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    //CREATE
    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model){
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("tipos", tipoHabitacionRepository.darTiposHabitacion());
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion){
        habitacionRepository.insertarHabitacion(habitacion.getDisponible(),
                                                habitacion.getCuenta(),
                                                habitacion.getTiposHabitacion_id().getId());
        return "redirect:/habitaciones";
    }

    //READ
    @GetMapping("/habitaciones")
    public String habitaciones(Model model){
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") int id, Model model){
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if(habitacion != null){
            model.addAttribute("habitacion", habitacion);
            model.addAttribute("tipos", tipoHabitacionRepository.darTiposHabitacion());
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Habitacion habitacion){
        habitacionRepository.actualizarHabitacion(id, 
                                                  habitacion.getDisponible(),
                                                  habitacion.getCuenta(),
                                                  habitacion.getTiposHabitacion_id().getId());
        return "redirect:/habitaciones";
    }

    //DELETE
    @GetMapping("/habitaciones/{id}/delte")
    public String habitacionEliminar(@PathVariable("id") int id){
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }
}
