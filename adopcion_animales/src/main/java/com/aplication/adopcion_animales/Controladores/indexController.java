package com.aplication.adopcion_animales.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/index")
    public String hello(){
        return "main";
    }

}
