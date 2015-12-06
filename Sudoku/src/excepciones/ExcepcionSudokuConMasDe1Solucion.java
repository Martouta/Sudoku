package excepciones;

public class ExcepcionSudokuConMasDe1Solucion extends Exception {
	public static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "No es un Sudoku valido porque tiene mas de una solucion";
	}
}
