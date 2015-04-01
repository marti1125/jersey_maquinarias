package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetalleStockMunicipalidad {
	
	@Id
	public long id;
	
	@ManyToOne
	public StockMunicipalidad stockMunicipalidad;
	
	public Date fechaInicio;
	
	public Date fechaFin;
	
	public double costoTotal;
	
	public DetalleStockMunicipalidad(){
	}
	
	public DetalleStockMunicipalidad(StockMunicipalidad stockMunicipalidad,
			Date fechaInicio, Date fechaFin, double costoTotal) {
		super();
		this.stockMunicipalidad = stockMunicipalidad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoTotal = costoTotal;
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

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
}
