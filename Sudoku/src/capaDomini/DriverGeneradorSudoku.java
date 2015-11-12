package capaDomini;

import java.util.Scanner;

public class DriverGeneradorSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while(true) {
			System.out.println("Escribe 0 para version de prueba, 1 para la definitiva, otro valor para salir");
			int asdf = entrada.nextInt();
			if(asdf==0) {
				System.out.println("Escribe las medidas n del tablero");
			    int n;
			    n = entrada.nextInt();
			    System.out.println("Escribe algoritmo (1~2)");
			    int alg;
			    alg = entrada.nextInt();
			    ts = new TaulerSudoku(n);
			    if(alg==1)
			    	ts = GeneradorSudoku.generaSudokuprueba(n);
			    else
			    	ts = GeneradorSudoku.generaSudokuprueba2(n);
			    ts.muestraTabla();
			    System.out.println("Escoge algoritmo (1~3)");
			    int a = entrada.nextInt();
			    int b = -1;
			    TaulerSudoku sol = new TaulerSudoku(n);
			    if(a==1) {
				    sol = ResolvedorSudoku.resuelveSudoku1(ts);
				    b = ResolvedorSudoku.sols1(ts);
			    }
			    if(a==2) {
			    	sol = ResolvedorSudoku.resuelveSudoku2(ts);
				    b = ResolvedorSudoku.sols2(ts);
			    }
			    if(a==3) {
			    	sol = ResolvedorSudoku.resuelveSudoku3(ts);
				    b = ResolvedorSudoku.sols3(ts);
			    }
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
			else if(asdf==1) {
				System.out.println("Escribe las medidas n del tablero");
			    int n;
			    n = entrada.nextInt();
			    System.out.println("Escribe dificultad (1~3)");
			    int dif;
			    dif = entrada.nextInt();
			    ts = new TaulerSudoku(n);
			    if(dif==1)
			    	ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.facil);
			    else if(dif==2)
			    	ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.medio);
			    else if(dif==3)
			    	ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.dificil);
			    else
			    	ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.trivial);
			    ts.muestraTabla();
			    System.out.println("Escoge algoritmo (1~3)");
			    int a = entrada.nextInt();
			    TaulerSudoku sol = new TaulerSudoku(n);
			    if(a==1)
				    sol = ResolvedorSudoku.resuelveSudoku1(ts);
			    if(a==2)
			    	sol = ResolvedorSudoku.resuelveSudoku2(ts);
			    if(a==3)
			    	sol = ResolvedorSudoku.resuelveSudoku3(ts);
			    sol.muestraTabla();
			}
			else break;
		}
	    entrada.close();
	}
	
	private static TaulerSudoku ts;
}
