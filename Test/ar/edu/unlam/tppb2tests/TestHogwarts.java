package ar.edu.unlam.tppb2tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tppb2.Alumno;
import ar.edu.unlam.tppb2.Casa;
import ar.edu.unlam.tppb2.Gestion;
import ar.edu.unlam.tppb2.Personalidad;
import ar.edu.unlam.tppb2.Mago;

public class TestHogwarts {

	private Casa gryffindor;
	private Casa slytherin;
	private Casa hufflepuff;
	private Casa ravenclaw;

	private Alumno alumno1;
	private Alumno alumno2;
	private Alumno alumno3;

	@Before
	public void setUp() {
		 Gestion hogwarts = new Gestion();

		    gryffindor = new Casa("Gryffindor");
		    slytherin = new Casa("Slytherin");
		    hufflepuff = new Casa("Hufflepuff");
		    ravenclaw = new Casa("Ravenclaw");

		    alumno1 = new Alumno("Harry", "Potter", 1, Personalidad.VALIENTE);
		    alumno2 = new Alumno("Lourdes", "Godoy Lotta", 2, Personalidad.AMABLE);
		    alumno3 = new Alumno("Gianfranco", "Pazzarino", 3, Personalidad.VALIENTE);

	}

	// 1
	@Test
	public void sePuedeInscribirAUnAlumno() {
		fail("Not yet implemented");
	}

	// 2
	@Test
	public void noSePuedeInscribirAUnAlumnoConElMismoID() {
		fail("Not yet implemented");
	}

	// 3
	@Test
	public void sePuedeAsignarUnAlumnoALaCasa() {
		boolean resultado = hufflepuff.asignarAlumno(alumno2);
		assertTrue(resultado);
		assertEquals(1, hufflepuff.obtenerCantidadAlumnos().intValue());

	}

	// 4
	@Test
	public void sePuedeAsignarMasDeUnAlumnoAUnaCasa() {
		gryffindor.asignarAlumno(alumno1);
		gryffindor.asignarAlumno(alumno3);

		assertEquals(2, gryffindor.obtenerCantidadAlumnos().intValue());

	}

	// 5
	@Test
	public void unAlumnoDaUnaEvaluacionQueEsteAprobada() {
		fail("Not yet implemented");
	}

	// 6
	@Test
	public void unAlumnoDaUnaEvaluacionQueEsteDesaprobada() {
		fail("Not yet implemented");
	}

	// 7
	@Test
	public void seMuestranLosPuntosDeCadaAlumno() {
		fail("Not yet implemented");
	}

	// 8
	@Test
	public void seOrdenanLosAlumnosDeLaCasaGryffindorPorPuntos() {
		fail("Not yet implemented");
	}

	// 9
	@Test
	public void seOrdenanTodosLosAlumnosPorID() {
		fail("Not yet implemented");
	}

	// 10
	@Test
	public void seDeterminaLaCasaGanadoraAlTerminarElAño() {
		fail("Not yet implemented");
	}

}
