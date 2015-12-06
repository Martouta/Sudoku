package persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import persistencia.CtrlUser;
import capaDomini.JocSudoku;
import capaDomini.Partida;
import capaDomini.TaulerSudoku;
import capaDomini.Tauler;
//import capaDomini.tipoDificultad;
import capaDomini.User;

public class CtrlPartida {

	private static boolean dirty;             // true si s'ha modificat la llista de partidas
	protected static ArrayList<Partida> partidas; // ordenats per id
	protected static ArrayList<String> nombresPartidas;
	protected static ArrayList<String> usuariosPartidas;		// los username, evidentemente
    private static String path = "src/data/partidas.txt";
    
    // se necesita crear antes CtrlUsuario y CtrlJocSudoku
    public CtrlPartida() {
    	dirty = false;
    	try {
    		CtrlPersistencia.setSeparator(" ");
    		partidas = new ArrayList<Partida>();
    		nombresPartidas = new ArrayList<String>();
    		usuariosPartidas = new ArrayList<String>();
    		File file = new File(Paths.get(path).toAbsolutePath().toString());
    		if(!file.exists()) file.getParentFile().mkdirs();
    		else
    			carrega();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void init() {
    	dirty = false;
    	try {
    		CtrlPersistencia.setSeparator(" ");
    		partidas = new ArrayList<Partida>();
    		nombresPartidas = new ArrayList<String>();
    		usuariosPartidas = new ArrayList<String>();
    		File file = new File(Paths.get(path).toAbsolutePath().toString());
    		if(!file.exists()) file.getParentFile().mkdirs();
    		else
    			carrega();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    protected static void carrega()
    {
        try {
        	int punt;// = 0;
            ArrayList<ArrayList<String>> partidasPers = CtrlPersistencia.loadTable(path);
            for (ArrayList<String> fila : partidasPers) {
            	punt = 0;
            	usuariosPartidas.add(fila.get(punt++));
            	String nombretauler = fila.get(punt++);
            	punt++;
            	int nsegundos = Integer.parseInt(fila.get(punt++));
            	int npistas = Integer.parseInt(fila.get(punt++));
            	nombresPartidas.add(fila.get(punt++));
            	JocSudoku js = CtrlJocSudoku.getJocSudoku(nombretauler);
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
                js.setTauler(ts);
                User usuario = CtrlUser.getUsuari(usuariosPartidas.get(usuariosPartidas.size()-1));
                Partida p = new Partida(usuario,js);
                p.pauseTiempo();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
                String s = fila.get(punt++);
                p.setDataIni(df.parse(s));
                p.setSegundos(nsegundos);
                p.setNPistas(npistas);
                int nmarcas = Integer.parseInt(fila.get(punt++));
                for(int i=0;i<nmarcas;i++) {
                	p.marcarNumero(Integer.parseInt(fila.get(punt++)), Integer.parseInt(fila.get(punt++)),
                			Integer.parseInt(fila.get(punt++)));
                }
                partidas.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static ArrayList<ArrayList<String>> codifica()
    {
        ArrayList<ArrayList<String>> partidasPers = new ArrayList<ArrayList<String>>();
        try {
            for (int ii=0;ii<partidas.size();ii++) {
            	Partida p = partidas.get(ii);
            	ArrayList<String> fila = new ArrayList<String>();
            	fila.add(usuariosPartidas.get(ii));
            	JocSudoku js = p.getJocSudoku();
            	fila.add(js.getId());
            	fila.add(js.getDificultad().toString());
            	fila.add(Integer.toString(p.getSegundosTotales()));
                fila.add(Integer.toString(p.getNumPistas()));
            	fila.add(nombresPartidas.get(ii));
            	Tauler ts = js.getTauler();
            	int nn = ts.getAlto();
                fila.add(Integer.toString((int)Math.sqrt(nn))); //guardem la n del tauler ----------> get(0)
                for(int i=0;i<nn;i++) {
                	for(int j=0;j<nn;j++) {
                		if(ts.estaVacia(i, j))
                			fila.add(Integer.toString(0));
                		else {
                			fila.add(Integer.toString(ts.getNumero(i, j)));
                			fila.add(Boolean.toString(ts.estaFija(i, j)));
                		}
                	}
                }
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
                Date d = p.getDataIni();
                fila.add(df.format(d));
                int nmarcas = 0;
                for(int i=0;i<nn;i++) {
                	for(int j=0;j<nn;j++) {
                		for(int k=1;k<=nn;k++) {
                			if(p.estaMarcado(i, j, k))
                				nmarcas++;
                		}
                	}
                }
                fila.add(Integer.toString(nmarcas));
                for(int i=0;i<nn;i++) {
                	for(int j=0;j<nn;j++) {
                		for(int k=1;k<=nn;k++) {
                			if(p.estaMarcado(i, j, k)) {
                				fila.add(Integer.toString(i));
                				fila.add(Integer.toString(j));
                				fila.add(Integer.toString(k));
                			}
                		}
                	}
                }
                partidasPers.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partidasPers;
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
    
    public static ArrayList<Partida> getTaula() {
        return partidas;
    }
    
    // solo puedes conseguir la partida si eres el mismo usuario
    public static Partida getPartida(String id, User usuario)
    {
        for (int i=0;i<nombresPartidas.size();i++) {
            if (Objects.equals(nombresPartidas.get(i), id) 
            		&& Objects.equals(usuario.getUsername(),usuariosPartidas.get(i))) 
            	return partidas.get(i);
        }
        return null;
    }
    
 	// Retorna fals si hi ha hagut cap error i llença excepció o bé si el joc ja hi és i no es pot afegir
 	// id es el identificador de la partida
    public static boolean afegeixPartida(Partida p, String id)
     {
         try {
             for (String s : nombresPartidas) {
                 if (Objects.equals(s, id)) {
                     return false;
                 }
             }
             nombresPartidas.add(id);
             usuariosPartidas.add(p.getUsuario().getUsername());
             dirty = partidas.add(p);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return dirty;
     }

    // necesitas tener el usuario que toca, si no, no te la encuentra
 	 public static boolean esborraPartida(String id, User usuario)
     {
         try {
             for(int i=0;i<partidas.size();i++) {
            	 if(Objects.equals(id, nombresPartidas.get(i)) &&
            			 Objects.equals(usuario.getUsername(), usuariosPartidas.get(i))) {
            		 partidas.remove(i);
            		 usuariosPartidas.remove(i);
            		 nombresPartidas.remove(i);
            		 return dirty = true;
            	 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return dirty;
     }
}
