package ar.edu.unlam.tppb2;

import java.util.HashSet;
import java.util.Set;

public class Casa {
	
	private Integer puntos;
	private Set<Alumno> alumnos;
	private String nombre;
	
	public Casa(String nombre) {
		this.nombre = nombre;
		this.alumnos = new HashSet<>();
	}
	
	public boolean asignarAlumno(Alumno alumno) {
	    return this.alumnos.add(alumno);
	}

	public Integer obtenerCantidadAlumnos() {
		
		return this.alumnos.size();
	}
	
}
