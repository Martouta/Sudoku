package capaDomini;

import java.util.*;
import excepciones.*;

public class Tauler {

	public Tauler() {
		//
	}
	
	public Tauler(int m, int n) throws ExcepcionTamanoIncorrecto, ExcepcionPosicionFueraRango {
		if (m <= 0 || n <= 0) throw (new ExcepcionTamanoIncorrecto());
		ancho = m; alto = n;
		creaCeldasConPosicion();
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
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
	
	
	public Cella getCella(int x, int y) throws ExcepcionPosicionFueraRango {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		return vCellas.get(x*ancho + y);
	}
	
	public int getNumero(int x, int y) throws ExcepcionPosicionFueraRango {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		return vCellas.get(x*ancho + y).getNumero();
	}
	
	public boolean estaVacia(int x, int y) throws ExcepcionPosicionFueraRango {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		return vCellas.get(x*ancho + y).estaVacia();
	}
	
	public boolean estaFija(int x, int y) throws ExcepcionPosicionFueraRango {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		return vCellas.get(x*ancho + y).estaFija();
	}
	
	public boolean estaBloqueada(int x, int y) throws ExcepcionPosicionFueraRango {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		return vCellas.get(x*ancho + y).estaBloqueada();
	}
	
	public void setNumero(int x, int y, int val) throws ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		if (val < 0) throw (new ExcepcionValorFueraRango()); //FALTA: mirar valor por arriba
		if (vCellas.get(x*ancho + y).estaFija()) throw (new ExcepcionNumeroFijo());
		if (vCellas.get(x*ancho + y).estaBloqueada()) throw (new ExcepcionCasillaBloqueada());
		vCellas.get(x*ancho + y).setNumero(val);
	}
	
	public void borra(int x, int y) throws ExcepcionPosicionFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada {
		if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
		if (vCellas.get(x*ancho + y).estaFija()) throw (new ExcepcionNumeroFijo());
		if (vCellas.get(x*ancho + y).estaBloqueada()) throw (new ExcepcionCasillaBloqueada());
		vCellas.get(x*ancho + y).borra();
	}

	private void creaCeldasConPosicion() throws ExcepcionPosicionFueraRango {
    	vCellas = new Vector<Cella>();
        Cella cellaAux = null;
        for (int i = 0; i < alto; ++i) {
        	for (int j = 0; j < ancho; ++j) {
        		cellaAux = new Cella(i, j);
                vCellas.addElement(cellaAux);
        	}
        }
    }
	
	protected int ancho, alto; //idTauler, 
	protected Vector<Cella> vCellas;
	
}
