package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    

    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();

        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());

        return cliente;
    }
}
