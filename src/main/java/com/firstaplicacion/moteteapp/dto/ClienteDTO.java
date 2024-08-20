package com.firstaplicacion.moteteapp.dto;


import java.time.LocalDate;

public record ClienteDTO(
        Long id,
        String name,
        Integer edad,
        LocalDate fechaNacimiento,
        Integer telefono,
        String email,
        String direccion) {
}
