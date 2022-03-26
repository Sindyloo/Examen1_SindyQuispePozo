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


import com.idat.ec1restapi.model.Universidad;
import com.idat.ec1restapi.service.UniversidadService;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadController {
	@Autowired
	private UniversidadService service;
	
	@RequestMapping(method = RequestMethod.GET, path ="/listar")
	public ResponseEntity<List<Universidad>>listar(){
		return new ResponseEntity<List<Universidad>>(service.listarUniversidad(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad){
		service.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Universidad> universidadById(@PathVariable Integer id){
		Universidad universidad = service.universidadById(id);
		if(universidad != null) {
			return new ResponseEntity<Universidad>(universidad, HttpStatus.OK);

		}
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad universidad = service.universidadById(id);
		if(universidad != null) {
			service.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);		
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Universidad universidad){
		Universidad universidad1 = service.universidadById(universidad.getIdUniversidad());
		if(universidad1 != null) {
			service.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		  }
		  return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
