package com.sysbithomservices.backend.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sysbithomservices.backend.modelo.entity.Colaboradores;
import com.sysbithomservices.backend.modelos.servicios.InterfaceColaboradoresServicios;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ColaboradorRestControlador {

	@Autowired
	private InterfaceColaboradoresServicios colabService;

	@GetMapping("/colaboradores")
	public List<Colaboradores> index() {
		return colabService.findAll();
	}

	@GetMapping("/colaboradores/{id}")
	public ResponseEntity<?> show(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		Colaboradores colaborador = null;
		try {
			colaborador = colabService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de hacer la consulta en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (colaborador == null) {
			response.put("Mensaje", "El usuario colaborador con el id: ".concat(String.valueOf(id).concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Colaboradores>(colaborador, HttpStatus.OK);
	}

	@PostMapping("/colaboradores")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Colaboradores colaboradores) {
		
		Colaboradores colabNew = null;
		Map<String, Object> response = new HashMap<>();
 
		try {
			colabNew = colabService.save(colaboradores);;
		} catch (Exception e) {
			response.put("Mensaje", "Error al momento de insertar un colaborador en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El administrador ha sido creado con exito");
		response.put("Administrador", colabNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/colaboradores/{id}")
	public ResponseEntity<?> update(@RequestBody Colaboradores colaboradores, @PathVariable int id) {
		Colaboradores colaboradorActual = colabService.findById(id);
		Colaboradores colabUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (colaboradorActual == null) {
			response.put("Mensaje", "Error: El usuario colaborador con el id "
					.concat(String.valueOf(id).concat(" no existe, y por lo tanto no se logro editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
		colaboradorActual.setApe_ucr(colaboradores.getApe_ucr());
		colaboradorActual.setClave_ucr(colaboradores.getClave_ucr());
		colaboradorActual.setCorreo_ucr(colaboradores.getCorreo_ucr());
		colaboradorActual.setCuenta_bancaria(colaboradores.getCuenta_bancaria());
		colaboradorActual.setF_nacimiento_ucr(colaboradores.getF_nacimiento_ucr());
		colaboradorActual.setNom_ucr(colaboradores.getNom_ucr());
		colaboradorActual.setSeguridad_social(colaboradores.getSeguridad_social());
		colaboradorActual.setTelefono_ucr(colaboradores.getTelefono_ucr());
		colaboradorActual.setUsuario_ucr(colaboradores.getUsuario_ucr());
		
		colabUpdate = colabService.save(colaboradorActual);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de actualizar en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El colaborador ha sido actualizado con exito");
		response.put("Colaborador", colabUpdate);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/colaboradores/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();

		try {
			colabService.delete(id);
		} catch (Exception e) {
			response.put("Mensaje", "Error al momento de eliminar en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El colaborador ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
