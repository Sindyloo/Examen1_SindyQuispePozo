package com.idat.ec1restapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="mallaCurricular")
@Entity
public class MallaCurricular  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6117496620534339104L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String año;
	
	@OneToOne(mappedBy = "mallaCurricular")
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallaCurricular")
	private List<Curso> cursos = new ArrayList<>();
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	
	


}
