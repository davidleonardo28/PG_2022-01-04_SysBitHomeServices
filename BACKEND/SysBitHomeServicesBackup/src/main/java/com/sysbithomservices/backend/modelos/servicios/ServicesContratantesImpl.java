package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysbithomservices.backend.modelo.DAO.InterfaceContratantes;
import com.sysbithomservices.backend.modelo.entity.Contratantes;

@Service
public class ServicesContratantesImpl implements InterfaceContratantesServicios {
	
	@Autowired
	private InterfaceContratantes intContDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contratantes> findAll() {
		return (List<Contratantes>) intContDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Contratantes findById(int id) {
		return intContDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Contratantes save(Contratantes contratantes) {
		return intContDAO.save(contratantes);
	}

	@Override
	@Transactional
	public void delete(int id) {
		intContDAO.deleteById(id);
	}
}
