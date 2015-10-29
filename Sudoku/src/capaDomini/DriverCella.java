package capaDomini;

import java.util.*;

public class DriverCella {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        int opc = -1;
        System.out.println("Escribe el x y el y de la celda");
        int x,y;
        x = entrada.nextInt();
        y = entrada.nextInt();
        cs = new Cella(x,y);
        
        while(opc != 0) {
        	System.out.println("Controlador de Cella");
            System.out.println("1: Get del número");
            System.out.println("2: Set del número");
            System.out.println("3: Bloquear celda");
            System.out.println("4: Liberar celda");
            System.out.println("5: Borrar valor");
            System.out.println("6: Comprobar si está vacía");
            System.out.println("7: Get de x");
            System.out.println("8: Get de y");
            System.out.println("0: Salir");
            opc = entrada.nextInt();
            switch(opc) {
            case 0:
            	break;
            case 1:
            	System.out.println(cs.getNumero());
            	break;
            case 2:
            	System.out.println("Nuevo número?");
            	int a = entrada.nextInt();
            	cs.setNumero(a);
            	break;
            case 3:
            	cs.fijar();
            	break;
            case 4:
            	cs.liberar();
            	break;
            case 5:
            	cs.borra();
            	break;
            case 6:
            	System.out.println(cs.estaVacia());
            	break;
            case 7:
            	System.out.println(cs.getX());
            	break;
            case 8:
            	System.out.println(cs.getY());
            	break;
            default:
            	System.out.println("Opcion no valida");
            }
        }
        entrada.close();
	}
	
	//private static ControladorCella cc;
	private static Cella cs;
}
