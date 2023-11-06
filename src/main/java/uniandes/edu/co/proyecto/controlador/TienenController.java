package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Tienen;
import uniandes.edu.co.proyecto.modelo.TienenPK;
import uniandes.edu.co.proyecto.modelo.Dotacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TienenRepository;
import uniandes.edu.co.proyecto.repositorio.DotacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@RestController
public class TienenController {

    @Autowired
    private TienenRepository tienenRepository;

    @Autowired
    private DotacionRepository dotacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    //CREATE
    @GetMapping("/tienen/new")
    public String tienenForm(Model model){
        model.addAttribute("dotaciones", dotacionRepository.darDotaciones());
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return "tienenNuevo";
    }

    @PostMapping("/tienen/new/save")
    public String tienenGuardar(@ModelAttribute("Dotaciones_id") int Dotaciones_id,
                                @ModelAttribute("TiposHabitacion_id") int TiposHabitacion_id){
        Dotacion dotacion = dotacionRepository.darDotacion(Dotaciones_id);
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(TiposHabitacion_id);
        TienenPK pk = new TienenPK(dotacion, tipoHabitacion);
        Tienen tienen = new Tienen();
        tienen.setPk(pk);
        tienenRepository.insertarTienen(tienen.getPk().getDotaciones_id().getId(),
                                        tienen.getPk().getTiposHabitacion_id().getId());
        return "redirect:/tienen";
    }

    //READ
    @GetMapping("/tienen")
    public String tienen(Model model){
        model.addAttribute("tienen", tienenRepository.darTienenTodos());
        return model.toString();
    }
}