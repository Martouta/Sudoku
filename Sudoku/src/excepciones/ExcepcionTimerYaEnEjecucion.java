package excepciones;

public class ExcepcionTimerYaEnEjecucion extends Exception{
	public static final long serialVersionUID = 51L;

	@Override
	public String getMessage() {
		return "El Timer ya esta en ejecucion";
	}
}
