package excepciones.excUsuario;

public class ExcepcionContrasenaIncorrecta extends Exception{
	public static final long serialVersionUID = 30L;

	@Override
	public String getMessage() {
		return "Contrasena incorrecta";
	}
}
