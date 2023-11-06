package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Local;
import uniandes.edu.co.proyecto.repositorio.LocalRepository;


@RestController
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    //CREATE
    @GetMapping("/locales/new")
    public String localForm(Model model){
        model.addAttribute("local", new Local());
        return "localNuevo";
    }

    @PostMapping("/locales/new/save")
    public String localGuardar(@ModelAttribute Local local){
        localRepository.insertarLocal(local.getCapacidad(),
                                      local.getOcupado());
        return "redirect:/locales";
    }
    
    //READ
    @GetMapping("/locales")
    public String locales(Model model){
        model.addAttribute("locales", localRepository.darLocales());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/locales/{id}/edit")
    public String localEditarForm(@PathVariable("id") int id, Model model){
        Local local = localRepository.darLocal(id);
        if(local != null){
            model.addAttribute("local", local);
            return "localEditar";
        } else {
            return "redirect:/locales";
        }
    }

    @PostMapping("/locales/{id}/edit/save")
    public String localEditarGuardar(@PathVariable("id") int id, @ModelAttribute Local local){
        localRepository.actualizarLocal(id, 
                                        local.getCapacidad(),
                                        local.getOcupado());
        return "redirect:/locales";
    }

    //DELETE
    @GetMapping("/locales/{id}/delete")
    public String localEliminar(@PathVariable("id") int id){
        localRepository.eliminarLocal(id);
        return "redirect:/locales";
    }
}
