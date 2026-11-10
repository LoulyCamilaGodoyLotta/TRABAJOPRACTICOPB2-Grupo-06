package ar.edu.unlam.tppb2;

import java.util.Comparator;

public class OrdenarAlumnosPorPuntosYCasa implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		
		int porPuntos = o2.getPuntos().compareTo(o1.getPuntos());
		if(porPuntos == 0) {
			return o1.getCasa().compareTo(o2.getCasa());
		}
		
		return porPuntos;
	}

}
