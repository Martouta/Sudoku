package capaDomini;

public class RegioSudoku extends RegioSenseRepeticions{ //SE ENCARGA MARTA
	private tipoRegioSudoku tipus;
	
	RegioSudoku(tipoRegioSudoku tipo){
		super();
		tipus = tipo; //tipoRegioSudoku.cuadrado;
	}

	public tipoRegioSudoku getTipus() {
		return tipus;
	}

}
