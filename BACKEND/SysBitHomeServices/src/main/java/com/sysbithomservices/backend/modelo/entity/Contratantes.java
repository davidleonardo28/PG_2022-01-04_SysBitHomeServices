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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contratantes")
public class Contratantes implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_uce;
	
	@Column(length = 50)
	String nom_uce;
	
	@Column(length = 50)
	String ape_uce;
	
	@Column(nullable = false, unique = true)
	String correo_uce;
	@Column(nullable = false)
	Long telefono_uce;
	@Column(nullable = false)
	Long cuenta_bancaria_uce;
	@Column(nullable = false)
	String clave_uce;
	@Column(nullable = false)
	Long num_documento_uce;

	@Column(length = 50, nullable = false, unique = true)
	String usuario_uce;
	
	@Temporal(TemporalType.DATE)
	Date f_nacimiento_uce;
	
	@OneToOne(mappedBy = "cont", fetch = FetchType.LAZY)
	Supervisados supervisadosList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cont_docCont")
	DocumentosUce docCont;
	
	public Contratantes() {
		
	}

	public Contratantes(String nom_uce, String ape_uce, String correo_uce, Long telefono_uce,
			Long cuenta_bancaria_uce, String clave_uce, Long num_documento_uce, String usuario_uce,
			Date f_nacimiento_uce, Supervisados supervisadosList, DocumentosUce docCont) {
		super();
		this.nom_uce = nom_uce;
		this.ape_uce = ape_uce;
		this.correo_uce = correo_uce;
		this.telefono_uce = telefono_uce;
		this.cuenta_bancaria_uce = cuenta_bancaria_uce;
		this.clave_uce = clave_uce;
		this.num_documento_uce = num_documento_uce;
		this.usuario_uce = usuario_uce;
		this.f_nacimiento_uce = f_nacimiento_uce;
		this.supervisadosList = supervisadosList;
		this.docCont = docCont;
	}

	public int getCod_uce() {
		return cod_uce;
	}

	public void setCod_uce(int cod_uce) {
		this.cod_uce = cod_uce;
	}

	public String getNom_uce() {
		return nom_uce;
	}

	public void setNom_uce(String nom_uce) {
		this.nom_uce = nom_uce;
	}

	public String getApe_uce() {
		return ape_uce;
	}

	public void setApe_uce(String ape_uce) {
		this.ape_uce = ape_uce;
	}

	public String getCorreo_uce() {
		return correo_uce;
	}

	public void setCorreo_uce(String correo_uce) {
		this.correo_uce = correo_uce;
	}

	public Long getTelefono_uce() {
		return telefono_uce;
	}

	public void setTelefono_uce(Long telefono_uce) {
		this.telefono_uce = telefono_uce;
	}

	public Long getCuenta_bancaria_uce() {
		return cuenta_bancaria_uce;
	}

	public void setCuenta_bancaria_uce(Long cuenta_bancaria_uce) {
		this.cuenta_bancaria_uce = cuenta_bancaria_uce;
	}

	public String getClave_uce() {
		return clave_uce;
	}

	public void setClave_uce(String clave_uce) {
		this.clave_uce = clave_uce;
	}

	public Long getNum_documento_uce() {
		return num_documento_uce;
	}

	public void setNum_documento_uce(Long cod_tipo_documento) {
		this.num_documento_uce = cod_tipo_documento;
	}

	public String getUsuario_uce() {
		return usuario_uce;
	}

	public void setUsuario_uce(String usuario_uce) {
		this.usuario_uce = usuario_uce;
	}

	public Date getF_nacimiento_uce() {
		return f_nacimiento_uce;
	}

	public void setF_nacimiento_uce(Date f_nacimiento_uce) {
		this.f_nacimiento_uce = f_nacimiento_uce;
	}

	public Supervisados getSupervisadosList() {
		return supervisadosList;
	}

	public void setSupervisadosList(Supervisados supervisadosList) {
		this.supervisadosList = supervisadosList;
	}

	public DocumentosUce getDocCont() {
		return docCont;
	}

	public void setDocCont(DocumentosUce docCont) {
		this.docCont = docCont;
	}
}
