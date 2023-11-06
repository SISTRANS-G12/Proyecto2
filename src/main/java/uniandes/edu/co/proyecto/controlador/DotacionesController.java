package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.Dotacion;
import uniandes.edu.co.proyecto.repositorio.DotacionRepository;

@Controller
public class DotacionesController {
    @Autowired
    private DotacionRepository dotacionRepository;

    //CREATE
    @GetMapping("/dotaciones/new")
    public String dotacionForm(Model model){
        model.addAttribute("dotacion", new Dotacion());
        return "dotacionNuevo";
    }

    @PostMapping("/dotaciones/new/save")
    public String dotacionGuardar(@ModelAttribute Dotacion dotacion){
        dotacionRepository.insertarDotacion(dotacion.getNombre(),
                                            dotacion.getPrecio());
        return "redirect:/dotaciones";
    }

    //READ
    @GetMapping("/dotaciones")
    public String dotaciones(Model model){
        model.addAttribute("dotaciones", dotacionRepository.darDotaciones());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/dotaciones/{id}/edit")
    public String dotacionEditarForm(@PathVariable("id") int id, Model model){
        Dotacion dotacion = dotacionRepository.darDotacion(id);
        if(dotacion != null){
            model.addAttribute("dotacion", dotacion);
            return "dotacionEditar";
        } else {
            return "redirect:/dotaciones";
        }
    }

    @PostMapping("/dotaciones/{id}/edit/save")
    public String dotacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Dotacion dotacion){
        dotacionRepository.actualizarDotacion(id, 
                                              dotacion.getNombre(),
                                              dotacion.getPrecio());
        return "redirect:/dotaciones";
    }

    //DELETE
    @GetMapping("/dotaciones/{id}/delete")
    public String dotacionEliminar(@PathVariable("id") int id){
        dotacionRepository.eliminarDotacion(id);
        return "redirect:/dotaciones";
    }
}
