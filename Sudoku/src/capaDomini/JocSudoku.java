package capaDomini;

import java.util.*;

public class JocSudoku extends Joc {
	
	private TaulerSudoku tauler_sol;
	
	/*public JocSudoku(int n, String idJocSudoku) {
		super(n, n, idJocSudoku);
	}*/
	
	public JocSudoku(String idJocSudoku, TaulerSudoku t, TaulerSudoku tSol) {
		super(idJocSudoku, t);
		setDificultad(calcularDificultad(t));
		tauler_sol = tSol;
	}

	public void Pista() {
	    int ncellas=super.getTauler().getAlto()*super.getTauler().getAncho();
	    if(super.getTauler().getNumCeldasRellenas() < ncellas){
            boolean found=false;
            Random gen1 = new Random();
            int x = gen1.nextInt(10);
            Random gen2 = new Random();
            int y = gen2.nextInt(10);
            int i=0;
   	        while(i<ncellas && !found){
   	        	if(!super.getTauler().estaVacia(x,y)){
   	        		++x;
   	        		if(x==10){ ++y; x=0;}
   	        		if(y==10){ y=0; x=0;}
                }
			else found=true;
   	        ++i;
		}
   	        if (found){
   	        	super.getTauler().setNumero(x,y,tauler_sol.getNumero(x,y));
   	        }
	    }
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
}
