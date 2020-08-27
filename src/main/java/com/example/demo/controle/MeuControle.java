package com.example.demo.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuControle {
    
    @GetMapping("/cliente")
    public String cliente() {
        return "xxxx";
    }


    @GetMapping("/cliente/{codigo}")
    public String Cliente(@PathVariable int codigo){
        
        
        return "CLIENTES " + codigo;
    }
}