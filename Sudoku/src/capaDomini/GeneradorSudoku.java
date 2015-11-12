package capaDomini;

import java.util.*;

import excepciones.*;

public class GeneradorSudoku {
	
	public static TaulerSudoku generaSudoku(int n, tipoDificultad dif) {
		TaulerSudoku ts = new TaulerSudoku(n);
		init(n);
		try {
			if(dif==tipoDificultad.trivial)
				throw new ExcepcionDificultadInvalida();
		} catch (ExcepcionDificultadInvalida e) {
			System.out.println(e.getMessage());
			return ts;
		}
		rand = new Random();
		while(true) {
			itera(n);
			ts.setNumCelda(ultx, ulty, mat[ultx][ulty], false);
			int aa=ResolvedorSudoku.sols3(ts);
			if(aa==0) {
				System.out.println("Sudoku no resoluble, borrando �ltima casilla");
				ts.borraNumCelda(ultx, ulty);
				int a = mat[ultx][ulty];
				filas[ultx][a] = false;
				columnas[ulty][a] = false;
				cuadros[(ultx/n)*n+(ulty/n)][a] = false;
				mat[ultx][ulty] = 0;
			}
			else {
				ts.getCella(ultx, ulty).fijar();
				if(aa==1)
					break;
			}
		}
		if(dif==tipoDificultad.dificil)
			return ts;
		// si hay que hacer el sudoku m�s facil, hay que rellenar casillas
		double ratio = 0.0;
		if(dif==tipoDificultad.medio)
			ratio = 0.37037+rand.nextDouble()*(0.39506-0.37037);
		else
			ratio = 0.39506+rand.nextDouble()*(0.61728-0.39506);
		int ncr = (int) (ratio*n*n*n*n);
		TaulerSudoku ts2 = new TaulerSudoku(n);
		ts2 = ResolvedorSudoku.resuelveSudoku3(ts);
		while(ts.getNumCeldasRellenas()<ncr) {
			int pos = rand.nextInt(n*n*n*n);
			while(!ts.estaVacia(pos/(n*n), pos%(n*n)))
				pos = rand.nextInt(n*n*n*n);
			ts.setNumCelda(pos/(n*n), pos%(n*n), ts2.getNumero(pos/(n*n), pos%(n*n)), true);
		}
		return ts;
	}
	
	public static TaulerSudoku generaSudokuprueba(int n) {
		rand = new Random();
		TaulerSudoku ts = new TaulerSudoku(n);
		init(n);
		while(ResolvedorSudoku.sols3(ts)>1) {	// usamos el algoritmo pepino, obviamente
			itera(n);
			ts.setNumCelda(ultx, ulty, mat[ultx][ulty], false);
			if(ResolvedorSudoku.sols3(ts)==0) {
				System.out.println("Sudoku no resoluble, borrando �ltima casilla");
				ts.borraNumCelda(ultx, ulty);
				int a = mat[ultx][ulty];
				filas[ultx][a] = false;
				columnas[ulty][a] = false;
				cuadros[(ultx/n)*n+(ulty/n)][a] = false;
				mat[ultx][ulty] = 0;
			}
			else {
				ts.borraNumCelda(ultx, ulty);
				ts.setNumCelda(ultx, ulty, mat[ultx][ulty], true);
			}
		}
		return ts;
	}
	
	// este no mola, salen muchos valores muy juntos
	public static TaulerSudoku generaSudokuprueba2(int n) {
		rand = new Random();
		TaulerSudoku ts = new TaulerSudoku(n);
		init(n);
		while(ResolvedorSudoku.sols3(ts)>1) {
			itera2(n);
			ts.setNumCelda(ultx, ulty, mat[ultx][ulty], false);
			if(ResolvedorSudoku.sols3(ts)==0) {
				System.out.println("Sudoku no resoluble, borrando �ltima casilla");
				ts.borraNumCelda(ultx, ulty);
				int a = mat[ultx][ulty];
				filas[ultx][a] = false;
				columnas[ulty][a] = false;
				cuadros[(ultx/n)*n+(ulty/n)][a] = false;
				mat[ultx][ulty] = 0;
			}
			else
				ts.getCella(ultx, ulty).fijar();
		}
		return ts;
	}
	
	private static void init(int n) {
		filas = new boolean[n*n][n*n+1];
		columnas = new boolean[n*n][n*n+1];
		cuadros = new boolean[n*n][n*n+1];
		mat = new int[n*n][n*n];
		for(int i=0;i<n*n;i++) {
			for(int j=0;j<n*n;j++) {
				filas[i][j] = columnas[i][j] = cuadros[i][j] = false;
				mat[i][j] = 0;
			}
		}
		filas[n*n-1][n*n] = columnas[n*n-1][n*n] = cuadros[n*n-1][n*n] = false;
	}
	
	private static void itera(int n) {
		int fila = 0;
		int columna = 0;
		int num = -1;
		do {
			fila = rand.nextInt(n*n);
			columna = rand.nextInt(n*n);
		} while(mat[fila][columna]!=0);
		do {
			num = rand.nextInt(n*n)+1;
		} while(filas[fila][num] || columnas[columna][num]
				|| cuadros[(fila/n)*n+(columna/n)][num]);
		ultx = fila;
		ulty = columna;
		filas[fila][num] = true;
		columnas[columna][num] = true;
		cuadros[(fila/n)*n+(columna/n)][num] = true;
		mat[fila][columna] = num;
	}
	
	private static void itera2(int n) {
		int fila = 0;
		int columna = 0;
		int pos = rand.nextInt(n*n*n*n);
		while(mat[pos/(n*n)][pos%(n*n)]!=0) {
			pos++;
			pos %= n*n*n*n;
		}
		fila = pos/(n*n);
		columna = pos%(n*n);
		int num = rand.nextInt(n*n)+1;
		while(filas[fila][num] || columnas[columna][num]
				|| cuadros[(fila/n)*n+(columna/n)][num]) {
			num++;
			if(num>n*n)
				num-=n*n;
		}
		ultx = fila;
		ulty = columna;
		filas[fila][num] = true;
		columnas[columna][num] = true;
		cuadros[(fila/n)*n+(columna/n)][num] = true;
		mat[fila][columna] = num;
	}
	
	private static Random rand;
	private static int ultx;
	private static int ulty;
	private static int mat[][];
	private static boolean filas[][];
	private static boolean columnas[][];
	private static boolean cuadros[][];
}
