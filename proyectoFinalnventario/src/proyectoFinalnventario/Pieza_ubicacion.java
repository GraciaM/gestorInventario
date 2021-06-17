package proyectoFinalnventario;

public class Pieza_ubicacion {

	private String referencia;
	private String estanteria;
	private String estante;

	public Pieza_ubicacion(String referencia, String estanteria, String estante) {
		this.referencia = referencia;
		this.estanteria = estanteria;
		this.estante = estante;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getEstanteria() {
		return estanteria;
	}

	public String getEstante() {
		return estante;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	public void setEstante(String estante) {
		this.estante = estante;
	}

}
