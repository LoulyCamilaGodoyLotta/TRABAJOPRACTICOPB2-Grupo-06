package ar.edu.unlam.tppb2;

import java.util.HashSet;
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
	
	public Set<Mago> getMagos() { return magos; }
	
}
