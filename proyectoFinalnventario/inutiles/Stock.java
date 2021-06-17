package proyectoFinalnventario;

public class Stock {

	private String referencia;
	private int numStock;
	private int stockPrestado;

	public Stock(String referencia, int numStock) {
		this.numStock = numStock;
	}

	public String getReferencia() {
		return referencia;
	}

	public int getNumStock() {
		return numStock;
	}

	public int getStockPrestado() {
		return stockPrestado;
	}

	public void setNumStock(int numStock) {
		this.numStock = numStock;
	}

	public void setStockPrestado(int stockPrestado) {
		this.stockPrestado = stockPrestado;
	}

}
