package excepciones;

public class ExcepcionCasillaYaTienePosicion extends Exception{
	public static final long serialVersionUID = 50L;

	@Override
	public String getMessage() {
		return "La posicion de una casilla que ya tiene una posicion valida no puede ser modificada";
	}
}
