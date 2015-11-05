package capaDomini;
//import java.util.*;

public abstract class Joc {
	private tipoDificultad dificultad;
	private String id;
	private Tauler tauler;
	
	// no es necessaria ja que no serveix
	public Joc() {
		dificultad = null;
		id = null;
	}
	
	public Joc(int m, int n, tipoDificultad dif, String idJoc) {
		dificultad = dif;
		id = idJoc;
		tauler = new Tauler(m,n);
	}
	
	public Joc(tipoDificultad dif, String idJoc, Tauler t) {
		dificultad = dif;
		id = idJoc;
		tauler = t;
	}
	
	public String getId() {
		return id;
	}
	
	public tipoDificultad getDificultad() {
		return dificultad;
	}
	
	public Tauler getTauler() {
		return tauler;
	}
}