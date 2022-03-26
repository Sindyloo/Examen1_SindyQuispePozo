package com.idat.ec1restapi.service;

import java.util.List;


import com.idat.ec1restapi.model.MallaCurricular;

public interface MallaCurricularService {
	
	public void guardarMallaCurricular(MallaCurricular m);
	public void eliminarMallaCurricular(Integer id);
	public void editarMallaCurricular(MallaCurricular m);
	public List<MallaCurricular> listarMallaCurricular();
	public MallaCurricular mallaCurricularById(Integer id);
}
