package proyectoFinalnventario;

public class Pieza_pertenece_Producto {

	private String referencia;
	private String modelo;
	private String marca;

	public Pieza_pertenece_Producto(String referencia, String modelo, String marca) {
		this.referencia = referencia;
		this.modelo = modelo;
		this.marca = marca;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
