package proyectoFinalnventario;

public class Pieza {

	private String referencia;
	private String nombre;
	private String descripcion;
	private double precio_venta;
	
	public Pieza(String referencia, String nombre) {
		this.referencia = referencia;
		this.nombre = nombre;
	}
	
	public String getReferencia() {
		return referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
}
