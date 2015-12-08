package excepciones;

public class ExcepcionMasDeUnSudokuSeleccionado extends Exception {
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Hay mas de un sudoku seleccionado";
	}
}
