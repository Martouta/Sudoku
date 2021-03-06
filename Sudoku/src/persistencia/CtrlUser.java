package persistencia;

import persistencia.CtrlPersistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import capaDomini.User;

//////////////////////////////
//
// CtrlUser
//
// Agregacio de Usuaris
// Permet gestionar usuaris
//
// Es considera que el nom d'usuari es unic
// Els usuaris s'ordenen per nom per raons d'eficiencia
// Es considera que els usuaris es troben a la taula "users"
// amb el format aconsellat a CtrlPersistencia
//
//////////////////////////////

public class CtrlUser
{
	private static boolean dirty;             // true si s'ha modificat la llista d'usuari
	protected static ArrayList<User> usuaris; // ordenats per nom
    private static String path = "src/data/users.txt"; //Canvi del path 
	
	// Carrega els usuaris de la BD
	// si hi ha hagut error al carregar els usuaris llença una excepcio
	protected static void carrega()
    {
		try {
            ArrayList<ArrayList<String>> users = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : users) {
            	String username = fila.get(0);
            	if (Boolean.parseBoolean(fila.get(1))) 
            		usuaris.add(new User(username, fila.get(2)));
            	else usuaris.add(new User(username,""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	// Codifica els usuaris en el format que es guardaran a la BD
	protected static ArrayList<ArrayList<String>> codifica()
    {
        ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
        try {
            for (User us : usuaris) {
                ArrayList<String> fila = new ArrayList<String>();
                fila.add(us.getUsername());
                String passwd = us.getPassword();
                if (!passwd.isEmpty()) {
                	fila.add(Boolean.toString(true)); //afegim un boolea per controlar si te contrasenya o no
                	fila.add(passwd);
                }
                else fila.add(Boolean.toString(false)); //igual que a dalt
                users.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

	// Constructor per defecte
	// Inicialitza l'agregacio
	/*public CtrlUser() {
		dirty = false;
		try {
            usuaris = new ArrayList<User>();
            carrega();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
	
	public static void init() {
		dirty = false;
		try {
			CtrlPersistencia.setSeparator(" ");
            usuaris = new ArrayList<User>();
            File file = new File(Paths.get(path).toAbsolutePath().toString());
            if(!file.exists()) file.getParentFile().mkdirs();
            else carrega();
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
                dirty = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

    // Retorna la taula d'usuaris
    public static ArrayList<User> getTaula() {
        return usuaris;
    }

    // Consulta la contrasenya de l'usuari amb username "nom"
    public static boolean comprovaPwd(String nom, String pwd) {
      boolean ret = false;
      for (User usuari : usuaris) {
        if (Objects.equals(usuari.getUsername(), nom)) ret = usuari.testPassword(pwd);
      }
      return ret;
    }
	// Retorna l'Usuari amb username igual a nom
	// Retorna null si no el troba
	public static User getUsuari(String nom)
    {
        for (User usuari : usuaris) {
            if (Objects.equals(usuari.getUsername(), nom)) return usuari;
        }
        return null;
    }
	
	// Afegeix l'Usuari us a l'agregat
	// Retorna fals si hi ha hagut cap error i llença excepció o bé si l'usuari ja hi és i no es pot afegir
	public static boolean afegeixUsuari(User us)
    {
        try {
            for (User aux : usuaris) {
                if (Objects.equals(aux.getUsername(), us.getUsername())) {
                    return false;
                }
            }
            dirty = usuaris.add(us);
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
            for (int i = usuaris.size() - 1; i >= 0; i--) {
                User usuari = usuaris.get(i);
                if (Objects.equals(usuari.getUsername(), nom)) dirty = usuaris.remove(usuari);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirty;
    }
}
