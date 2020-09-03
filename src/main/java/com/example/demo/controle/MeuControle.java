package com.example.demo.controle;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MeuControle {
    
    List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.codigo = 1;
        c1.nome = "Jose";
        c1.endereco = "Rux X, 99";
        c1.saldo = 100.345;

        c2.codigo = 2;
        c2.nome = "Maria";
        c2.endereco = "Rux Y, 92";
        c2.saldo = 123;

        c3.codigo = 3;
        c3.nome = "Mario";
        c3.endereco = "Rux H, 23";
        c3.saldo = 1230;

        clientes = Arrays.asList(c1, c2, c3);
    }

    @GetMapping("/clientes")
    public List<Cliente> cliente() {
        return clientes;
    }


    @GetMapping("/clientes/{codigo}")
    public Cliente Cliente(@PathVariable int codigo){
        for(Cliente i : clientes){
            if(i.codigo == codigo){
                return i;
            }
        }
        
        return null;
    }
}