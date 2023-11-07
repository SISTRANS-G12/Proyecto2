package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller
public class PlanConsumoController {
    
    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    //CREATE 
    @GetMapping("planesconsumo/new")
    public String planConsumoForm(Model model){
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/planesconsumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.insertarPlanConsumo(planConsumo.getDescripcion(),
                                                  planConsumo.getDescuento(),
                                                  planConsumo.getPrecio_fijo());
        return "redirect:/planesconsumo";                                    
    }

    //READ
    @GetMapping("/planesconsumo")
    public String planesConsumo(Model model){
        model.addAttribute("planesConsumo", planConsumoRepository.darPlanesConsumo());
        return "planesConsumo";
    }

    //UPDATE
    @GetMapping("/planesconsumo/{id}/edit")
    public String planConsumoEditarForm(@PathVariable("id") int id, Model model){
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo(id);
        if(planConsumo != null){
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        } else {
            return "redirect:/planesconsumo";
        }
    }

    @PostMapping("/planesconsumo/{id}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("id") int id, @ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.actualizarPlanConsumo(id,
                                                    planConsumo.getDescripcion(),
                                                    planConsumo.getDescuento(),
                                                    planConsumo.getPrecio_fijo());
        return "redirect:/planesconsumo";
    }

    //DELETE
    @GetMapping("/planesconsumo/{id}/delete")
    public String planConsumoEliminar(@PathVariable("id") int id){
        planConsumoRepository.eliminarPlanConsumo(id);
        return "redirect:/planesconsumo";        
    }

    
}
