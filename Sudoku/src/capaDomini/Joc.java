package capaDomini;
//import java.util.*;

import capaDomini.Tauler;

public abstract class Joc {
	private int m, n;
	private tipoDificultad dificultad;
	private String id;
	private Tauler tauler;
	
	// no es necessaria ja que no serveix
	public Joc() {
		m = n = 0;
		dificultad = null;
		id = null;
	}
	
	public Joc(int m, int n, tipoDificultad dif, String idJoc) {
		this.m = m;
		this.n = n;
		dificultad = dif;
		id = idJoc;
		
	}
	
	public Joc(int m, int n, tipoDificultad dif, String idJoc, Tauler t) {
		this.m = m;
		this.n = n;
		dificultad = dif;
		id = idJoc;
		tauler = t;
	}
	
	public String getId() {
		return id;
	}
	
	public int getN() {
		return n;
	}
	
	public tipoDificultad getDificultad() {
		return dificultad;
	}
	
	public Tauler getTauler() {
		return tauler;
	}
}
