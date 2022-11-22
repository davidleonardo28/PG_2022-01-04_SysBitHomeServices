package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="colaboradores")
public class Colaboradores implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_ucr;
	
	@Column(length = 50, nullable = false)
	String nom_ucr;
	
	@Column(length = 50, nullable = false)
	String ape_ucr;
	
	@Column(nullable = false, unique = true)
	String correo_ucr;
	
	@Column(nullable = false)
	Long telefono_ucr;
	
	@Column(nullable = false)
	Long num_documento_ucr;
	
	@Column(nullable = false)
	Long cuenta_bancaria;
	
	@Column(nullable = false)
	String clave_ucr;
	
	@Column(length = 10, nullable = false, unique = true)
	String usuario_ucr;
	
	@Temporal(TemporalType.DATE)
	Date f_nacimiento_ucr;
	String seguridad_social;
	
	@OneToOne(mappedBy = "colab", fetch = FetchType.LAZY)
	Supervisados supervisadosList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "colab_doccolab")
	DocumentosUcr docColab;
	
	public Colaboradores() {
		
	}

	public Colaboradores(String nom_ucr, String ape_ucr, String correo_ucr, Long telefono_ucr,
			Long num_documento_ucr, Long cuenta_bancaria, String clave_ucr, String usuario_ucr, Date f_nacimiento_ucr,
			String seguridad_social, Supervisados supervisadosList, DocumentosUcr docColab) {
		super();
		this.nom_ucr = nom_ucr;
		this.ape_ucr = ape_ucr;
		this.correo_ucr = correo_ucr;
		this.telefono_ucr = telefono_ucr;
		this.num_documento_ucr = num_documento_ucr;
		this.cuenta_bancaria = cuenta_bancaria;
		this.clave_ucr = clave_ucr;
		this.usuario_ucr = usuario_ucr;
		this.f_nacimiento_ucr = f_nacimiento_ucr;
		this.seguridad_social = seguridad_social;
		this.supervisadosList = supervisadosList;
		this.docColab = docColab;
	}

	public int getCod_ucr() {
		return cod_ucr;
	}

	public void setCod_ucr(int cod_ucr) {
		this.cod_ucr = cod_ucr;
	}

	public String getNom_ucr() {
		return nom_ucr;
	}

	public void setNom_ucr(String nom_ucr) {
		this.nom_ucr = nom_ucr;
	}

	public String getApe_ucr() {
		return ape_ucr;
	}

	public void setApe_ucr(String ape_ucr) {
		this.ape_ucr = ape_ucr;
	}

	public String getCorreo_ucr() {
		return correo_ucr;
	}

	public void setCorreo_ucr(String correo_ucr) {
		this.correo_ucr = correo_ucr;
	}

	public Long getTelefono_ucr() {
		return telefono_ucr;
	}

	public void setTelefono_ucr(Long telefono_ucr) {
		this.telefono_ucr = telefono_ucr;
	}

	public Long getNum_documento_ucr() {
		return num_documento_ucr;
	}

	public void setNum_documento_ucr(Long num_documento_ucr) {
		this.num_documento_ucr = num_documento_ucr;
	}

	public Long getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(Long cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}

	public String getClave_ucr() {
		return clave_ucr;
	}

	public void setClave_ucr(String clave_ucr) {
		this.clave_ucr = clave_ucr;
	}

	public String getUsuario_ucr() {
		return usuario_ucr;
	}

	public void setUsuario_ucr(String usuario_ucr) {
		this.usuario_ucr = usuario_ucr;
	}

	public Date getF_nacimiento_ucr() {
		return f_nacimiento_ucr;
	}

	public void setF_nacimiento_ucr(Date f_nacimiento_ucr) {
		this.f_nacimiento_ucr = f_nacimiento_ucr;
	}

	public String getSeguridad_social() {
		return seguridad_social;
	}

	public void setSeguridad_social(String seguridad_social) {
		this.seguridad_social = seguridad_social;
	}

	public Supervisados getSupervisadosList() {
		return supervisadosList;
	}

	public void setSupervisadosList(Supervisados supervisadosList) {
		this.supervisadosList = supervisadosList;
	}

	public DocumentosUcr getDocColab() {
		return docColab;
	}

	public void setDocColab(DocumentosUcr docColab) {
		this.docColab = docColab;
	}
	
}
