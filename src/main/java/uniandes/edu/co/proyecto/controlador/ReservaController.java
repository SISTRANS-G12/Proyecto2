package uniandes.edu.co.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@RestController
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    //CREATE
    @GetMapping("/reservas/new")
    public String reservaForm(Model model){
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva){
        reservaRepository.insertarReserva(reserva.getFecha_entrada(),
                                          reserva.getFecha_salida(),
                                          reserva.getNumero_personas(),
                                          reserva.getCheck_in(),
                                          reserva.getCheck_out(), 
                                          reserva.getPlanesConsumo_id().getId(),
                                          reserva.getHabitaciones_id().getId(), 
                                          reserva.getUsuarios_id().getId());
        return "redirect:/reservas";
    }

    //READ
    @GetMapping("/reservas")
    public String reservas(Model model){
        model.addAttribute("reservas", reservaRepository.darReservas());
        return model.toString();
    }

    //UPDATE
    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model){
        Reserva reserva = reservaRepository.darReserva(id);
        if(reserva != null){
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Reserva reserva){
        reservaRepository.actualizarReserva(id,
                                            reserva.getFecha_entrada(),
                                            reserva.getFecha_salida(),
                                            reserva.getNumero_personas(),
                                            reserva.getCheck_in(),
                                            reserva.getCheck_out(),
                                            reserva.getPlanesConsumo_id().getId(),
                                            reserva.getHabitaciones_id().getId(),
                                            reserva.getUsuarios_id().getId());
        return "redirect:/reservas";
    }

    //DELETE
    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id){
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";        
    }
    
}
