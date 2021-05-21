package com.roratyweb.rotary.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roratyweb.rotary.entidades.Cidade;
import com.roratyweb.rotary.repositorios.CidadeRepositorio;
import com.roratyweb.rotary.servicos.excecoes.DatabaseException;
import com.roratyweb.rotary.servicos.excecoes.ResourceNotFoundException;

@Service
public class CidadeServico {

	@Autowired
	private CidadeRepositorio repository;
	
	public List<Cidade> findAll() {
		return repository.findAll();
	}
		
	public Cidade findById(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cidade insert(Cidade obj) {
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
	
	public Cidade update(Integer id, Cidade obj) {
		try {
			Cidade entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Cidade entity, Cidade obj) {
		entity.setCidadeDesc(obj.getCidadeDesc());
		entity.setEstado(obj.getEstado());
	}
}
