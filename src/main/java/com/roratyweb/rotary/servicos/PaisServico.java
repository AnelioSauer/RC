package com.roratyweb.rotary.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roratyweb.rotary.entidades.Pais;
import com.roratyweb.rotary.repositorios.PaisRepositorio;
import com.roratyweb.rotary.servicos.excecoes.DatabaseException;
import com.roratyweb.rotary.servicos.excecoes.ResourceNotFoundException;

@Service
public class PaisServico {

	@Autowired
	private PaisRepositorio repository;
	
	public List<Pais> findAll() {
		return repository.findAll();
	}
	
	public Pais findById(String id) {
		Optional<Pais> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pais insert(Pais obj) {
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
	
	public Pais update(String id, Pais obj) {
		try {
			Pais entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Pais entity, Pais obj) {
		entity.setPaisDesc(obj.getPaisDesc());
	}
}
