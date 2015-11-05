package capaDomini;

public class JocSudoku extends Joc {
	
	public JocSudoku(int n, tipoDificultad dif, String idJocSudoku) {
		super(n, n, dif, idJocSudoku);
	}
	
	public JocSudoku(tipoDificultad dif, String idJocSudoku, TaulerSudoku t) {
		super(dif, idJocSudoku, t);
	}

	public void pista() {
		
	}
}
