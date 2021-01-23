package co.edu.udea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping(value="/hello")
    public String getMensaje(){
        return "Hola desde el mundo Spring Boot";
    }
}
