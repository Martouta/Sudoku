package excepciones;

public class ExcepcionTimerYaEstaParado extends Exception{
	public static final long serialVersionUID = 52L;

	@Override
	public String getMessage() {
		return "El Timer ya esta parado";
	}
}
