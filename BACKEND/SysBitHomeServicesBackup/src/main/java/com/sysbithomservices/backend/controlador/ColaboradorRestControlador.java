package com.sysbithomservices.backend.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
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
			response.put("Mensaje",
					"El usuario colaborador con el id: ".concat(String.valueOf(id).concat(" no existe")));
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
			colabNew = colabService.save(new Colaboradores(colaboradores.getNomUcr(), colaboradores.getApeUcr(),
					colaboradores.getCorreoUcr(), colaboradores.getTelefonoUcr(), colaboradores.getNumDocumentoUcr(),
					colaboradores.getCuentaBancaria(), encryptPassword(colaboradores.getClaveUcr()),
					colaboradores.getUsuarioUcr(), colaboradores.getFechaNacimientoUcr(), null,
					colaboradores.gettipoDoc()));
		} catch (Exception e) {
			response.put("Mensaje", "Error al momento de insertar un colaborador en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El administrador ha sido creado con exito");
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
			colaboradorActual.setApeUcr(colaboradores.getApeUcr());
			colaboradorActual.setClaveUcr(colaboradores.getClaveUcr());
			colaboradorActual.setCorreoUcr(colaboradores.getCorreoUcr());
			colaboradorActual.setCuentaBancaria(colaboradores.getCuentaBancaria());
			colaboradorActual.setFechaNacimientoUcr(colaboradores.getFechaNacimientoUcr());
			colaboradorActual.setNomUcr(colaboradores.getNomUcr());
			colaboradorActual.setSeguridadSocial(colaboradores.getSeguridadSocial());
			colaboradorActual.setTelefonoUcr(colaboradores.getTelefonoUcr());
			colaboradorActual.setUsuarioUcr(colaboradores.getUsuarioUcr());

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

	public String encryptPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(password.getBytes());
			byte[] mb = md.digest();

			return Hex.encodeHexString(mb);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
			return "No se pudo encriptar la contraseña";
		}

	}
}
