package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.apache.commons.codec.binary.Hex;

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
@Table(name="colaboradores")
public class Colaboradores implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codUcr;
	
	@Column(length = 50, nullable = false)
	String nomUcr;
	
	@Column(length = 50, nullable = false)
	String apeUcr;
	
	@Column(nullable = false, unique = true)
	String correoUcr;
	
	@Column(nullable = false)
	Long telefonoUcr;
	
	@Column(nullable = false)
	Long numDocumentoUcr;
	
	@Column(nullable = false)
	Long cuentaBancaria;
	
	@Column(nullable = false)
	String claveUcr;
	
	@Column(length = 10, nullable = false, unique = true)
	String usuarioUcr;
	
	@Temporal(TemporalType.DATE)
	Date fechaNacimientoUcr;
	
	String seguridadSocial;
	
	@OneToOne(mappedBy = "colab", fetch = FetchType.LAZY)
	Supervisados supervisadosList;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doc_colab")	
	TipoDocumento tipoDoc;
		
	public Colaboradores() {
		
	}

	public Colaboradores(int codUcr, String nomUcr, String apeUcr, String correoUcr, Long telefonoUcr,
			Long numDocumentoUcr, Long cuentaBancaria, String claveUcr, String usuarioUcr, Date fechaNacimientoUcr,
			String seguridadSocial, Supervisados supervisadosList, TipoDocumento tipoDoc) {
		super();
		this.codUcr = codUcr;
		this.nomUcr = nomUcr;
		this.apeUcr = apeUcr;
		this.correoUcr = correoUcr;
		this.telefonoUcr = telefonoUcr;
		this.numDocumentoUcr = numDocumentoUcr;
		this.cuentaBancaria = cuentaBancaria;
		this.claveUcr = claveUcr;
		this.usuarioUcr = usuarioUcr;
		this.fechaNacimientoUcr = fechaNacimientoUcr;
		this.seguridadSocial = seguridadSocial;
		this.supervisadosList = supervisadosList;
		this.tipoDoc = tipoDoc;
	}

	
	
	public Colaboradores(String nomUcr, String apeUcr, String correoUcr, Long telefonoUcr, Long numDocumentoUcr,
			Long cuentaBancaria, String claveUcr, String usuarioUcr, Date fechaNacimientoUcr,
			Supervisados supervisadosList, TipoDocumento tipoDoc) {
		this.nomUcr = nomUcr;
		this.apeUcr = apeUcr;
		this.correoUcr = correoUcr;
		this.telefonoUcr = telefonoUcr;
		this.numDocumentoUcr = numDocumentoUcr;
		this.cuentaBancaria = cuentaBancaria;
		this.claveUcr = claveUcr;
		this.usuarioUcr = usuarioUcr;
		this.fechaNacimientoUcr = fechaNacimientoUcr;
		this.supervisadosList = supervisadosList;
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

	public Long getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(Long cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public String getClaveUcr() {
		return claveUcr;
	}

	public void setClaveUcr(String claveUcr) {
		this.claveUcr = claveUcr;
	}

	public String getUsuarioUcr() {
		return usuarioUcr;
	}

	public void setUsuarioUcr(String usuarioUcr) {
		this.usuarioUcr = usuarioUcr;
	}

	public Date getFechaNacimientoUcr() {
		return fechaNacimientoUcr;
	}

	public void setFechaNacimientoUcr(Date fechaNacimientoUcr) {
		this.fechaNacimientoUcr = fechaNacimientoUcr;
	}

	public String getSeguridadSocial() {
		return seguridadSocial;
	}

	public void setSeguridadSocial(String seguridadSocial) {
		this.seguridadSocial = seguridadSocial;
	}

	public Supervisados getSupervisadosList() {
		return supervisadosList;
	}

	public void setSupervisadosList(Supervisados supervisadosList) {
		this.supervisadosList = supervisadosList;
	}

	public TipoDocumento gettipoDoc() {
		return tipoDoc;
	}

	public void setDocColab(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	
}
