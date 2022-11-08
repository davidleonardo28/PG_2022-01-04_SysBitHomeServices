package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="colaboradores")
public class Colaboradores implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_ucr;
	
	@Column(length = 50)
	String nom_ucr;
	
	@Column(length = 50)
	String ape_ucr;
	
	String correo_ucr;
	int telefono_ucr;
	
	@Column(length = 50)
	String cuenta_bancaria;
	
	String documento_ucr;
	String clave_ucr;
	
	@Column(length = 10)
	String usuario_ucr;
	
	@Temporal(TemporalType.DATE)
	Date f_nacimiento_ucr;
	String seguridad_social;
	
	
	public Colaboradores(int cod_ucr, String nom_ucr, String ape_ucr, String correo_ucr, int telefono_ucr,
			String cuenta_bancaria, String documento_ucr, String clave_ucr, String usuario_ucr, Date f_nacimiento_ucr,
			String seguridad_social) {
		super();
		this.cod_ucr = cod_ucr;
		this.nom_ucr = nom_ucr;
		this.ape_ucr = ape_ucr;
		this.correo_ucr = correo_ucr;
		this.telefono_ucr = telefono_ucr;
		this.cuenta_bancaria = cuenta_bancaria;
		this.documento_ucr = documento_ucr;
		this.clave_ucr = clave_ucr;
		this.usuario_ucr = usuario_ucr;
		this.f_nacimiento_ucr = f_nacimiento_ucr;
		this.seguridad_social = seguridad_social;
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
	public int getTelefono_ucr() {
		return telefono_ucr;
	}
	public void setTelefono_ucr(int telefono_ucr) {
		this.telefono_ucr = telefono_ucr;
	}
	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}
	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
	public String getDocumento_ucr() {
		return documento_ucr;
	}
	public void setDocumento_ucr(String documento_ucr) {
		this.documento_ucr = documento_ucr;
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
	
}
