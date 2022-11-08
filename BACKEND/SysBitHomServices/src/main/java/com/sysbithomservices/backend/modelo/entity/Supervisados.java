package com.sysbithomservices.backend.modelo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supervisados")
public class Supervisados implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int cod_admin;
	int cod_ucr;
	int cod_uce;
	
	public Supervisados(int id, int cod_admin, int cod_ucr, int cod_uce) {
		super();
		this.id = id;
		this.cod_admin = cod_admin;
		this.cod_ucr = cod_ucr;
		this.cod_uce = cod_uce;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCod_admin() {
		return cod_admin;
	}
	public void setCod_admin(int cod_admin) {
		this.cod_admin = cod_admin;
	}
	public int getCod_ucr() {
		return cod_ucr;
	}
	public void setCod_ucr(int cod_ucr) {
		this.cod_ucr = cod_ucr;
	}
	public int getCod_uce() {
		return cod_uce;
	}
	public void setCod_uce(int cod_uce) {
		this.cod_uce = cod_uce;
	}
	
}
