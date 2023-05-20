package com.sysbithomservices.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysbithomservices.backend.modelo.entity.TipoDocumento;
import com.sysbithomservices.backend.modelos.servicios.InterfaceTipoDocumServicios;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TipoDocRestControlador {

	@Autowired
	private InterfaceTipoDocumServicios tipoDocService;

	@GetMapping("/TipoDocumentos")
	public List<TipoDocumento> index() {
		return tipoDocService.findAll();
	}
}
