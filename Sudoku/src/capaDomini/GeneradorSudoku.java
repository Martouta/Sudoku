package capaDomini;

import java.util.*;

public class GeneradorSudoku {
	public static TaulerSudoku generaSudokuprueba(int n) {
		rand = new Random();
		TaulerSudoku ts = new TaulerSudoku(n);
		init(n);
		while(ResolvedorSudoku.sols3(ts)>1) {	// usamos el algoritmo pepino, obviamente
			itera(n);
			ts.setNumCelda(ultx, ulty, mat[ultx][ulty], false);
			if(ResolvedorSudoku.sols3(ts)==0) {
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
			
			/*TaulerSudoku ts2 = new TaulerSudoku(n);
			for(int i=0;i<n*n;i++) {
				for(int j=0;j<n*n;j++) {
					if(!ts.estaVacia(i, j))
						ts2.setNumCelda(i, j, ts.getNumero(i, j), true);
				}
			}*//*
			int fila = 0;
			int columna = 0;
			int num;
			do {
				fila = rand.nextInt(n*n);
				columna = rand.nextInt(n*n);
			} while(!ts.estaVacia(fila, columna));
			do {
				num = rand.nextInt(n*n)+1;
			} while(!ts.esPosible(fila, columna, num));
			ts.setNumCelda(fila, columna, num, false);
			if(ResolvedorSudoku.sols3(ts)!=0) {
				ts.borraNumCelda(fila, columna);
				ts.setNumCelda(fila, columna, num, true);
			}
			else
				ts.borraNumCelda(fila, columna);*/
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
	
	private static Random rand;
	private static int ultx;
	private static int ulty;
	private static int mat[][];
	private static boolean filas[][];
	private static boolean columnas[][];
	private static boolean cuadros[][];
}
