package proyectoFinalnventario;

public class Ubicacion {

	private String estanteria;
	private String estante;
	
	public Ubicacion(String estanteria, String estante) {
		this.estanteria = estanteria;
		this.estante = estante;
	}

	public String getEstanteria() {
		return estanteria;
	}

	public String getEstante() {
		return estante;
	}

	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	public void setEstante(String estante) {
		this.estante = estante;
	}
	
}
