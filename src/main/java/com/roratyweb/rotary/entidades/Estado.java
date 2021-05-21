package com.roratyweb.rotary.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String estadoCod;
	private String estadoDesc;

	@JoinColumn(name = "paisCod")
	@ManyToOne
	private Pais pais;

	public Estado() {
		super();
	}

	public Estado(String estadoCod, String estadoDesc, Pais pais ) {
		super();
		this.estadoCod = estadoCod;
		this.estadoDesc = estadoDesc;
		this.pais = pais;
	}

	public String getEstadoCod() {
		return estadoCod;
	}

	public void setEstadoCod(String estadoCod) {
		this.estadoCod = estadoCod;
	}

	public String getEstadoDesc() {
		return estadoDesc;
	}

	public void setEstadoDesc(String estadoDesc) {
		this.estadoDesc = estadoDesc;
	}

	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoCod == null) ? 0 : estadoCod.hashCode());
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
		Estado other = (Estado) obj;
		if (estadoCod == null) {
			if (other.estadoCod != null)
				return false;
		} else if (!estadoCod.equals(other.estadoCod))
			return false;
		return true;
	}
	
	
	

}
