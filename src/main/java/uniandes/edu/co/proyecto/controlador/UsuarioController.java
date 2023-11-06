package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //CREATE
    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model){
        model.addAttribute("usuario, new Usuario()");
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getTipo_documento(),
                                          usuario.getNumero_documento(),
                                          usuario.getNombre(),
                                          usuario.getCorreo(),
                                          usuario.getTiposUsuario_id().getId());
        return "redirect:/usuarios";
    }

    //READ
    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model){
        Usuario usuario = usuarioRepository.darUsuario(id);
        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuario usuario){
        usuarioRepository.actualizarUsuario(id,
                                            usuario.getTipo_documento(),
                                            usuario.getNumero_documento(),
                                            usuario.getNombre(),
                                            usuario.getCorreo(),
                                            usuario.getTiposUsuario_id().getId());
        return "redirect:/usuarios";
    }

    //DELETE
    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id){
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
    
}
