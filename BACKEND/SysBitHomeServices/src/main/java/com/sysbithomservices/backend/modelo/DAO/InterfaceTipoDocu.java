package com.sysbithomservices.backend.modelo.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sysbithomservices.backend.modelo.entity.TipoDocumento;

public interface InterfaceTipoDocu extends CrudRepository<TipoDocumento, Integer>{
    @Query("SELECT t FROM TipoDocumento t WHERE t.nombreTipoDocumento = :nombreTipoDocumento")
	public TipoDocumento findByNomTipDoc(@Param("nombreTipoDocumento") String nombreTipoDocumento);
}
