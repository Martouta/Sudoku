package capaDomini;

public class ResolvedorSudoku {
	
	public static int resuelveSudoku(TaulerSudoku s, TaulerSudoku sol) {
		carga(s);
		sol = new TaulerSudoku(n);
		rec();
		guarda(sol);
		return nsols;
	}
	
	public static int sols(TaulerSudoku s) {
		carga(s);
		rec();
		return nsols;
	}
	
	public static TaulerSudoku resuelveSudoku(TaulerSudoku s) {
		carga(s);
		TaulerSudoku sol = new TaulerSudoku(n);
		rec();
		guarda(sol);
		return sol;
	}
	
	private static void carga(TaulerSudoku s) { // inicializar
		n = s.getN();
		nn = s.getNN();
		ncr = 0;
		nsols = 0;
		mat = new int[nn][nn];
		matterm = new int[nn][nn];
		filas = new boolean[nn][nn+1];
		columnas = new boolean[nn][nn+1];
		cuadros = new boolean[nn][nn+1];
		for(int i=0;i<nn;i++) {
			for(int j=0;j<=nn;j++)
				filas[i][j] = columnas[i][j] = cuadros[i][j] = false;
		}
		
		for(int i=0;i<nn;i++) {
			for(int j=0;j<nn;j++) {
				if(!s.estaVacia(i, j)) {
					int a = s.getNumero(i,j);
					mat[i][j] = a;
					filas[i][a] = true;
					columnas[j][a] = true;
					cuadros[(i/n)*n+(j/n)][a] = true;
					ncr++;
				}
				else
					mat[i][j] = -1;
			}
		}
	}
	
	private static void rec() {	// funcion recursiva
		if(nsols>1)
			return;
		if(ncr==nn*nn) {
			for(int i=0;i<nn;i++) {
				for(int j=0;j<nn;j++)
					matterm[i][j] = mat[i][j];
			}
			nsols++;
			return;
		}
		int xpos=-1, ypos=-1;
		for(int i=0;i<nn && xpos<0;i++) {
			for(int j=0;j<nn && ypos<0;j++) {
				if(mat[i][j]<=0) {
					xpos = i;
					ypos = j;
				}
			}
		}
		if(xpos<0)
			return;
		for(int i=1;i<=nn;i++) {
			if(!(filas[xpos][i] || columnas[ypos][i] 
					|| cuadros[(xpos/n)*n+(ypos/n)][i])) {
				ncr++;
				filas[xpos][i] = true;
				columnas[ypos][i] = true;
				cuadros[(xpos/n)*n+(ypos/n)][i] = true;
				mat[xpos][ypos] = i;
				rec();
				mat[xpos][ypos] = -1;
				filas[xpos][i] = false;
				columnas[ypos][i] = false;
				cuadros[(xpos/n)*n+(ypos/n)][i] = false;
				ncr--;
			}
		}
	}
	
	private static void guarda(TaulerSudoku sol) {	
		if(nsols<1)
			return;
		for(int i=0;i<nn;i++) {
			for(int j=0;j<nn;j++)
				sol.setNumCelda(i, j, matterm[i][j], false);
		}
	}
	
	private static int nn;
	private static int n;
	private static int nsols;
	private static int ncr;	// num casillas rellenas
	private static int mat[][];
	private static int matterm[][];	// matriz terminada
	private static boolean filas[][];
	private static boolean columnas[][];
	private static boolean cuadros[][];
}
