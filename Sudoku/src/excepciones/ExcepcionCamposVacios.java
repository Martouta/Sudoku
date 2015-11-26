package excepciones;

public class ExcepcionCamposVacios extends Exception {
	public static final long serialVersionUID = 46L;

	@Override
	public String getMessage() {
		return "Hay campos obligatorios no rellenados";
	}
}