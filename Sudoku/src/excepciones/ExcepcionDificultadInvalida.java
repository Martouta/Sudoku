package excepciones;

public class ExcepcionDificultadInvalida extends Exception {
	public static final long serialVersionUID = 4242L;

	@Override
	public String getMessage() {
		return "No se puede generar un sudoku de dificultad trivial";
	}
}
