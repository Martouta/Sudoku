package capaDomini;

import java.util.*;

import DataTransferObjects.DTOCeldaFija;
import DataTransferObjects.tipoDificultad;
import excepciones.ExcepcionCasillaBloqueada;
import excepciones.ExcepcionCasillaVaciaNoFijable;
import excepciones.ExcepcionNoQuedanCeldasVacias;
import excepciones.ExcepcionNumeroFijo;
import excepciones.ExcepcionPosicionFueraRango;
import excepciones.ExcepcionValorFueraRango;
import excepciones.ExcepcionValorYaPuesto;

public class JocSudoku extends Joc implements Cloneable {
	
	//private static String idmarca; //que os parece hacer un idstatic para ir assignando ids a los diferentes juegos? o mejor en Joc?
	
	private TaulerSudoku tauler_sol;
	
	/*public JocSudoku(int n, String idJocSudoku) {
		super(n, n, idJocSudoku);
	}*/
	
	public JocSudoku(String idJocSudoku, TaulerSudoku t, TaulerSudoku tSol) {
		super(idJocSudoku, t);
		setDificultad(calcularDificultad(t));
		tauler_sol = tSol;
	}
	
	public TaulerSudoku getTaulerResuelto(){
		return tauler_sol;
	}

	public DTOCeldaFija pedirPista() throws ExcepcionNoQuedanCeldasVacias, ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable {
	    int ncellas=super.getTauler().getNumCeldas();
	    DTOCeldaFija celdaPista = new DTOCeldaFija(1, 1, 1);
	    
	    if(super.getTauler().getNumCeldasRellenas() == ncellas) throw new ExcepcionNoQuedanCeldasVacias();
	    
	    boolean found=false;
        Random gen1 = new Random();
        int nn = (int) Math.pow(super.getTauler().getNumCeldas(),0.5);
        int x = gen1.nextInt(nn);
        Random gen2 = new Random();
        int y = gen2.nextInt(nn);
        int i=0;
	    while(i<ncellas && !found){
	    	if(!super.getTauler().estaVacia(x,y)){
		        ++x;
		        if(x==nn){ ++y; x=0;}
		        if(y==nn){ y=0; x=0;}
	    	}
	    	else found=true;
	    	++i;
	    }
	    int valor = tauler_sol.getNumero(x,y);
	    TaulerSudoku taulerSudoku = (TaulerSudoku) super.getTauler();
	    taulerSudoku.setNumCelda(x, y, valor, false);
	    celdaPista = new DTOCeldaFija(x,y,valor);
	    return celdaPista;
	}
	
	private tipoDificultad calcularDificultad(TaulerSudoku ts) {
		tipoDificultad t;
		//int nn = ts.getNN();
		int c, cr;
		cr = ts.getNumCeldasRellenas();
		c = ts.getNumCeldas();
		double ratio = ((double)(cr))/((double)(c));
		if (ratio > 0.61728) t = tipoDificultad.trivial;
		else if (ratio > 0.39506) t = tipoDificultad.facil;
		else if (ratio > 0.37037) t = tipoDificultad.medio;
		else t = tipoDificultad.dificil;
		
		/*if (nn == 9) {
			cr = ts.getNumCeldasRellenas();
			if (cr > 50) t = tipoDificultad.trivial; //ratio = 0.61728
			else if (cr > 32) t = tipoDificultad.facil; //ratio = 0.39506
			else if (cr > 30) t = tipoDificultad.medio; //ratio = 0.37037
			else t = tipoDificultad.dificil; 
		}*/
		
		return t;
	}
	public JocSudoku clone() {
		try {
			String id = new String(super.getId());
			TaulerSudoku t = new TaulerSudoku(tauler_sol.getN());
			TaulerSudoku tsol = new TaulerSudoku(tauler_sol.getN());
			for(int i=0;i<t.getAlto();i++) {
				for(int j=0;j<t.getAncho();j++) {
					if(!this.getTauler().estaVacia(i, j))
						t.setNumCelda(i, j, this.getTauler().getNumero(i, j), this.getTauler().estaFija(i, j));
					tsol.setNumCelda(i, j, tauler_sol.getNumero(i, j), tauler_sol.estaFija(i, j));
				}
			}
			return new JocSudoku(id,t,tsol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setTauler(Tauler t) {
		super.setTauler(t);
	}
	
	public void setId(String s) {
		super.setId(s);
	}
}