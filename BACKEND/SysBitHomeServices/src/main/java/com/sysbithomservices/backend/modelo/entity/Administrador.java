package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;
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

@Entity
@Table(name="administradores")
public class Administrador implements Serializable{

	private static final long serialVersionUID = 1L;

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
	String password;
	
	@Column(nullable = false)
	Long telefonoAdmin;
	
	@Column(nullable = false)
	Long numDocumentoAdmin;
	
	@Column(nullable = false, unique = true)
	String username;
	
	Boolean enable;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "admin_authorities", joinColumns = @JoinColumn(name= "admin_id"),
	inverseJoinColumns = @JoinColumn(name= "role_id"))
	List<Supervisados> supervisados;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doc_admin")
	TipoDocumento docAdmin;

	public Administrador() {
		
	}

	public Administrador(String nomAdmin, String apeAdmin, String correoAdmin, String password,
			Long telefonoAdmin, Long numDocumentoAdmin, String username,
			TipoDocumento docAdmin) {
		super();
		this.nomAdmin = nomAdmin;
		this.apeAdmin = apeAdmin;
		this.correoAdmin = correoAdmin;
		this.password = password;
		this.telefonoAdmin = telefonoAdmin;
		this.numDocumentoAdmin = numDocumentoAdmin;
		this.username = username;
		this.docAdmin = docAdmin;
	}

	public Administrador(String nomAdmin, String apeAdmin, String correoAdmin, String password, Long telefonoAdmin,
			Long numDocumentoAdmin, String username, Boolean enable, List<Supervisados> supervisados,
			TipoDocumento docAdmin) {
		super();
		this.nomAdmin = nomAdmin;
		this.apeAdmin = apeAdmin;
		this.correoAdmin = correoAdmin;
		this.password = password;
		this.telefonoAdmin = telefonoAdmin;
		this.numDocumentoAdmin = numDocumentoAdmin;
		this.username = username;
		this.enable = enable;
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


	public TipoDocumento getDocAdmin() {
		return docAdmin;
	}

	public void setDocAdmin(TipoDocumento docAdmin) {
		this.docAdmin = docAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
