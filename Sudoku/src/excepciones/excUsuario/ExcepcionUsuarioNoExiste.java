package excepciones.excUsuario;

public class ExcepcionUsuarioNoExiste extends Exception{
	public static final long serialVersionUID = 30L;

	@Override
	public String getMessage() {
		return "No hay ningun usuario con este nombre de usuario";
	}
}
