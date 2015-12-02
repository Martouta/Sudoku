package capaDomini;

import java.util.Vector;
import excepciones.*;

public class TaulerSudoku extends Tauler {
 
    public TaulerSudoku(int n) { 
        super(n*n, n*n);
        this.n = n;
        rellenaRegiones();
    }
    
    public int getN() {
    	return n;
    }
    
    public int getNN(){
    	return n*n;
    }
    
    /*public void muestraTabla() {
        for (int i = 0; i < n*n; ++i) {
            //if (i%n == 0) System.out.println("-----------------------------");
            for (int j = 0; j < n*n; ++j) {
                if (j%n == 0) System.out.printf("|");
                //Cella cellaAux = super.getCella((i*n*n) + j);
                Cella cellaAux = super.getCella(i,j);
                if (cellaAux.estaVacia()) System.out.printf(0 + "");
                else System.out.printf(cellaAux.getNumero() + "");
            }
            System.out.printf("%n");
        }
    }*/
    
    public void muestraTabla() {
        for (int i = 0; i < n*n; ++i) {
            //if (i%n == 0) System.out.println("-----------------------------");
        	if(i%n==0) {
        		System.out.print("++");
        		for(int j=0;j<n;j++) {
        			int niters = 3*n-1;
        			for(int k=0;k<niters;k++)
        				System.out.print("-");
        			System.out.print("++");
        		}
            	System.out.println();
            }
        	for (int j = 0; j < n*n; ++j) {
            	if (j%n == 0) System.out.printf("|");
                System.out.printf("|");
                Cella cellaAux = super.getCella(i,j);
                if (cellaAux.estaVacia()) System.out.printf(" " + 0);
                else if (cellaAux.getNumero() <= 9) System.out.printf(" " + cellaAux.getNumero());
                else System.out.printf(cellaAux.getNumero() + "");
            }
            System.out.println("||");
            //System.out.printf("%n");
            
        }
        System.out.print("++");
		for(int j=0;j<n;j++) {
			int niters = 3*n-1;
			for(int k=0;k<niters;k++)
				System.out.print("-");
			System.out.print("++");
		}
    	System.out.println();
    }
    
   public void setNumCelda(int x, int y, int val, boolean fija) {
	   try {
		   if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
		   if (val < 0 || val > n*n) throw (new ExcepcionValorFueraRango());
		   if (super.estaFija(x, y)) throw (new ExcepcionNumeroFijo());
		   
		   boolean posible = esPosible(x,y,val);
		   if (!posible) throw (new ExcepcionValorYaPuesto());
		   SetNumEnFila(x,y,val);
		   SetNumEnColumna(x,y,val);
		   SetNumEnCuadrado(x,y,val);
		   
		   super.setNumero(x, y, val);  
		   if (fija) fijar(x,y);
			
		   /*con fijarla una vez ya se aplica a las demás regiones
		   pero no puedo hacer lo mismo con el valor
		   porque entonces no se actualizaría el vector de RegióSenseRepeticions para cada Regio.
		   Se fija al final de ponerle el valor a la Celda desde todas las Regiones que la tienen
		   */
		   System.out.println("Se ha insertado el valor " + val + " en la fila " + x + " y columna " + y);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			System.out.println(e.getMessage());
		}
    }
   
