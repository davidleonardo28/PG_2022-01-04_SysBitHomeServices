package com.sysbithomservices.backend.modelo.DAO;

import org.springframework.data.repository.CrudRepository;
import com.sysbithomservices.backend.modelo.entity.TipoDocumento;

public interface InterfaceTipoDocu extends CrudRepository<TipoDocumento, Integer>{

}
