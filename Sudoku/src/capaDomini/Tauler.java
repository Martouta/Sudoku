package capaDomini;

import java.util.Vector;

public class Tauler {
	
	public Tauler(int m, int n) { //mirar que m,n siguin > 0
		try {
			if (m <= 0 || n <= 0) {
				throw new Exception();
			}
			ancho = m;
			alto = n;
			tauler = new Cella[alto][ancho]; //mirar com ferho per als altres grups
			regionAfectada = new RegioSenseRepeticions[alto][ancho][3];
			posAfectadas = new int[alto][ancho][3];
			for (int i = 0; i < alto; ++i) {
				for (int j = 0; j < ancho; ++j) {
					//tauler[i][j] = new CellaSudoku(i,j);
					tauler[i][j] = new Cella();
					posAfectadas[i][j][0] = posAfectadas[i][j][1] = posAfectadas[i][j][2] = -1;
				}
			}
		} catch(Exception e) {
			System.out.println("m,n > 0");
		}
		//regio = new Regio[alto]; //esta parte mejor ponerla en la clase tauler sudoku, otras clases no tienen esta topologia de regiones
	}
	
	//cal una creadora que passi un vector de celles ja inicialitzada com a regio??????????????????????????
	//cal tenir funcions que recorrin el tauler per anar inicialitzantlo????
	
	public Cella getCella(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return tauler[x][y];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return null;
	}
	
	public int getNumero(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return tauler[x][y].getNumero();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return -2; // error de rango
	}
	
	public void setNumero(int x, int y, int val) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			if (val <= 0 || val > alto) { //cal mirar si a tots ens passa aixo
				throw new Exception();
			}
		}
		catch (ArrayIndexOutOfBoundsException e1) { //la de x/y -> ArrayIndexOutOfBoundsException
			System.out.println(e1 + " Out of bounds de x/y");
		}
		catch (Exception e2) { //la de val
			System.out.println("val solo puede contener valores entre: 1<=val<=N");
		}
		int valant = getNumero(x,y);
		try {
			for(int i=0;i<3;i++) {
				if(posAfectadas[x][y][i]==-1)
					continue;
				regionAfectada[x][y][i].setNumero(posAfectadas[x][y][i], val);
			}
			tauler[x][y].setNumero(val);
		} catch (Exception e) {
			for(int i=0;i<3;i++) {
				if(posAfectadas[x][y][i]==-1)
					continue;
				regionAfectada[x][y][i].setNumero(posAfectadas[x][y][i], valant);
			}
			tauler[x][y].setNumero(valant);
		}
	}
	
	public boolean estaVacia(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return tauler[x][y].estaVacia();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
		return false;
	}
	
	public int getNumCeldas() {
		return ancho*alto;
	}
	
	public int getNumCeldasRellenas() {
		int cont = 0;
		for (int i = 0; i < alto; ++i) {
			for (int j = 0; j < ancho; ++j) {
				if (!tauler[i][j].estaVacia()) ++cont;
			}
		}
		return cont;
	}
	
	public void borra(int x, int y) {
		//try and catch
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			tauler[x][y].borra(); //cal comunicarho a regio que s'ha eliminat el contingut d'una cella
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " La x o y estan fuera de rango. 0 <= x,y < alto,ancho");
		}
	}
	
	public int addRegio(Vector<Cella> v) {
		Regio r = new Regio(v.size(),v);
		regiones.addElement(r);
		return regiones.size()-1;
	}
	
	public int addRegioSenseRepeticions(Vector<Cella> v) {
		RegioSenseRepeticions r = new RegioSenseRepeticions(v.size(),v);
		regiones.addElement(r);
		for(int i=0;i<v.size();i++) {
			int xx = v.get(i).getX();
			int yy = v.get(i).getY();
			int c = 0;
			while(posAfectadas[xx][yy][c]>=0)	// esto si asignas mas de tres regiones a una celda peta, cosa tuya
				c++;
			regionAfectada[xx][yy][c] = r;
			posAfectadas[xx][yy][c] = i;
		}
		return regiones.size()-1;
	}
	
	private int ancho, alto;
	private Cella[][] tauler;
	private Vector<Regio> regiones;
	private RegioSenseRepeticions[][][] regionAfectada;
	private int[][][] posAfectadas;
}
