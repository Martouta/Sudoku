package excepciones;

public class ExcepcionNoHaySudokuConCaracteristicasSeleccionadas extends Exception{
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "<html>No hay ningun sudoku guardado del tipo,<br>dificultad y tamano seleccionados.</html>";
	}
}
