package excepciones;

public class ExcepcionHayPartidaConSudoku extends Exception {
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se puede borrar un sudoku con una partida en la BD con este sudoku";
	}
}
