package excepciones.excUsuario;

public class ExcepcionUsuarioNoExiste extends Exception{
	public static final long serialVersionUID = 30L;

	@Override
	public String getMessage() {
		return "<html>No hay ningun usuario con<br/>este nombre de usuario</html>";
	}
}
