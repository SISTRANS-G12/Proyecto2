package uniandes.edu.co.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
}
