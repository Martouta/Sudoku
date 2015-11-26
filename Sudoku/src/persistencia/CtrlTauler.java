package persistencia;

import java.io.IOException;
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
    private static String path = "src/domini/JocsProva/taulers.txt";
	
	// Carrega els taulersObj de la BD
	// si hi ha hagut error al carregar els taulersObj llença una excepcio
	protected static void carrega()
    {
        try {
        	int punt = 0;
            ArrayList<ArrayList<String>> taulersPers = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : taulersPers) {
                //taulersObj.add(new TaulerSudoku(Integer.parseInt(fila.get(0)))); //creem un TaulerSudoku de mida (n*n)X(n*n), pero ens falta
            	nombresTauler.add(fila.get(punt++));																            //afegir-hi les regions i celles guardades al fitxer
                int n = Integer.parseInt(fila.get(punt++)); //agafem la n del tauler---> 0
                TaulerSudoku ts = new TaulerSudoku(n);
                for(int i=0;i<n*n;i++) {
                	for(int j=0;j<n*n;j++){
                		int num = Integer.parseInt(fila.get(punt++));
                		if(num!=0)
                			ts.setNumCelda(i, j, num, true);
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
                		else
                			fila.add(Integer.toString(ts.getNumero(i, j)));
                	}
                }
                taulersPers.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taulersPers;
    }

	// Constructor per defecte
	// Inicialitza l'agregacio
	public CtrlTauler() {
		dirty = false;
		try {
            taulersObj = new ArrayList<TaulerSudoku>();
            //carrega(); //si no ho treiem, peta ja que intenta llegir d'un fitxer no existent
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	// Si s'han modificat les dades carregades des de la BD, desar els canvis
    // Aquest mètode s'ha de cridar quan es vulgin guardar els canvis a la BD
	public static void end() {
        if (dirty) {
            try {
                CtrlPersistencia.storeTable(path, codifica());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

    // Retorna la taula d'taulersObj
    public static ArrayList<TaulerSudoku> getTaula() {
        return taulersObj;
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
	// Retorna fals si hi ha hagut cap error i llença excepció o bé si l'usuari ja hi és i no es pot afegir
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
	// Retorna false si hi ha hagut cap error i llença excepció
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