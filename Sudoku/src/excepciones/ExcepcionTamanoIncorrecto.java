package excepciones;

public class ExcepcionTamanoIncorrecto extends Exception{
	public static final long serialVersionUID = 47L;

	@Override
	public String getMessage() {
		return "El tamano no es valido";
	}
}
