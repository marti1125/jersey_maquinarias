package aux_model;

import java.util.List;

public class Evento {
	
	public List<Propriedad> eventos;
	public String color;
	public String textColor;
	
	public Evento(List<Propriedad> eventos, String color, String textColor) {
		super();
		this.eventos = eventos;
		this.color = color;
		this.textColor = textColor;
	}
	public List<Propriedad> getEventos() {
		return eventos;
	}
	public void setEventos(List<Propriedad> eventos) {
		this.eventos = eventos;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	
}
