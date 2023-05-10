package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="supervisados")
public class Supervisados implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codUsuarios; 
	
	@Column
	String nombRole;
	
	public Supervisados() {
		
	}

	public Supervisados(int codUsuarios, String nombRole) {
		super();
		this.codUsuarios = codUsuarios;
		this.nombRole = nombRole;
	}

	public int getCodUsuarios() {
		return codUsuarios;
	}

	public void setCodUsuarios(int codUsuarios) {
		this.codUsuarios = codUsuarios;
	}

	public String getNombRole() {
		return nombRole;
	}

	public void setNombRole(String nombRole) {
		this.nombRole = nombRole;
	}
}
