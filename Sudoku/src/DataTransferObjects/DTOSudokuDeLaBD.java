package DataTransferObjects;

public class DTOSudokuDeLaBD {
	private String nombreSudoku;
	private int numeroCasillasRellenas;
	
	public DTOSudokuDeLaBD(String nombreSudoku, int numeroCasillasRellenas) {
		this.nombreSudoku = nombreSudoku;
		this.numeroCasillasRellenas = numeroCasillasRellenas;
	}

	public String getNombreSudoku() {
		return nombreSudoku;
	}

	public int getNumeroCasillasRellenas() {
		return numeroCasillasRellenas;
	}

}
