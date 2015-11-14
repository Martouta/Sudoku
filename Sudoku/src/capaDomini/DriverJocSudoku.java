package capaDomini;

import java.util.Scanner;

public class DriverJocSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    int opc = -1;
	    System.out.println("Escribe la n del sudoku");
	    int n;
        n = entrada.nextInt();
        
        TaulerSudoku t;
        TaulerSudoku tsol;
        //GeneradorSudoku g=null;
        t=GeneradorSudoku.generaSudoku(n, tipoDificultad.dificil);
	    //ResolvedorSudoku r=null;
	    tsol = ResolvedorSudoku.resuelveSudoku1(t);
	    t.muestraTabla();
	    tsol.muestraTabla();
	    
	    
	    JocSudoku js = new JocSudoku("hue",t,tsol);
	    
	    while(opc != 0) {
	    	System.out.println("Driver de Joc Sudoku");
	    	System.out.println("1: Pista");
	    	System.out.println("0: Salir");
	    	opc = entrada.nextInt();
	    	switch(opc) {
	    		case 0:
	    			break;
	    		case 1: //si el tauler està complet no fa res
	    			js.Pista();
	    			System.out.println("pista donada");
	    			t.muestraTabla();
	    			break;
		        default:
		        	System.out.println("Opcion no valida");
		        }
		    }
	    	entrada.close();
	}

}