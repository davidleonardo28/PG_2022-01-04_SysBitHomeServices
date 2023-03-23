package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contratantes")
public class Contratantes implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codUce;
	
	@Column(length = 50)
	String nomUce;
	
	@Column(length = 50)
	String apeUce;
	
	@Column(nullable = false, unique = true)
	String correoUce;
	@Column(nullable = false)
	Long telefonoUce;

	@Column(nullable = false)
	String claveUce;
	
	@Column(nullable = false)
	Long numDocumentoUce;

	@Column(length = 50, nullable = false, unique = true)
	String usuarioUce;
	
	@Temporal(TemporalType.DATE)
	Date fechaNacimientoUce;
	
	@OneToOne(mappedBy = "cont", fetch = FetchType.LAZY)
	Supervisados supervisadosList;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "docCont")
	TipoDocumento tipoDocContratantes;
	
	public Contratantes() {
		
	}

	public Contratantes(int codUce, String nomUce, String apeUce, String correoUce, Long telefonoUce, String claveUce,
			Long numDocumentoUce, String usuarioUce, Date fechaNacimientoUce, Supervisados supervisadosList,
			TipoDocumento tipoDocContratantes) {
		super();
		this.codUce = codUce;
		this.nomUce = nomUce;
		this.apeUce = apeUce;
		this.correoUce = correoUce;
		this.telefonoUce = telefonoUce;
		this.claveUce = claveUce;
		this.numDocumentoUce = numDocumentoUce;
		this.usuarioUce = usuarioUce;
		this.fechaNacimientoUce = fechaNacimientoUce;
		this.supervisadosList = supervisadosList;
		this.tipoDocContratantes = tipoDocContratantes;
	}
	
	public Contratantes(String nomUce, String apeUce, String correoUce, Long telefonoUce, String claveUce,
			Long numDocumentoUce, String usuarioUce, Date fechaNacimientoUce, Supervisados supervisadosList,
			TipoDocumento tipoDocContratantes) {
		this.nomUce = nomUce;
		this.apeUce = apeUce;
		this.correoUce = correoUce;
		this.telefonoUce = telefonoUce;
		this.claveUce = claveUce;
		this.numDocumentoUce = numDocumentoUce;
		this.usuarioUce = usuarioUce;
		this.fechaNacimientoUce = fechaNacimientoUce;
		this.supervisadosList = supervisadosList;
		this.tipoDocContratantes = tipoDocContratantes;
		
	}

	public int getCodUce() {
		return codUce;
	}

	public void setCodUce(int codUce) {
		this.codUce = codUce;
	}

	public String getNomUce() {
		return nomUce;
	}

	public void setNomUce(String nomUce) {
		this.nomUce = nomUce;
	}

	public String getApeUce() {
		return apeUce;
	}

	public void setApeUce(String apeUce) {
		this.apeUce = apeUce;
	}

	public String getCorreoUce() {
		return correoUce;
	}

	public void setCorreoUce(String correoUce) {
		this.correoUce = correoUce;
	}

	public Long getTelefonoUce() {
		return telefonoUce;
	}

	public void setTelefonoUce(Long telefonoUce) {
		this.telefonoUce = telefonoUce;
	}

	public String getClaveUce() {
		return claveUce;
	}

	public void setClaveUce(String claveUce) {
		this.claveUce = claveUce;
	}

	public Long getNumDocumentoUce() {
		return numDocumentoUce;
	}

	public void setNumDocumentoUce(Long numDocumentoUce) {
		this.numDocumentoUce = numDocumentoUce;
	}

	public String getUsuarioUce() {
		return usuarioUce;
	}

	public void setUsuarioUce(String usuarioUce) {
		this.usuarioUce = usuarioUce;
	}

	public Date getFechaNacimientoUce() {
		return fechaNacimientoUce;
	}

	public void setFechaNacimientoUce(Date fechaNacimientoUce) {
		this.fechaNacimientoUce = fechaNacimientoUce;
	}

	public Supervisados getSupervisadosList() {
		return supervisadosList;
	}

	public void setSupervisadosList(Supervisados supervisadosList) {
		this.supervisadosList = supervisadosList;
	}

	public TipoDocumento getTipoDocContratantes() {
		return tipoDocContratantes;
	}

	public void setTipoDocContratantes(TipoDocumento tipoDocContratantes) {
		this.tipoDocContratantes = tipoDocContratantes;
	}
}
