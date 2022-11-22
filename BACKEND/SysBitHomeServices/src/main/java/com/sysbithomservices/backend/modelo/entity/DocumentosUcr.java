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
@Table(name="documentos_ucr")
public class DocumentosUcr implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_ucr;
	
	@ManyToOne
	@JoinColumn(name = "docCol_td")
	TipoDocumento tipoDoc;
		
	@OneToOne(mappedBy = "docColab", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	Colaboradores colaboradoresList;

	public DocumentosUcr() {
		
	}

	public DocumentosUcr(int cod_ucr, TipoDocumento tipoDoc, Colaboradores colaboradoresList) {
		super();
		this.cod_ucr = cod_ucr;
		this.tipoDoc = tipoDoc;
		this.colaboradoresList = colaboradoresList;
	}

	public int getCod_ucr() {
		return cod_ucr;
	}

	public void setCod_ucr(int cod_ucr) {
		this.cod_ucr = cod_ucr;
	}
}
