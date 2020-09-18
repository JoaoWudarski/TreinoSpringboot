package com.example.demo.controle;

import java.net.URI;
import java.util.List;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/clientes")
public class MeuControle {
    
    @Autowired
    private ClienteRepository repository;

    @GetMapping()
    public List<Cliente> getClientes() {
        return repository.getAllClientes();
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int codigo){
        Cliente cliente = repository.getClienteByCodigo(codigo);

        
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }  
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Cliente cliente){
       cliente = repository.save(cliente);
        URI uri = URI.create("http://localhost:8080/clientes/" + cliente.getCodigo());
       return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> Delete(@PathVariable int codigo){
        Cliente cliente = repository.getClienteByCodigo(codigo);

        if(cliente != null){
            repository.remove(cliente);
            return ResponseEntity.noContent().build();
        }  
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int codigo, @RequestBody Cliente cliente){

        if(repository.getClienteByCodigo(codigo) != null){
            cliente.setCodigo(codigo);
            cliente = repository.update(cliente);
            return ResponseEntity.ok(cliente);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}