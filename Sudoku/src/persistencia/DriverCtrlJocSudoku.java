package persistencia;

//import java.util.ArrayList;
import java.util.Scanner;

import DataTransferObjects.tipoDificultad;
import capaDomini.GeneradorSudoku;
import capaDomini.JocSudoku;
import capaDomini.ResolvedorSudoku;
import capaDomini.TaulerSudoku;
import excepciones.ExcepcionCasillaBloqueada;
import excepciones.ExcepcionCasillaVaciaNoFijable;
import excepciones.ExcepcionNumCeldasDiferenteTamano;
import excepciones.ExcepcionNumeroFijo;
import excepciones.ExcepcionPosicionFueraRango;
import excepciones.ExcepcionTamanoIncorrecto;
import excepciones.ExcepcionValorFueraRango;
import excepciones.ExcepcionValorYaPuesto;

public class DriverCtrlJocSudoku {

	public static void main(String[] args) throws ExcepcionTamanoIncorrecto, ExcepcionPosicionFueraRango, ExcepcionNumCeldasDiferenteTamano, ExcepcionCasillaBloqueada, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable {
		Scanner entrada = new Scanner(System.in);
	    //int opc = -1;
	    System.out.println("Escribe la n del sudoku");
	    int n;
        n = entrada.nextInt();
        
        TaulerSudoku t;
        TaulerSudoku tsol;
        JocSudoku js, js1;
        do {
	        if(n<4)	t=GeneradorSudoku.generaSudoku(n, tipoDificultad.dificil);
	        else 	t=GeneradorSudoku.generaSudoku2(n, tipoDificultad.dificil);
		    tsol = ResolvedorSudoku.resuelveSudoku1(t);
		    t.muestraTabla();
		    tsol.muestraTabla();
			js = new JocSudoku("pepito",t,tsol);
			js1 = new JocSudoku("aleix",t,tsol);
			if(n==4 && js.getDificultad()!=tipoDificultad.trivial) break;
        } while(js.getDificultad()!=tipoDificultad.dificil);
		//System.out.println(js.getDificultad());

		CtrlJocSudoku.init();
		if (!CtrlJocSudoku.afegeixJocSudoku(js,"pepe")) System.out.println("Aquest id ja esta a la BD");
		if (!CtrlJocSudoku.afegeixJocSudoku(js1,"pepe")) System.out.println("Aquest id ja esta a la BD");
		CtrlJocSudoku.end();
		
		CtrlJocSudoku.renombraJocSudoku("pepito", "pepe");
		
		if (!CtrlJocSudoku.afegeixJocSudoku(js,"pepe")) System.out.println("Aquest id ja esta a la BD"); //hauria de donar error ja que hem canviat el nom,
																								  //aixi que ja esta a la BD
		
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
}
