package capaDomini;
 
import java.util.*;

import DataTransferObjects.tipoRegioSudoku;
import excepciones.ExcepcionNumCeldasDiferenteTamano;
import excepciones.ExcepcionTamanoIncorrecto;
 
public class RegioSudoku extends RegioSenseRepeticions{
    
	public RegioSudoku(int n, tipoRegioSudoku tipo) throws ExcepcionTamanoIncorrecto{
        super(n*n);
        tipus = tipo;
    }
     
    public RegioSudoku(int n, Vector<Cella> vc, tipoRegioSudoku tipo) throws ExcepcionTamanoIncorrecto, ExcepcionNumCeldasDiferenteTamano{
        super(n*n, vc);
        tipus = tipo;
    }
 
    public tipoRegioSudoku getTipus() {
        return tipus;
    }
     
    private tipoRegioSudoku tipus;
 
}