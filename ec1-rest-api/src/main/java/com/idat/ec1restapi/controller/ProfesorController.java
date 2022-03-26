package com.idat.ec1restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec1restapi.model.Profesor;
import com.idat.ec1restapi.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(method = RequestMethod.GET, path ="/listar")
	public ResponseEntity<List<Profesor>>listar(){
		return new ResponseEntity<List<Profesor>>(service.listarProfesor(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		service.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Profesor> profesorById(@PathVariable Integer id){
		Profesor profesor = service.profesorById(id);
		if(profesor != null) {
			return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);

		}
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor profesor = service.profesorById(id);
		if(profesor != null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);		
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		Profesor profesor1 = service.profesorById(profesor.getIdProfesor());
		if(profesor1 != null) {
			service.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
