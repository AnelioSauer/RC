package com.roratyweb.rotary.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

// JPA faz a persistencia do bco relacional com o orientado a objetos
@Entity
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Identifica o atributo chave primaria
	@Id
	private String paisCod;
	private String paisDesc;
	
	public Pais() {
		super();
	}
	// o Estado não foi incluído no construtor pois já está sendo instanciado acima
	public Pais(String paisCod, String paisDesc) {
		super();
		this.paisCod = paisCod;
		this.paisDesc = paisDesc;
	}
	public String getPaisCod() {
		return paisCod;
	}
	public void setPaisCod(String paisCod) {
		this.paisCod = paisCod;
	}
	public String getPaisDesc() {
		return paisDesc;
	}
	public void setPaisDesc(String paisDesc) {
		this.paisDesc = paisDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paisCod == null) ? 0 : paisCod.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (paisCod == null) {
			if (other.paisCod != null)
				return false;
		} else if (!paisCod.equals(other.paisCod))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pais [paisCod=" + paisCod + ", paisDesc=" + paisDesc + "]";
	}
	
}
