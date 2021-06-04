package proyectoFinalnventario;

public class Producto {

	private String marca;
	private String modelo;
	private int medida;
	private String color;
	private String familia;
	
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
	
	public int getMedida() {
		return medida;
	}

	public String getColor() {
		return color;
	}
	
	public String getFamilia() {
		return familia;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMedida(int medida) {
		this.medida = medida;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void setFamilia(String familia) {
		this.familia = familia;
	}

	@Override
	public String toString() {
		return "Producto [marca=" + marca + ", modelo=" + modelo + ", medida=" + medida + ", color=" + color + "]";
	}
	
}
