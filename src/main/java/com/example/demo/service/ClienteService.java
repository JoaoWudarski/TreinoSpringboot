package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();

        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());

        return cliente;
    }

	public List<Cliente> getAllClientes() {
		return repository.getAllClientes();
	}

	public Cliente getClienteByCodigo(int codigo) {
        Optional<Cliente> op = repository.getClienteByCodigo(codigo);
        return op.orElseThrow(() -> new ResponseStatusException
                             (HttpStatus.NOT_FOUND, "Cliente nao encontrado")
                              );
	}

	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	public void removeByCodigo(int codigo) {
        repository.remove(getClienteByCodigo(codigo));
	}

	public Cliente update(Cliente cliente) {
        getClienteByCodigo(cliente.getCodigo());
        return repository.update(cliente);
	}
}
