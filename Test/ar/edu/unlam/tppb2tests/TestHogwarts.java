package ar.edu.unlam.tppb2tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tppb2.Alumno;
import ar.edu.unlam.tppb2.Examen;
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
		
	}
	
	@Test
	public void queNoMePermitaInscribirAUnAlumnoConElMismoID() {
		
	}
	
	@Test
	public void queMePermitaInscribirUnProfesor() {
	
	}
	
	@Test
	public void queNoMePermitaInscribirAUnProfesorConElMismoIDYLanceProfesorDuplicadoException() {
		
	}
	
	@Test
	public void quePermitaMostrarLosPuntosQueTieneUnAlumno() {
		
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
	public void quePermitaMostrarLosPuntosQueTieneUnAlumnoSancionado() throws MagoNoEncontradoException, SancionInvalidaException, MagoEncontradoPeroEsProfesorException {
		hogwarts.inscribirMago(alumno2);
		hogwarts.aplicarSancion("A-2", 5);
		
		assertEquals(10, ((Alumno)alumno2).getPuntos(), 0);
	}
	
	@Test
	public void queNoPermitaAplicarleSancionAOtroMagoQueNoSeaAlumno() {
		hogwarts.inscribirMago(profesor1);
		
		try {
			hogwarts.aplicarSancion("P-1", 3);
			fail("Debió lanzar MagoEncontradoPeroEsProfesorException");
		}catch(MagoEncontradoPeroEsProfesorException e) {
			assertEquals("Se encontró al mago pero al ser profesor no se puede aplicarle sanción", e.getMessage());			
		}catch(MagoNoEncontradoException e) {
			fail("No debía lanzar esta excepción");
		}catch(SancionInvalidaException e) {
			fail("No debía lanzar esta excepción");
		}
	}
	
	@Test
	public void unAlumnoDaUnaEvaluacionQueEsteAprobada() throws MagoEncontradoPeroEsProfesorException {
		hogwarts.inscribirMago(alumno1);
		hogwarts.alumnoDaExamen("A-1", Examen.APRUEBA);
		
		assertEquals(110, ((Alumno)alumno1).getPuntos(), 0);
	}
	
	@Test
	public void unAlumnoDaUnaEvaluacionQueEsteDesaprobada() throws MagoEncontradoPeroEsProfesorException {
		hogwarts.inscribirMago(alumno1);
		hogwarts.alumnoDaExamen("A-1", Examen.DESAPRUEBA);
		
		assertEquals(100, ((Alumno)alumno1).getPuntos(), 0);
	}
	
	@Test(expected= MagoEncontradoPeroEsProfesorException.class)
	public void noPermiteQueUnProfesorDeUnExamen() throws MagoEncontradoPeroEsProfesorException {
		hogwarts.inscribirMago(profesor1);
		hogwarts.alumnoDaExamen("P-1", Examen.APRUEBA);
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
