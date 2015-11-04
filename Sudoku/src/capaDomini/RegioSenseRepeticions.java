package capaDomini;
 
import java.util.*;
import excepciones.*;
 
public class RegioSenseRepeticions extends Regio {
    RegioSenseRepeticions(int tamano) {
    	super(tamano);
    	try {
			if (tamano < 0) throw (new ExcepcionTamanoIncorrecto());
			oc = new boolean[tamano];
			for (int i = 0; i < tamano; ++i) {
			     oc[i] = false;
			}
		} catch (ExcepcionTamanoIncorrecto e) {
			System.out.println(e.getMessage());
		}
    }
     
    RegioSenseRepeticions(int tamano, Vector<Cella> vc) {
        super(tamano, vc);
        try {
			if (tamano < 1) throw (new ExcepcionTamanoIncorrecto());
			oc = new boolean[tamano];
			if (tamano != vc.size()) throw (new ExcepcionNumCeldasDiferenteTamano());
			for (int i = 0; i < tamano; ++i) {
			    oc[i] = false;
			}
			for (int i = 0; i < tamano; ++i) {
			    int valor = vc.get(i).getNumero();
			    if (valor != -1) oc[valor-1] = true;
			}
		} catch (ExcepcionTamanoIncorrecto e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionNumCeldasDiferenteTamano e) {
			System.out.println(e.getMessage());
		}
    }
 
    @Override
    public void setNumero(int pos, int val) {
    	try {
			if (val <= 0) throw (new ExcepcionValorFueraRango()); //FALTA: mirar si el val es mes gran del maxim permes
			if (oc[val-1]) throw (new ExcepcionValorYaPuesto());
			super.setNumero(pos, val);
			oc[val-1] = true;
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			System.out.println(e.getMessage());
		}
    }
 
    @Override
    public void borra(int pos) { //MIRAR
    	try {
			if (pos <= 0) throw (new ExcepcionPosicionFueraRango()); //FALTA: mirar si pos es mes gran que la pos maxima
			int valor = super.getCella(pos).getNumero();
			super.borra(pos); //borra el num de la celda de la posicion que me pasan
			oc[valor-1] = false;
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
     
    public boolean estaNumero(int val){
    	try {
			if (val <= 0) throw (new ExcepcionValorFueraRango()); //FALTA: mirar si el val es mes gran del maxim permes
			return oc[val-1];
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		}
    }
     
    boolean[] oc; //true = ese valor esta ocupado
}