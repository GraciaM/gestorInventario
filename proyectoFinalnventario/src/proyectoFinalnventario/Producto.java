package proyectoFinalnventario;

public class Producto {

	private String marca;
	private String modelo;
	
	public Producto(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Producto [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
