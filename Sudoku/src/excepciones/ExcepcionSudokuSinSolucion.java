package excepciones;

public class ExcepcionSudokuSinSolucion extends Exception {
	public static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "El Sudoku no tiene solucion";
	}
}