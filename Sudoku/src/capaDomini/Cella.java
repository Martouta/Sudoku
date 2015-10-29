package capaDomini;

public class Cella {
	public Cella() {
		numero = x = y = -1;
		fija = false;
	}
	
	public Cella(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int pos) {
		x = pos;
	}
	
	public void setY(int pos) {
		y = pos;
	}
	
	public boolean estaFija() {
		return fija;
	}
	
	private int numero;
	private boolean fija;
	private int x;
	private int y;
}
