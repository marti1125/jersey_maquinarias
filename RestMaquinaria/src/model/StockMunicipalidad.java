package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StockMunicipalidad {
	
	@Id
	public String codigo;
	
	@ManyToOne
	public Municipalidad municipalidad;
	
	@ManyToOne
	public TipoMaquinaria tipoMaquinaria;
	
	public StockMunicipalidad(){
	}

	public StockMunicipalidad(Municipalidad municipalidad,
			TipoMaquinaria tipoMaquinaria, String codigo) {
		super();
		this.municipalidad = municipalidad;
		this.tipoMaquinaria = tipoMaquinaria;
		this.codigo = codigo;
	}

	public Municipalidad getMunicipalidad() {
		return municipalidad;
	}

	public void setMunicipalidad(Municipalidad municipalidad) {
		this.municipalidad = municipalidad;
	}

	public TipoMaquinaria getTipoMaquinaria() {
		return tipoMaquinaria;
	}

	public void setTipoMaquinaria(TipoMaquinaria tipoMaquinaria) {
		this.tipoMaquinaria = tipoMaquinaria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}

