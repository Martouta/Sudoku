package capaDomini;

import java.util.Vector;

public class RegioSudoku extends RegioSenseRepeticions{ //SE ENCARGA MARTA
	private tipoRegioSudoku tipus;
	
	RegioSudoku(int tamano, tipoRegioSudoku tipo){
		super(tamano);
		tipus = tipo; //tipoRegioSudoku.cuadrado;
	}
	
	RegioSudoku(int tamano, Vector<Cella> vc, tipoRegioSudoku tipo){
		super(tamano, vc);
		tipus = tipo; //tipoRegioSudoku.cuadrado;
	}

	public tipoRegioSudoku getTipus() {
		return tipus;
	}

}
