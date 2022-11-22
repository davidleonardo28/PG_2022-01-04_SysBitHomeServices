package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="supervisados")
public class Supervisados implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_usuarios; 
	
	@OneToOne
	@JoinColumn(name = "sup_admin")
	Administradores admin;
	
	@OneToOne
	@JoinColumn(name = "sup_colab")
	Colaboradores colab;
	
	@OneToOne
	@JoinColumn(name = "sup_cont")
	Contratantes cont;

	public Supervisados(int cod_usuarios) {
		super();
		this.cod_usuarios = cod_usuarios;
	}

	public int getCod_usuarios() {
		return cod_usuarios;
	}

	public void setCod_usuarios(int cod_usuarios) {
		this.cod_usuarios = cod_usuarios;
	}

	public Administradores getAdmin() {
		return admin;
	}

	public void setAdmin(Administradores admin) {
		this.admin = admin;
	}

	public Colaboradores getColab() {
		return colab;
	}

	public void setColab(Colaboradores colab) {
		this.colab = colab;
	}

	public Contratantes getCont() {
		return cont;
	}

	public void setCont(Contratantes cont) {
		this.cont = cont;
	}
	
}
