package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    //CREATE
    @GetMapping("/tiposUsuario/new")
    public String tipoUsuarioForm(Model model){
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tipoUsuarioNuevo";
    }

    @PostMapping("/tiposUsuario/new/save")
    public String tiposUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario){
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getNombre());
        return "redirect:/tiposUsuario";
    }

    //READ
    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model){
        model.addAttribute("tiposUsuario", tipoUsuarioRepository.darTiposUsuario());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/tiposUsuario/{id}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("id") int id, Model model){
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if(tipoUsuario != null){
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tipoUsuarioEditar";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @PostMapping("/tiposUsuario/{id}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoUsuario tipoUsuario){
        tipoUsuarioRepository.actualizarTipoUsuario(id,
                                                    tipoUsuario.getNombre());
        return "redirect:/tiposUsuario";
    }

    //DELETE
    @GetMapping("/tiposUsuario/{id}/delete")
    public String tipoUsuarioEliminar(@PathVariable("id") int id){
        tipoUsuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/tiposUsuario";
    }

    
}
