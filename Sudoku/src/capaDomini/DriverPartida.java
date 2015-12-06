package capaDomini;

import java.util.*;

public class DriverPartida {

	public static void main(String[] args) throws Exception  {
		Scanner entrada = new Scanner(System.in);
        int opc = -1;
        p = new Partida();
        
        while(opc != 0) {
        	System.out.println("Controlador de Partida");
            System.out.println("1: Get segundos totales");
            System.out.println("2: start timer");
            System.out.println("3: pause timer");
            System.out.println("4: get estado timer");
            System.out.println("5: get tiempo con ints");
            System.out.println("6: get numero de pistas");
            System.out.println("7: incrementar numero de pistas");
            System.out.println("8: get resuelto");
            System.out.println("9: ya resuelto");
            System.out.println("10: get data fi");
            System.out.println("11: get data ini");
            System.out.println("0: Salir");
            opc = entrada.nextInt();
            switch(opc) {
            case 0:
            	break;
            case 1:
            	System.out.println(p.getSegundosTotales());
            	break;
            case 2:
            	p.startTiempo();
            	break;
            case 3:
            	p.pauseTiempo();
            	break;
            case 4:
            	System.out.println(p.getSegundos());
            	break;
            case 5:
            	System.out.println(p.getHoras() + ":" + p.getMinutos() + ":" + p.getSegundos());
            	break;
            case 6:
            	System.out.println(p.getNumPistas());
            	break;
            case 7:
            	//p.incrementaPista();
            	break;
            case 8:
            	System.out.println(p.getResuelto());
            	break;
            case 9:
            	p.yaResuelto();
            	break;
            case 10:
            	System.out.println(p.getDataFi());
            	break;
            case 11:
            	System.out.println(p.getDataIni());
            	break;
            default:
            	System.out.println("Opcion no valida");
            }
        }
        entrada.close();
	}
	
	private static Partida p;

}
