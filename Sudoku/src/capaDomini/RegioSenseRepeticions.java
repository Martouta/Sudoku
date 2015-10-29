package capaDomini;

import java.util.*;

public class RegioSenseRepeticions extends Regio { //SE ENCARGA MARTA
	boolean[] oc; //true = ese valor está ocupado
	
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
		} catch (Exception e) {
			System.out.println("Este numero ya esta puesto");
		}
	}

	@Override
	public void borra(int pos) {
		int valor = super.getCella(pos).getNumero();
		super.borra(pos); //borra el num de la celda de la posición que me pasan
		oc[valor-1] = false; //ahora ese valor está libre
	}
	
}

/*falta comprobar :)*/