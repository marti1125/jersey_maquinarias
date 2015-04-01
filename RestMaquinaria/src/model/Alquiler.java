package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Alquiler {
	
	@Id
	public long id;
	
	@ManyToOne
	@JoinColumn(name="tipo_maquinaria")
	public TipoMaquinaria tipo_maquinaria;
	
	public double p_hora;
	
	public Alquiler(){
	}

	public Alquiler(long id, TipoMaquinaria tipo_maquinaria, double p_hora) {
		super();
		this.id = id;
		this.tipo_maquinaria = tipo_maquinaria;
		this.p_hora = p_hora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoMaquinaria getTipo_maquinaria() {
		return tipo_maquinaria;
	}

	public void setTipo_maquinaria(TipoMaquinaria tipo_maquinaria) {
		this.tipo_maquinaria = tipo_maquinaria;
	}

	public double getP_hora() {
		return p_hora;
	}

	public void setP_hora(double p_hora) {
		this.p_hora = p_hora;
	}
	
}
