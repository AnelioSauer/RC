package com.roratyweb.rotary.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Distrito implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer distritoCod;
	private String distritoDesc;
	
	@JoinColumn(name = "zonaCod")
	@ManyToOne
	private Zona zona;

	public Distrito() {
		super();
	}

	public Distrito(Integer distritoCod, String distritoDesc, Zona zona) {
		super();
		this.distritoCod = distritoCod;
		this.distritoDesc = distritoDesc;
		this.zona = zona;
	}

	public Integer getDistritoCod() {
		return distritoCod;
	}

	public void setDistritoCod(Integer distritoCod) {
		this.distritoCod = distritoCod;
	}

	public String getDistritoDesc() {
		return distritoDesc;
	}

	public void setDistritoDesc(String distritoDesc) {
		this.distritoDesc = distritoDesc;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distritoCod == null) ? 0 : distritoCod.hashCode());
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
		Distrito other = (Distrito) obj;
		if (distritoCod == null) {
			if (other.distritoCod != null)
				return false;
		} else if (!distritoCod.equals(other.distritoCod))
			return false;
		return true;
	}
	
	
	

}
