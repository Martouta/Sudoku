package capaDomini;

import java.util.Vector;

public abstract class Regio { //SE ENCARGA MARTA
	private int tam;
	private Vector<Cella> vCellas;
	
	Regio (int tamano) {
		tam = tamano;
		vCellas = new Vector();
		for (int i = 0; i < tam; ++i) {
			Cella cellaAux = new Cella();
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
	
	//Falta algo para crear las Celdas?? creo que en sudoku sólo
	
	public int getNumCeldas() {
		return tam; //tengo que comprobar si están creadas???
	}
	
	public int getNumCeldasRellenas() { //lo calcula cada vez
		try {
			if (vCellas.size() != tam) throw new Exception();
			int numCeldasRellenas = tam;
			for (int i = 0; i < tam; ++i) {
				if (vCellas.get(i).estaVacia()) numCeldasRellenas--;
			}
			return numCeldasRellenas;
		} catch (Exception e) {
			System.out.println("No están todas las celdas creadas");
		}
		return -1;
	}
	
	public boolean estaVacia(int pos) {
		try {
			if (vCellas.size() != tam) throw new Exception();
			return (vCellas.get(pos).estaVacia());
		} catch (Exception e) {
			System.out.println("No están todas las celdas creadas");
		}
		return false;
	}
	
	public Cella getCella(int pos) {
		try {
			if (vCellas.size() != tam) throw new Exception();
			return (vCellas.get(pos));
		} catch (Exception e) {
			System.out.println("No están todas las celdas creadas");
		}
		Cella cellaAux = null;
		return cellaAux;
	}
	
	public int getNumero(int pos) {
		try {
			if (vCellas.size() != tam) throw new Exception();
			return (vCellas.get(pos).getNumero());
		} catch (Exception e) {
			System.out.println("No están todas las celdas creadas");
		}
		return -1;
	}
	
	public void setNumero(int pos, int val) {
		try {
			if (vCellas.size() != tam) throw new Exception();
			vCellas.get(pos).setNumero(val);
		} catch (Exception e) {
			System.out.println("No están todas las celdas creadas");
		}
	}
	
	public void borra(int pos) {
		try {
			if (vCellas.size() != tam) throw new Exception();
			vCellas.get(pos).borra();
		} catch (Exception e) {
			System.out.println("No están todas las celdas creadas");
		}
	}
}
