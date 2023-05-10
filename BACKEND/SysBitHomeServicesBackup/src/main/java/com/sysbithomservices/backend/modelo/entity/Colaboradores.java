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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="colaboradores")
public class Colaboradores implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codUcr;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=50, message ="no puede tener mas de 50 caracteres")
	@Column(length = 50, nullable = false)
	String nomUcr;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=50, message ="no puede tener mas de 50 caracteres")
	@Column(length = 50, nullable = false)
	String apeUcr;
	
	@NotEmpty(message ="no puede estar vacio")
	@Email(message ="el correo es incorrecto")
	@Column(nullable = false, unique = true)
	String correoUcr;
	
	@NotNull(message ="no puede estar vacio")
	@Column(nullable = false)
	Long telefonoUcr;
	
	@NotNull(message ="no puede estar vacio")
	@Column(nullable = false)
	Long numDocumentoUcr;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(nullable = false)
	String claveUcr;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(length = 10, nullable = false, unique = true)
	String username;
	
	@NotNull(message ="no puede estar vacio")
	@Temporal(TemporalType.DATE)
	Date fechaNacimientoUcr;
	
	@NotNull(message ="no puede estar vacio")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doc_colab")	
	TipoDocumento tipoDoc;
	
	Boolean enable;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ucr_authorities", joinColumns = @JoinColumn(name= "ucr_id"),
	inverseJoinColumns = @JoinColumn(name= "role_id"))
	List<Supervisados> supervisados;
		
	public Colaboradores() {
		
	}

	public Colaboradores(int codUcr, String nomUcr, String apeUcr, String correoUcr, Long telefonoUcr,
			Long numDocumentoUcr, String claveUcr, String username, Date fechaNacimientoUcr,
			 TipoDocumento tipoDoc) {
		super();
		this.codUcr = codUcr;
		this.nomUcr = nomUcr;
		this.apeUcr = apeUcr;
		this.correoUcr = correoUcr;
		this.telefonoUcr = telefonoUcr;
		this.numDocumentoUcr = numDocumentoUcr;
		this.claveUcr = claveUcr;
		this.username = username;
		this.fechaNacimientoUcr = fechaNacimientoUcr;
		this.tipoDoc = tipoDoc;
	}

	
	
	public Colaboradores(String nomUcr, String apeUcr, String correoUcr, Long telefonoUcr, Long numDocumentoUcr,
		 String claveUcr, String username, Date fechaNacimientoUcr, TipoDocumento tipoDoc) {
		this.nomUcr = nomUcr;
		this.apeUcr = apeUcr;
		this.correoUcr = correoUcr;
		this.telefonoUcr = telefonoUcr;
		this.numDocumentoUcr = numDocumentoUcr;
		this.claveUcr = claveUcr;
		this.username = username;
		this.fechaNacimientoUcr = fechaNacimientoUcr;
		this.tipoDoc = tipoDoc;
	}

	public int getCodUcr() {
		return codUcr;
	}

	public void setCodUcr(int codUcr) {
		this.codUcr = codUcr;
	}

	public String getNomUcr() {
		return nomUcr;
	}

	public void setNomUcr(String nomUcr) {
		this.nomUcr = nomUcr;
	}

	public String getApeUcr() {
		return apeUcr;
	}

	public void setApeUcr(String apeUcr) {
		this.apeUcr = apeUcr;
	}

	public String getCorreoUcr() {
		return correoUcr;
	}

	public void setCorreoUcr(String correoUcr) {
		this.correoUcr = correoUcr;
	}

	public Long getTelefonoUcr() {
		return telefonoUcr;
	}

	public void setTelefonoUcr(Long telefonoUcr) {
		this.telefonoUcr = telefonoUcr;
	}

	public Long getNumDocumentoUcr() {
		return numDocumentoUcr;
	}

	public void setNumDocumentoUcr(Long numDocumentoUcr) {
		this.numDocumentoUcr = numDocumentoUcr;
	}

	public String getClaveUcr() {
		return claveUcr;
	}

	public void setClaveUcr(String claveUcr) {
		this.claveUcr = claveUcr;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Date getFechaNacimientoUcr() {
		return fechaNacimientoUcr;
	}

	public void setFechaNacimientoUcr(Date fechaNacimientoUcr) {
		this.fechaNacimientoUcr = fechaNacimientoUcr;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public List<Supervisados> getSupervisados() {
		return supervisados;
	}

	public void setSupervisados(List<Supervisados> supervisados) {
		this.supervisados = supervisados;
	}
}
