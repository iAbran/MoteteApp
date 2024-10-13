package com.firstaplicacion.moteteapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String tiempo;
    private LocalDate fechaLanzamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    @JsonIgnore
    @ManyToMany(mappedBy = "cursos")
    private List<Cliente> clientes;

    @JsonIgnore
    @Column(unique = true)
    @Size(max = 4, min = 4, message = "Tiene que ser exactamente 4 digitos")
    private String codigoUnico;

}
