package excepciones;

public class ExcepcionNombreConEspaciosEnBlanco extends Exception {
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No pueden haber espacios en blanco en el nombre ni en la contrasena";
	}
	
}
