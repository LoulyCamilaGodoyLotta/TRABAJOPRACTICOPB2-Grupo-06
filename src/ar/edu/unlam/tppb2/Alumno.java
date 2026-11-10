package ar.edu.unlam.tppb2;

public class Alumno extends Mago implements Sancionable{

	private Personalidad personalidad;
	private Integer puntos;
	private String casa;
	private Boolean estaSancionado;
	private Integer diasSancionado;
	
	public Alumno(String codigo, String nombre, String apellido, Personalidad personalidad, Integer puntos) {
		super(codigo, nombre, apellido);
		this.personalidad = personalidad;
		this.puntos = puntos;
		this.estaSancionado = false;
		this.diasSancionado = 0;
		this.casa = asignarCasa(personalidad);
	}
	
	public String asignarCasa(Personalidad personalidad) {
		switch (personalidad) {
		case Personalidad.VALIENTE:
			casa = "Gryffindor";
			break;
		case Personalidad.AMABLE:
			casa = "Hufflepuff";
			break;
		case Personalidad.PROBLEMATICO:
			casa = "Slytherin";
			break;
		case Personalidad.INGENIOSO:
			casa = "Ravenclaw";
			break;
		default:
			break;
		}
		return casa;
	}
	
	public void aplicarSancion(int dias) {
		this.estaSancionado = true;
		this.diasSancionado += dias;
		this.puntos -= 10;
	}
	
	public Personalidad getPersonalidad() { 
		return personalidad; 
	}
	public Integer getPuntos() { 
		return puntos; 
	}
	public void setPuntos(int puntos) { 
		this.puntos = puntos; 
	}
	public String getCasa() { 
		return casa; 
	}	
	
	@Override
	public Boolean estaSancionado() { 
		return estaSancionado; 
	}
	@Override
	public Integer getDiasSancionado() { 
		return diasSancionado; 
	}	
}
