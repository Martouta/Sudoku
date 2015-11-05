package capaDomini;

import capaDomini.Tauler;

public class JocSudoku extends Joc {

	//potser no es necessaria ja que inicialitza el joc buit, i no ens pot interessar que aixo passi
	public JocSudoku() {
		super();
	}
	
	public JocSudoku(int n, tipoDificultad dif, String idJocSudoku) {
		super(n, n, dif, idJocSudoku);
	}
	
	public JocSudoku(int n, tipoDificultad dif, String idJocSudoku, Tauler t) {
		super(n, n, dif, idJocSudoku, t);
	}

	public void pista() {
		
	}
}
