package capaDomini;
 
import java.util.*;
 
public class RegioSudoku extends RegioSenseRepeticions{
    
	public RegioSudoku(int n, tipoRegioSudoku tipo){
        super(n*n);
        tipus = tipo;
    }
     
    public RegioSudoku(int n, Vector<Cella> vc, tipoRegioSudoku tipo){
        super(n*n, vc);
        tipus = tipo;
    }
 
    public tipoRegioSudoku getTipus() {
        return tipus;
    }
     
    private tipoRegioSudoku tipus;
 
}