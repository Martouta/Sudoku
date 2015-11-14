package capaDomini;

import java.util.Scanner;

public class DriverRegio { //Falta comprobar el constructor que le paso las celdas creadas

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    int opc = -1;
	    System.out.println("Escribe el tamano de la region");
	    int n;
	    n = entrada.nextInt();
	    rs = new Regio(n);
	    
	    while(opc != 0) {
	    	System.out.println("Driver de Regio Sudoku");
	    	System.out.println("1: Get numero de celdas");
	    	System.out.println("2: Get numero de celdas rellenas");
	    	System.out.println("3: Esta vacia?");
	    	System.out.println("4: GetCella()");
	    	System.out.println("5: Get numero en celda de la posicion pos");
	    	System.out.println("6: Set numero (int pos, int val)");
	    	System.out.println("7: Borra (pos)");
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
	    			int pos = entrada.nextInt();
	    			Cella cellaAux = rs.getCella(pos);
	    			int val = entrada.nextInt();
	    			cellaAux.setNumero(val);
	    			System.out.println(cellaAux.getNumero());
	    			cellaAux.borra();
	    			System.out.println(cellaAux.getNumero());
		            break;
		        case 5:
		        	pos = entrada.nextInt();
		        	System.out.println(rs.getNumero(pos));
		        	break;
		        case 6:
		        	pos = entrada.nextInt();
		        	val = entrada.nextInt();
		        	rs.setNumero(pos,val);
		        	System.out.println(rs.getNumero(pos));
		            break;
		        case 7:
		        	pos = entrada.nextInt();
		        	rs.borra(pos);
		        	System.out.println(rs.getNumero(pos));
		        	break;
		        default:
		        	System.out.println("Opcion no valida");
		        }
		    }
	    	entrada.close();
	}
	private static Regio rs;

}

//HECHO
