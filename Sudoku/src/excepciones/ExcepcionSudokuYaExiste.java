package excepciones;

public class ExcepcionSudokuYaExiste extends Exception{
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Ya hay un sudoku con este nombre";
	}
}