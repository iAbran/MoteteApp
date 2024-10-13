package com.firstaplicacion.moteteapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private Integer edad;
    private ClienteGender genero;
    private LocalDate fechaNacimiento;
    @Column(unique = true)
    private Integer telefono;
    private String email;
    private String direccion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "clientes_cursos",
            joinColumns = @JoinColumn(name = "clientes_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cursos_id", referencedColumnName = "id")
    )
    private List<Curso> cursos;

    //Calcula la edad de sfecha de Nacimiento que es dob
    public Integer getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

}