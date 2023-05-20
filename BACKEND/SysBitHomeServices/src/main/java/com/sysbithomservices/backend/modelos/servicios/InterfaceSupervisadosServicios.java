package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sysbithomservices.backend.modelo.entity.Supervisados;

public interface InterfaceSupervisadosServicios {

    @Query("SELECT s FROM Supervisados s WHERE s.nombRole = :nombreRol")
	public List<Supervisados> findByRole(@Param("nombreRol") String nombreRol);
}
