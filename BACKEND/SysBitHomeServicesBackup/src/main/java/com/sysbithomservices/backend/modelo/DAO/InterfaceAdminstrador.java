package com.sysbithomservices.backend.modelo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.sysbithomservices.backend.modelo.entity.Administrador;

public interface InterfaceAdminstrador extends CrudRepository<Administrador, Integer>{
	
	public Administrador findByUsername(String username);
}
