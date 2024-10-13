package com.firstaplicacion.moteteapp.services;

import com.firstaplicacion.moteteapp.dto.CursoDTO;
import com.firstaplicacion.moteteapp.models.Curso;
import com.firstaplicacion.moteteapp.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> getCursos() {
        return repository.findAll();
    }

    private List<CursoDTO> cursoConvierteDatos(List<Curso> curso) {
        return curso.stream()
                .map(c -> new CursoDTO(
                        c.getTitulo(), c.getDescripcion(),
                        c.getTiempo(),c.getFechaLanzamiento(),
                        c.getAuthor(), c.getClientes()))
                .collect(Collectors.toList());
    }


    public CursoDTO getCursosById(Long id) {
        return repository.findCursoById(id)
                .map(c -> new CursoDTO(
                        c.getTitulo(), c.getDescripcion(),
                        c.getTiempo(), c.getFechaLanzamiento(),
                        c.getAuthor(), c.getClientes()))
                .orElse(null);
    }

    public void addNewCurso(Curso c) {
        Optional<Curso> cursoOptional = repository.findCursoByCodigoUnico(c.getCodigoUnico());

        if (cursoOptional.isPresent()) {
            throw new IllegalStateException(
                    "This unique code "+cursoOptional+" is already taken");
        }
        repository.save(c);
    }
}
