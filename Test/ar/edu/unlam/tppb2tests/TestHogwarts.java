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
	public void quePermitaMostrarLosPuntosQueTienenLosAlumnosDeUnaMismaCasa() {
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(alumno2);
		
		Mago alumno3 = new Alumno("A-3", "draco", "malfoy", Personalidad.PROBLEMATICO, 30);
		
		hogwarts.inscribirMago(alumno3);
		
		assertEquals(120, hogwarts.calcularPuntosDeUnaCasa("Gryffindor"), 0);
	}
	
	@Test
	public void quePermitaMostrarLosPuntosQueTienenLosAlumnos() {
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(alumno2);

		Mago alumno3 = new Alumno("A-3", "draco", "malfoy", Personalidad.PROBLEMATICO, 30);
		
		hogwarts.inscribirMago(alumno3);
		
		assertEquals(150, hogwarts.calcularPuntosDeTodoElColegio(), 0);
	}
	
	@Test
	public void queMePermitaObtenerLosAlumnosSancionados() throws MagoNoEncontradoException, SancionInvalidaException, MagoEncontradoPeroEsProfesorException  {
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(alumno2);
		hogwarts.aplicarSancion("A-1", 3);
		List<Alumno> alumnosSancionados = hogwarts.obtenerAlumnosSancionados();
		
		assertEquals(1, alumnosSancionados.size());
		assertEquals("A-1", alumnosSancionados.get(0).getCodigo());
	}
	
	@Test
	public void queMePermitaObtenerElPromedioDeDiasSancionados() throws MagoNoEncontradoException, SancionInvalidaException, MagoEncontradoPeroEsProfesorException {
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(alumno2);
		
		hogwarts.aplicarSancion("A-1", 6);
		hogwarts.aplicarSancion("A-2", 7);
		
		assertEquals(6.5, hogwarts.obtenerPromedioDiasSanciones(), 0);
	}

	@Test(expected = MagoNoEncontradoException.class)
	public void queNoMePermitaAplicarleSancionAUnAlumnoConCodigoInexistente() throws MagoNoEncontradoException, SancionInvalidaException, MagoEncontradoPeroEsProfesorException {
		hogwarts.inscribirMago(alumno1);
		
		hogwarts.aplicarSancion("A-3", 3);
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
