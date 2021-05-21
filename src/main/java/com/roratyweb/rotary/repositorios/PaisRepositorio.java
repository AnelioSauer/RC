package com.roratyweb.rotary.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roratyweb.rotary.entidades.Pais;

// Instancia o objeto repositorio que vai ter várias operações para trabalhar com o Pais
public interface PaisRepositorio extends JpaRepository<Pais, String> {

}
