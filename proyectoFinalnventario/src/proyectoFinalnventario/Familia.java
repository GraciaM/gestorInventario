package proyectoFinalnventario;

public class Familia {

	private String nombre;
	private String descripcion;

	public Familia(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return nombre + "\nDescripcion: " + descripcion;
	}

}
