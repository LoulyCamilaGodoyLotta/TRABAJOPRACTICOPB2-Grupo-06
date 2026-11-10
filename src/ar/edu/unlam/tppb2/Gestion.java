package ar.edu.unlam.tppb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Gestion {
	
	private Set<Mago> magos;
	
	public Gestion() {
		this.magos = new HashSet<Mago>();
	}
	
	public void inscribirMago(Mago mago) {
		Mago buscarMago = encontrarMago(mago.getCodigo());
		if (buscarMago != null) {
			throw new MagoDuplicadoException("El mago ya estaba inscripto anteriormente");
		}
		magos.add(mago);
	}
	
	public Mago encontrarMago(String codigo) {
		for (Mago mago : magos) {
			if(mago.getCodigo().equals(codigo)) {
				return mago;
			}
		}
		return null;
	}
	
	public Integer calcularPuntosDeUnaCasa(String casa) {
		int puntosTotales = 0;
		for (Mago mago : magos) {
			if (mago instanceof Alumno && ((Alumno) mago).getCasa().equals(casa)) {
				puntosTotales += ((Alumno)mago).getPuntos();
			}
		}
		return puntosTotales;
	}
	
	public Integer calcularPuntosDeTodoElColegio() {
		int puntosTotales = 0;
		for (Mago mago : magos) {
			if (mago instanceof Alumno) {
				puntosTotales += ((Alumno) mago).getPuntos();
			}
		}
		return puntosTotales;
	}
	
	public void aplicarSancion(String codigo, int dias) throws MagoNoEncontradoException, SancionInvalidaException, MagoEncontradoPeroEsProfesorException {
		Mago magoBuscado = encontrarMago(codigo);
		if (dias <= 0) {
			throw new SancionInvalidaException("Los dias a sancionar deben ser mayores a cero");
		}
		if (magoBuscado == null) {
			throw new MagoNoEncontradoException("El mago no se encontró");
		}
		if (magoBuscado instanceof Profesor) {
			throw new MagoEncontradoPeroEsProfesorException("Se encontró al mago pero al ser profesor no se puede aplicarle sanción");
		}
		if (magoBuscado != null) {
			if (magoBuscado instanceof Alumno) {
				((Alumno) magoBuscado).aplicarSancion(dias);
			}
		}	
	}
	
	public List<Alumno> obtenerAlumnosSancionados() {
		List<Alumno> alumnosSancionados = new ArrayList<Alumno>();
		for (Mago mago : magos) {
			if(mago instanceof Alumno && ((Alumno) mago).estaSancionado()) {
				alumnosSancionados.add((Alumno)mago);
			}
		}
		return alumnosSancionados;
	}
	
	public double obtenerPromedioDiasSanciones() {
		double sumaDias = 0;
		int alumnosSancionados = 0;
		for(Mago mago : magos) {
			if (mago instanceof Sancionable) {
				sumaDias += ((Sancionable)mago).getDiasSancionado();
				alumnosSancionados++;
			}
		}
		return sumaDias/alumnosSancionados ;
	}
	
	public void alumnoDaExamen(String codigo, Examen nota) throws MagoEncontradoPeroEsProfesorException {
		Mago magoBuscado = encontrarMago(codigo);
		if (magoBuscado instanceof Profesor) {
			throw new MagoEncontradoPeroEsProfesorException("Se encontró al mago pero al ser profesor no se le puede tomar examen");
		}
		if (magoBuscado instanceof Alumno) {
			if(nota.equals(Examen.APRUEBA)) {
				((Alumno) magoBuscado).setPuntos(((Alumno)magoBuscado).getPuntos() + 10);
			}
		}
	}
	
	public TreeSet<Profesor> seOrdenanLosProfesoresPorCodigoAscendente() {
		TreeSet<Profesor> profesoresOrdenados = new TreeSet<>();
		
		for(Mago mago : magos) {
			if (mago instanceof Profesor){
				profesoresOrdenados.add((Profesor)mago);
			}
		}
		return profesoresOrdenados;
	}
	
	public TreeSet<Alumno> seOrdenanLosAlumnosPorPuntosDescendenteYPorCasaAscendente() {
		
		TreeSet<Alumno> alumnosOrdenadosPorPuntos = new TreeSet<Alumno>(new OrdenarAlumnosPorPuntosYCasa()); 
		
		for(Mago mago : magos) {
			if (mago instanceof Alumno) {
				alumnosOrdenadosPorPuntos.add((Alumno)mago);
			}
		}
		return alumnosOrdenadosPorPuntos;
	}
	
	public Map<String, String> obtenerReporteTodosLosMagos() {
		TreeMap<String, String> reporte = new TreeMap<String, String>();
		
		for(Mago mago : magos) {
			reporte.put(mago.getCodigo(), mago.getApellido());
		}
		return reporte;
	}
	
	public String determinarCasaGanadora() {
		String casaGanadora = "";
		int puntos = 0;
		
		for(Mago mago : magos) {
			if(mago instanceof Alumno) {
				if(puntos < calcularPuntosDeUnaCasa(((Alumno)mago).getCasa()))
				casaGanadora = ((Alumno)mago).getCasa();
				puntos = calcularPuntosDeUnaCasa(((Alumno)mago).getCasa());
			}
		}
		
		return casaGanadora;
	}
	
	public Set<Mago> getMagos() { return magos; }
	
}
