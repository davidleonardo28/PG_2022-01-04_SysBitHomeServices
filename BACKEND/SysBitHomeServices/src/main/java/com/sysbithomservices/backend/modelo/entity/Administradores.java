package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;
import java.util.ArrayList;
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

@Entity
@Table(name="administradores")
public class Administradores implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_administrador;
	
	@Column(length = 50, nullable = false)
	String nom_admin;
	
	@Column(length = 50, nullable = false)
	String ape_admin;
	
	@Column(nullable = false, unique = true)
	String correo_admin;
	
	@Column(nullable = false)
	String clave_admin;
	
	@Column(nullable = false)
	Long telefono_admin;
	
	@Column(nullable = false)
	Long num_documento_admin;
	
	@Column(nullable = false, unique = true)
	String usuario_admin;
	
	@OneToOne(mappedBy = "admin", fetch = FetchType.LAZY)
	Supervisados supervisados;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_docadm")
	DocumentosAdmin docAdmin;

	public Administradores() {
		
	}
	
	public Administradores(int cod_administrador, String nom_admin, String ape_admin, String correo_admin,
			String clave_admin, Long telefono_admin, Long num_documento_admin, String usuario_admin,
			Supervisados supervisados, DocumentosAdmin docAdmin) {
		this.cod_administrador = cod_administrador;
		this.nom_admin = nom_admin;
		this.ape_admin = ape_admin;
		this.correo_admin = correo_admin;
		this.clave_admin = clave_admin;
		this.telefono_admin = telefono_admin;
		this.num_documento_admin = num_documento_admin;
		this.usuario_admin = usuario_admin;
		this.supervisados = supervisados;
		this.docAdmin = docAdmin;
	}

	public int getCod_administrador() {
		return cod_administrador;
	}

	public void setCod_administrador(int cod_administrador) {
		this.cod_administrador = cod_administrador;
	}

	public String getNom_admin() {
		return nom_admin;
	}

	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}

	public String getApe_admin() {
		return ape_admin;
	}

	public void setApe_admin(String ape_admin) {
		this.ape_admin = ape_admin;
	}

	public String getCorreo_admin() {
		return correo_admin;
	}

	public void setCorreo_admin(String correo_admin) {
		this.correo_admin = correo_admin;
	}

	public String getClave_admin() {
		return clave_admin;
	}

	public void setClave_admin(String clave_admin) {
		this.clave_admin = clave_admin;
	}

	public Long getTelefono_admin() {
		return telefono_admin;
	}

	public void setTelefono_admin(Long telefono_admin) {
		this.telefono_admin = telefono_admin;
	}

	public Long getNum_documento_admin() {
		return num_documento_admin;
	}

	public void setNum_documento_admin(Long num_documento_admin) {
		this.num_documento_admin = num_documento_admin;
	}

	public String getUsuario_admin() {
		return usuario_admin;
	}

	public void setUsuario_admin(String usuario_admin) {
		this.usuario_admin = usuario_admin;
	}

	public Supervisados getSupervisados() {
		return supervisados;
	}

	public void setSupervisados(Supervisados supervisados) {
		this.supervisados = supervisados;
	}

	public DocumentosAdmin getDocAdmin() {
		return docAdmin;
	}

	public void setDocAdmin(DocumentosAdmin docAdmin) {
		this.docAdmin = docAdmin;
	}

}
