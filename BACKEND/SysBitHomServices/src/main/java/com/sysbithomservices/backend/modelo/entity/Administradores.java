package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administradores")
public class Administradores implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_administrador;
	
	@Column(length = 50)
	String nom_admin;
	
	@Column(length = 50)
	String ape_admin;
	String correo_admin;
	String clave_admin;
	int telefono_admin;
	String usuario_admin;
	
	public Administradores(int cod_administrador, String nom_admin, String ape_admin, String correo_admin,
			String clave_admin, int telefono_admin, String usuario_admin) {
		super();
		this.cod_administrador = cod_administrador;
		this.nom_admin = nom_admin;
		this.ape_admin = ape_admin;
		this.correo_admin = correo_admin;
		this.clave_admin = clave_admin;
		this.telefono_admin = telefono_admin;
		this.usuario_admin = usuario_admin;
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
	public int getTelefono_admin() {
		return telefono_admin;
	}
	public void setTelefono_admin(int telefono_admin) {
		this.telefono_admin = telefono_admin;
	}
	public String getUsuario_admin() {
		return usuario_admin;
	}
	public void setUsuario_admin(String usuario_admin) {
		this.usuario_admin = usuario_admin;
	}
	
	
}
