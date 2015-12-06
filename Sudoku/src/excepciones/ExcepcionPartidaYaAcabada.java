package excepciones;

public class ExcepcionPartidaYaAcabada extends Exception {
	public static final long serialVersionUID = 40L;
	
	@Override
	public String getMessage() {
		return "La partida ya esta acabada";
	}
}