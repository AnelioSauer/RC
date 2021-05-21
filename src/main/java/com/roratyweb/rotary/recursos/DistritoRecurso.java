package com.roratyweb.rotary.recursos;



import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.roratyweb.rotary.entidades.Distrito;
import com.roratyweb.rotary.servicos.DistritoServico;

@RestController
@RequestMapping(value = "/distritos")
public class DistritoRecurso {
	
	@Autowired 
	private DistritoServico service;
	
	@GetMapping
	public ResponseEntity<List<Distrito>> findAll() {
		List<Distrito> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Distrito> findById(@PathVariable Integer id) {
		Distrito obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Distrito> insert(@RequestBody Distrito obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getDistritoCod()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Distrito> update(@PathVariable Integer id, @RequestBody Distrito obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
