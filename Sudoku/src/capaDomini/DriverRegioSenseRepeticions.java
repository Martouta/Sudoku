package capaDomini;

import java.util.Scanner;

public class DriverRegioSenseRepeticions {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    int opc = -1;
	    System.out.println("Escribe el tamano de la region sin repeticion");
	    int n;
	    n = entrada.nextInt();
	    rs = new RegioSenseRepeticions(n);
	    
	    while(opc != 0) {
	    	System.out.println("Driver de Regio Sudoku");
	    	System.out.println("1: Get numero de celdas");
	    	System.out.println("2: Get numero de celdas rellenas");
	    	System.out.println("3: Esta vacia?");
	    	System.out.println("4: GetCella()");
	    	System.out.println("5: Get numero en celda de la posicion");
	    	System.out.println("6: Set numero (int pos, int val) <--over");
	    	System.out.println("7: Borra (pos) <--over");
	    	System.out.println("8: estaNumero (int val)");
	    	System.out.println("0: Salir");
	    	opc = entrada.nextInt();
	    	switch(opc) {
	    		case 0:
	    			break;
	    		case 1:
	    			System.out.println(rs.getNumCeldas());
	    			break;
	    		case 2:
	    			System.out.println(rs.getNumCeldasRellenas());
	    			break;
	    		case 3:
	    			for (int i = 0; i < rs.getNumCeldas(); i++) {
	    				System.out.println(rs.estaVacia(i));
	    			}
	    			break;
	    		case 4:
	    			Cella cellaAux = rs.getCella(rs.getNumCeldas()-1);
	    			cellaAux.setNumero(rs.getNumCeldas());
	    			System.out.println(cellaAux.getNumero());
	    			cellaAux.borra();
	    			System.out.println(cellaAux.getNumero());
		            break;
		        case 5:
		        	System.out.println(rs.getNumero(rs.getNumCeldas()-1));
		        	break;
		        case 6:
		        	rs.setNumero(2,4);
		        	System.out.println(rs.getNumero(2));
		            break;
		        case 7:
		        	rs.setNumero(2,3);
		        	System.out.println(rs.getNumero(2));
		        	rs.borra(2);
		        	System.out.println(rs.getNumero(2));
		        	break;
		        case 8:
		        	System.out.println(rs.estaNumero(2));
		        	break;
		        default:
		        	System.out.println("Opcion no valida");
		        }
		    }
	    	entrada.close();
	}
	private static RegioSenseRepeticions rs;

}

//HECHO
