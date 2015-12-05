package capaDomini;

import excepciones.*;

public class CjtoMarcas {
	int tamano;
	private boolean[] marcas;
	//DATO: se guarda Cella y Partida dependiendo de la navegabilidad
	
	public CjtoMarcas(int tamano) {
		this.tamano = tamano;
		marcas = new boolean[tamano];
		for (int i = 0; i < tamano; ++i) {
		     marcas[i] = false;
		}
	}
	
	public void marcarNumero(int val) throws ExcepcionValorFueraRango{
		if (val < 1 || val > tamano) throw (new ExcepcionValorFueraRango());
		marcas[val-1] = true;
	}
	
	public void desmarcarNumero(int val) throws ExcepcionValorFueraRango{
		if (val < 1 || val > tamano) throw (new ExcepcionValorFueraRango());
		marcas[val-1] = false;
	}
	
	public boolean estaMarcado(int val) throws ExcepcionValorFueraRango{
		if (val < 1 || val > tamano) throw (new ExcepcionValorFueraRango());
		return marcas[val-1];
	}
	
}
