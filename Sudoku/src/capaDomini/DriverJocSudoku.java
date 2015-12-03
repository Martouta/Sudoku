package capaDomini;

import java.util.Scanner;

import DataTransferObjects.tipoDificultad;

public class DriverJocSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    int opc = -1;
	    System.out.println("Escribe la n del sudoku");
	    int n;
        n = entrada.nextInt();
        
        TaulerSudoku t;
        TaulerSudoku tsol;
        t=GeneradorSudoku.generaSudoku(n, tipoDificultad.dificil);
	    tsol = ResolvedorSudoku.resuelveSudoku1(t);
	    t.muestraTabla();
	    tsol.muestraTabla();
	    
	    
	    js = new JocSudoku("prova1",t,tsol);
	    //js = new JocSudoku("prova1",tsol,tsol); //para probar Pista si el tablero esta lleno
	    
	    while(opc != 0) {
	    	System.out.println("Driver de Joc Sudoku");
	    	System.out.println("1: Pista");
	    	System.out.println("2: Get id del JocSudoku");
	    	System.out.println("3: Get dificultad del JocSudoku");
	    	System.out.println("4: Set la dificultad del JocSudoku");
	    	System.out.println("0: Salir");
	    	opc = entrada.nextInt();
	    	switch(opc) {
	    		case 0:
	    			break;
	    		case 1: //si el tauler està complet no fa res
	    			js.Pista();
	    			//System.out.println("pista donada");
	    			t.muestraTabla();
	    			break;
	    		case 2:
	    			System.out.println(js.getId());
	    			break;
	    		case 3:
	    			System.out.println(js.getDificultad());
	    			break;
	    		case 4:
	    			System.out.println("Introduce la dificultad del sudoku manualmente");
	    			System.out.println("trivial, facil, medio, dificil");
	    			try {
	    				tipoDificultad td = tipoDificultad.valueOf(entrada.next());
		    			js.setDificultad(td);
		    			System.out.println(js.getDificultad());
	    			}
	    			catch(IllegalArgumentException e) {
	    				System.out.println("La dificultad introducida no es valida");
	    			}
	    			break;
		        default:
		        	System.out.println("Opcion no valida");
		        }
		    }
	    	entrada.close();
	}

	private static JocSudoku js;
}