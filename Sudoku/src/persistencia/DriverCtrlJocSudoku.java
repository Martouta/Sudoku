package persistencia;

import java.util.ArrayList;
import java.util.Scanner;

import capaDomini.GeneradorSudoku;
import capaDomini.JocSudoku;
import capaDomini.ResolvedorSudoku;
import capaDomini.TaulerSudoku;
import capaDomini.tipoDificultad;

public class DriverCtrlJocSudoku {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    //int opc = -1;
	    System.out.println("Escribe la n del sudoku");
	    int n;
        n = entrada.nextInt();
        
        TaulerSudoku t;
        TaulerSudoku tsol;
        JocSudoku js;
        do {
	        if(n<4)	t=GeneradorSudoku.generaSudoku(n, tipoDificultad.dificil);
	        else 	t=GeneradorSudoku.generaSudoku2(n, tipoDificultad.dificil);
		    tsol = ResolvedorSudoku.resuelveSudoku1(t);
		    t.muestraTabla();
		    tsol.muestraTabla();
			js = new JocSudoku("pepito",t,tsol);
			//js = new JocSudoku("aleix",t,tsol);
			if(n==4 && js.getDificultad()!=tipoDificultad.trivial //&& js.getDificultad()!=tipoDificultad.facil)
				)break;
        } while(js.getDificultad()!=tipoDificultad.dificil);
		System.out.println(js.getDificultad());

		cjs = new CtrlJocSudoku(t,tsol);
		CtrlJocSudoku.afegeixJocSudoku(js);
		CtrlJocSudoku.end();
		
		js = new JocSudoku("pepe",t,tsol);
		//System.out.println(js.getDificultad());

		CtrlJocSudoku.afegeixJocSudoku(js);
		CtrlJocSudoku.end();
		
		//provem si esborran el vector de jocs i carregantlo del txt funciona
		/*CtrlJocSudoku.esborraJocSudoku("pepe");
		CtrlJocSudoku.esborraJocSudoku("pepito");
		CtrlJocSudoku.end();
		*/
		/*ArrayList<JocSudoku> j = CtrlJocSudoku.getTaula();
		if (j.isEmpty()) System.out.println("Esta buit");
		CtrlJocSudoku.carrega(t,tsol);
		*/
		
		/*System.out.println("Carregat");
		j = CtrlJocSudoku.getTaula();
		if (j.isEmpty()) System.out.println("Falla");
		else System.out.println("Correcte");
		for (JocSudoku js1 : j) {
			System.out.println(js1.getId());
		}
		*/
		System.out.println("Termino");
		entrada.close();
	}

	private static CtrlJocSudoku cjs;
}
