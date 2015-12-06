package persistencia;

import java.util.Objects;
import java.util.Scanner;

import DataTransferObjects.tipoDificultad;
import capaDomini.GeneradorSudoku;
import capaDomini.JocSudoku;
import capaDomini.Partida;
import capaDomini.ResolvedorSudoku;
import capaDomini.Tauler;
import capaDomini.TaulerSudoku;
import capaDomini.User;

public class DriverCtrlPartida {

	public static void main(String[] args) throws Exception  {
		CtrlUser.init();
		//CtrlTauler.init();
		CtrlJocSudoku.init();
		CtrlPartida.init();
		
		
		Scanner entrada = new Scanner(System.in);
	    int opc = -1;
	    while(true) {
		    System.out.println("Escribe 0 para añadir usuario, 1 para añadir juego, 2 para añadir partida, 3 para cargar partida");
		    opc = entrada.nextInt();
		    if(opc<0 || opc>3)
		    	break;
		    if(opc==0) {
		    	System.out.println("Escribe username y password");
		    	String s,s2;
		    	entrada.nextLine();
		    	s = entrada.nextLine();
		    	s2 = entrada.nextLine();
		    	User u = new User(s,s2);
		    	CtrlUser.afegeixUsuari(u);
		    }
		    else if(opc==1) {
		    	System.out.println("Selecciona tamaño (2~4)");
		    	int n = entrada.nextInt();
		    	System.out.println("Selecciona dificultad (1~3)");
		    	int dif = entrada.nextInt();
		    	TaulerSudoku ts = new TaulerSudoku(n);
		    	if(dif==1)
		    		ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.facil);
		    	else if(dif==2)
		    		ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.medio);
		    	else if(dif==3)
		    		ts = GeneradorSudoku.generaSudoku(n, tipoDificultad.dificil);
		    	System.out.println("Selecciona nombre");
		    	entrada.nextLine();
		    	String s = entrada.nextLine();
		    	System.out.println("Escribe el username del autor");
		    	String s2 = entrada.nextLine();
		    	if(Objects.equals(s2,""))
		    		CtrlJocSudoku.afegeixJocSudoku(new JocSudoku(s,ts,ResolvedorSudoku.resuelveSudoku3(ts)),s2);
		    	else if(CtrlUser.getUsuari(s2)!=null)
			    	CtrlJocSudoku.afegeixJocSudoku(new JocSudoku(s,ts,ResolvedorSudoku.resuelveSudoku3(ts)),s2);
		    	else
		    		System.out.println("Usuario Inválido");
		    }
		    else if(opc==2) {
		    	System.out.println("Di nombre del usuario");
		    	entrada.nextLine();
		    	String s = entrada.nextLine();
		    	System.out.println("Contraseña");
		    	String s2 = entrada.nextLine();
		    	if(CtrlUser.comprovaPwd(s, s2)) {
		    		System.out.println("Contraseña correcta");
		    		System.out.println("Selecciona un juego");
		    		String nombrejuego = entrada.nextLine();
		    		JocSudoku js = CtrlJocSudoku.getJocSudoku(nombrejuego);
		    		Tauler t = js.getTauler();
		    		Partida p = new Partida(CtrlUser.getUsuari(s),js);
		    		display(t,p);
		    		System.out.println("Pon numeros o marcas");
		    		System.out.println("0 para numero, 1 para marca, 2 para pista, -1 para salir");
		    		int opt = entrada.nextInt();
		    		while(opt!=-1) {
		    			if(opt==2) {
		    				p.getJocSudoku().Pista();
		    				p.incrementaPista();
		    				display(t,p);
			    			opt = entrada.nextInt();
		    				continue;
		    			}
		    			int x,y,val;
		    			x = entrada.nextInt();
		    			y = entrada.nextInt();
		    			val = entrada.nextInt();
		    			if(opt==0) {
		    				t.setNumero(x, y, val);
		    			} else if (opt==1){
		    				if(p.estaMarcado(x, y, val))
		    					p.desmarcarNumero(x, y, val);
		    				else
		    					p.marcarNumero(x, y, val);
		    			}
		    			display(t,p);
		    			opt = entrada.nextInt();
		    		}
		    		System.out.println("Guardo cambios");
		    		p.getJocSudoku().setTauler(t);
		    		System.out.println("Di nombre partida");
		    		entrada.nextLine();
		    		String aaa = entrada.nextLine();
		    		CtrlPartida.afegeixPartida(p, aaa);
		    	}
		    } else if(opc==3) {
		    	System.out.println("Di nombre del usuario");
		    	entrada.nextLine();
		    	String s = entrada.nextLine();
		    	System.out.println("Contraseña");
		    	String s2 = entrada.nextLine();
		    	if(CtrlUser.comprovaPwd(s, s2)) {
		    		System.out.println("Contraseña correcta");
		    		System.out.println("Selecciona una partida");
		    		String nombrepartida = entrada.nextLine();
		    		Partida p = CtrlPartida.getPartida(nombrepartida, CtrlUser.getUsuari(s));
		    		JocSudoku js = p.getJocSudoku();
		    		Tauler t = js.getTauler();
		    		display(t,p);
		    		System.out.println("Pon numeros o marcas");
		    		System.out.println("0 para numero, 1 para marca, 2 para pista, -1 para salir");
		    		int opt = entrada.nextInt();
		    		while(opt!=-1) {
		    			if(opt==2) {
		    				p.getJocSudoku().Pista();
		    				p.incrementaPista();
		    				display(t,p);
			    			opt = entrada.nextInt();
		    				continue;
		    			}
		    			int x,y,val;
		    			x = entrada.nextInt();
		    			y = entrada.nextInt();
		    			val = entrada.nextInt();
		    			if(opt==0) {
		    				t.setNumero(x, y, val);
		    			} else if (opt==1){
		    				if(p.estaMarcado(x, y, val))
		    					p.desmarcarNumero(x, y, val);
		    				else
		    					p.marcarNumero(x, y, val);
		    			}
		    			display(t,p);
		    			opt = entrada.nextInt();
		    		}
		    		System.out.println("Guardo cambios");
		    		p.getJocSudoku().setTauler(t);
		    	}
		    }
	    }
	    System.out.println("Guardo");
	    CtrlUser.end();
	    //CtrlTauler.end();
	    CtrlJocSudoku.end();
	    CtrlPartida.end();
	    
		System.out.println("Termino");
		entrada.close();
	}

	private static void display(Tauler t, Partida p) throws Exception  {
		int n = (int) Math.sqrt(t.getAlto());
		for (int i = 0; i < n*n; ++i) {
            //if (i%n == 0) System.out.println("-----------------------------");
        	if(i%n==0) {
        		System.out.print("++");
        		for(int j=0;j<n;j++) {
        			int niters = 3*n-1;
        			for(int k=0;k<niters;k++)
        				System.out.print("-");
        			System.out.print("++");
        		}
            	System.out.println();
            }
        	for (int j = 0; j < n*n; ++j) {
            	if (j%n == 0) System.out.printf("|");
                System.out.printf("|");
                if (t.estaVacia(i, j)) System.out.printf(" " + 0);
                else if (t.getNumero(i, j) <= 9) System.out.printf(" " + t.getNumero(i, j));
                else System.out.printf(t.getNumero(i, j) + "");
            }
            System.out.println("||");
            //System.out.printf("%n");
            
        }
        System.out.print("++");
		for(int j=0;j<n;j++) {
			int niters = 3*n-1;
			for(int k=0;k<niters;k++)
				System.out.print("-");
			System.out.print("++");
		}
    	System.out.println();
    	System.out.printf("Tiempo: %d seg\n",p.getSegundosTotales());
    	System.out.printf("Número de pistas: %d\n", p.getNumPistas());
    	System.out.println("Marcas:");
    	for(int i=0;i<n*n;i++) {
    		for(int j=0;j<n*n;j++) {
    			for(int k=1;k<=n*n;k++) {
    				if(p.estaMarcado(i, j, k))
    					System.out.printf("%d %d %d\n", i,j,k);
    			}
    		}
    	}
	}
}
