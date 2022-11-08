package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documentos_admin")
public class DocumentosAdmin implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_admin;
	int cod_tipo_documento;
	int num_documento_admin;
	
	public DocumentosAdmin(int cod_admin, int cod_tipo_documento, int num_documento_admin) {
		super();
		this.cod_admin = cod_admin;
		this.cod_tipo_documento = cod_tipo_documento;
		this.num_documento_admin = num_documento_admin;
	}
	public int getCod_admin() {
		return cod_admin;
	}
	public void setCod_admin(int cod_admin) {
		this.cod_admin = cod_admin;
	}
	public int getCod_tipo_documento() {
		return cod_tipo_documento;
	}
	public void setCod_tipo_documento(int cod_tipo_documento) {
		this.cod_tipo_documento = cod_tipo_documento;
	}
	public int getNum_documento_admin() {
		return num_documento_admin;
	}
	public void setNum_documento_admin(int num_documento_admin) {
		this.num_documento_admin = num_documento_admin;
	}
}
