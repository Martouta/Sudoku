package capaDomini;

public class ResolvedorSudoku {
	
	public static int resuelveSudoku1(TaulerSudoku s, TaulerSudoku sol) {
		carga(s);
		rec();
		guarda(sol);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return nsols;
	}
	
	public static int sols1(TaulerSudoku s) {
		carga(s);
		rec();
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return nsols;
	}
	
	public static TaulerSudoku resuelveSudoku1(TaulerSudoku s) {
		carga(s);
		TaulerSudoku sol = new TaulerSudoku(n);
		rec();
		guarda(sol);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return sol;
	}
	
	public static int resuelveSudoku2(TaulerSudoku s, TaulerSudoku sol) {
		carga(s);
		siso();
		if(flag)
			return 0;
		rec();
		guarda(sol);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return nsols;
	}
	
	public static int sols2(TaulerSudoku s) {
		carga(s);
		siso();
		if(flag)
			return 0;
		rec();
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return nsols;
	}
	
	public static TaulerSudoku resuelveSudoku2(TaulerSudoku s) {
		carga(s);
		TaulerSudoku sol = new TaulerSudoku(n);
		siso();
		if(flag)
			return sol;
		rec();
		guarda(sol);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return sol;
	}
	
	public static int resuelveSudoku3(TaulerSudoku s, TaulerSudoku sol) {
		carga(s);
		siso();
		if(flag)
			return 0;
		prepara();
		rec2(0);
		guarda(sol);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return nsols;
	}
	
	public static int sols3(TaulerSudoku s) {
		carga(s);
		siso();
		if(flag)
			return 0;
		prepara();
		rec2(0);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return nsols;
	}
	
	public static TaulerSudoku resuelveSudoku3(TaulerSudoku s) {
		carga(s);
		TaulerSudoku sol = new TaulerSudoku(n);
		siso();
		if(flag)
			return sol;
		prepara();
		rec2(0);
		guarda(sol);
		System.out.printf("Se ha ejecutado el algoritmo, %d iteraciones\n", niters);
		return sol;
	}
	
	private static void carga(TaulerSudoku s) { // inicializar
		n = s.getN();
		nn = s.getNN();
		ncr = 0;
		nsols = 0;
		niters = 0;
		flag = false;
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
	
	private static void siso() {  // single solution
		int a,b;
		for(int i=0;i<nn;i++) {
			for(int j=0;j<nn;j++) {
				if(mat[i][j]>0)
					continue;
				a=0;
				b=0;
				for(int k=1;k<=nn && a<2;k++) {
					if(!(filas[i][k] || columnas[j][k] 
					|| cuadros[(i/n)*n+(j/n)][k])) {
						a++;
						b=k;
					}
				}
				if(a==0) {
					flag = true;
					return;
				}
				if(a!=1)
					continue;
				mat[i][j] = b;
				filas[i][b] = columnas[j][b] = cuadros[(i/n)*n+(j/n)][b] = true;
				ncr++;
				i=0;
				j=-1;	// se lo que hago
			}
		}
	}
	
	private static void rec() {	// funcion recursiva
		if(nsols>1)
			return;
		niters++;
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
	
	private static void rec2(int pos) {	// funcion recursiva
		if(nsols>1)
			return;
		niters++;
		if(niters>5000000*(1+2*nsols))
			return;
		if(ncr==nn*nn) {
			for(int i=0;i<nn;i++) {
				for(int j=0;j<nn;j++)
					matterm[i][j] = mat[i][j];
			}
			nsols++;
			return;
		}
		if(pos>=tamord)
			return;
		int xpos = orden[pos]/nn;
		int ypos = orden[pos]%nn;
		for(int i=1;i<=nn;i++) {
			if(!(filas[xpos][i] || columnas[ypos][i] 
					|| cuadros[(xpos/n)*n+(ypos/n)][i])) {
				ncr++;
				filas[xpos][i] = true;
				columnas[ypos][i] = true;
				cuadros[(xpos/n)*n+(ypos/n)][i] = true;
				mat[xpos][ypos] = i;
				rec2(pos+1);
				mat[xpos][ypos] = -1;
				filas[xpos][i] = false;
				columnas[ypos][i] = false;
				cuadros[(xpos/n)*n+(ypos/n)][i] = false;
				ncr--;
			}
		}
	}
	
	private static void prepara() {
		orden = new int[nn*nn-ncr];
		tamord = nn*nn-ncr;
		int pos = 0;
		for(int ii=2;ii<=nn;ii++) {
			for(int i=0;i<nn;i++) {
				for(int j=0;j<nn;j++) {
					int a=0;
					if(mat[i][j]>=0)
						continue;
					for(int k=1;k<=nn && a<2;k++) {
						if(!(filas[i][k] || columnas[j][k] 
						|| cuadros[(i/n)*n+(j/n)][k]))
							a++;
					}
					if(a==ii) {
						orden[pos] = i*nn+j;
						pos++;
					}
				}
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
	private static boolean flag;
	private static int mat[][];
	private static int matterm[][];	// matriz terminada
	private static boolean filas[][];
	private static boolean columnas[][];
	private static boolean cuadros[][];
	private static int orden[];
	private static int tamord;
	private static int niters;
}