   private void rellenaRegiones() { //MEJORABLE POR EL FOR DE 3 Y LUEGO SWITCH
       rs = new RegioSudoku[(n*n)*3]; //vector amb totes les regions del sudoku;
       tipoRegioSudoku tipoRS;
       Vector<Cella> vCellasAux;
       //FILAS:
       tipoRS = tipoRegioSudoku.fila;
       for (int j = 0; j < n*n; ++j) { //Una iteracion por fila
           vCellasAux = new Vector<Cella>();
           for (int z = 0; z < n*n; ++z) { //una iteracion por cada Celda de la fila (recorremos las columnas de esta fila)
               //int posicion = j*(n*n) + z; //Formula de AC de: posicion = nFila*CuantasColumnas + nColumna
               //vCellasAux.addElement(super.getCella(posicion));
           	vCellasAux.addElement(super.getCella(j,z));
           }
           rs[j] = new RegioSudoku(n,vCellasAux,tipoRS); //rs[(0*n*n)+j] = new RegioSudoku(n,vCellasAux,tipoRS);
       }
       //COLUMNAS:
       tipoRS = tipoRegioSudoku.columna;
       for (int j = 0; j < n*n; ++j) { //Una iteracion por columna
           vCellasAux = new Vector<Cella>();
           for (int z = 0; z < n*n; ++z) { //una iteracion por cada Celda de la columna (recorremos las filas de esta columna)
               //int posicion = z*(n*n) + j; //Formula de AC de: posicion = nFila*CuantasColumnas + nColumna
               //vCellasAux.addElement(super.getCella(posicion));
           	vCellasAux.addElement(super.getCella(z,j));
           }
           rs[(n*n)+j] = new RegioSudoku(n,vCellasAux,tipoRS); //rs[(1*n*n)+j] = new RegioSudoku(n,vCellasAux,tipoRS);
       }
       //CUADRADOS:
       tipoRS = tipoRegioSudoku.cuadrado;
       for (int j = 0; j < n; ++j) { //Una iteracion por cada "fila de cuadrado"
           for (int z = 0; z < n; ++z) { //una iteracion por cada "columna de cuadrado" dentro de esa "fila de cuadrado"
               //EMPIEZA CODIGO PARA UNA SOLA REGION-CUADRADO
               vCellasAux = new Vector<Cella>();
               for (int a1 = 0; a1 < n; ++a1) { //Para recorrer las filas de celdas dentro del cuadrado
                   int numFilaGlobal = j*n + a1;
                   for (int a2 = 0; a2 < n; ++a2) { //Para recorrer las columnas de celdas dentro del cuadrado
                       int numColumnaGlobal = z*n + a2;
                       //int posicion = numFilaGlobal * (n*n) + numColumnaGlobal;
                       //vCellasAux.addElement(super.getCella(posicion));
                       vCellasAux.addElement(super.getCella(numFilaGlobal,numColumnaGlobal));
                   }
               }
               rs[(2*n*n)+(j*n+z)] = new RegioSudoku(n,vCellasAux,tipoRS); //rs[(2*n*n)+(j*n+z)] = new RegioSudoku(n,vCellasAux,tipoRS);
               //ACABA CODIGO PARA UNA SOLA REGION-CUADRADO
           }
       }
   }
    
