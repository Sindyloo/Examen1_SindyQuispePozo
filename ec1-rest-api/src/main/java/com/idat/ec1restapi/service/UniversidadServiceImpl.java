package com.idat.ec1restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1restapi.model.Universidad;
import com.idat.ec1restapi.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private UniversidadRepository repository;
	@Override
	public void guardarUniversidad(Universidad u) {
		// TODO Auto-generated method stub
		repository.save(u);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void editarUniversidad(Universidad u) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(u);

	}

	@Override
	public List<Universidad> listarUniversidad() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Universidad universidadById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
