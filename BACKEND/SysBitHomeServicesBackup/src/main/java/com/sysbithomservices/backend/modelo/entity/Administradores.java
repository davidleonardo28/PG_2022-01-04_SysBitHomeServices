package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="administradores")
public class Administradores implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codAdmin;
	
	@Column(length = 50, nullable = false)
	String nomAdmin;
	
	@Column(length = 50, nullable = false)
	String apeAdmin;
	
	@Column(nullable = false, unique = true)
	String correoAdmin;
	
	@Column(nullable = false)
	String claveAdmin;
	
	@Column(nullable = false)
	Long telefonoAdmin;
	
	@Column(nullable = false)
	Long numDocumentoAdmin;
	
	@Column(nullable = false, unique = true)
	String usuarioAdmin;
	
	@OneToOne(mappedBy = "admin", fetch = FetchType.LAZY)
	Supervisados supervisados;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doc_admin")
	TipoDocumento docAdmin;

	public Administradores() {
		
	}

	public Administradores(int codAdmin, String nomAdmin, String apeAdmin, String correoAdmin, String claveAdmin,
			Long telefonoAdmin, Long numDocumentoAdmin, String usuarioAdmin, Supervisados supervisados,
			TipoDocumento docAdmin) {
		super();
		this.codAdmin = codAdmin;
		this.nomAdmin = nomAdmin;
		this.apeAdmin = apeAdmin;
		this.correoAdmin = correoAdmin;
		this.claveAdmin = claveAdmin;
		this.telefonoAdmin = telefonoAdmin;
		this.numDocumentoAdmin = numDocumentoAdmin;
		this.usuarioAdmin = usuarioAdmin;
		this.supervisados = supervisados;
		this.docAdmin = docAdmin;
	}




	public int getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}

	public String getNomAdmin() {
		return nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getApeAdmin() {
		return apeAdmin;
	}

	public void setApeAdmin(String apeAdmin) {
		this.apeAdmin = apeAdmin;
	}

	public String getCorreoAdmin() {
		return correoAdmin;
	}

	public void setCorreoAdmin(String correoAdmin) {
		this.correoAdmin = correoAdmin;
	}

	public String getClaveAdmin() {
		return claveAdmin;
	}

	public void setClaveAdmin(String claveAdmin) {
		this.claveAdmin = claveAdmin;
	}

	public Long getTelefonoAdmin() {
		return telefonoAdmin;
	}

	public void setTelefonoAdmin(Long telefonoAdmin) {
		this.telefonoAdmin = telefonoAdmin;
	}

	public Long getNumDocumentoAdmin() {
		return numDocumentoAdmin;
	}

	public void setNumDocumentoAdmin(Long numDocumentoAdmin) {
		this.numDocumentoAdmin = numDocumentoAdmin;
	}

	public String getUsuarioAdmin() {
		return usuarioAdmin;
	}

	public void setUsuarioAdmin(String usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}

	public Supervisados getSupervisados() {
		return supervisados;
	}

	public void setSupervisados(Supervisados supervisados) {
		this.supervisados = supervisados;
	}

	public TipoDocumento getDocAdmin() {
		return docAdmin;
	}

	public void setDocAdmin(TipoDocumento docAdmin) {
		this.docAdmin = docAdmin;
	}
}
