package proyectoFinalnventario;

public class Pieza_costo {

	private String referencia;
	private String CIF;
	private int precioCosto;

	public Pieza_costo(String referencia, String CIF, int precioCosto) {
		this.referencia = referencia;
		this.CIF = CIF;
		this.precioCosto = precioCosto;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getCIF() {
		return CIF;
	}

	public int getPrecioCosto() {
		return precioCosto;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public void setPrecioCosto(int precioCosto) {
		this.precioCosto = precioCosto;
	}

}
