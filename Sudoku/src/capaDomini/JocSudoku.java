package capaDomini;

import java.util.*;

public class JocSudoku extends Joc {
	
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

	public void Pista() {
	    int ncellas=super.getTauler().getNumCeldas();
	    if(super.getTauler().getNumCeldasRellenas() < ncellas){
            boolean found=false;
            Random gen1 = new Random();
            int nn = (int) Math.pow(super.getTauler().getNumCeldas(),0.5);
            int x = gen1.nextInt(nn);
            Random gen2 = new Random();
            int y = gen2.nextInt(nn);
            int i=0;
   	        while(i<ncellas && !found){
   	        	//System.out.println("Pista " + x + " " + y); //
   	        	if(!super.getTauler().estaVacia(x,y)){
   	        		++x;
   	        		if(x==nn){ ++y; x=0;}
   	        		if(y==nn){ y=0; x=0;}
                }
			else found=true;
   	        ++i;
		}
   	        if (found){
   	        	System.out.println("Pista en la posicion " + x + " " + y); //
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
	
	public void setTauler(Tauler t) {
		super.setTauler(t);
	}
}