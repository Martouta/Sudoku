package capaDomini;

import java.util.Vector;
//import java.util.*;

public class Regio { //SE ENCARGA MARTA
	private int tam;
	private Vector<Cella> vCellas;
	
	Regio (int tamano) {
		tam = tamano;
		vCellas = new Vector();
		Cella cellaAux = null;
		for (int i = 0; i < tam; ++i) {
			cellaAux = new Cella();
			vCellas.addElement(cellaAux);
		}
	}
	
	Regio (int tamano, Vector<Cella> vc) { //deberíamos hacer que pase sólo Vector<Cella> vc y tamano se calcula con el .size()?
		tam = tamano;
		try {
			if (vc.size() != tam) throw new Exception();
			vCellas = (Vector) vc.clone();
		} catch (Exception e) {
			System.out.println("El numero de celas es diferente a la cantidad de celas requeridas");
		}
	}
	
	public int getNumCeldas() {
		return tam;
	}
	
	public int getNumCeldasRellenas() { //lo calcula cada vez
		int numCeldasRellenas = tam;
		for (int i = 0; i < tam; ++i) {
			if (vCellas.get(i).estaVacia()) numCeldasRellenas--;
		}
		return numCeldasRellenas;
	}
	
	public boolean estaVacia(int pos) { //return (vCellas.get(pos).estaVacia());
		try {
			if (pos < 0 || pos >= tam) { throw new ArrayIndexOutOfBoundsException(); }
			return (vCellas.get(pos).estaVacia());
		} catch (Exception e1) {
			System.out.println("Esta posición está fuera de rango");
		}
		return false;
	}
	
	public Cella getCella(int pos) { //return (vCellas.get(pos));
		try {
			if (pos < 0 || pos >= tam) { throw new ArrayIndexOutOfBoundsException(); }
			return (vCellas.get(pos));
		} catch (Exception e1) {
			System.out.println("Esta posición está fuera de rango");
		}
		return new Cella();
	}
	
	public int getNumero(int pos) { //return (vCellas.get(pos).getNumero());
		try {
			if (pos < 0 || pos >= tam) { throw new ArrayIndexOutOfBoundsException(); }
			return (vCellas.get(pos).getNumero());
		} catch (Exception e1) {
			System.out.println("Esta posición está fuera de rango");
		}
		return -1;
	}
	
	public void setNumero(int pos, int val) { //vCellas.get(pos).setNumero(val);
		try {
			if (pos < 0 || pos >= tam) {throw new ArrayIndexOutOfBoundsException();}
			if (val < 1 || val > tam) {throw new Exception();}
			vCellas.get(pos).setNumero(val);
		}
		catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1 + "Esta posición está fuera de rango");
		}
		catch (Exception e2) {
			System.out.println("El valor está fuera de rango");
		}
	}
	
	public void borra(int pos) { //vCellas.get(pos).borra();
		try {
			if (pos < 0 || pos >= tam) { throw new ArrayIndexOutOfBoundsException(); }
			vCellas.get(pos).borra();
		} catch (Exception e1) {
			System.out.println("Esta posición está fuera de rango");
		}
	}
}