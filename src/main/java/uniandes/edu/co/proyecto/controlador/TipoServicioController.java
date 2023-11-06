package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.TipoServicio;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;

@Controller
public class TipoServicioController {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    //CREATE
    @GetMapping("/tiposservicio/new")
    public String tipoServicioForm(Model model){
        model.addAttribute("tipoServicio", new TipoServicio());
        return "tipoServicioNuevo";
    }

    @PostMapping("/tiposservicio/new/save")
    public String tipoServicioGuardar(@ModelAttribute TipoServicio tipoServicio){
        tipoServicioRepository.insertarTipoServicio(tipoServicio.getNombre());
        return "redirect:/tiposservicio";
    }
    
    //READ
    @GetMapping("/tiposservicio")
    public String tiposServicio(Model model){
        model.addAttribute("tiposServicio", tipoServicioRepository.darTiposServicio());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/tiposservicio/{id}/edit")
    public String tipoServicioEditarForm(@PathVariable("id") int id, Model model){
        TipoServicio tipoServicio = tipoServicioRepository.darTipoServicio(id);
        if(tipoServicio != null){
            model.addAttribute("tipoServicio", tipoServicio);
            return "tipoServicioEditar";
        } else {
            return "redirect:/tiposservicio";
        }
    }

    @PostMapping("/tiposservicio/{id}/edit/save")
    public String tipoServicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoServicio tipoServicio){
        tipoServicioRepository.actualizarTipoServicio(id,
                                                      tipoServicio.getNombre());
        return "redirect:/tiposservicio";
    }
    
    //DELETE
    @GetMapping("/tiposservicio/{id}/delete")
    public String tipoServicioEliminar(@PathVariable("id") int id){
        tipoServicioRepository.eliminarTipoServicio(id);
        return "redirect:/tiposservicio";
    }
}
