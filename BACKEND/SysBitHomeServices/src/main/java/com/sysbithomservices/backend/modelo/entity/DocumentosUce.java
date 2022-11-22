package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="documentos_uce")
public class DocumentosUce implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_uce;
	
	@ManyToOne
	@JoinColumn(name = "docCont_td")
	TipoDocumento tipoDoc;

	@OneToOne(mappedBy = "docCont", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	Contratantes contratantesList;
	
	public DocumentosUce() {
		
	}
	
	public DocumentosUce(TipoDocumento tipoDoc, Contratantes contratantesList) {
		this.tipoDoc = tipoDoc;
		this.contratantesList = contratantesList;
	}

	public DocumentosUce(int cod_uce, TipoDocumento tipoDoc, Contratantes contratantesList) {
		this.cod_uce = cod_uce;
		this.tipoDoc = tipoDoc;
		this.contratantesList = contratantesList;
	}

	public int getCod_uce() {
		return cod_uce;
	}

	public void setCod_uce(int cod_uce) {
		this.cod_uce = cod_uce;
	}
}
