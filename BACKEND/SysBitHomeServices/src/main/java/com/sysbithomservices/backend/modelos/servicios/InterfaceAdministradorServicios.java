package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import com.sysbithomservices.backend.modelo.entity.Administrador;

public interface InterfaceAdministradorServicios {

	public List<Administrador> findAll();
	
	public Administrador findById(int id);
	
	public Administrador save(Administrador administrador);
	
	public void delete(int id);
	
	public Administrador findByUsername(String username);
}
