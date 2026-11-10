package ar.edu.unlam.tppb2tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tppb2.Alumno;
import ar.edu.unlam.tppb2.Gestion;
import ar.edu.unlam.tppb2.Personalidad;
import ar.edu.unlam.tppb2.Profesor;
import ar.edu.unlam.tppb2.SancionInvalidaException;
import ar.edu.unlam.tppb2.Mago;
import ar.edu.unlam.tppb2.MagoDuplicadoException;
import ar.edu.unlam.tppb2.MagoEncontradoPeroEsProfesorException;
import ar.edu.unlam.tppb2.MagoNoEncontradoException;

public class TestHogwarts {
	
	private Gestion hogwarts;
	private Mago alumno1;
	private Mago alumno2;
	private Mago profesor1;

	@Before
	public void setUp() {
		hogwarts = new Gestion();
		
		alumno1 = new Alumno("A-1", "harry", "potter", Personalidad.VALIENTE, 100);
		
		alumno2 = new Alumno("A-2", "ron", "weasley", Personalidad.VALIENTE, 20);
		
		profesor1 = new Profesor("P-1", "severus", "snape");
	}
	
	@Test
	public void queMePermitaInscribirUnAlumno() {
		hogwarts.inscribirMago(alumno1);
		assertEquals(1, hogwarts.getMagos().size());
	}
	
	@Test(expected = MagoDuplicadoException.class)
	public void queNoMePermitaInscribirAUnAlumnoConElMismoID() {
		hogwarts.inscribirMago(alumno1);

		Mago alumno3 = new Alumno("A-1", "hermione", "granger", Personalidad.VALIENTE, 20);
		
		hogwarts.inscribirMago(alumno3);
	}
	
	@Test
	public void queMePermitaInscribirUnProfesor() {
		hogwarts.inscribirMago(profesor1);
		
		assertTrue(hogwarts.getMagos().contains(profesor1));
		assertEquals(1, hogwarts.getMagos().size());
	}
	
	@Test(expected = MagoDuplicadoException.class)
	public void queNoMePermitaInscribirAUnProfesorConElMismoIDYLanceProfesorDuplicadoException() {
		hogwarts.inscribirMago(profesor1);
		
		Mago profesor2 = new Profesor("P-1", "remus", "lupin");
		hogwarts.inscribirMago(profesor2);
	}
	
	@Test
	public void quePermitaMostrarLosPuntosQueTieneUnAlumno() {
		assertEquals(100, ((Alumno)alumno1).getPuntos(), 0);
	}
	
	@Test
	public void quePermitaMostrarLosPuntosQueTienenLosAlumnosDeUnaMismaCasa() {
		
	}
	
	@Test
	public void quePermitaMostrarLosPuntosQueTienenLosAlumnos() {
		
	}
	
	@Test
	public void queMePermitaObtenerLosAlumnosSancionados() {
		
	}
	
	@Test
	public void queMePermitaObtenerElPromedioDeDiasSancionados() {
		
	}

	@Test
	public void queNoMePermitaAplicarleSancionAUnAlumnoConCodigoInexistente() {
		
	}

	
	@Test
	public void quePermitaMostrarLosPuntosQueTieneUnAlumnoSancionado() {
		
	}
	
	@Test
	public void queNoPermitaAplicarleSancionAOtroMagoQueNoSeaAlumno() {
		
	}
	
	@Test
	public void unAlumnoDaUnaEvaluacionQueEsteAprobada() {
		
	}
	
	@Test
	public void unAlumnoDaUnaEvaluacionQueEsteDesaprobada() {
		
	}
	
	@Test
	public void noPermiteQueUnProfesorDeUnExamen() {
		
	}
	
	@Test
	public void seOrdenanLosProfesoresPorCodigoAscendenteYPorApellido() {
		
	}

	@Test
	public void seOrdenanLosAlumnosPorPuntosDescendenteYPorCasaAscendente() {
		
	}
	
	@Test
	public void quePermitaObtenerUnReporteConTodosLosMagosPorCodigoYApellido() {
		
	}
	
	@Test
	public void seDeterminaLaCasaGanadoraAlTerminarElAño() {
	
	}

}
