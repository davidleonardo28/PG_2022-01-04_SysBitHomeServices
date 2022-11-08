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
@Table(name="contratantes")
public class Contratantes implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_uce;
	
	@Column(length = 50)
	String nom_uce;
	
	@Column(length = 50)
	String ape_uce;
	String correo_uce;
	int telefono_uce;
	String cuenta_bancaria_uce;
	String clave_uce;
	
	@Column(length = 50)
	String usuario_uce;
	
	@Temporal(TemporalType.DATE)
	Date f_nacimiento_uce;
	

	public Contratantes(int cod_uce, String nom_uce, String ape_uce, String correo_uce, int telefono_uce,
			String cuenta_bancaria_uce, String clave_uce, String usuario_uce, Date f_nacimiento_uce) {
		super();
		this.cod_uce = cod_uce;
		this.nom_uce = nom_uce;
		this.ape_uce = ape_uce;
		this.correo_uce = correo_uce;
		this.telefono_uce = telefono_uce;
		this.cuenta_bancaria_uce = cuenta_bancaria_uce;
		this.clave_uce = clave_uce;
		this.usuario_uce = usuario_uce;
		this.f_nacimiento_uce = f_nacimiento_uce;
	}

	public int getCod_uce() {
		return cod_uce;
	}

	public void setCod_uce(int cod_uce) {
		this.cod_uce = cod_uce;
	}

	public String getNom_uce() {
		return nom_uce;
	}

	public void setNom_uce(String nom_uce) {
		this.nom_uce = nom_uce;
	}

	public String getApe_uce() {
		return ape_uce;
	}

	public void setApe_uce(String ape_uce) {
		this.ape_uce = ape_uce;
	}

	public String getCorreo_uce() {
		return correo_uce;
	}

	public void setCorreo_uce(String correo_uce) {
		this.correo_uce = correo_uce;
	}

	public int getTelefono_uce() {
		return telefono_uce;
	}

	public void setTelefono_uce(int telefono_uce) {
		this.telefono_uce = telefono_uce;
	}

	public String getCuenta_bancaria_uce() {
		return cuenta_bancaria_uce;
	}

	public void setCuenta_bancaria_uce(String cuenta_bancaria_uce) {
		this.cuenta_bancaria_uce = cuenta_bancaria_uce;
	}

	public String getClave_uce() {
		return clave_uce;
	}

	public void setClave_uce(String clave_uce) {
		this.clave_uce = clave_uce;
	}

	public String getUsuario_uce() {
		return usuario_uce;
	}

	public void setUsuario_uce(String usuario_uce) {
		this.usuario_uce = usuario_uce;
	}

	public Date getF_nacimiento_uce() {
		return f_nacimiento_uce;
	}

	public void setF_nacimiento_uce(Date f_nacimiento_uce) {
		this.f_nacimiento_uce = f_nacimiento_uce;
	}

}