    public boolean esPosible(int x, int y, int val){
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			if (val < 0 || val > n*n) throw (new ExcepcionValorFueraRango());
			
			//CALCULA POSICIONES:
			//posicion de la region fila en el vector rs: x + 0
			int posRegFila = x + 0;
			//posicion de la region columna en el vector rs: y + (n*n)
			int posRegColumna = y + (n*n);
			//posicion de la region cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
			    //numero de fila de region cuadrado (no de la celda): fmc = x/n (es x/n truncado)
			    //numero de col. de region cuadrado (no de la celda): cmc = y/n
			int fmc = x/n;
			int cmc = y/n;
			int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
 
			boolean posible = true;
			posible = ! rs[posRegFila].estaNumero(val);
			if (posible) posible = ! rs[posRegColumna].estaNumero(val);
			if (posible) posible = ! rs[posRegCuadrado].estaNumero(val);
			
			return posible;
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		}
    }
    
    private void fijar(int x, int y) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			int posRegFila = x;
			rs[posRegFila].getCella(y).fijar(); //Con hacerlo para una region ya vale porque se hace en la fila realmente
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
    
    private void SetNumEnFila(int x, int y, int val) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			if (val < 0 || val > n*n) throw (new ExcepcionValorFueraRango());
			int posRegFila = x; //posicion de la region fila en el vector rs: x + 0
			rs[posRegFila].setNumero(y, val);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
    
    private void SetNumEnColumna(int x, int y, int val) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			if (val < 0 || val > n*n) throw (new ExcepcionValorFueraRango());
			int posRegColumna = y + (n*n);
			rs[posRegColumna].setNumero(x, val);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
    
    private void SetNumEnCuadrado(int x, int y, int val) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			if (val < 0 || val > n*n) throw (new ExcepcionValorFueraRango());
			//CALCULA POSICION:
			//posicion de la region cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
			//numero de fila de region cuadrado (no de la celda): fmc = x/n (es x/n truncado)
			//numero de col. de region cuadrado (no de la celda): cmc = y/n
			int fmc = x/n;
			int cmc = y/n;
			int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
			
			int modFila = x%n;
			int modColu = y%n;
			int posDentroDelCuadrado = modFila*n + modColu; //posicion dentro del cuadrado del 0 a n*n: modFila*n + modColu
			rs[posRegCuadrado].setNumero(posDentroDelCuadrado, val);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
    
    private void borraNumEnFila(int x, int y) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			int posRegFila = x; //posicion de la region fila en el vector rs: x + 0
			rs[posRegFila].borra(y);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
    
    private void borraNumEnColumna(int x, int y) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			int posRegColumna = y + (n*n); //posicion de la region columna en el vector rs: y + (n*n)
	        rs[posRegColumna].borra(x);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
    }
    
    private void borraNumEnCuadrado(int x, int y) {
    	try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			//CALCULA POSICION:
			//posicion de la region cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
			//numero de fila de region cuadrado (no de la celda): fmc = x/n (es x/n truncado)
			//numero de col. de region cuadrado (no de la celda): cmc = y/n
			int fmc = x/n;
			int cmc = y/n;
			int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
			
			int modFila = x%n;
			int modColu = y%n;
			int posDentroDelCuadrado = modFila*n + modColu; //posicion dentro del cuadrado del 0 a n*n: modFila*n + modColu
			rs[posRegCuadrado].borra(posDentroDelCuadrado);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
    } 
    
	public void borraNumCelda(int x, int y) {
		try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			numeroYaNoEstaEnRegiones(x, y); //importante hacer este antes que los dem�s para no perder el valor.
			super.borra(x, y);
			borraNumEnFila(x,y);
			borraNumEnColumna(x,y);
			borraNumEnCuadrado(x,y);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
	}

	private void numeroYaNoEstaEnRegiones(int x, int y) {
		try {
			if (x < 0 || x > n*n || y < 0 || y > n*n) throw (new ExcepcionPosicionFueraRango());
			//CALCULA POSICIONES:
			//posicion de la region fila en el vector rs: x + 0
			int posRegFila = x + 0;
			//posicion de la region columna en el vector rs: y + (n*n)
			int posRegColumna = y + (n*n);
			//posicion de la region cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
			    //numero de fila de region cuadrado (no de la celda): fmc = x/n (es x/n truncado)
			    //numero de col. de region cuadrado (no de la celda): cmc = y/n
			int fmc = x/n;
			int cmc = y/n;
			int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);

			int val = rs[posRegFila].getNumero(y);
			rs[posRegFila].numeroYaNoEsta(val);
			rs[posRegColumna].numeroYaNoEsta(val);
			rs[posRegCuadrado].numeroYaNoEsta(val);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*INCORRECTO, LO PODREMOS BIEN HECHO EN EL CTRL DE SU CASO DE USO
	public void resetearTableroSudoku() { //nueva opcion
		Cella aux = null;
		for (int i = 0; i < n*n; ++i) {
			for (int j = 0; j < n*n; ++j) {
				aux = super.getCella(i, j);
				if (!aux.estaFija()) aux.borra();
			}
		}
	}*/

	private RegioSudoku[] rs;
	private int n;
	//private int[][][] posAfectadas;
}