package com.firstaplicacion.moteteapp.controllers;

import com.firstaplicacion.moteteapp.dto.ClienteDTO;
import com.firstaplicacion.moteteapp.services.ClientesService;
import com.firstaplicacion.moteteapp.models.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class ClientesController {
    private ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping(path = "/clientes")
    public List<ClienteDTO> getCliente(){
        return clientesService.getCliente();
    }

    @GetMapping("/clientes/{id}")
    public ClienteDTO getClienteId(@PathVariable Long id){
        return clientesService.getClienteById(id);
    }

    @PostMapping("/clientes/api")
    public void RegisterNewClientes(@RequestBody Clientes clientes){
        clientesService.addNewCliente(clientes);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public void deleteStudent(@PathVariable("clienteId") Long clienteId){
        clientesService.deleteCliente(clienteId);
    }

    @PutMapping(path = "/clientes/{clienteId}")
    public void updateStudent(
            @PathVariable("clienteId") Long clienteId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer telefono){

        clientesService.updateCliente(clienteId, name, email, telefono);
    }

}
