package persistencia;

import java.util.ArrayList;
import java.util.Scanner;

import capaDomini.*;

public class DriverCtrlTauler {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    
	    System.out.println("Escribe la n del sudoku");
	    int n;
        n = entrada.nextInt();
        
        TaulerSudoku t;
        t=GeneradorSudoku.generaSudoku2(n, tipoDificultad.dificil);
	    t.muestraTabla();
	    
		//cts = new CtrlTauler();
		if (!CtrlTauler.afegeixTaulerSudoku(t,"aleix")) System.out.println("Ja hi ha un tauler amb aquest id a la BD");
		//if (!CtrlTauler.afegeixTaulerSudoku(t,"pepe")) System.out.println("Ja hi ha un tauler amb aquest id a la BD");
		//if (!CtrlTauler.afegeixTaulerSudoku(t,"pepito")) System.out.println("Ja hi ha un tauler amb aquest id a la BD");
		//if (!CtrlTauler.afegeixTaulerSudoku(t,"holaprimo")) System.out.println("Ja hi ha un tauler amb aquest id a la BD");
		CtrlTauler.end();
		
		ArrayList<String> noms = CtrlTauler.getNoms();
		for (String s : noms) { //haurien de sortir els tres noms
			System.out.println(s);
		}
		
		//if (!CtrlTauler.esborraTaulerSudoku("aleix")) System.out.println("No hi ha cap tauler amb aquest id a la BD"); 
		
		/*noms = CtrlTauler.getNoms();
		for (String s : noms) { //haurien de sortir els noms mensy aleix
			System.out.println(s);
		}*/
		
		CtrlTauler.end();
		if (CtrlTauler.getTaula().size() != 0) {
			//guarda un sudoku pero no l'omple
			ArrayList<TaulerSudoku> ats = CtrlTauler.getTaula();
			//System.out.println(ats.size());
			TaulerSudoku result = ats.get(0);
			//System.out.println(result.getN() + " " + result.getNN());
			result.muestraTabla();
		}
		
		/*ArrayList<TaulerSudoku> j = CtrlTauler.getTaula();
		if (j.isEmpty()) System.out.println("Esta buit");
		CtrlJocSudoku.carrega(t,tsol);*/
		
		/*System.out.println("Carregat");
		j = CtrlJocSudoku.getTaula();
		if (j.isEmpty()) System.out.println("Falla");
		else System.out.println("Correcte");
		for (JocSudoku js1 : j) {
			System.out.println(js1.getId());
		}*/
		
		System.out.println("Termino");
		entrada.close();
	}

	//private static CtrlTauler cts;
}
