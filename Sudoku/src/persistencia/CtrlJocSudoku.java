package persistencia;

import java.util.ArrayList;
import capaDomini.JocSudoku;
import capaDomini.TaulerSudoku;

import capaDomini.User;

public class CtrlJocSudoku {

	private static boolean dirty;             // true si s'ha modificat la llista de jocs
	protected static ArrayList<JocSudoku> jocs; // ordenats per id
    private static String path = "src/domini/JocsProva/jocs.txt";
    
    public CtrlJocSudoku(TaulerSudoku ts, TaulerSudoku tssol) {
		dirty = false;
		try {
            jocs = new ArrayList<JocSudoku>();
            /*TaulerSudoku ts = ;//aqui se obtiene el tablero de la BD para cargarlo junto a juego
            TaulerSudoku tssol = ; //obtener el tablero solucionado*/
            carrega(ts, tssol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void carrega(TaulerSudoku ts, TaulerSudoku tssol)
    {
        try {
            ArrayList<ArrayList<String>> joc = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : joc) {
                jocs.add(new JocSudoku(fila.get(0), ts, tssol));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
