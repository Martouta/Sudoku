package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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
    
    public static JocSudoku getJocSudoku(String id)
    {
        for (JocSudoku joc : jocs) {
            if (Objects.equals(joc.getId(), id)) return joc;
        }
        return null;
    }
    
    // Afegeix l'Usuari us a l'agregat
 	// Retorna fals si hi ha hagut cap error i llença excepció o bé si l'usuari ja hi és i no es pot afegir
 	public static boolean afegeixUsuari(JocSudoku js)
     {
         try {
             for (JocSudoku aux : jocs) {
                 if (Objects.equals(aux.getId(), js.getId())) {
                     return false;
                 }
             }
             dirty = jocs.add(js);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return dirty;
     }

 	// Esborra l'Usuari amb username nom de l'agregat
 	// Retorna false si hi ha hagut cap error i llença excepció
 	public static boolean esborraUsuari(String id)
     {
         try {
             for (int i = jocs.size() - 1; i >= 0; i--) {
                 JocSudoku js = jocs.get(i);
                 if (Objects.equals(js.getId(), id)) dirty = jocs.remove(js);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return dirty;
     }
}
