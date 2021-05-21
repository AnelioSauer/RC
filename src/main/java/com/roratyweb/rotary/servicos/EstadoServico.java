package com.roratyweb.rotary.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roratyweb.rotary.entidades.Estado;
import com.roratyweb.rotary.repositorios.EstadoRepositorio;
import com.roratyweb.rotary.servicos.excecoes.DatabaseException;
import com.roratyweb.rotary.servicos.excecoes.ResourceNotFoundException;

@Service
public class EstadoServico {

	@Autowired
	private EstadoRepositorio repository;
	
	public List<Estado> findAll() {
		return repository.findAll();
	}
	
	public Estado findById(String id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Estado insert(Estado obj) {
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
	
	public Estado update(String id, Estado obj) {
		try {
			Estado entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Estado entity, Estado obj) {
		entity.setEstadoDesc(obj.getEstadoDesc());
		entity.setPais(obj.getPais());
	}
}
