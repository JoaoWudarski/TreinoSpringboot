package com.example.demo.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/clientes")
public class MeuControle {
    

    @Autowired
    private ClienteService service;

    @GetMapping()
    public List<Cliente> getClientes() {
        return service.getAllClientes();
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int codigo){
        Cliente cliente = service.getClienteByCodigo(codigo);
        return ResponseEntity.ok(cliente);

    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO,
                                        HttpServletRequest request,
                                        UriComponentsBuilder builder
    ){
        Cliente cliente = service.fromDTO(clienteDTO);
        cliente = service.save(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI()+ "/" + cliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }



    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> Delete(@PathVariable int codigo){
        service.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int codigo, 
                                             @RequestBody ClienteDTO clienteDTO){
        
        Cliente cliente = service.fromDTO(clienteDTO);
        cliente.setCodigo(codigo);
        cliente = service.update(cliente);
        return ResponseEntity.ok(cliente);
 
    }
}