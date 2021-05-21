package com.roratyweb.rotary.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roratyweb.rotary.entidades.Cidade;

// Instancia o objeto repositorio que vai ter várias operações para trabalhar com a cidade
public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

}
