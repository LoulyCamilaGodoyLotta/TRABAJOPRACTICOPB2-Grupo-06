package ar.edu.unlam.tppb2;

public class Profesor extends Mago implements Comparable<Profesor> {

	public Profesor(String codigo, String nombre, String apellido) {
		super(codigo, nombre, apellido);
		
	}

	@Override
	public int compareTo(Profesor o) {
		int porCodigo = this.getCodigo().compareTo(o.getCodigo());
		if (porCodigo == 0) {
			return this.getApellido().compareTo(o.getApellido());
		}
		return porCodigo;
	}
}
