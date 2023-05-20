package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import com.sysbithomservices.backend.modelo.entity.Contratantes;

public interface InterfaceContratantesServicios {

	public List<Contratantes> findAll();
	
	public Contratantes findById(int id);
	
	public Contratantes save(Contratantes contratantes);
	
	public void delete(int id);
	
	public Contratantes findByUsername(String username);

	
}
