package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbithomservices.backend.modelo.DAO.InterfaceTipoDocu;
import com.sysbithomservices.backend.modelo.entity.TipoDocumento;

@Service
public class ServicesTipoDocuImpl implements InterfaceTipoDocumServicios {
	
	@Autowired
	private InterfaceTipoDocu intTipoDocDAO;

	@Override
	public List<TipoDocumento> findAll() {

		return (List<TipoDocumento>) intTipoDocDAO.findAll();
	}

	@Override
	public TipoDocumento intTipoDocDAO(String nombreTipoDocumento) {
		return intTipoDocDAO.findByNomTipDoc(nombreTipoDocumento);
	}
}
