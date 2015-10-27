package capaDomini;

public abstract class Cella {
	public Cella() {
		numero = -1;
		fija = false;
	}
	
	// si la celda está vacía, devuelve -1
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int val) {
		try {
			if(fija)
				throw new Exception();
			numero = val;
		}
		catch (Exception e) {
			System.out.println("No puedes modificar una casilla fija");
		}
	}
	
	public boolean estaVacia() {
		return numero==-1;
	}
	
	public void borra() {
		try {
			if(fija)
				throw new Exception();
			numero = -1;
		}
		catch (Exception e) {
			System.out.println("No puedes borrar una casilla fija");
		}
	}
	
	// comprobar
	public void fijar() {
		try {
			if(estaVacia())
				throw new Exception();
			fija = true;
		}
		catch (Exception e) {
			System.out.println("No puedes fijar una casilla vacía");
		}
	}
	// comprobar
	public void liberar() {
		fija = false;
	}
	
	private int numero;
	private boolean fija;
}
