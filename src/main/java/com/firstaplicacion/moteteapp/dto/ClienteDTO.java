package com.firstaplicacion.moteteapp.dto;


import com.firstaplicacion.moteteapp.models.ClienteGender;
import com.firstaplicacion.moteteapp.models.Curso;

import java.time.LocalDate;
import java.util.List;

public record ClienteDTO(
        Long id,
        String name,
        Integer edad,
        LocalDate fechaNacimiento,
        ClienteGender genero,
        Integer telefono,
        String email,
        String direccion,
        List<Curso> cursos) {}
