package capaDomini;

import java.util.Scanner;

public class DriverResolvedorSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe las medidas n del tablero");
	    int n;
	    n = entrada.nextInt();
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
	    int b;
	    TaulerSudoku sol = new TaulerSudoku(n);
	    sol = ResolvedorSudoku.resuelveSudoku(ts);
	    b = ResolvedorSudoku.sols(ts);
	    if(b==1)
	    {
	    	System.out.println("Soluci�n �nica");
	    	sol.muestraTabla();
	    }
	    else if(b==0)
	    	System.out.println("No hay soluci�n");
	    else
	    	System.out.println("M�ltiples soluciones");
	    entrada.close();
	}
	
	private static TaulerSudoku ts;
}
