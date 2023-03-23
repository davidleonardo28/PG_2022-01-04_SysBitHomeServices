package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import com.sysbithomservices.backend.modelo.entity.Administradores;

public interface InterfaceAdministradorServicios {

	public List<Administradores> findAll();
	
	public Administradores findById(int id);
	
	public Administradores save(Administradores contratantes);
	
	public void delete(int id);
	
}
