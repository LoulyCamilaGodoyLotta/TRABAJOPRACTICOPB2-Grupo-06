package ar.edu.unlam.tppb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
	
	public Set<Mago> getMagos() { return magos; }
	
}
