package com.roratyweb.rotary.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roratyweb.rotary.entidades.Distrito;

// Instancia o objeto repositorio que vai ter várias operações para trabalhar com o Estado
public interface DistritoRepositorio extends JpaRepository<Distrito, Integer> {

}
