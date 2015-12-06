package excepciones;

public class ExcepcionNoQuedanCeldasVacias extends Exception {
	public static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se puede pedir pista porque no quedan celdas vacias";
	}
	
}
