package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sysbithomservices.backend.modelo.entity.TipoDocumento;

public interface InterfaceTipoDocumServicios {

	public List<TipoDocumento> findAll();
    @Query("SELECT t FROM TipoDocumento t WHERE t.nombreTipoDocumento = :nombreTipoDocumento")
	public TipoDocumento intTipoDocDAO(@Param("nombreTipoDocumento") String nombreTipoDocumento);
		
}
