package com.sysbithomservices.backend.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
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
import com.sysbithomservices.backend.modelo.entity.Supervisados;
import com.sysbithomservices.backend.modelos.servicios.InterfaceContratantesServicios;
import com.sysbithomservices.backend.modelos.servicios.ServicesSupervisadosImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ContratantesRestControlador {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContratantesRestControlador.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private InterfaceContratantesServicios contService;

	@Autowired
	private ServicesSupervisadosImpl SupervisorService;

	String smtpHost = "smtp.gmail.com";
	int smtpPort = 587; 

	String senderEmail = "diego.veloza18@gmail.com";
	String senderPassword = "idmnjaeofomtebns";

	Properties properties = new Properties();

	@Secured("ROLE_ADMIN")
	@GetMapping("/contratentes/Lista")
	public List<Contratantes> index() {
		return contService.findAll();
	}

	@Secured("ROLE_ADMIN")
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
	public ResponseEntity<?> create(@Valid @RequestBody Contratantes contratantes, BindingResult result) {
		Contratantes contNew = null;
		Map<String, Object> response = new HashMap<>();

		String subject;
		String body;
		List<Supervisados> roles = SupervisorService.findByRole("ROLE_UCE");

		if (result.hasErrors()) {

			List<String> errores = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("Errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		try {
			if (!contratantes.getClaveUce().equals(contratantes.getConfirmClaveUce())) {
				response.put("Mensaje", "Las contraseñas ingresadas no coinciden");
			} else {
				if (!roles.isEmpty()) {
					contNew = contService.save(new Contratantes(contratantes.getNomUce(), contratantes.getApeUce(),
							contratantes.getCorreoUce(), contratantes.getTelefonoUce(),
							passwordEncoder.encode(contratantes.getClaveUce()), contratantes.getNumDocumentoUce(),
							contratantes.getUsername(), contratantes.getFechaNacimientoUce(),
							contratantes.getTipoDocContratantes(), roles, true));
					
					subject = "Bienviendo " + contratantes.getUsername() + " a SysBitHomeServices";
					body = "Cordial saludo, estimado colaborador: " + contratantes.getNomUce() + " "
							+ contratantes.getApeUce() + ".\r\n\n"
							+ "Le informamos que los documentos que adjuntó en su cuenta, han sido verificados correctamente.\r\n"
							+ "¡Ya puedes adquirir el servicio laboral doméstico que necesites!\r\n";

					Email(subject, body, contratantes.getCorreoUce());
				} else {
					response.put("Mensaje", "El Rol no ha sido encontrado");
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception happens", e);
			response.put("Mensaje", "Error al momento de insertar un contratente en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		if (contNew == null) {
			response.put("mensaje", "Datos nulos no se puede ingresar a la BD");

		} else
			response.put("mensaje", "El contratantes ha sido creado con exito");
		response.put("Contratantes", contNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@Secured({ "ROLE_ADMIN", "ROLE_UCE" })
	@PutMapping("/contratentes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Contratantes contratantes, BindingResult result,
			@PathVariable int id) {
		Contratantes contratantesActual = contService.findById(id);

		Map<String, Object> response = new HashMap<>();

		Contratantes contUpdate = null;
		if (result.hasErrors()) {

			List<String> errores = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("Errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		if (contratantesActual == null) {
			response.put("Mensaje", "Error: El usuario colaborador con el id "
					.concat(String.valueOf(id).concat(" no existe, y por lo tanto no se logro editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			contratantesActual.setApeUce(contratantes.getApeUce());
			contratantesActual.setClaveUce(passwordEncoder.encode(contratantes.getClaveUce()));
			contratantesActual.setNumDocumentoUce(contratantes.getNumDocumentoUce());
			contratantesActual.setCorreoUce(contratantes.getCorreoUce());
			contratantesActual.setFechaNacimientoUce(contratantes.getFechaNacimientoUce());
			contratantesActual.setNomUce(contratantes.getNomUce());
			contratantesActual.setTelefonoUce(contratantes.getTelefonoUce());
			contratantesActual.setUsername(contratantes.getUsername());

			contUpdate = contService.save(contratantesActual);

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al momento de actualizar  en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El contratante ha sido actualizado con exito");
		response.put("Contratante", contUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_UCE" })
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
	public void Email(String subject, String body, String recipientEmail) {
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); 
		properties.put("mail.smtp.starttls.protocols", "TLSv1.2"); 
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.port", smtpPort);

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);

			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			System.out.println("Failed to send email. Error: " + e.getMessage());
		}

	}
}
