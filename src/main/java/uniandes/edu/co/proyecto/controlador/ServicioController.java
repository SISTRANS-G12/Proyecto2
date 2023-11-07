package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.LocalRepository;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;

@Controller
public class ServicioController {
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    //CREATE 
    @GetMapping("/servicios/new")
    public String servicioForm(Model model){
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("locales", localRepository.darLocales());
        model.addAttribute("tipos", tipoServicioRepository.darTiposServicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioRepository(@ModelAttribute Servicio servicio){
        servicioRepository.insertarServicio(servicio.getPrecio(),
                                            servicio.getNombre(),
                                            servicio.getDescripcion(),
                                            servicio.getIncluido(),
                                            servicio.getCaracteristica(),
                                            servicio.getTiposServicio_id().getId(),
                                            servicio.getLocales_id().getId());
        return "redirect:/servicios";
    }

    //READ
    @GetMapping("/servicios")
    public String servicios(Model model){
        model.addAttribute("servicios", servicioRepository.darServicios());
        return "servicios";
    }

    //UPDATE
    @GetMapping("/servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") int id, Model model){
        Servicio servicio = servicioRepository.darServicio(id);
        if(servicio != null){
            model.addAttribute("servicio", servicio);
            model.addAttribute("locales", localRepository.darLocales());
            model.addAttribute("tipos", tipoServicioRepository.darTiposServicio());
            return "servicioEditar";
        } else {
            return "redirect:/servicio";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Servicio servicio){
        servicioRepository.actualizarServicio(id,
                                              servicio.getPrecio(),
                                              servicio.getNombre(),
                                              servicio.getDescripcion(),
                                              servicio.getIncluido(),
                                              servicio.getCaracteristica(),
                                              servicio.getTiposServicio_id().getId(),
                                              servicio.getLocales_id().getId());
        return "redirect:/servicios";
    }

    //DELETE
    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") int id){
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicios";
    }
}
