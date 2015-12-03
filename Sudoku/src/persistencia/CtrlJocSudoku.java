package persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import capaDomini.JocSudoku;
import capaDomini.ResolvedorSudoku;
import capaDomini.Tauler;
import capaDomini.TaulerSudoku;


public class CtrlJocSudoku {

	private static boolean dirty;             // true si s'ha modificat la llista de jocs
	protected static ArrayList<JocSudoku> jocs; // ordenats per id
    private static String path = "src/domini/data/jocs.txt";
    
    public static void init() {
    	dirty = false;
		try {
			CtrlPersistencia.setSeparator(" ");
            jocs = new ArrayList<JocSudoku>();
            File file = new File(Paths.get(path).toAbsolutePath().toString());
            if(!file.exists()) file.getParentFile().mkdirs();
            else carrega();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    protected static void carrega() {
    	try {
    		int punt;// = 0;
            ArrayList<ArrayList<String>> taulersPers = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : taulersPers) {
            	punt = 0;
            	String id = fila.get(punt++);
                int n = Integer.parseInt(fila.get(punt++)); //agafem la n del tauler---> 0
                TaulerSudoku ts = new TaulerSudoku(n);
                for(int i=0;i<n*n;i++) {
                	for(int j=0;j<n*n;j++){
                		int num = Integer.parseInt(fila.get(punt++));
                		if(num!=0) {
	                		ts.setNumCelda(i, j, num, false);
	                		boolean basaur = Boolean.parseBoolean(fila.get(punt++));
	                		if(basaur)
	                			ts.getCella(i, j).fijar();
                		}
                	}
                }
                jocs.add(new JocSudoku(id,ts,ResolvedorSudoku.resuelveSudoku3(ts)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static ArrayList<ArrayList<String>> codifica()
    {
    	ArrayList<ArrayList<String>> tjocs = new ArrayList<ArrayList<String>>();
        try {
            for (int ii=0;ii<jocs.size();ii++) {
            	JocSudoku js = jocs.get(ii);
            	ArrayList<String> fila = new ArrayList<String>();
            	fila.add(js.getId());
            	Tauler t = js.getTauler();
            	int nn = t.getAncho();
                fila.add(Integer.toString((int)Math.sqrt(nn))); //guardem la n del tauler ----------> get(0)
                
                for(int i=0;i<nn;i++) {
                	for(int j=0;j<nn;j++) {
                		if(t.estaVacia(i, j))
                			fila.add(Integer.toString(0));
                		else {
                			fila.add(Integer.toString(t.getNumero(i, j)));
                			fila.add(Boolean.toString(t.estaFija(i, j)));
                		}
                	}
                }
                tjocs.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tjocs;
    }
    
    public static void end() {
        if (dirty) {
            try {
                CtrlPersistencia.storeTable(path, codifica());
                dirty = false;
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
    
    // Afegeix el JocSudoku js a l'agregat
 	// Retorna fals si hi ha hagut cap error i llença excepció o bé si el joc ja hi és i no es pot afegir
 	public static boolean afegeixJocSudoku(JocSudoku js)
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

 	// Esborra el joc amb id de l'agregat
 	// Retorna false si hi ha hagut cap error i llença excepció
 	public static boolean esborraJocSudoku(String id)
     {
         try {
             for (int i = jocs.size() - 1; i >= 0; i--) {
                 JocSudoku js = jocs.get(i);
                 if (Objects.equals(js.getId(), id)) {
                	 //System.out.println("Elimino el " + js.getId());
                	 jocs.remove(i);
                	 dirty = true;
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return dirty;
     }
 	
 	// dudo que la usemos, pero venga
 	public static boolean renombraJocSudoku(String idAntes, String idDespues) {
 		try {
            for (int i = jocs.size() - 1; i >= 0; i--) {
                if (Objects.equals(jocs.get(i).getId(), idAntes)) {
                	jocs.get(i).setId(idDespues);
                	dirty = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirty;
 	}
}
