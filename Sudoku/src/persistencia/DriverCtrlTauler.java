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
	    
		cts = new CtrlTauler();
		CtrlTauler.afegeixTaulerSudoku(t,"pepito");
		CtrlTauler.end();
		
		CtrlTauler.esborraTaulerSudoku("pepito"); //esborra tot el vector, per aixi carregarlo del txt
		
		CtrlTauler.carrega();
		//CtrlTauler.getTaulerSudoku("pepe").muestraTabla(); //mes endavant caldra passar string idTauler per identificar quin agafa
		if (CtrlTauler.getTaula().size() != 0) {
			//guarda un sudoku pero no l'omple
			ArrayList<TaulerSudoku> ats = CtrlTauler.getTaula();
			System.out.println(ats.size());
			TaulerSudoku result = ats.get(0);
			System.out.println(result.getN() + " " + result.getNN());
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

	private static CtrlTauler cts;
}
