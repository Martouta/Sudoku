package excepciones;

public class ExcepcionNoHaySudokuConCaracteristicasSeleccionadas extends Exception{
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No hay ningun sudoku guardado del tipo, dificultad y tamano seleccionados.";
	}
}
