package capaDomini;
 
import java.util.*;
 
public class RegioSenseRepeticions extends Regio {
    RegioSenseRepeticions(int tamano) {
    	super(tamano);
    	try {
    		if (tamano < 0) throw new Exception();
            oc = new boolean[tamano];
            for (int i = 0; i < tamano; ++i) {
                 oc[i] = false;
            }
    	} catch(Exception e) {
    		System.out.println("tamano > 0");
    	}
    }
     
    RegioSenseRepeticions(int tamano, Vector<Cella> vc) {
        super(tamano, vc);
        try {
        	if (tamano < 0) throw new Exception();
        	oc = new boolean[tamano];
        } catch(Exception e) {
        	System.out.println("tamano > 0");
        }
        try {
        	if (tamano != vc.size()) throw new Exception();
        	for (int i = 0; i < tamano; ++i) {
                oc[i] = false;
            }
            for (int i = 0; i < tamano; ++i) {
                int valor = vc.get(i).getNumero();
                if (valor != -1) oc[valor-1] = true;
            }
        }
        catch (Exception e) {
        	System.out.println("El numero de celas es diferente a la cantidad de celas requeridas");
        }
    }
 
    @Override
    public void setNumero(int pos, int val) {
    	try {
    		if (val <= 0) throw new Exception(); //mirar si supera el valor maxim tambe
    	}catch(Exception e) {
    		System.out.println("1<=val");
    	}
        try {
            if (oc[val-1]) throw new Exception();
            super.setNumero(pos, val);
            oc[val-1] = true;
        } catch (Exception e) {
            System.out.println("Este numero ya esta puesto");
        }
    }
 
    @Override
    public void borra(int pos) {
        int valor = super.getCella(pos).getNumero();
        if (!super.getCella(pos).estaVacia()) {
        	super.borra(pos); //borra el num de la celda de la posición que me pasan
        	oc[valor-1] = false; //ahora ese valor está libre ----------------------------------------->peta aqui ja que valor val -1 (fals ja que l'he canviat amb -4)
        }
    }
     
    public boolean estaNumero(int val){
        return oc[val-1];
    }
     
    boolean[] oc; //true = ese valor está ocupado
}
 
 
//HECHO