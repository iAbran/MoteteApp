package com.firstaplicacion.moteteapp.services;

import com.firstaplicacion.moteteapp.dto.AuthorDTO;
import com.firstaplicacion.moteteapp.models.Author;
import com.firstaplicacion.moteteapp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    //GET ALL Method
    public List<AuthorDTO> getAuthor() {
        return authorConvierteDatos(repository.findAll());
    }

    //GET ID Method
    public AuthorDTO getAuthorById( Long id) {
        return repository.findAuthorById(id)
                .map(a -> new AuthorDTO(
                        a.getName(), a.getEdad(),
                        a.getFechaNacimiento(), a.getCursos()))
                .orElse(null);
    }

    //POST Method
    public void addNewAuthor(Author a) {
        Optional<Author> authorOptional = repository.findAuthorByMatricula(a.getMatricula());
        if (authorOptional.isPresent()) {
            throw new IllegalStateException("This "+a.getMatricula()+" already exists");
        }
        repository.save(a);
    }

    public List<AuthorDTO> authorConvierteDatos(List<Author> author) {
        return author.stream()
                .map(a -> new AuthorDTO(
                        a.getName(), a.getEdad(),
                        a.getFechaNacimiento(), a.getCursos()))
                .collect(Collectors.toList());
    }

}
