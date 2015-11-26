package excepciones.excUsuario;

public class ExcepcionContrasenasNoCoinciden extends Exception{
	public static final long serialVersionUID = 30L;

	@Override
	public String getMessage() {
		return "Las 2 contrasenas no coinciden";
	}
}
