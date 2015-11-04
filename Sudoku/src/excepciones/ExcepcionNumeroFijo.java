package excepciones;

public class ExcepcionNumeroFijo extends Exception {
	public static final long serialVersionUID = 43L;

	@Override
	public String getMessage() {
		return "El numero es fijo y no se puede modificar";
	}
}
