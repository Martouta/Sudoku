package DataTransferObjects;

public class DTOInfoCelda {
	//Tanto fila como columna pueden ser cualquier valor mayor o igual a 0 y menor a (n*n)-1, lo digo para evitar la duda de si es de "0 a 8" o "1 a 9"
	private int fila;
	private int columna;
	private int valor;
	private boolean esFija;
	
	public DTOInfoCelda(int fila, int columna, int valor, boolean esFija) {
		this.fila = fila;
		this.columna = columna;
		this.valor = valor;
		this.esFija = esFija;
	}
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public int getValor() {
		return valor;
	}
	
	public boolean getEsFija() {
		return esFija;
	}
	
}
