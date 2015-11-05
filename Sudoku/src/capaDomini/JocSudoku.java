package capaDomini;

public class JocSudoku extends Joc {
	
	/*public JocSudoku(int n, String idJocSudoku) {
		super(n, n, idJocSudoku);
	}*/
	
	public JocSudoku(String idJocSudoku, TaulerSudoku t) {
		super(idJocSudoku, t);
		setDificultad(calcularDificultad(t));
	}

	public void pista() {
		
	}
	
	private tipoDificultad calcularDificultad(TaulerSudoku ts) {
		tipoDificultad t;
		//int nn = ts.getNN();
		int c, cr;
		cr = ts.getNumCeldasRellenas();
		c = ts.getNumCeldas();
		int ratio = cr/c;
		if (ratio > 0.61728) t = tipoDificultad.trivial;
		else if (ratio > 0.39506) t = tipoDificultad.facil;
		else if (ratio > 0.37037) t = tipoDificultad.medio;
		else t = tipoDificultad.dificil;
		
		/*if (nn == 9) {
			cr = ts.getNumCeldasRellenas();
			if (cr > 50) t = tipoDificultad.trivial; //ratio = 0.61728
			else if (cr > 32) t = tipoDificultad.facil; //ratio = 0.39506
			else if (cr > 30) t = tipoDificultad.medio; //ratio = 0.37037
			else t = tipoDificultad.dificil; 
		}*/
		
		return t;
	}
}
