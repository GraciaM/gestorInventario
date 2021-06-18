package proyectoFinalnventario;

import java.io.Serializable;

public class Pedido implements Serializable {

	private String referencia;
	private String nombre;
	private int cantidad;
	private double precio_unidad;
	private double precio_total;
	// private Proveedor prov;

	public Pedido() {

	}

	public Pedido(String referencia, String nombre, int cantidad, double precio_unidad) {
		this.referencia = referencia;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio_unidad = precio_unidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio_unidad() {
		return precio_unidad;
	}

	public double getPrecio_total() {
		return precio_unidad * cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	@Override
	public String toString() {
		return "Pedido [referencia=" + referencia + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio_unidad="
				+ precio_unidad + "]";
	}

}
