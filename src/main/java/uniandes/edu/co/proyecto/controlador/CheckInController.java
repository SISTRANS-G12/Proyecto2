package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.repositorio.CheckInRepository;

@Controller
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    //CREATE
    @GetMapping("/checkins/new")
    public String checkInForm(Model model){
        model.addAttribute("checkin", new CheckIn());
        return "checkInNuevo";
    }

    @PostMapping("/checkins/new/save")
    public String checkInGuardar(@ModelAttribute CheckIn checkIn){
        checkInRepository.insertarCheckIn(checkIn.getReservas_id().getId());
        return "redirect:/checkins";
    }

    //READ
    @GetMapping("/checkins")
    public String checkIns(Model model){
        model.addAttribute("checkins", checkInRepository.darCheckIns());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/checkins/{id}/edit")
    public String checkInEditarForm(@PathVariable("id") int id, Model model){
        CheckIn checkIn = checkInRepository.darCheckIn(id);
        if(checkIn != null){
            model.addAttribute("checkIn", checkIn);
            return "checkInEditar";
        } else {
            return "redirect:/checkIns";
        }
    }

    @PostMapping("/checkins/{id}/edit/save")
    public String checkInEditarGuardar(@PathVariable("id") int id, @ModelAttribute CheckIn checkIn){
        checkInRepository.actualizarCheckIn(id,
                                            checkIn.getReservas_id().getId());
        return "redirect:/checkins";
    }

    //DELETE
    @GetMapping("/checkins/{id}/delete")
    public String checkInEliminar(@PathVariable("id") int id){
        checkInRepository.eliminarCheckIn(id);
        return "redirect:/checkins";
    }
}
