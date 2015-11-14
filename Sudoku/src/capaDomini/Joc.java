package capaDomini;
//import java.util.*;

public abstract class Joc {
	private tipoDificultad dificultad;
	private String id;
	private Tauler tauler;
	
	public Joc() {
		dificultad = null;
		id = null;
	}
	
	public Joc(int m, int n, tipoDificultad dif, String idJoc) {
		try {
			dificultad = dif;
			id = idJoc;
			tauler = new Tauler(m,n);
		}
		catch (IllegalArgumentException e) {
			System.out.println("No hay ningún valor de dificultad que coincida con el introducido");
		}
	}
	
	public Joc(String idJoc, Tauler t) {
		dificultad = null;
		id = idJoc;
		tauler = t;
	}
	
	public Joc(String idJoc, Tauler t, tipoDificultad td) {
		try {
			dificultad = td;
			id = idJoc;
			tauler = t;
		}
		catch (IllegalArgumentException e) {
			System.out.println("No hay ningún valor de dificultad que coincida con el introducido");
		}
	}
	
	public String getId() {
		return id;
	}
	
	public tipoDificultad getDificultad() {
		return dificultad;
	}
	
	public void setDificultad(tipoDificultad t) {
		dificultad = t;
	}
	
	public Tauler getTauler() {
		return tauler;
	}
}