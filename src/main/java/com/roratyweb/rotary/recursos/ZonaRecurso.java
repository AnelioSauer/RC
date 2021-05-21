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

import com.roratyweb.rotary.entidades.Zona;
import com.roratyweb.rotary.servicos.ZonaServico;

@RestController
@RequestMapping(value = "/zonas")
public class ZonaRecurso {
	
	@Autowired 
	private ZonaServico service;
	
	@GetMapping
	public ResponseEntity<List<Zona>> findAll() {
		List<Zona> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Zona> findById(@PathVariable String id) {
		Zona obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Zona> insert(@RequestBody Zona obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getZonaCod()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Zona> update(@PathVariable String id, @RequestBody Zona obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
