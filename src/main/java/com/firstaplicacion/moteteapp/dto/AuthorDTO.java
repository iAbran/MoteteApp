package com.firstaplicacion.moteteapp.dto;

import com.firstaplicacion.moteteapp.models.Curso;

import java.time.LocalDate;
import java.util.List;

public record AuthorDTO(
        String name,
        Integer edad,
        LocalDate fechaNacimiento,
        List<Curso> cursos) {}
