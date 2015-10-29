package capaDomini;
import java.util.*;

public class DriverTaulerSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        int opc = -1;
        System.out.println("Escribe las medidas n del tablero");
        int n;
        n = entrada.nextInt();
        ts = new Tauler(n,n);
        
        while(opc != 0) {
        	System.out.println("Driver de TaulerSudoku");
        	System.out.println("1: Get de la cella xy");
            System.out.println("2: Get del numero de la posicio xy");
            System.out.println("3: Set del numero de la posicio xy");
            System.out.println("4: Comprovar si la cella xy esta buida");
            System.out.println("5: Get del nombre de celles del tauler");
            System.out.println("6: Get del nombre de celles buides del tauler");
            System.out.println("7: Borrar valor");
            System.out.println("0: Salir");
            opc = entrada.nextInt();
            switch(opc) {
            case 0:
            	break;
            case 1:
            	System.out.println("XY");
            	break;
            case 2:
            	System.out.println("Introduce X e Y");
            	int x, y;
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	System.out.println(ts.getNumero(x, y));
            	break;
            case 3:
            	System.out.println("Introduce X, Y y el valor de la celda");
            	int val;
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	val = entrada.nextInt();
            	ts.setNumero(x, y, val);
            	break;
            case 4:
            	System.out.println("Introduce X e Y");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	System.out.println(ts.estaVacia(x,y));
            	break;
            case 5:
            	System.out.println(ts.getNumCeldas());
            	break;
            case 6:
            	System.out.println(ts.getNumCeldasRellenas());
            	break;
            case 7:
            	System.out.println("Introduce X e Y para borrar");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	ts.borra(x, y);
            	break;
            default:
            	System.out.println("Opcion no valida");
            }
        }
        entrada.close();
	}
	
	//private static TaulerSudoku ts;
	private static Tauler ts;
}
