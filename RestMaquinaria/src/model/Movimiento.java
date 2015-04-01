package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movimiento {
	
	@Id
	public long id;
	
	@ManyToOne
	public StockMunicipalidad stockMunicipalidad;
	
	public Date fechaInicio;
	
	public Date fechaFin;
	
	public String estado;
	
	public Movimiento(){
	}
	
	public Movimiento(long id, StockMunicipalidad stockMunicipalidad,
			Date fechaInicio, Date fechaFin, String estado) {
		super();
		this.id = id;
		this.stockMunicipalidad = stockMunicipalidad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StockMunicipalidad getStockMunicipalidad() {
		return stockMunicipalidad;
	}

	public void setStockMunicipalidad(StockMunicipalidad stockMunicipalidad) {
		this.stockMunicipalidad = stockMunicipalidad;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
