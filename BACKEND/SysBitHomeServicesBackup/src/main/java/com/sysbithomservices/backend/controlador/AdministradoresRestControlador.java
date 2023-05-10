 package com.sysbithomservices.backend.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysbithomservices.backend.modelo.entity.Administrador;
import com.sysbithomservices.backend.modelos.servicios.InterfaceAdministradorServicios;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdministradoresRestControlador {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContratantesRestControlador.class);

	@Autowired
	private InterfaceAdministradorServicios adminService;

	@Secured("ROLE_ADMIN")
	@GetMapping("/administradores/lista")
	public List<Administrador> index() {
		return adminService.findAll();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/administradores/{id}")
	public ResponseEntity<?> show(@PathVariable int id) {

		Administrador admin = null;

		Map<String, Object> response = new HashMap<>();

		try {
			admin = adminService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de hacer la consulta en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (admin == null) {
			response.put("Mensaje", "El administrador con el id: ".concat(String.valueOf(id).concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Administrador>(admin, HttpStatus.OK);
	}
	
	
	@PostMapping("/administradores")
	public ResponseEntity<?> create(@RequestBody Administrador administradores) {

		Administrador adminNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			adminNew = adminService.save(administradores);
		} catch (Exception e) {
			LOGGER.error("Exception happens", e);
			response.put("Mensaje", "Error al momento de insertar un administrador en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El administrador ha sido creado con exito");
		response.put("Administrador", adminNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/administradores/{id}")
	public ResponseEntity<?> update(@RequestBody Administrador administradores, @PathVariable int id) {
		Administrador administradoresActual = adminService.findById(id);
		Administrador adminUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (administradoresActual == null) {
			response.put("Mensaje", "Error: El administrador con el id "
					.concat(String.valueOf(id).concat(" no existe, y por lo tanto no se logro editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			administradoresActual.setApeAdmin(administradores.getApeAdmin());
			administradoresActual.setPassword(administradores.getPassword());
			administradoresActual.setNomAdmin(administradores.getNomAdmin());
			administradoresActual.setNumDocumentoAdmin(administradores.getNumDocumentoAdmin());
			administradoresActual.setTelefonoAdmin(administradores.getTelefonoAdmin());
			administradoresActual.setUsername(administradores.getUsername());

			adminUpdate = adminService.save(administradoresActual);

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de actualizar  en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El administrador ha sido actualizado con exito");
		response.put("Administrador", adminUpdate);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/administradores/{id}")
	public ResponseEntity<?>  delete(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();

		try {
			adminService.delete(id);
		} catch (Exception e) {
			response.put("Mensaje", "Error al momento de eliminar en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El administrador ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
}
