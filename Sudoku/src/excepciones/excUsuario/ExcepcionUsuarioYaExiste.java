package excepciones.excUsuario;

public class ExcepcionUsuarioYaExiste extends Exception{
	public static final long serialVersionUID = 30L;

	@Override
	public String getMessage() {
		return "Ya hay un usuario con este nombre de usuario";
	}
}
