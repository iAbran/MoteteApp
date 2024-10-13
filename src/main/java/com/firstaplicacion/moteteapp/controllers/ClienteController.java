package com.firstaplicacion.moteteapp.controllers;

import com.firstaplicacion.moteteapp.dto.ClienteDTO;
import com.firstaplicacion.moteteapp.models.Cliente;
import com.firstaplicacion.moteteapp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class ClienteController
{
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //GET ALL Method
    @GetMapping(path = "/clientes")
    public List<ClienteDTO> getCliente() {
        return clienteService.getCliente();
    }

    //GET ID Method
    @GetMapping("/clientes/{id}")
    public ClienteDTO getClienteId(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    //POST Method
    @PostMapping("/clientes/api")
    public void RegisterNewCliente(@RequestBody Cliente cliente) {
        clienteService.addNewCliente(cliente);
    }

    //DELETE Method
    @DeleteMapping("/clientes/{clienteId}")
    public void deleteStudent(@PathVariable("clienteId") Long clienteId) {
        clienteService.deleteCliente(clienteId);
    }

    //PUT Method
    @PutMapping(path = "/clientes/{clienteId}")
    public void updateStudent(
            @PathVariable("clienteId") Long clienteId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer telefono) {

        clienteService.updateCliente(clienteId, name, email, telefono);
    }

}
