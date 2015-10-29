package capaDomini;

import capaDomini.Regio;

public class TaulerSudoku extends Tauler {

	public TaulerSudoku(int n) {
		super(n, n);
		regio = new Regio[n]; //vector amb totes les regions del sudoku (N regions)
		/*for (int i = 0; i < n; ++i) {
			regio[i] = new RegioSudoku(m,regioSudoku);
		}*/
	}

	//caldra reescriure els metodes que necessitin modificar regio (setNumero, borra...)
	//regio[] -------> com saber a quina regio ha afectat???????????'
	//enlloc de Cella haurem de fer servir CellaSudoku
	
	private Regio[] regio;
}
