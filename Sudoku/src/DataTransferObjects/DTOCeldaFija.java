package DataTransferObjects;

public class DTOCeldaFija {
	//Tanto fila como columna pueden ser cualquier valor mayor o igual a 0 y menor a (n*n)-1, lo digo para evitar la duda de si es de "0 a 8" o "1 a 9"
	private int fila;
	private int columna;
	private int valor;
	
	public DTOCeldaFija(int fila, int columna, int valor) {
		this.fila = fila;
		this.columna = columna;
		this.valor = valor;
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
	
}
