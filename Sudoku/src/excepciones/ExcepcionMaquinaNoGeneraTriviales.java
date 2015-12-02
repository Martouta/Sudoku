package excepciones;

public class ExcepcionMaquinaNoGeneraTriviales extends Exception{
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pueden generar sudokus triviales";
	}
}
