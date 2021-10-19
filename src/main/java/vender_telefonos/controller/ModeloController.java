package vender_telefonos.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import vender_telefonos.exception.ModeloNotFoundException;
import vender_telefonos.model.Modelo;
import vender_telefonos.service.IModeloService;


@RestController
@RequestMapping("/modelo")
public class ModeloController {

	@Autowired
	private IModeloService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Modelo>> listar(){ 
		return new ResponseEntity<List<Modelo>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Modelo> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Modelo> modelo = service.listarPorId(id);
		
		if(!modelo.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Modelo> resource = EntityModel.of(modelo.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("modelo-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Modelo tipo_p) { 
		Modelo modelo = service.registrar(tipo_p);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(modelo.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(tipo_p); 
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Modelo tipo) { 
		 Optional<Modelo> modelo = service.listarPorId(tipo.getId());
		 if(!modelo.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + tipo.getId());
		 }else {
			 service.modificar(tipo);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(modelo); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Modelo> tipo = service.listarPorId(id);
		 if(!tipo.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
