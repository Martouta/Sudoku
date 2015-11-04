package capaDomini;
import java.util.*;

public class DriverTaulerSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        int opc = -1;
        System.out.println("Escribe las medidas n del tablero");
        int n;
        n = entrada.nextInt();
        ts = new TaulerSudoku(n);
        
        while(opc != 0) {
        	System.out.println("Driver de TaulerSudoku");
        	System.out.println("1: getN");
            System.out.println("2: getNN");
            System.out.println("3: muestraTabla()");
            System.out.println("4: setNumCelda(int x, int y, int val, boolean fija)");
            System.out.println("5: boolean esPosible(int x, int y, int val)");
            System.out.println("6: fijar(int x, int y)");
            System.out.println("7: borraNumCelda(int x, int y)");
            System.out.println("8: getNumero(int x, int y)");
            System.out.println("0: Salir");
            opc = entrada.nextInt();
            switch(opc) {
            case 0:
            	break;
            case 1:
            	System.out.println("El valor es " + ts.getN());
            	break;
            case 2:
            	System.out.println("El valor es " + ts.getNN());
            	break;
            case 3:
            	ts.muestraTabla();
            	break;
            case 4:
            	System.out.println("Introduce X, Y, valor y fija");
            	int x, y, val;
            	boolean fija;
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	val = entrada.nextInt();
            	fija = entrada.nextBoolean();
            	ts.setNumCelda(x,y,val,fija);
            	System.out.println("El valor es " + ts.getNumero(x, y));
            	break;
            case 5:
            	System.out.println("Introduce X, Y, valor");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	val = entrada.nextInt();
            	System.out.println("Es posible: " + ts.esPosible(x, y, val));
            	break;
            case 6:
            	System.out.println("Introduce X, Y");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	System.out.println("Esta fija: " + ts.estaFija(x,y));
            	break;
            case 7:
            	System.out.println("Introduce X, Y");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	ts.borraNumCelda(x, y);
            	System.out.println("El valor es " + ts.getNumero(x, y));
            	break;
            case 8:
            	System.out.println("Introduce X, Y");
            	x = entrada.nextInt();
            	y = entrada.nextInt();
            	System.out.println("El valor es " + ts.getNumero(x, y));
            	break;
            default:
            	System.out.println("Opcion no valida");
            }
        }
        entrada.close();
	}
	
	private static TaulerSudoku ts;
}