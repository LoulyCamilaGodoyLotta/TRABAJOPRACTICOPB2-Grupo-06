package ar.edu.unlam.tppb2tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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
		Mago profesor2 = new Profesor("P-2","remus", "lupin");
		Mago profesor3 = new Profesor("P-4", "minerva", "mcgonagall");
		Mago profesor4 = new Profesor("P-3", "alastor", "moody");

		hogwarts.inscribirMago(profesor1);
		hogwarts.inscribirMago(profesor2);
		hogwarts.inscribirMago(profesor3);
		hogwarts.inscribirMago(profesor4);
		
		TreeSet<Profesor> profesoresOrdenadosPorCodigo = hogwarts.seOrdenanLosProfesoresPorCodigoAscendente();
		
		assertEquals(profesor1.getCodigo(), profesoresOrdenadosPorCodigo.getFirst().getCodigo());
		assertEquals(profesor3.getCodigo(), profesoresOrdenadosPorCodigo.getLast().getCodigo());
	}

	@Test
	public void seOrdenanLosAlumnosPorPuntosDescendenteYPorCasaAscendente() {
		Mago alumno2 = new Alumno("A-2", "luna", "lovegood", Personalidad.INGENIOSO, 110);
		Mago alumno3 = new Alumno("A-3", "cedric", "diggory", Personalidad.AMABLE, 110);
		Mago alumno4 = new Alumno("A-4", "draco", "malfoy", Personalidad.PROBLEMATICO, 30);
		
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(alumno2);
		hogwarts.inscribirMago(alumno3);
		hogwarts.inscribirMago(alumno4);
		
		TreeSet<Alumno> alumnosOrdenadosPorCasas = hogwarts.seOrdenanLosAlumnosPorPuntosDescendenteYPorCasaAscendente();
		
		assertEquals(((Alumno)alumno3).getPuntos(), alumnosOrdenadosPorCasas.getFirst().getPuntos());
		assertEquals(((Alumno)alumno3).getCasa(), alumnosOrdenadosPorCasas.getFirst().getCasa());
		assertEquals(((Alumno)alumno4).getPuntos(), alumnosOrdenadosPorCasas.getLast().getPuntos());
		assertEquals(((Alumno)alumno4).getCasa(), alumnosOrdenadosPorCasas.getLast().getCasa());
	}
	
	@Test
	public void quePermitaObtenerUnReporteConTodosLosMagosPorCodigoYApellido() {
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(profesor1);
		
		Map<String, String> reporteMagos = hogwarts.obtenerReporteTodosLosMagos();
		
		for(Map.Entry<String, String> entry : reporteMagos.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			switch(key) {
			case "A-1":
				assertEquals(alumno1.getApellido(), val);
				break;
			case "P-1":
				assertEquals(profesor1.getApellido(), val);
				break;
				
			}
		}
	}
	
	@Test
	public void seDeterminaLaCasaGanadoraAlTerminarElAño() throws MagoEncontradoPeroEsProfesorException {
		Mago alumno2 = new Alumno("A-2", "luna", "lovegood", Personalidad.INGENIOSO, 120);
		Mago alumno3 = new Alumno("A-3", "lourdes", "godoy lotta", Personalidad.AMABLE, 110);
		Mago alumno4 = new Alumno("A-4", "draco", "malfoy", Personalidad.PROBLEMATICO, 30);
		
		hogwarts.inscribirMago(alumno1);
		hogwarts.inscribirMago(alumno2);
		hogwarts.inscribirMago(alumno3);
		hogwarts.inscribirMago(alumno4);
		
		hogwarts.alumnoDaExamen(alumno1.getCodigo(), Examen.APRUEBA);
		
		hogwarts.alumnoDaExamen(alumno2.getCodigo(), Examen.APRUEBA);
		
		hogwarts.alumnoDaExamen(alumno3.getCodigo(), Examen.APRUEBA);
		hogwarts.alumnoDaExamen(alumno3.getCodigo(), Examen.APRUEBA);
		hogwarts.alumnoDaExamen(alumno3.getCodigo(), Examen.APRUEBA);
		
		hogwarts.alumnoDaExamen(alumno4.getCodigo(), Examen.APRUEBA);
		hogwarts.alumnoDaExamen(alumno4.getCodigo(), Examen.DESAPRUEBA);

		assertEquals(((Alumno)alumno3).getCasa(), hogwarts.determinarCasaGanadora());
	}

}
