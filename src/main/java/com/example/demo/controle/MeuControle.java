package com.example.demo.controle;

import java.util.List;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MeuControle {
    
    @Autowired
    private ClienteRepository repository;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return repository.getAllClientes();
    }


    @GetMapping("/clientes/{codigo}")
    public Cliente Cliente(@PathVariable int codigo) {
        return repository.getClienteByCodigo(codigo);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);

    }
    
}