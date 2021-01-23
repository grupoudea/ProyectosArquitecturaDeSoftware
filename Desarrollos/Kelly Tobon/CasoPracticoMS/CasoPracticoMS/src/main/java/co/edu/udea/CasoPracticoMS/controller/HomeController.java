package co.edu.udea.CasoPracticoMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

    @GetMapping(value = "/")
    public String mostrarSaludo(){
        return "Hola Kelly";
    }

    @GetMapping(value = "/hello")
    public String mostrarMensaje(){
        return "Hola profe, cómo estás...";
    }
}
