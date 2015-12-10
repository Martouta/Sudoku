package excepciones;

public class ExcepcionNingunSudokuSeleccionado extends Exception {
	public static final long serialVersionUID = 46L;

	@Override
	public String getMessage() {
		return "No hay ningun sudoku seleccionado";
	}
}
