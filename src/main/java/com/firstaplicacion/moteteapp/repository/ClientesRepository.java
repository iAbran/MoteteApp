package com.firstaplicacion.moteteapp.repository;

import com.firstaplicacion.moteteapp.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientesRepository
        extends JpaRepository<Clientes, Long> {


//  esto hace que busque  los estudiantes por email en la base de datos
    @Query("SELECT s FROM Clientes s WHERE s.email = :email")
    Optional<Clientes> findClientesByEmail(String email);

    @Query("SELECT s FROM Clientes s WHERE s.telefono = :telefono")
    Optional<Clientes> findClientesByTelefono(Integer telefono);

    @Query("SELECT s FROM Clientes s WHERE s.id = :id")
    Optional<Clientes> findClientesById(Long id);

}
