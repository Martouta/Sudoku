package persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import capaDomini.*;

//////////////////////////////
//
// CtrlTauler
//
// Agregacio de Taulers
// Permet gestionar Taulers
//////////////////////////////

public class CtrlTauler
{
	private static boolean dirty;             // true si s'ha modificat la llista d'usuari
	protected static ArrayList<TaulerSudoku> taulersObj; // ordenats per nom
	protected static ArrayList<String> nombresTauler;
    private static String path = "src/data/taulers.txt";
    
    // prefiero hacerlo as�, garantizamos un orden
    public static void init() {
    	try {
			 CtrlPersistencia.setSeparator(" ");
            taulersObj = new ArrayList<TaulerSudoku>();
            nombresTauler = new ArrayList<String>();
            File file = new File(Paths.get(path).toAbsolutePath().toString());
            if(!file.exists()) file.getParentFile().mkdirs();
            else carrega();
            //System.out.println("Inicialitzo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	// Carrega els taulersObj de la BD
	// si hi ha hagut error al carregar els taulersObj llen�a una excepcio
	protected static void carrega()
    {
        try {
        	int punt;// = 0;
            ArrayList<ArrayList<String>> taulersPers = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : taulersPers) {
            	punt = 0;
            	nombresTauler.add(fila.get(punt++));
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
                taulersObj.add(ts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	// Codifica els taulersObj en el format que es guardaran a la BD
	protected static ArrayList<ArrayList<String>> codifica()
    {
        ArrayList<ArrayList<String>> taulersPers = new ArrayList<ArrayList<String>>();
        try {
            for (int ii=0;ii<taulersObj.size();ii++) {
            	TaulerSudoku ts = taulersObj.get(ii);
            	ArrayList<String> fila = new ArrayList<String>();
            	fila.add(nombresTauler.get(ii));
            	int n = ts.getN();
                fila.add(Integer.toString(n)); //guardem la n del tauler ----------> get(0)
                
                for(int i=0;i<n*n;i++) {
                	for(int j=0;j<n*n;j++) {
                		if(ts.estaVacia(i, j))
                			fila.add(Integer.toString(0));
                		else {
                			fila.add(Integer.toString(ts.getNumero(i, j)));
                			fila.add(Boolean.toString(ts.estaFija(i, j)));
                		}
                	}
                }
                taulersPers.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taulersPers;
    }

	// Si s'han modificat les dades carregades des de la BD, desar els canvis
    // Aquest m�tode s'ha de cridar quan es vulgin guardar els canvis a la BD
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

    // Retorna la taula d'taulersObj
    public static ArrayList<TaulerSudoku> getTaula() {
        return taulersObj;
    }
    
    public static ArrayList<String> getNoms() {
    	return nombresTauler;
    }
	
	// Retorna l'Usuari amb username igual a nom
	// Retorna null si no el troba
	public static TaulerSudoku getTaulerSudoku(String nom) //com identifiquem els sudokus?
    {
        for (int i=0;i<taulersObj.size();i++) {
            if (Objects.equals(nombresTauler.get(i), nom)) return taulersObj.get(i);
        }
        return null;
    }
	
	// Afegeix l'Usuari us a l'agregat
	// Retorna fals si hi ha hagut cap error i llen�a excepci� o b� si l'usuari ja hi �s i no es pot afegir
	public static boolean afegeixTaulerSudoku(TaulerSudoku ts, String nom)
    {
        try {
            for (String aux : nombresTauler) {
                if (Objects.equals(aux, nom)) { //haurem de posar id als taulers per tal d'identificarlos per la BD
                    return false;
                }
            }
        	nombresTauler.add(nom);
            dirty = taulersObj.add(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirty;
    }
	
	// Esborra l'Usuari amb username nom de l'agregat
	// Retorna false si hi ha hagut cap error i llen�a excepci�
	public static boolean esborraTaulerSudoku(String nom) {
        try {
            for (int i = nombresTauler.size() - 1; i >= 0; i--) {
                String s = nombresTauler.get(i);
                if (Objects.equals(s, nom)) { 
                	taulersObj.remove(i);
                	nombresTauler.remove(i);
                	dirty = true;
                	return dirty;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirty;
    }
}