package com.idat.ec1restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1restapi.model.Curso;
import com.idat.ec1restapi.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository repository;
	@Override
	public void guardarCurso(Curso c) {
		// TODO Auto-generated method stub
		repository.save(c);

	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void editarCurso(Curso c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);

	}

	@Override 
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Curso cursoById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
