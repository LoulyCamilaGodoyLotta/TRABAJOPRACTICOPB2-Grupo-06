package ar.edu.unlam.tppb2;

public class Alumno extends Mago implements Examen {

	private Personalidad personalidad;
	private Integer puntos;
	
	
	public Alumno(String nombre, String apellido, Integer id, Personalidad personalidad) {
		super(nombre, apellido, id);
		this.personalidad = personalidad;
		
	}
	

}
