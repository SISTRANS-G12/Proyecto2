package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;


import uniandes.edu.co.proyecto.modelo.CheckOut;
import uniandes.edu.co.proyecto.repositorio.CheckOutRepository;

@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;

    //CREATE
    @GetMapping("/checkouts/new")
    public String checkOutForm(Model model){
        model.addAttribute("checkOut", new CheckOut());
        return "checkOutNuevo";
    }

    @PostMapping("/checkouts/new/save")
    public String checkOutGuardar(@ModelAttribute CheckOut checkOut){
        checkOutRepository.insertarCheckOut(checkOut.getReservas_id().getId());
        return "redirect:/checkouts";
    }
    
    //READ
    @GetMapping("/checkouts")
    public String checkOuts(Model model){
        model.addAttribute("checkouts", checkOutRepository.darCheckOuts());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/checkouts/{id}/edit")
    public String checkOutEditarForm(@PathVariable("id") int id, Model model){
        CheckOut checkOut = checkOutRepository.darCheckOut(id);
        if(checkOut != null){
            model.addAttribute("checkOut", checkOut);
            return "checkOutEditar";
        } else {
            return "redirect:/checkouts";
        }
    }

    @PostMapping("/checkouts/{id}/edit/save")
    public String checkOutEditarGuardar(@PathVariable("id") int id, @ModelAttribute CheckOut checkOut){
        checkOutRepository.actualizarCheckOut(id,
                                              checkOut.getReservas_id().getId());
        return "redirect:/checkOuts";
    }

    //DELETE
    @GetMapping("/checkouts/{id}/delete")
    public String checkOutEliminar(@PathVariable("id")int id){
        checkOutRepository.eliminarCheckOut(id);
        return "redirect:/checkouts";
    }
}