package persistencia;

import java.io.IOException;
import java.util.ArrayList;

import capaDomini.JocSudoku;
import capaDomini.TaulerSudoku;
import capaDomini.User;
import capaDomini.tipoDificultad;

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
    
    protected static ArrayList<ArrayList<String>> codifica()
    {
        ArrayList<ArrayList<String>> joc = new ArrayList<ArrayList<String>>();
        try {
            for (JocSudoku js : jocs) {
                ArrayList<String> fila = new ArrayList<String>();
                fila.add(js.getId());
                fila.add(js.getDificultad().toString());                
                joc.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joc;
    }
    
    public static void end() {
        if (dirty) {
            try {
                CtrlPersistencia.storeTable(path, codifica());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
    
    public static ArrayList<JocSudoku> getTaula() {
        return jocs;
    }
    
    

}
