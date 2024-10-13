package com.firstaplicacion.moteteapp.controllers;

import com.firstaplicacion.moteteapp.dto.CursoDTO;
import com.firstaplicacion.moteteapp.models.Curso;
import com.firstaplicacion.moteteapp.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class CursoController {

    private final CursoService service;

    @Autowired
    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping(path = "/cursos")
    public List<Curso> getCursos() {
        return service.getCursos();
    }

    @GetMapping("/cursos/{id}")
    public CursoDTO getCursoById(@PathVariable Long id) {
        return service.getCursosById(id);
    }

    @PostMapping("/cursos/api")
    public void addNewCurso(Curso c) {
        service.addNewCurso(c);
    }
}
