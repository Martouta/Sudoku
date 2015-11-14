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
            System.out.println("3: Fijar celda");
            System.out.println("4: Liberar celda");
            System.out.println("5: Borrar valor");
            System.out.println("6: Comprobar si está vacía");
            System.out.println("7: Get de x");
            System.out.println("8: Get de y");
            System.out.println("9: Set de x");
            System.out.println("10: Set de y");
            System.out.println("11: Set de x e y");
            System.out.println("12: Comprobar si la celda esta fija");
            System.out.println("13: Comprobar si la celda esta bloqueada");
            System.out.println("14: Bloquear una celda");
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
            case 9:
            	System.out.println("Introduce la nueva x");
            	int pos = entrada.nextInt();
            	cs.setX(pos);
            	break;
            case 10:
            	System.out.println("Introduce la nueva y");
            	pos = entrada.nextInt();
            	cs.setY(pos);
            	break;
            case 11:
            	System.out.println("Introduce la nueva x e y");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	cs.setXeY(x,y);
            	break;
            case 12:
            	System.out.println(cs.estaFija());
            	break;
            case 13:
            	System.out.println(cs.estaBloqueada());
            	break;
            case 14:
            	cs.bloquear();
            	System.out.println(cs.estaBloqueada());
            	break;
            default:
            	System.out.println("Opcion no valida");
            }
        }
        entrada.close();
	}
	
	private static Cella cs;
}
