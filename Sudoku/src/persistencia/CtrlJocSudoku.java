package persistencia;

import java.util.ArrayList;
import capaDomini.JocSudoku;
import capaDomini.Joc;

import capaDomini.User;

public class CtrlJocSudoku {

	private static boolean dirty;             // true si s'ha modificat la llista de jocs
	protected static ArrayList<JocSudoku> jocs; // ordenats per id
    private static String path = "src/domini/JocsProva/jocs.txt";
    
    public CtrlJocSudoku() {
		dirty = false;
		try {
            jocs = new ArrayList<JocSudoku>();
            carrega();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void carrega()
    {
        try {
            ArrayList<ArrayList<String>> joc = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : joc) {
                jocs.add(new JocSudoku(joc.get(0)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
