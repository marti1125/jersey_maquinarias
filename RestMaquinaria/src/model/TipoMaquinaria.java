package model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoMaquinaria {
	
	@Id
	public long id;
	
	public String nombre;
	
	@OneToMany(mappedBy = "tipo_maquinaria")
    public Set<Alquiler> alquileres;
	
	public TipoMaquinaria(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public TipoMaquinaria() {
		
	}

	public Set<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(Set<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
