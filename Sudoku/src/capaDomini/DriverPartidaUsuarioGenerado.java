package capaDomini;

import java.util.*;

public class DriverPartidaUsuarioGenerado {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escribe las medidas n del tablero");
        int n = entrada.nextInt();
        
		User usuario = new User("usu1", null);
		TaulerSudoku ts;
		TaulerSudoku tSol;
		tipoDificultad dif;
		System.out.println("Selecciona la dificultad: facil(1), medio(2) y dificil(3)"); //trivial no se genera
		int opt = entrada.nextInt();
		
		if (opt == 1) {
			dif = tipoDificultad.facil;
			ts = GeneradorSudoku.generaSudoku2(n, dif);
		}
		else if (opt == 2) {
			dif = tipoDificultad.medio;
			ts = GeneradorSudoku.generaSudoku2(n, dif);
		}
		else {
			dif = tipoDificultad.dificil;
			ts = GeneradorSudoku.generaSudoku2(n, dif);
		}
		
		tSol = ResolvedorSudoku.resuelveSudoku3(ts);
		
		
		JocSudoku sudoku = new JocSudoku("1",ts,tSol);
		Partida p = new Partida(usuario, sudoku);
	    
		
		int opc = -1;
		while(opc != 0 && sudoku.getTauler().getNumCeldas() != sudoku.getTauler().getNumCeldasRellenas()) {
			ts.muestraTabla();
			System.out.println("1: Introduce celda no fija");
			System.out.println("2: Borra celda no fija");
			System.out.println("3: muestra sudoku en proceso");
			System.out.println("4: muestra sudoku solucionado");
			System.out.println("5: pedir pista");
			System.out.println("6: numero de pistas");
			System.out.println("7: marcar numero");
			System.out.println("8: desmarcar numero");
			System.out.println("9: esta marcado");
			System.out.println("10: ver marcas de la casilla");
			System.out.println("11: Resetea el tablero entero (solo celdas no fijas)");
			
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
            	System.out.println("Introduce X y Y");
    			x = entrada.nextInt();
    	    	y = entrada.nextInt();
    	    	ts.borraNumCelda(x, y);
            	break;
            case 3:
            	ts.muestraTabla();
            	break;
            case 4:
            	tSol.muestraTabla();
            	break;
            case 5:
            	sudoku.Pista();
            	p.incrementaPista();
            	break;
            case 6:
            	System.out.println("numero de pistas: " + p.getNumPistas());
            	break;
            case 7:
            	System.out.println("Introduce X, Y y valor");
    			x = entrada.nextInt();
    	    	y = entrada.nextInt();
    	    	val = entrada.nextInt();
            	p.marcarNumero(x, y, val);
            	break;
            case 8:
            	System.out.println("Introduce X, Y y valor");
    			x = entrada.nextInt();
    	    	y = entrada.nextInt();
    	    	val = entrada.nextInt();
            	p.desmarcarNumero(x, y, val);
            	break;
            case 9:
            	System.out.println("Introduce X, Y y valor");
    			x = entrada.nextInt();
    	    	y = entrada.nextInt();
    	    	val = entrada.nextInt();
            	System.out.println(p.estaMarcado(x, y, val));
            	break;
            case 10:
            	System.out.println("Introduce X e Y");
    			x = entrada.nextInt();
    	    	y = entrada.nextInt();
    	    	p.mostrarMarcasPosicion(x,y);
            	break;
            case 11:
            	ts.resetearTableroSudoku();
            	break;
            default:
            	System.out.println("Opcion no valida");
            }
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
