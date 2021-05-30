package com.roratyweb.rotary.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.roratyweb.rotary.entidades.Cidade;
import com.roratyweb.rotary.entidades.Distrito;
import com.roratyweb.rotary.entidades.Estado;
import com.roratyweb.rotary.entidades.Pais;
import com.roratyweb.rotary.entidades.Zona;
import com.roratyweb.rotary.repositorios.CidadeRepositorio;
import com.roratyweb.rotary.repositorios.DistritoRepositorio;
import com.roratyweb.rotary.repositorios.EstadoRepositorio;
import com.roratyweb.rotary.repositorios.PaisRepositorio;
import com.roratyweb.rotary.repositorios.ZonaRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	// CommandLineRunner para executar esta parte quando o programa for iniciado
	// Esta interface implementa o metodo run
	@Autowired
	private PaisRepositorio paisRepositorio;
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@Autowired
	private ZonaRepositorio zonaRepositorio;
	
	@Autowired
	private DistritoRepositorio distritoRepositorio;
	
	// Resolve problem de injeção de dependencia
	@Override
	public void run(String... args) throws Exception {
		
		Pais p1 = new Pais("BRA", "Brasil");
		Pais p2 = new Pais("USA", "Estados Unidos da America");
		Pais p3 = new Pais("ARG", "Argentina");
		
		// Salva os registros no banco de dados
		paisRepositorio.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado e1 = new Estado("RS", "Rio Grande Do Sul", p1);
		Estado e2 = new Estado("SC", "Santa Catarina", p1);
		Estado e3 = new Estado("PR", "Parana", p3);
		
		// Salva os registros no banco de dados
		estadoRepositorio.saveAll(Arrays.asList(e1, e2, e3));

		Cidade c1 = new Cidade(98280, "Panambi", e1);
		Cidade c2 = new Cidade(98300, "Palmeira das Missões", e1);
		Cidade c3 = new Cidade(98700, "Ijuí", e1);
		Cidade c4 = new Cidade(98005, "Cruz Alta", e2);
		
		// Salva os registros no banco de dados
		cidadeRepositorio.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Zona z1 = new Zona("ZONE 7", "China");
		Zona z2 = new Zona("ZONE 22", "Africa");
		Zona z3 = new Zona("ZONE 23", "Seção A: Sul do Brasil - Seção B: Argentina - Bolivia - Chile - Equador - Paraguay - Peru e Uruguai");
		
		// Salva os registros no banco de dados
		zonaRepositorio.saveAll(Arrays.asList(z1, z2, z3));
		
		Distrito d1 = new Distrito(4660, "Noroeste do Rio Grande Do Sul", z3);
		Distrito d2 = new Distrito(4700, "Norte do Rio Grande Do Sul", z3);
		Distrito d3 = new Distrito(4670, "Leste do Rio Grande Do Sul", z3);
		Distrito d4 = new Distrito(4680, "Sul do Rio Grande Do Sul", z3);
		Distrito d5 = new Distrito(4780, "Oeste do Rio Grande Do Sul", z3);
		
		// Salva os registros no banco de dados
		distritoRepositorio.saveAll(Arrays.asList(d1, d2, d3, d4, d5));
		
	}
	
}
