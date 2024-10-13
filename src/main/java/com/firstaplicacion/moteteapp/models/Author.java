package com.firstaplicacion.moteteapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private Integer edad;
    private LocalDate fechaNacimiento;

    @Column(unique = true)
    @Size(min = 4, max = 4, message = "La matricula debe tener exactamente 4 dígitos")
    private String matricula;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Curso> cursos;

    public Integer getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

}
