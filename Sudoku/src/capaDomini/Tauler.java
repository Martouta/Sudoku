package capaDomini;

import java.util.Vector;

public class Tauler {

	public Tauler(int m, int n) { //mirar que m,n siguin > 0
		try {
			if (m <= 0 || n <= 0) {
				throw new Exception();
			}
			ancho = m; alto = n;
			creaCeldas();
		} catch(Exception e) {
			System.out.println("m,n > 0");
		}
	}
	
	public int getNumCeldas() {
		return ancho*alto;
	}
	
	public int getNumCeldasRellenas() {
		int cont = 0;
		for (int i = 0; i < alto*ancho; ++i) {
			if (!vCellas.get(i).estaVacia()) ++cont;
		}
		return cont;
	}
	
	
	public Cella getCella(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return vCellas.get(x*ancho + y);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return null;
	}
	
	public Cella getCella(int posicion) {
		try {
			if (posicion < 0 || posicion >= alto*ancho) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return vCellas.get(posicion);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e + "La posicion esta fuera de rango");
		}
		return null;
	}
	
	public int getNumero(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return vCellas.get(x*ancho + y).getNumero();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return -2; // error de rango
	}
	
	public boolean estaVacia(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return vCellas.get(x*ancho + y).estaVacia();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return false;
	}
	
	public boolean estaFija(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return vCellas.get(x*ancho + y).estaFija();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return false;
	}
	
	
	public void setNumero(int x, int y, int val) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			if (val <= 0 || val > alto) { //cal mirar si a tots ens passa aixo
				throw new Exception();
			}
			if (vCellas.get(x*ancho + y).estaFija()) {
				throw new Exception();
			}
			vCellas.get(x*ancho + y).setNumero(val);
		}
		catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1 + " Out of bounds de x/y");
		}
		catch (Exception e2) { //la de val
			System.out.println("val solo puede contener valores entre: 1<=val<=N");
			System.out.println("la casilla esta fija, no se puede modificar");
		}
	}
	
	public void borra(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			if (vCellas.get(x*ancho + y).estaFija()) {
				throw new Exception();
			}
			vCellas.get(x*ancho + y).borra(); //cal comunicarho a regio que s'ha eliminat el contingut d'una cella
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		catch(Exception e) {
			System.out.println("La celda estaba fija");
		}
	}

	private void creaCeldas() {
    	vCellas = new Vector();
        Cella cellaAux = null;
        for (int i = 0; i < ancho * alto; ++i) {
            cellaAux = new Cella();
            vCellas.addElement(cellaAux);
        }
    }
	
	private int ancho, alto;
	private Vector<Cella> vCellas;
	
}
