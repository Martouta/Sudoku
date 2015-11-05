package capaDomini;

import excepciones.*;

public class Cella {
	public Cella() {
		numero = x = y = -1;
		fija = false;
		bloqueada = false;
	}
	
	public Cella(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// si la celda está vacía, devuelve -1
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int val) {
		try {
			if(fija) throw (new ExcepcionNumeroFijo());
			numero = val;
		}
		catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean estaVacia() {
		return numero==-1;
	}
	
	public void borra() {
		try {
			if(fija) throw (new ExcepcionNumeroFijo());
			numero = -1;
		}
		catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void fijar() {
		try {
			if(numero == -1) throw (new ExcepcionCasillaVaciaNoFijable());
			fija = true;
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			System.out.println(e.getMessage());
		}
	}
	
	// comprobar
	public void liberar() {
		fija = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int pos) {
		x = pos;
	}
	
	public void setY(int pos) {
		y = pos;
	}
	
	public boolean estaFija() {
		return fija;
	}
	
	public boolean estaBloqueada() {
		return bloqueada;
	}
	
	public void bloquear() {
		bloqueada = true;
	}
	
	private int numero;
	private boolean fija;
	private boolean bloqueada;
	private int x;
	private int y;
}
