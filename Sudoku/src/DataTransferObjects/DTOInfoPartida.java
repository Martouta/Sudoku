package DataTransferObjects;

import java.util.Vector;

public class DTOInfoPartida {
	private String nombreSudoku;
	private Vector<DTOCeldaFija> vCeldasFijas;
	private Vector<DTOCeldaFija> vCeldasNoFijas;
	private Vector<DTOCeldaFija> vMarcas;
	
	public DTOInfoPartida(String nombreSudoku, DTOTiempo tiempoEjecutandose, int numeroPistas, Vector<DTOCeldaFija> vCeldasFijas, Vector<DTOCeldaFija> vCeldasNoFijas, Vector<DTOCeldaFija> vMarcas) {
		this.nombreSudoku = nombreSudoku;
		this.vCeldasFijas = vCeldasFijas;
		this.vCeldasNoFijas = vCeldasNoFijas;
		this.vMarcas = vMarcas;
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
	
	public Vector<DTOCeldaFija> getMarcas() {
		return vMarcas;
	}

}
