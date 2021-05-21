package com.roratyweb.rotary.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roratyweb.rotary.entidades.Estado;

// Instancia o objeto repositorio que vai ter várias operações para trabalhar com o Estado
public interface EstadoRepositorio extends JpaRepository<Estado, String> {

}
