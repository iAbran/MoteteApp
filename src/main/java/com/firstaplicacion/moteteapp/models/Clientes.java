package com.firstaplicacion.moteteapp.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private Integer edad;
    private LocalDate fechaNacimiento;
    @Column(unique = true)
    private Integer telefono;
    private String email;
    private String direccion;

    public Clientes() {
    }

    public Clientes(
            Long id,
            String name,
            LocalDate fechaNacimiento,
            Integer telefono,
            String email,
            String direccion) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Clientes(
            String name,
            LocalDate fechaNacimiento,
            Integer telefono,
            String email,
            String direccion) {
        this.name = name;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //Calcula la edad de sfecha de Nacimiento que es dob
    public Integer getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
