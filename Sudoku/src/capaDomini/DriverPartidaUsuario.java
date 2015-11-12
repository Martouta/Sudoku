package capaDomini;

import java.util.*;

public class DriverPartidaUsuario {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escribe las medidas n del tablero");
        int n = entrada.nextInt();
        
		User usuario = new User("usu1", null);
		TaulerSudoku ts = new TaulerSudoku(n);
		JocSudoku sudoku = new JocSudoku("1",ts);
		Partida p = new Partida(usuario, sudoku);
		TaulerSudoku tSol;
		
		//TaulerSudoku ts2 = ResolvedorSudoku.resuelveSudoku3(ts);
		
		/*System.out.println("Introduce X, Y, valor");
    	int x, y, val;
    	boolean fija;
    	x = entrada.nextInt();
    	y = entrada.nextInt();
    	val = entrada.nextInt();
    	fija = entrada.nextBoolean();
    	ts.setNumCelda(x,y,val,fija);
    	System.out.println("El valor es " + ts.getNumero(x, y));*/
		
		System.out.println("Introduce el numero de celdas fijas");
		int nCeldasFijas = entrada.nextInt();
		for (int i = 0; i < nCeldasFijas; ++i) {
			System.out.println("Introduce X, Y y valor");
			int x, y, val;
			x = entrada.nextInt();
	    	y = entrada.nextInt();
	    	val = entrada.nextInt();
	    	ts.setNumCelda(x,y,val,true);
		}
		
		int nSols = 0;
		if(n==1) {
			tSol = ResolvedorSudoku.resuelveSudoku1(ts);
		    nSols = ResolvedorSudoku.sols1(ts);
	    }
		else if(n==2) {
	    	tSol = ResolvedorSudoku.resuelveSudoku2(ts);
		    nSols = ResolvedorSudoku.sols2(ts);
	    }
	    else {
	    	tSol = ResolvedorSudoku.resuelveSudoku3(ts);
		    nSols = ResolvedorSudoku.sols3(ts);
	    }
	    
		if (nSols == 1) {
			int opc = -1;
			while(opc != 0) {
				System.out.println("1: Introduce celda no fija");
				System.out.println("2: muestra sudoku en proceso");
				System.out.println("3: muestra sudoku solucionado");
				System.out.println("0: Salir");
	            opc = entrada.nextInt();
	            switch(opc) {
	            case 0:
	            	break;
	            case 1:
	            	System.out.println("Introduce X, Y y valor");
	    			int x, y, val;
	    			x = entrada.nextInt();
	    	    	y = entrada.nextInt();
	    	    	val = entrada.nextInt();
	    	    	ts.setNumCelda(x,y,val,false);
	            	break;
	            case 2:
	            	ts.muestraTabla();
	            	break;
	            case 3:
	            	tSol.muestraTabla();
	            	break;
	            default:
	            	System.out.println("Opcion no valida");
	            }
			}
		} else if (nSols == 0){
			System.out.println("El Sudoku no tiene solucion");
			ts.muestraTabla();
		} else {
			System.out.println("El Sudoku tiene mas de una solucion, pero puedes jugar igualmente");
		}
		
		
        entrada.close();
	}
}
