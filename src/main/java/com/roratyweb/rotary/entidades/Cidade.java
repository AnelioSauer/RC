package com.roratyweb.rotary.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;

	// Identifica o atributo chave primaria
	@Id
	private Integer cidadeCod;
	private String cidadeDesc;
	
	@JoinColumn(name = "estadoCod")
	@ManyToOne
	private Estado estado;

	public Cidade() {
		super();
	}

	public Cidade(Integer cidadeCod, String cidadeDesc, Estado estado) {
		super();
		this.cidadeCod = cidadeCod;
		this.cidadeDesc = cidadeDesc;
		this.estado = estado;
	}

	public Integer getCidadeCod() {
		return cidadeCod;
	}

	public void setCidadeCod(Integer cidadeCod) {
		this.cidadeCod = cidadeCod;
	}

	public String getCidadeDesc() {
		return cidadeDesc;
	}

	public void setCidadeDesc(String cidadeDesc) {
		this.cidadeDesc = cidadeDesc;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidadeCod == null) ? 0 : cidadeCod.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cidadeCod == null) {
			if (other.cidadeCod != null)
				return false;
		} else if (!cidadeCod.equals(other.cidadeCod))
			return false;
		return true;
	}
	
}
