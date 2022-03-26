package com.idat.ec1restapi.service;

import java.util.List;

import com.idat.ec1restapi.model.Profesor;

public interface ProfesorService {
	
	public void guardarProfesor(Profesor p);
	public void eliminarProfesor(Integer id);
	public void editarProfesor(Profesor p);
	public List<Profesor> listarProfesor();
	public Profesor profesorById(Integer id);

}
