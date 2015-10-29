package capaDomini;

import java.util.Vector;

public class RegioSudoku extends RegioSenseRepeticions{ //SE ENCARGA MARTA
	private tipoRegioSudoku tipus;
	
	RegioSudoku(int n, tipoRegioSudoku tipo){
		super(n*n);
		tipus = tipo; //tipoRegioSudoku.cuadrado;
	}
	
	RegioSudoku(int n, Vector<Cella> vc, tipoRegioSudoku tipo){
		super(n*n, vc);
		tipus = tipo; //tipoRegioSudoku.cuadrado;
	}

	public tipoRegioSudoku getTipus() {
		return tipus;
	}

}

/*falta comprobar*/