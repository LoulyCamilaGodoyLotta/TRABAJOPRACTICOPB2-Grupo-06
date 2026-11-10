package ar.edu.unlam.tppb2;

import java.util.Objects;

public class Mago {
	
	private String codigo;
	private String nombre;
	private String apellido;
	
	public Mago(String codigo, String nombre, String apellido) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getCodigo() {	
		return codigo; 
	}
	public String getNombre() {	
		return nombre; 
	}	
	public String getApellido() { 
		return apellido; 
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Mago))
			return false;
		Mago other = (Mago) obj;
		return codigo.equals(other.codigo);
	}
	
	
}
