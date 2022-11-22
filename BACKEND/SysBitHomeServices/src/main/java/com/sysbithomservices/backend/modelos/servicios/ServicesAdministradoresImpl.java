package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysbithomservices.backend.modelo.DAO.InterfaceAdminstrador;
import com.sysbithomservices.backend.modelo.entity.Administradores;

@Service
public class ServicesAdministradoresImpl implements InterfaceAdministradorServicios {
	
	@Autowired
	private InterfaceAdminstrador intAdminDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Administradores> findAll() {
		return (List<Administradores>) intAdminDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Administradores findById(int id) {
		return intAdminDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Administradores save(Administradores contratantes) {
		return intAdminDAO.save(contratantes);
	}

	@Override
	@Transactional
	public void delete(int id) {
		intAdminDAO.deleteById(id);
	}
}
