package capaDomini;

import capaDomini.Tauler;

public class JocSudoku extends Joc {

	//potser no es necessaria ja que inicialitza el joc buit, i no ens pot interessar que aixo passi
	public JocSudoku() {
		super();
	}
	
	public JocSudoku(int mida, tipoDificultad dif, String idJocSudoku) {
		super(mida, dif, idJocSudoku);
	}
	
	public JocSudoku(int mida, tipoDificultad dif, String idJocSudoku, Tauler t) {
		super(mida, dif, idJocSudoku, t);
	}

	public void pista() {
		
	}
}
