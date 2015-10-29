package capaDomini;

import java.util.Vector;

public abstract class Regio { //SE ENCARGA MARTA
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
	
	Regio (int tamano, Vector<Cella> vc) {
		tam = tamano;
		try {
			if (vc.size() != tam) throw new Exception();
			vCellas = (Vector) vc.clone();
		} catch (Exception e) {
			System.out.println("El número de celas es diferente a la cantidad de celas requeridas");
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
	
	public boolean estaVacia(int pos) {
		return (vCellas.get(pos).estaVacia());
	}
	
	public Cella getCella(int pos) {
		return (vCellas.get(pos));
	}
	
	public int getNumero(int pos) {
		return (vCellas.get(pos).getNumero());
	}
	
	public void setNumero(int pos, int val) {
		vCellas.get(pos).setNumero(val);
	}
	
	public void borra(int pos) {
		vCellas.get(pos).borra();
	}
}
