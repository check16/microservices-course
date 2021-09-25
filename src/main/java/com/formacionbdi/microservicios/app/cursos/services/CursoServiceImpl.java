package com.formacionbdi.microservicios.app.cursos.services;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionbdi.microservicios.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}
