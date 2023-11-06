package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@RestController
public class PlanConsumoController {
    
    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    //CREATE 
    @GetMapping("planesConsumo/new")
    public String planConsumoForm(Model model){
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/planesConsumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.insertarPlanConsumo(planConsumo.getDescripcion(),
                                                  planConsumo.getDescuento(),
                                                  planConsumo.getPrecio_fijo());
        return "redirect:/planesConsumo";                                    
    }

    //READ
    @GetMapping("/planesConsumo")
    public String planesConsumo(Model model){
        model.addAttribute("planesConsumo", planConsumoRepository.darPlanesConsumo());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/planesConsumo/{id}/edit")
    public String planConsumoEditarForm(@PathVariable("id") int id, Model model){
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo(id);
        if(planConsumo != null){
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        } else {
            return "redirect:/planesConsumo";
        }
    }

    @PostMapping("/planesConsumo/{id}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("id") int id, @ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.actualizarPlanConsumo(id,
                                                    planConsumo.getDescripcion(),
                                                    planConsumo.getDescuento(),
                                                    planConsumo.getPrecio_fijo());
        return "redirect:/planesConsumo";
    }

    //DELETE
    @GetMapping("/planesConsumo/{id}/delete")
    public String planConsumoEliminar(@PathVariable("id") int id){
        planConsumoRepository.eliminarPlanConsumo(id);
        return "redirect:/planesConsumo";        
    }

    
}
