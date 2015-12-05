package capaDomini;
 
import java.util.*;
import excepciones.*;
 
public class Regio {
     
    public Regio (int tamano) throws ExcepcionTamanoIncorrecto {
    	if (tamano < 1) throw (new ExcepcionTamanoIncorrecto());
		tam = tamano;
		vCellas = new Vector<Cella>();
		Cella cellaAux = null;
		for (int i = 0; i < tam; ++i) {
		    cellaAux = new Cella();
		    vCellas.addElement(cellaAux);
		}
    }
     
    public Regio (int tamano, Vector<Cella> vc) throws ExcepcionTamanoIncorrecto, ExcepcionNumCeldasDiferenteTamano {
    	if (tamano < 1) throw (new ExcepcionTamanoIncorrecto());
		tam = tamano;
		if (vc.size() != tam) throw (new ExcepcionNumCeldasDiferenteTamano());
		vCellas = (Vector<Cella>) vc;
    }
     
    public int getNumCeldas() {
        return tam;
    }
     
    public int getNumCeldasRellenas() { //lo calcula cada vez
        int numCeldasRellenas = tam;
        for (int i = 0; i < tam; ++i) {
            if (vCellas.get(i).estaVacia()) numCeldasRellenas--;
        }
        return numCeldasRellenas;
    }
     
    public boolean estaVacia(int pos) throws ExcepcionPosicionFueraRango{
    	if (pos < 0 || pos >= tam) throw (new ExcepcionPosicionFueraRango());
		return (vCellas.get(pos).estaVacia());
    }
     
    public Cella getCella(int pos) throws ExcepcionPosicionFueraRango{
    	if (pos < 0 || pos >= tam) throw (new ExcepcionPosicionFueraRango());
		return (vCellas.get(pos));
    }
     
    public int getNumero(int pos) throws ExcepcionPosicionFueraRango{
    	if (pos < 0 || pos >= tam) throw (new ExcepcionPosicionFueraRango());
		return (vCellas.get(pos).getNumero());
    }
     
    public void setNumero(int pos, int val) throws ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionValorYaPuesto{
    	if (pos < 0 || pos >= tam) throw (new ExcepcionPosicionFueraRango());
		if (val < 1 || val > tam) throw (new ExcepcionValorFueraRango());
		vCellas.get(pos).setNumero(val);
    }
     
    public void borra(int pos) throws ExcepcionPosicionFueraRango, ExcepcionNumeroFijo{
    	if (pos < 0 || pos >= tam) throw (new ExcepcionPosicionFueraRango());
		vCellas.get(pos).borra();
    }
     
    private int tam;
    private Vector<Cella> vCellas;
}