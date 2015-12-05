package excepciones;

public class ExcepcionValorFueraRango extends Exception {
	public static final long serialVersionUID = 45L;

	@Override
	public String getMessage() {
		return "Hay un valor fuera del rango permitido";
	}
}
