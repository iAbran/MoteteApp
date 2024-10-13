package com.firstaplicacion.moteteapp.repository;

import com.firstaplicacion.moteteapp.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long>
{
    Optional<Cliente> findClientesByEmail(String email);
    Optional<Cliente> findClientesByTelefono(Integer telefono);
    Optional<Cliente> findClientesById(Long id);
}
