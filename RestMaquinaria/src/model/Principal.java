package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Principal {
	
	@Id
	public long id;
	
	public String dni;
	
	public String ciudadano;
	
	public String direccionCiudadano;
	
	public String ruc;
	
	public String empresa;
	
	public String direccionEmpresa;
	
	public double costoTotal;
	
	@ManyToMany
	public Municipalidad municipalidad;

	public Principal(String dni, String ciudadano,
			String direccionCiudadano, String ruc, String empresa,
			String direccionEmpresa, double costoTotal,
			Municipalidad municipalidad) {
		super();
		this.dni = dni;
		this.ciudadano = ciudadano;
		this.direccionCiudadano = direccionCiudadano;
		this.ruc = ruc;
		this.empresa = empresa;
		this.direccionEmpresa = direccionEmpresa;
		this.costoTotal = costoTotal;
		this.municipalidad = municipalidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(String ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getDireccionCiudadano() {
		return direccionCiudadano;
	}

	public void setDireccionCiudadano(String direccionCiudadano) {
		this.direccionCiudadano = direccionCiudadano;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Municipalidad getMunicipalidad() {
		return municipalidad;
	}

	public void setMunicipalidad(Municipalidad municipalidad) {
		this.municipalidad = municipalidad;
	}

}
