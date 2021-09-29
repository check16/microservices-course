package com.formacionbdi.microservicios.app.cursos.controllers;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.services.CursoService;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> optional = this.service.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound()
                                 .build();
        }
        Curso cursoDB = optional.get();
        cursoDB.setNombre(curso.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(this.service.save(cursoDB));
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
        Optional<Curso> optional = this.service.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound()
                                 .build();
        }
        Curso cursoDB = optional.get();
        alumnos.forEach(alumno -> cursoDB.addAlumno(alumno));
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(this.service.save(cursoDB));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumnos(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> optional = this.service.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound()
                                 .build();
        }
        Curso cursoDB = optional.get();
        cursoDB.removeAlumno(alumno);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(this.service.save(cursoDB));
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id) {
        Curso curso = service.findCursoByAlumnoId(id);
        return ResponseEntity.ok(curso);
    }
}
