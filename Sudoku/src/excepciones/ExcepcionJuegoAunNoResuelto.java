package excepciones;

public class ExcepcionJuegoAunNoResuelto extends Exception{
	public static final long serialVersionUID = 53L;

	@Override
	public String getMessage() {
		return "El Juego aun no esta resuelto";
	}
}
