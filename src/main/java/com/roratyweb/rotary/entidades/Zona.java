package com.roratyweb.rotary.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Identifica o atributo chave primaria
	@Id
	private String zonaCod;
	private String zonaDesc;
	public Zona() {
		super();
	}
	public Zona(String zonaCod, String zonaDesc) {
		super();
		this.zonaCod = zonaCod;
		this.zonaDesc = zonaDesc;
	}
	public String getZonaCod() {
		return zonaCod;
	}
	public void setZonaCod(String zonaCod) {
		this.zonaCod = zonaCod;
	}
	public String getZonaDesc() {
		return zonaDesc;
	}
	public void setZonaDesc(String zonaDesc) {
		this.zonaDesc = zonaDesc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zonaCod == null) ? 0 : zonaCod.hashCode());
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
		Zona other = (Zona) obj;
		if (zonaCod == null) {
			if (other.zonaCod != null)
				return false;
		} else if (!zonaCod.equals(other.zonaCod))
			return false;
		return true;
	}
	
}
