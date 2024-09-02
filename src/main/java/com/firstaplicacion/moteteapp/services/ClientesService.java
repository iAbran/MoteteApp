package com.firstaplicacion.moteteapp.services;

import com.firstaplicacion.moteteapp.dto.ClienteDTO;
import com.firstaplicacion.moteteapp.repository.ClientesRepository;
import com.firstaplicacion.moteteapp.models.Clientes;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesService {
    private final ClientesRepository repository;
    private Optional<Clientes> clientesOptional;

    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }
    //Method GET: Get all Clients
    public List<ClienteDTO> getCliente(){
        return convierteDatos(repository.findAll());
    }

    //Method GET: Get Clients by id
    public ClienteDTO getClienteById(Long id) {
        Optional<Clientes>  cliente = repository.findClientesById(id);
        if (cliente.isPresent()) {
            Clientes c = cliente.get();

            return new ClienteDTO(c.getId(), c.getName(),
                    c.getEdad(), c.getFechaNacimiento(), c.getTelefono(),
                    c.getEmail(), c.getDireccion());
        }
        return null;
    }

    //Method POST: Add new Clients to the Data Base
    public void addNewCliente(Clientes clientes) {
        clientesOptional = repository
                .findClientesByEmail(clientes.getEmail());
        if (clientesOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        repository.save(clientes);
        System.out.println("se guardo correctamente");

    }

    //Method DELETE: Delete Clients from the Data Base
    public void deleteCliente(Long clientesId) {
        boolean exists = repository.existsById(clientesId);
        if (!exists){
            throw new IllegalStateException(
                    "the student with id " + clientesId + " does not exists");
        }
        repository.deleteById(clientesId);
        System.out.println("se elimino correctamente");
    }

    //Method PUT: Actualiza los valores de los CLients
    @Transactional
    public void updateCliente(Long clientesId,
                              String name,
                              String email,
                              Integer telefono)    {
        Clientes clientes = repository.findById(clientesId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + clientesId + " does not exists"));
    //este codigo hace: que si el nombre cumple con algunas condiciones se actualize
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(clientes.getName(), name)) {
            clientes.setName(name);
        }
    //este codio hace: que si el email cumple con algunas condiciones y que no este ocupado se actualize
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(clientes.getEmail(), email)) {
            clientesOptional = repository.findClientesByEmail(email);
            if (clientesOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            clientes.setEmail(email);
        }
        if (telefono != null &&
                telefono > 99999999  &&
                !Objects.equals(clientes.getTelefono(), telefono)) {
            clientesOptional = repository.findClientesByTelefono(telefono);
            if (clientesOptional.isPresent()){
                throw new IllegalStateException("telefono taken");
            }
            clientes.setTelefono(telefono);
        }
    }

    public List<ClienteDTO> convierteDatos(List<Clientes> clientes){
        return clientes.stream()
                .map(c -> new ClienteDTO(c.getId(), c.getName(),
                        c.getEdad(), c.getFechaNacimiento(), c.getTelefono(),
                        c.getEmail(), c.getDireccion()))
                .collect(Collectors.toList());
    }


}

    
