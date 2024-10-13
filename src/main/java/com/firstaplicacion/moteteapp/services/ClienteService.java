package com.firstaplicacion.moteteapp.services;

import com.firstaplicacion.moteteapp.dto.ClienteDTO;
import com.firstaplicacion.moteteapp.models.Cliente;
import com.firstaplicacion.moteteapp.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    @Autowired
    private Optional<Cliente> clientesOptional;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    //Method GET ALL: Get all Clients
    public List<ClienteDTO> getCliente() {
        return clienteConvierteDatos(repository.findAll());
    }

    //Method GET ID: Get Clients by id
    public ClienteDTO getClienteById(Long id)
    {
        return repository.findClientesById(id)
                .map(c -> new ClienteDTO(c.getId(), c.getName(),
                        c.getEdad(), c.getFechaNacimiento(),
                        c.getGenero(), c.getTelefono(),
                        c.getEmail(), c.getDireccion(), c.getCursos()))
                .orElse(null);
    }

    //Method POST: Add new Clients to the system
    public void addNewCliente(Cliente c)
    {
        clientesOptional = repository.findClientesByEmail(c.getEmail());

        if (clientesOptional.isPresent()){
            throw new IllegalStateException("this email already is taken");
        }
        repository.save(c);
        System.out.println("se guardo correctamente");
    }

    //Method DELETE: Delete Clients from the system
    public void deleteCliente(Long clientesId)
    {
        boolean exists = repository.existsById(clientesId);
        if (!exists){
            throw new IllegalStateException(
                    "Student with id "+clientesId+" does not exists");
        }
        repository.deleteById(clientesId);
        System.out.println("se elimino correctamente");
    }

    //Method PUT: Actualiza los valores de los CLients
    @Transactional
    public void updateCliente(Long clientesId, String name, String email, Integer telefono)
    {
        Cliente cliente = repository.findById(clientesId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id "+clientesId+" does not exists"));
        //este codigo hace: que si el nombre cumple con algunas condiciones se actualize
        if (name != null && !name.isEmpty() &&
                !Objects.equals(cliente.getName(), name)) {
            cliente.setName(name);
        }

        //este codio hace: que si el email cumple con algunas condiciones y que no este ocupado se actualize
        if (email != null && !email.isEmpty() &&
                !Objects.equals(cliente.getEmail(), email)) {

            clientesOptional = repository.findClientesByEmail(email);
            if (clientesOptional.isPresent()){
                throw new IllegalStateException("This email "+email+" is already taken");
            }
            cliente.setEmail(email);
        }

        if (telefono != null && telefono > 99999999  &&
                !Objects.equals(cliente.getTelefono(), telefono)) {

            clientesOptional = repository.findClientesByTelefono(telefono);
            if (clientesOptional.isPresent()) {
                throw new IllegalStateException("This phone number "+telefono+" is already taken");
            }
            cliente.setTelefono(telefono);
        }
    }

    public List<ClienteDTO> clienteConvierteDatos(List<Cliente> clientes)
    {
        return clientes.stream()
                .map(c -> new ClienteDTO(c.getId(), c.getName(),
                        c.getEdad(), c.getFechaNacimiento(),
                        c.getGenero(), c.getTelefono(),
                        c.getEmail(), c.getDireccion(), c.getCursos()))
                .collect(Collectors.toList());
    }
}

    
