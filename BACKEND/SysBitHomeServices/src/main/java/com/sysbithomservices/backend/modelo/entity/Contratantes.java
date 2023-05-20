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
@Table(name="contratantes")
public class Contratantes implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codUce;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=50, message ="no puede tener mas de 50 caracteres")
	@Column(length = 50)
	String nomUce;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=50, message ="no puede tener mas de 50 caracteres")
	@Column(length = 50)
	String apeUce;

	@NotEmpty(message ="no puede estar vacio")
	@Email(message ="el correo es incorrecto")
	@Column(nullable = false, unique = true)
	String correoUce;
	
	@NotNull(message ="no puede estar vacio")
	@Column(nullable = false)
	Long telefonoUce;

	@NotEmpty(message ="no puede estar vacio")
	@Column(nullable = false)
	String claveUce;

	String confirmClaveUce;
	
	@NotNull(message ="no puede estar vacio")
	@Column(nullable = false)
	Long numDocumentoUce;

	@NotEmpty(message ="no puede estar vacio")
	@Column(length = 50, nullable = false, unique = true)
	String username;
	
	@NotNull(message ="no puede estar vacio")
	@Temporal(TemporalType.DATE)
	Date fechaNacimientoUce;
	
	@NotNull(message ="no puede estar vacio")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "docCont")
	TipoDocumento tipoDocContratantes;
	
	Boolean enable;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "uce_authorities", joinColumns = @JoinColumn(name= "uce_id"),
	inverseJoinColumns = @JoinColumn(name= "role_id"))
	List<Supervisados> supervisados;
	
	public Contratantes() {
		
	}

	public Contratantes(int codUce, String nomUce, String apeUce, String correoUce, Long telefonoUce, String claveUce,
			Long numDocumentoUce, String username, Date fechaNacimientoUce,
			TipoDocumento tipoDocContratantes) {
		super();
		this.codUce = codUce;
		this.nomUce = nomUce;
		this.apeUce = apeUce;
		this.correoUce = correoUce;
		this.telefonoUce = telefonoUce;
		this.claveUce = claveUce;
		this.numDocumentoUce = numDocumentoUce;
		this.username = username;
		this.fechaNacimientoUce = fechaNacimientoUce;
		this.tipoDocContratantes = tipoDocContratantes;
	}
	
	public Contratantes(String nomUce, String apeUce, String correoUce, Long telefonoUce, String claveUce,
			Long numDocumentoUce, String username, Date fechaNacimientoUce, 
			TipoDocumento tipoDocContratantes, List<Supervisados> supervisado, boolean enable) {
		this.nomUce = nomUce;
		this.apeUce = apeUce;
		this.correoUce = correoUce;
		this.telefonoUce = telefonoUce;
		this.claveUce = claveUce;
		this.numDocumentoUce = numDocumentoUce;
		this.username = username;
		this.fechaNacimientoUce = fechaNacimientoUce;
		this.tipoDocContratantes = tipoDocContratantes;
		this.supervisados = supervisado;
		this.enable = enable;
		
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
	

	public String getConfirmClaveUce() {
		return confirmClaveUce;
	}

	public void setConfirmClaveUce(String confirmClaveUce) {
		this.confirmClaveUce = confirmClaveUce;
	}

	public Long getNumDocumentoUce() {
		return numDocumentoUce;
	}


	public void setNumDocumentoUce(Long numDocumentoUce) {
		this.numDocumentoUce = numDocumentoUce;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFechaNacimientoUce() {
		return fechaNacimientoUce;
	}

	public void setFechaNacimientoUce(Date fechaNacimientoUce) {
		this.fechaNacimientoUce = fechaNacimientoUce;
	}

	public TipoDocumento getTipoDocContratantes() {
		return tipoDocContratantes;
	}

	public void setTipoDocContratantes(TipoDocumento tipoDocContratantes) {
		this.tipoDocContratantes = tipoDocContratantes;
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
