package capaDomini;
 
import java.util.*;
import excepciones.*;
 
public class RegioSenseRepeticions extends Regio {
	
    public RegioSenseRepeticions(int tamano) throws ExcepcionTamanoIncorrecto{
    	super(tamano);
    	if (tamano < 0) throw (new ExcepcionTamanoIncorrecto());
		oc = new boolean[tamano];
		for (int i = 0; i < tamano; ++i) {
		     oc[i] = false;
		}
    }
     
    public RegioSenseRepeticions(int tamano, Vector<Cella> vc) throws ExcepcionTamanoIncorrecto, ExcepcionNumCeldasDiferenteTamano{
        super(tamano, vc);
        if (tamano < 1) throw (new ExcepcionTamanoIncorrecto());
		oc = new boolean[tamano];
		if (tamano != vc.size()) throw (new ExcepcionNumCeldasDiferenteTamano());
		for (int i = 0; i < tamano; ++i) {
		    oc[i] = false;
		}
		for (int i = 0; i < tamano; ++i) {
		    int valor = vc.get(i).getNumero();
		    if (valor != -1) oc[valor-1] = true;
		}
    }
 
    @Override
    public void setNumero(int pos, int val) throws ExcepcionValorYaPuesto, ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo{
    	if (oc[val-1]) throw (new ExcepcionValorYaPuesto());
		super.setNumero(pos, val);
		oc[val-1] = true;
    }
 
    
    /*DATO IMPORTANTE: borra ya NO actualiza el vector de "esta el numero?" porque
     * entonces al borrarse en una region, al hacerlo las demás regiones no pueden actualizarlo
     * al no saber el valor que tenía la celda antes de borrarse
     */
    public void numeroYaNoEsta(int val) throws ExcepcionValorFueraRango{
    	if (val <= 0 || val > getNumCeldas()) throw (new ExcepcionValorFueraRango());
		oc[val-1] = false;
    }
     
    public boolean estaNumero(int val) throws ExcepcionValorFueraRango{
    	if (val <= 0 || val > getNumCeldas()) throw (new ExcepcionValorFueraRango());
		return oc[val-1];
    }
     
    private boolean[] oc; //true = ese valor esta ocupado
}