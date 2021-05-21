package com.roratyweb.rotary.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roratyweb.rotary.entidades.Distrito;
import com.roratyweb.rotary.repositorios.DistritoRepositorio;
import com.roratyweb.rotary.servicos.excecoes.DatabaseException;
import com.roratyweb.rotary.servicos.excecoes.ResourceNotFoundException;

@Service
public class DistritoServico {

	@Autowired
	private DistritoRepositorio repository;
	
	public List<Distrito> findAll() {
		return repository.findAll();
	}
	
	public Distrito findById(Integer id) {
		Optional<Distrito> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Distrito insert(Distrito obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Distrito update(Integer id, Distrito obj) {
		try {
			Distrito entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Distrito entity, Distrito obj) {
		entity.setDistritoDesc(obj.getDistritoDesc());
		entity.setZona(obj.getZona());
	}
}
