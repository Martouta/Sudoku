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
	protected static ArrayList<User> taulersObj; // ordenats per nom
    private static String path = "src/domini/JocsProva/taulers.txt";
	
	// Carrega els taulersObj de la BD
	// si hi ha hagut error al carregar els taulersObj llença una excepcio
	protected static void carrega()
    {
        try {
            ArrayList<ArrayList<String>> taulersPers = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : taulersPers) {
                taulersObj.add(new Tauler(fila.get(0), fila.get(1), fila.get(2)));
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
            for (User us : taulersObj) {
                ArrayList<String> fila = new ArrayList<String>();
                fila.add(us.getUsername());
                fila.add(us.getPassword());
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
            taulersObj = new ArrayList<User>();
            carrega();
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
    public static ArrayList<User> getTaula() {
        return taulersObj;
    }
	
	// Retorna l'Usuari amb username igual a nom
	// Retorna null si no el troba
	public static User getUsuari(String nom)
    {
        for (User usuari : taulersObj) {
            if (Objects.equals(usuari.getUsername(), nom)) return usuari;
        }
        return null;
    }
	
	// Afegeix l'Usuari us a l'agregat
	// Retorna fals si hi ha hagut cap error i llença excepció o bé si l'usuari ja hi és i no es pot afegir
	public static boolean afegeixUsuari(User us)
    {
        try {
            for (User aux : taulersObj) {
                if (Objects.equals(aux.getUsername(), us.getUsername())) {
                    return false;
                }
            }
            dirty = taulersObj.add(us);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirty;
    }
	
	// Esborra l'Usuari amb username nom de l'agregat
	// Retorna false si hi ha hagut cap error i llença excepció
	public static boolean esborraUsuari(String nom)
    {
        try {
            for (int i = taulersObj.size() - 1; i >= 0; i--) {
                User usuari = taulersObj.get(i);
                if (Objects.equals(usuari.getUsername(), nom)) dirty = taulersObj.remove(usuari);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirty;
    }
}