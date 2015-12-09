package DataTransferObjects;

import java.util.Vector;

public class DTOSudokuGenerado {
	private Vector<DTOCeldaFija> vCeldasFijas;
	private String nombreSudoku;
	
	public DTOSudokuGenerado (String nombreSudoku, Vector<DTOCeldaFija> vCeldasFijas) {
		this.vCeldasFijas = vCeldasFijas;
		this.nombreSudoku = nombreSudoku;
	}
	
	public String getNombreSudoku() {
		return nombreSudoku;
	}
	
	public Vector<DTOCeldaFija> getCeldasFijas() {
		return vCeldasFijas;
	}
}
