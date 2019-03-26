package dev.nicesoft.pruebaspringjwt.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.nicesoft.pruebaspringjwt.domain.Persona;
import dev.nicesoft.pruebaspringjwt.service.PersonaService;

@RestController("/")
@CrossOrigin(origins="*")
public class PersonaRestController {
	
	@Autowired
	private PersonaService personaService;
	
	
	@PostMapping("/personas")
	public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
		Map<String, Object> response = new HashMap<>();
		try {
			Persona nuevaPersona = this.personaService.crearActualizar(persona);
			response.put("mensaje", "La persona ha sido creada exitosamente");
			response.put("entity", nuevaPersona);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("mensaje", "Error al crear la persona: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/personas")
	public ResponseEntity<?> listarPersonas() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Persona> listaPersonas = this.personaService.listarPersonas();
			response.put("mensaje", "Las personas han sido listadas exitosamente");
			response.put("entity", listaPersonas);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al listar las personas: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/personas/{id}")
	public ResponseEntity<?> listarPersonasPorId(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Optional<Persona> persona = this.personaService.listarPersonaPorId(id);
		
			if (persona.isPresent()) {
				response.put("mensaje", "La persona ha sido listada exitosamente");
				response.put("entity", persona.get());
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.put("mensaje", "No se encuentra una persona con ese id");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", "Error al listar la persona: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/personas")
	public ResponseEntity<?> actualizarPersona(@RequestBody Persona persona) {
		Map<String, Object> response = new HashMap<>();
		try {
			Persona nuevaPersona = this.personaService.crearActualizar(persona);
			response.put("mensaje", "La persona ha sido actualizada exitosamente");
			response.put("entity", nuevaPersona);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("mensaje", "Error al actualizar la persona: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<?> eliminarPersona(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			this.personaService.eliminarPersona(id);
			response.put("mensaje", "La persona ha sido eliminada exitosamente");
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			response.put("mensaje", "Error al eliminar la persona: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
