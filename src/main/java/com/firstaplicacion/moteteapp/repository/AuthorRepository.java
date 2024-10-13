package com.firstaplicacion.moteteapp.repository;

import com.firstaplicacion.moteteapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>
{
    Optional<Author> findAuthorById(Long id);
    Optional<Author> findAuthorByMatricula(String matricula);
}
