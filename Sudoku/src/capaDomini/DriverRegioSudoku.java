package capaDomini;

import java.util.*;

public class DriverRegioSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	        int opc = -1;
	        System.out.println("Escribe la n de la region");
	        int n;
	        n = entrada.nextInt();
	        //r = new Regio(n); //perque es abstracta -> ferho amb la de RegioSudoku
	        
	        while(opc != 0) {
	        	System.out.println("Driver de Regio Sudoku");
	            /*System.out.println("1: Get del número");
	            System.out.println("2: Set del número");
	            System.out.println("3: Bloquear celda");
	            System.out.println("4: Liberar celda");
	            System.out.println("5: Borrar valor");
	            System.out.println("6: Comprobar si está vacía");
	            System.out.println("7: Get de x");
	            System.out.println("8: Get de y");*/
	            System.out.println("0: Salir");
	            opc = entrada.nextInt();
	            switch(opc) {
	            	case 0:
	            		break;
	            	/*case 1:
	            		System.out.println(r.getNumero());
	            		break;
	            	case 2:
	            		System.out.println("Nuevo número?");
	            		int a = entrada.nextInt();
		            	r.setNumero(a);
		            	break;
		            case 3:
		            	r.fijar();
		            	break;
		            case 4:
		            	r.liberar();
		            	break;
		            case 5:
		            	r.borra();
		            	break;
		            case 6:
		            	System.out.println(r.estaVacia());
		            	break;
		            case 7:
		            	System.out.println(r.getX());
		            	break;
		            case 8:
		            	System.out.println(r.getY());
		            	break;*/
		
		            default:
		            	System.out.println("Opción no válida");
		        }
	        }
	        entrada.close();
		}
		
		//private static Regio r;

}
