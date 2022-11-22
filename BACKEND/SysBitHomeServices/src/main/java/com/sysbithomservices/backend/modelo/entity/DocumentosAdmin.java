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
@Table(name="documentos_admin")
public class DocumentosAdmin implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_admin;
	
	@ManyToOne
	@JoinColumn(name = "docadm_td")
	TipoDocumento tipoDoc_admin;
	
	@OneToOne(mappedBy = "docAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	Administradores adminList;
	
	public DocumentosAdmin() {
		
	}
	
	public DocumentosAdmin(int cod_admin) {
		this.cod_admin = cod_admin;
	}
	public int getCod_admin() {
		return cod_admin;
	}
	public void setCod_admin(int cod_admin) {
		this.cod_admin = cod_admin;
	}
}
