package excepciones;

public class ExcepcionNumeroFijo extends Exception {
	public static final long serialVersionUID = 43L;

	@Override
	public String getMessage() {
		return "Una casilla esta fija y no se puede modificar";
	}
}
