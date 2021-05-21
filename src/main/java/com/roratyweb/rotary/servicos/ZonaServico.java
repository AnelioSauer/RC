package com.roratyweb.rotary.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roratyweb.rotary.entidades.Zona;
import com.roratyweb.rotary.repositorios.ZonaRepositorio;
import com.roratyweb.rotary.servicos.excecoes.DatabaseException;
import com.roratyweb.rotary.servicos.excecoes.ResourceNotFoundException;

@Service
public class ZonaServico {

	@Autowired
	private ZonaRepositorio repository;
	
	public List<Zona> findAll() {
		return repository.findAll();
	}
	
	public Zona findById(String id) {
		Optional<Zona> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Zona insert(Zona obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Zona update(String id, Zona obj) {
		try {
			Zona entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Zona entity, Zona obj) {
		entity.setZonaDesc(obj.getZonaDesc());
	}
}
