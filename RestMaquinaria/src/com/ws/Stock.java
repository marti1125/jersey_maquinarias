package com.ws;

public class Stock {
	
	long id;
	double precio;
	String maquinaria;
	String municipalidad;
	
	public Stock(){
		
	}
	
	public Stock(long id, double precio, String maquinaria, String municipalidad) {
		super();
		this.id = id;
		this.precio = precio;
		this.maquinaria = maquinaria;
		this.municipalidad = municipalidad;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getMaquinaria() {
		return maquinaria;
	}
	public void setMaquinaria(String maquinaria) {
		this.maquinaria = maquinaria;
	}
	public String getMunicipalidad() {
		return municipalidad;
	}
	public void setMunicipalidad(String municipalidad) {
		this.municipalidad = municipalidad;
	}
	
}
