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
import org.springframework.web.bind.annotation.RestController;

import com.sysbithomservices.backend.modelo.entity.Contratantes;
import com.sysbithomservices.backend.modelos.servicios.InterfaceContratantesServicios;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ContratantesRestControlador {

	@Autowired
	private InterfaceContratantesServicios contService;

	@GetMapping("/contratentes")
	public List<Contratantes> index() {
		return contService.findAll();
	}

	@GetMapping("/contratentes/{id}")
	public ResponseEntity<?> show(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		Contratantes contratentes = null;
		try {
			contratentes = contService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de hacer la consulta en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (contratentes == null) {
			response.put("Mensaje",
					"El usuario contratentes con el id: ".concat(String.valueOf(id).concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Contratantes>(contratentes, HttpStatus.OK);
	}

	@PostMapping("/contratentes")
	public ResponseEntity<?> create(@RequestBody Contratantes contratantes) {

		Contratantes contNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			contNew = contService.save(contratantes);
		} catch (Exception e) {
			response.put("Mensaje", "Error al momento de insertar un contratente en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El administrador ha sido creado con exito");
		response.put("Administrador", contNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/contratentes/{id}")
	public ResponseEntity<?> update(@RequestBody Contratantes contratantes, @PathVariable int id) {
		Contratantes contratantesActual = contService.findById(id);

		Contratantes contUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (contratantesActual == null) {
			response.put("Mensaje", "Error: El usuario colaborador con el id "
					.concat(String.valueOf(id).concat(" no existe, y por lo tanto no se logro editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			contratantesActual.setApe_uce(contratantes.getApe_uce());
			contratantesActual.setClave_uce(contratantes.getClave_uce());
			contratantesActual.setNum_documento_uce(contratantes.getNum_documento_uce());
			contratantesActual.setCorreo_uce(contratantes.getCorreo_uce());
			contratantesActual.setCuenta_bancaria_uce(contratantes.getCuenta_bancaria_uce());
			contratantesActual.setF_nacimiento_uce(contratantes.getF_nacimiento_uce());
			contratantesActual.setNom_uce(contratantes.getNom_uce());
			contratantesActual.setTelefono_uce(contratantes.getTelefono_uce());
			contratantesActual.setUsuario_uce(contratantesActual.getUsuario_uce());

			contUpdate = contService.save(contratantesActual);

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de actualizar  en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El contratante ha sido actualizado con exito");
		response.put("Contratante", contUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/contratentes/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();

		try {
			contService.delete(id);
		} catch (Exception e) {
			response.put("Mensaje", "Error al momento de eliminar en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El contratante ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
