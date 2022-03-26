package com.idat.ec1restapi.service;

import java.util.List;

import com.idat.ec1restapi.model.Curso;

public interface CursoService {
	
	public void guardarCurso(Curso c);
	public void eliminarCurso(Integer id);
	public void editarCurso(Curso c);
	public List<Curso> listarCursos();
	public Curso cursoById(Integer id);

}
