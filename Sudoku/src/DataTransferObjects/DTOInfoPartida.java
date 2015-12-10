package DataTransferObjects;

import java.util.Vector;

public class DTOInfoPartida {
	private String nombreSudoku;
	private Vector<DTOCeldaFija> vCeldasFijas;
	private Vector<DTOCeldaFija> vCeldasNoFijas;
	
	public DTOInfoPartida(String nombreSudoku, DTOTiempo tiempoEjecutandose, int numeroPistas, Vector<DTOCeldaFija> vCeldasFijas, Vector<DTOCeldaFija> vCeldasNoFijas, int n) {
		this.nombreSudoku = nombreSudoku;
		this.vCeldasFijas = vCeldasFijas;
		this.vCeldasNoFijas = vCeldasNoFijas;
	}
	
	public String getNombreSudoku() {
		return nombreSudoku;
	}

	public Vector<DTOCeldaFija> getCeldasFijas() {
		 return vCeldasFijas;
	}
	
	public Vector<DTOCeldaFija> getCeldasNoFijas() {
		 return vCeldasNoFijas;
	}

}
