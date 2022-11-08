package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documentos_ucr")
public class DocumentosUcr implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_ucr;
	int cod_tipo_documento;
	int num_documento_ucr;
	
	public DocumentosUcr(int cod_ucr, int cod_tipo_documento, int num_documento_ucr) {
		super();
		this.cod_ucr = cod_ucr;
		this.cod_tipo_documento = cod_tipo_documento;
		this.num_documento_ucr = num_documento_ucr;
	}
	
	public int getCod_ucr() {
		return cod_ucr;
	}
	public void setCod_ucr(int cod_ucr) {
		this.cod_ucr = cod_ucr;
	}
	public int getCod_tipo_documento() {
		return cod_tipo_documento;
	}
	public void setCod_tipo_documento(int cod_tipo_documento) {
		this.cod_tipo_documento = cod_tipo_documento;
	}
	public int getNum_documento_ucr() {
		return num_documento_ucr;
	}
	public void setNum_documento_ucr(int num_documento_ucr) {
		this.num_documento_ucr = num_documento_ucr;
	}
}
