package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_tipo_documento;
	
	@Column(length = 4)
	String tipo_documento;
	
	public TipoDocumento() {
		
	}

	public TipoDocumento(int cod_tipo_documento, String tipo_documento) {
		super();
		this.cod_tipo_documento = cod_tipo_documento;
		this.tipo_documento = tipo_documento;
	}

	public int getCod_tipo_documento() {
		return cod_tipo_documento;
	}

	public void setCod_tipo_documento(int cod_tipo_documento) {
		this.cod_tipo_documento = cod_tipo_documento;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
}
