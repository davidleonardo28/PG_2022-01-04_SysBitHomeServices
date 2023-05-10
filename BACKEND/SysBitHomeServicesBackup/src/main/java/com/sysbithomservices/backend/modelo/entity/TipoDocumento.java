package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codTipoDocumento;

	@Column(length = 4)
	String nombreTipoDocumento;

	public TipoDocumento() {

	}

	public TipoDocumento(int codTipoDocumento, String nombreTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
		this.nombreTipoDocumento = nombreTipoDocumento;
	}
	
	public TipoDocumento( String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}

	public int getCodTipoDocumento() {
		return codTipoDocumento;
	}

	public void setCodTipoDocumento(int codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}

	public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}

	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}
}
