package com.formacionbdi.microservicios.app.cursos.models.repository;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {

}
