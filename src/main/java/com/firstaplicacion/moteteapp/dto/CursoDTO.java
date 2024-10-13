package com.firstaplicacion.moteteapp.dto;

import com.firstaplicacion.moteteapp.models.Author;
import com.firstaplicacion.moteteapp.models.Cliente;

import java.time.LocalDate;
import java.util.List;

public record CursoDTO(
        String titulo,
        String descripcion,
        String tiempo,
        LocalDate fechaLanzamiento,
        Author author,
        List<Cliente> clientes) {}
