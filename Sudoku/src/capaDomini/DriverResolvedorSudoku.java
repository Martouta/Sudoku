package capaDomini;

import java.util.Scanner;

public class DriverResolvedorSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while(true) {
			System.out.println("Escribe las medidas n del tablero (0 para salir)");
		    int n;
		    n = entrada.nextInt();
		    if(n==0)
		    	break;
		    ts = new TaulerSudoku(n);
		    System.out.println("Escribe el tablero");
		    for(int i=0;i<n*n;i++) {
		    	for(int j=0;j<n*n;j++) {
		    		int a;
		    		a = entrada.nextInt();
		    		if(a>0 && a<=n*n)
		    			ts.setNumCelda(i, j, a, true);
		    	}
		    }
		    System.out.println("Escoge algoritmo (1~3)");
		    int a = entrada.nextInt();
		    int b = -1;
		    TaulerSudoku sol = new TaulerSudoku(n);
		    if(a==1)
		    	b = ResolvedorSudoku.resuelveSudoku1(ts, sol);
		    if(a==2)
		    	b = ResolvedorSudoku.resuelveSudoku2(ts, sol);
		    if(a==3)
		    	b = ResolvedorSudoku.resuelveSudoku3(ts, sol);
		    if(b==1)
		    {
		    	System.out.println("Solución única");
		    	sol.muestraTabla();
		    }
		    else if(b==0)
		    	System.out.println("No hay solución");
		    else if(b==2)
		    	System.out.println("Múltiples soluciones");
		}
	    entrada.close();
	}
	
	private static TaulerSudoku ts;
}
