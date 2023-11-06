package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    //CREATE 
    @GetMapping("/tiposhabitacion/new")
    public String tipoHabitacionForm(Model model){
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/tiposhabitacion/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion){
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getNombre(),
                                                        tipoHabitacion.getCapacidad(),
                                                        tipoHabitacion.getPrecio_noche());
        return "redirect:/tiposhabitacion";
    }
    
    //READ
    @GetMapping("/tiposhabitacion")
    public String reservas(Model model){
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/tiposhabitacion/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") int id, Model model){
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if(tipoHabitacion != null){
            model.addAttribute("tipoHabitaicon", tipoHabitacion);
            return "tipoHabitacionEditar";
        } else {
            return "redirect:/tiposhabitacion";
        }
    }

    @PostMapping("/tiposhabitacion/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoHabitacion tipoHabitacion){
        tipoHabitacionRepository.actualizarTipoHabitacion(id, 
                                                          tipoHabitacion.getNombre(),
                                                          tipoHabitacion.getCapacidad(),
                                                          tipoHabitacion.getPrecio_noche());
        return "redirect:/tiposhabitacion";
    }

    //DELETE
    @GetMapping("/tiposhabitacion/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") int id){
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tiposhabitacion";
    }
}
