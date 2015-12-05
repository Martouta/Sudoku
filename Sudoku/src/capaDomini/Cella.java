package capaDomini;

import excepciones.*;

public class Cella {
	
	public Cella() {
		numero = x = y = -1;
		fija = false;
		bloqueada = false;
	}
	
	public Cella(int x, int y) throws ExcepcionPosicionFueraRango{
		if (x < 0 || y < 0) throw new ExcepcionPosicionFueraRango();
		numero = -1;
		this.x = x;
		this.y = y;
		fija = false;
		bloqueada = false;		
	}
	
	// si la celda está vacía, devuelve -1
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int val) throws ExcepcionNumeroFijo{
		if(fija) throw (new ExcepcionNumeroFijo());
		numero = val;
	}
	
	public boolean estaVacia() {
		return numero==-1;
	}
	
	public void borra() throws ExcepcionNumeroFijo{
		if(fija) throw (new ExcepcionNumeroFijo());
		numero = -1;
	}
	

	public void fijar() throws ExcepcionCasillaVaciaNoFijable{
		if(numero == -1) throw (new ExcepcionCasillaVaciaNoFijable());
		fija = true;
	}
	
	public void liberar() {
		fija = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int pos) throws ExcepcionCasillaYaTienePosicion{
		if(x != -1 && y != -1) throw (new ExcepcionCasillaYaTienePosicion());
		x = pos;
	}
	
	public void setY(int pos) throws ExcepcionCasillaYaTienePosicion{
		if(x != -1 && y != -1) throw (new ExcepcionCasillaYaTienePosicion());
		y = pos;
	}
	
	public void setXeY(int x, int y)  throws ExcepcionCasillaYaTienePosicion{
		if(x != -1 && y != -1) throw (new ExcepcionCasillaYaTienePosicion());
		this.x = x;
		this.y = y;
	}
	
	public boolean estaFija() {
		return fija;
	}
	
	public boolean estaBloqueada() {
		return bloqueada;
	}
	
	public void bloquear() {
		bloqueada = true;
	}
	
	private int numero;
	private boolean fija;
	private boolean bloqueada;
	private int x;
	private int y;
}