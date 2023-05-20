package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbithomservices.backend.modelo.DAO.InterfaceSupervisor;
import com.sysbithomservices.backend.modelo.entity.Supervisados;

@Service
public class ServicesSupervisadosImpl implements InterfaceSupervisadosServicios {
	
	@Autowired
	private InterfaceSupervisor intSupe;

	@Override
	public List<Supervisados> findByRole(String nombreRol) {
		return intSupe.findByRole(nombreRol);
	}

}
