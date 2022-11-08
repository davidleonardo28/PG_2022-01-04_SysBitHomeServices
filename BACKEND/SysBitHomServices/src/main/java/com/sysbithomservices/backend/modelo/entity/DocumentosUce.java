package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documentos_uce")
public class DocumentosUce implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_uce;
	int cod_tipo_documento;
	int num_documento_uce;
	
	public DocumentosUce(int cod_uce, int cod_tipo_documento, int num_documento_uce) {
		super();
		this.cod_uce = cod_uce;
		this.cod_tipo_documento = cod_tipo_documento;
		this.num_documento_uce = num_documento_uce;
	}

	public int getCod_uce() {
		return cod_uce;
	}

	public void setCod_uce(int cod_uce) {
		this.cod_uce = cod_uce;
	}

	public int getCod_tipo_documento() {
		return cod_tipo_documento;
	}

	public void setCod_tipo_documento(int cod_tipo_documento) {
		this.cod_tipo_documento = cod_tipo_documento;
	}

	public int getNum_documento_uce() {
		return num_documento_uce;
	}

	public void setNum_documento_uce(int num_documento_uce) {
		this.num_documento_uce = num_documento_uce;
	}

}
