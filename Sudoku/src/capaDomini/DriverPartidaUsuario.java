package capaDomini;

import java.util.*;

public class DriverPartidaUsuario {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escribe las medidas n del tablero");
        int n = entrada.nextInt();
        
		User usuario = new User("usu1", null);
		TaulerSudoku ts = new TaulerSudoku(n);
		TaulerSudoku tSol;
		
		
		
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
		tSol = ResolvedorSudoku.resuelveSudoku3(ts);
		nSols = ResolvedorSudoku.sols3(ts);
		
		
		JocSudoku sudoku = new JocSudoku("1",ts,tSol);
		Partida p = new Partida(usuario, sudoku);
	    
		if (nSols == 1) {
			int opc = -1;
			while(opc != 0 && sudoku.getTauler().getNumCeldas() != sudoku.getTauler().getNumCeldasRellenas()) {
				System.out.println("1: Introduce celda no fija");
				System.out.println("2: muestra sudoku en proceso");
				System.out.println("3: muestra sudoku solucionado");
				System.out.println("4: pedir pista");
				System.out.println("5: numero de pistas");
				System.out.println("6: marcar numero");
				System.out.println("7: desmarcar numero");
				System.out.println("8: esta marcado");
				System.out.println("9: ver marcas de la casilla");
				
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
	            case 4:
	            	sudoku.Pista();
	            	p.incrementaPista();
	            	break;
	            case 5:
	            	System.out.println("numero de pistas: " + p.getNumPistas());
	            	break;
	            case 6:
	            	System.out.println("Introduce X, Y y valor");
	    			x = entrada.nextInt();
	    	    	y = entrada.nextInt();
	    	    	val = entrada.nextInt();
	            	p.marcarNumero(x, y, val);
	            	break;
	            case 7:
	            	System.out.println("Introduce X, Y y valor");
	    			x = entrada.nextInt();
	    	    	y = entrada.nextInt();
	    	    	val = entrada.nextInt();
	            	p.desmarcarNumero(x, y, val);
	            	break;
	            case 8:
	            	System.out.println("Introduce X, Y y valor");
	    			x = entrada.nextInt();
	    	    	y = entrada.nextInt();
	    	    	val = entrada.nextInt();
	            	System.out.println(p.estaMarcado(x, y, val));
	            	break;
	            case 9:
	            	System.out.println("Introduce X e Y");
	    			x = entrada.nextInt();
	    	    	y = entrada.nextInt();
	    	    	p.mostrarMarcasPosicion(x,y);
	            	break;
	            default:
	            	System.out.println("Opcion no valida");
	            }
			}
		} else if (nSols == 0){
			System.out.println("El Sudoku no tiene solucion");
			ts.muestraTabla();
		} else {
			System.out.println("No es un Sudoku valido porque tiene mas de una solucion");
		}
		
		
		if (sudoku.getTauler().getNumCeldas() == sudoku.getTauler().getNumCeldasRellenas()) {
			p.yaResuelto();
			
			System.out.println("Has acabado el juego en " + p.getHoras() + " horas, " + p.getMinutos() + " minutos i " + p.getSegundos() + " segundos");
			System.out.println("El juego ha sido iniciado el " + p.getDataIni() + "y acabado el " + p.getDataFi());
		} else {
			System.out.println("Se ha acabado el juego");
		}
		
        entrada.close();
	}
}
