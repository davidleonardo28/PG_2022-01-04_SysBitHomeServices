package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import com.sysbithomservices.backend.modelo.entity.Colaboradores;

public interface InterfaceColaboradoresServicios {

	public List<Colaboradores> findAll();
	
	public Colaboradores findById(int id);
	
	public Colaboradores save(Colaboradores colaboradores);
	
	public void delete(int id);
	
	public Colaboradores findByUsername(String username);

}
