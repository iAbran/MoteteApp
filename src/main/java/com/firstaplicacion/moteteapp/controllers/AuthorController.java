package com.firstaplicacion.moteteapp.controllers;

import com.firstaplicacion.moteteapp.dto.AuthorDTO;
import com.firstaplicacion.moteteapp.models.Author;
import com.firstaplicacion.moteteapp.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inicio")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    //GET ALL Method
    @GetMapping("/author")
    public List<AuthorDTO> getAuthor() {
        return service.getAuthor();
    }

    //GET ID Method
    @GetMapping("/author/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    //POST Method
    @PostMapping("/author/api")
    public void addNewAuthor(Author author) {
        service.addNewAuthor(author);
    }
}
