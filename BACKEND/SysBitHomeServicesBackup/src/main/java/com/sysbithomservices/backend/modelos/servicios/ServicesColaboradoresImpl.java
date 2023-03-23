package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysbithomservices.backend.modelo.DAO.InterfaceColaboradores;
import com.sysbithomservices.backend.modelo.entity.Colaboradores;

@Service
public class ServicesColaboradoresImpl implements InterfaceColaboradoresServicios {
	
	@Autowired
	private InterfaceColaboradores intColDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Colaboradores> findAll() {
		return (List<Colaboradores>) intColDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Colaboradores findById(int id) {
		return intColDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Colaboradores save(Colaboradores colaboradores) {
		return intColDAO.save(colaboradores);
	}

	@Override
	@Transactional
	public void delete(int id) {
		intColDAO.deleteById(id);
	}
}
