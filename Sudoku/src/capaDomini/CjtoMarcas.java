package capaDomini;

import excepciones.*;

public class CjtoMarcas {
	int tamano;//FALTA (IMPORTANTE): necesito la n*n!!! que aun desde aqui no la puedo conseguir
	private boolean[] marcas;
	//DATO: se guarda Cella y Partida dependiendo de la navegabilidad
	
	public CjtoMarcas() {
		tamano = 9;
		marcas = new boolean[tamano];
		for (int i = 0; i < tamano; ++i) {
		     marcas[i] = false;
		}
	}
	
	public void marcarNumero(int val){
		try {
			if (val <= 0 || val > tamano-1) throw (new ExcepcionValorFueraRango());
			marcas[val-1] = true;
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void desmarcarNumero(int val){
		try {
			if (val <= 0 || val > tamano-1) throw (new ExcepcionValorFueraRango());
			marcas[val-1] = false;
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean estaMarcado(int val) {
		try {
			if (val <= 0 || val > tamano-1) throw (new ExcepcionValorFueraRango());
			return marcas[val-1];
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
