package capaDomini;
//import java.util.*;

import DataTransferObjects.tipoDificultad;
import excepciones.ExcepcionPosicionFueraRango;
import excepciones.ExcepcionTamanoIncorrecto;

public abstract class Joc {
	private tipoDificultad dificultad;
	private String id;
	private Tauler tauler;
	
	public Joc() {
		dificultad = null;
		id = null;
	}
	
	public Joc(int m, int n, tipoDificultad dif, String idJoc) throws ExcepcionTamanoIncorrecto, ExcepcionPosicionFueraRango {
		dificultad = dif;
		id = idJoc;
		tauler = new Tauler(m,n);
	}
	
	public Joc(String idJoc, Tauler t) {
		dificultad = null;
		id = idJoc;
		tauler = t;
	}
	
	public Joc(String idJoc, Tauler t, tipoDificultad td) {
		dificultad = td;
		id = idJoc;
		tauler = t;
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
	
	public void setTauler(Tauler t) {
		tauler = t;
	}
	
	public void setId(String s) {
		id = s;
	}
}