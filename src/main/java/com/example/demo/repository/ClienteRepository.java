package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cliente;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClienteRepository {

    private List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Jose");
        c1.setEndereco("Rux X, 99");
        c1.setSaldo(100.345);

        c2.setCodigo(2);
        c2.setNome("Maria");
        c2.setEndereco("Rux Y, 92");
        c2.setSaldo(123);

        c3.setCodigo(3);
        c3.setNome("Mario");
        c3.setEndereco("Rux H, 23");
        c3.setSaldo(1230);
        
        clientes = new ArrayList<Cliente>();

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
    }
    
    public List<Cliente> getAllClientes(){
        return clientes;
    }

    public Cliente getClienteByCodigo(int codigo){
        for(Cliente i : clientes){
            if(i.getCodigo() == codigo){
                return i;
            }
        }
        return null;
    }

    public Cliente save(Cliente cliente){

        cliente.setCodigo(clientes.size() + 1);
        clientes.add(cliente);
        return cliente;
    }
}
