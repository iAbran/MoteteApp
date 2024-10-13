package com.firstaplicacion.moteteapp.repository;

import com.firstaplicacion.moteteapp.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>
{
    Optional<Curso> findCursoById(Long id);
    Optional<Curso> findCursoByCodigoUnico(String codigoUnico);
}
