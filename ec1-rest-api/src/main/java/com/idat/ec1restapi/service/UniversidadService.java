package com.idat.ec1restapi.service;

import java.util.List;

import com.idat.ec1restapi.model.Universidad;

public interface UniversidadService {
	
	public void guardarUniversidad(Universidad u);
	public void eliminarUniversidad(Integer id);
	public void editarUniversidad(Universidad u);
	public List<Universidad> listarUniversidad();
	public Universidad universidadById(Integer id);

}
