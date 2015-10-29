package capaDomini;

import java.util.*;

public class RegioSenseRepeticions extends Regio { //SE ENCARGA MARTA
	boolean[] oc; //true = ese valor est� ocupado
	
	RegioSenseRepeticions(int tamano) {
		super(tamano);
		oc = new boolean[tamano];
		for (int i = 0; i < tamano; ++i) {
			 oc[i] = false;
		}
	}
	
	RegioSenseRepeticions(int tamano, Vector<Cella> vc) {
		super(tamano, vc);
		oc = new boolean[tamano];
		for (int i = 0; i < tamano; ++i) {
			oc[i] = false;
		}
		for (int i = 0; i < tamano; ++i) {
			int valor = vc.get(i).getNumero();
			oc[valor-1] = true;
		}
	}

	@Override
	public void setNumero(int pos, int val) {
		try {
			if (oc[val-1]) throw new Exception();
			super.setNumero(pos, val);
			oc[val-1] = true;
		} catch (Exception e) {
			System.out.println("Este numero ya esta puesto");
		}
	}

	@Override
	public void borra(int pos) {
		int valor = super.getCella(pos).getNumero();
		super.borra(pos); //borra el num de la celda de la posici�n que me pasan
		oc[valor-1] = false; //ahora ese valor est� libre
	}
	
	public boolean estaNumero(int val){ //no s� si lo necesitaremos pero lo pongo para probar que todo va bien por el driver
		return oc[val-1];
	}
}
