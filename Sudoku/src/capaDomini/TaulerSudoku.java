package capaDomini;

import java.util.Vector;

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
    
    public void muestraTabla() {
        for (int i = 0; i < n*n; ++i) {
            //if (i%n == 0) System.out.println("-----------------------------");
            for (int j = 0; j < n*n; ++j) {
                if (j%n == 0) System.out.printf("|");
                Cella cellaAux = super.getCella((i*n*n) + j);
                if (cellaAux.estaVacia()) System.out.printf(0 + "");
                else System.out.printf(cellaAux.getNumero() + "");
            }
            System.out.printf("%n");
        }
    }
    
   public void setNumCelda(int x, int y, int val, boolean fija) { //FALTA: debería comprobar al principio de todo que no está fija
        boolean posible = esPosible(x,y,val);
         
        try {
            if (!posible) throw new Exception();
             
            SetNumEnFila(x,y,val);
            SetNumEnColumna(x,y,val);
            SetNumEnCuadrado(x,y,val);
            
            super.setNumero(x, y, val);
             
            if (fija) fijar(x,y);
            /*con fijarla una vez ya se aplica a las demás regiones
             * pero no puedo hacer lo mismo con el valor
             * porque entonces no se actualizaría el vector de RegióSenseRepeticions para cada Regio.
             * Se fija al final de ponerle el valor a la Celda desde todas las Regiones que la tienen
             */
            System.out.println("Se ha insertado el valor " + val + " en la fila " + x + " y columna " + y);
        } catch (Exception e) {
            System.out.println("Este numero ya esta puesto en la misma Región");
        }
    }
    
    private void rellenaRegiones() {
        rs = new RegioSudoku[(n*n)*3]; //vector amb totes les regions del sudoku;
        for (int i = 0; i < 3; ++i) { //porque hay 3 tipos de regiones
            tipoRegioSudoku tipoRS;
            Vector<Cella> vCellasAux;
            switch (i) {
                case 0: //Filas
                    tipoRS = tipoRegioSudoku.fila;
                    for (int j = 0; j < n*n; ++j) { //Una iteración por fila
                        vCellasAux = new Vector();
                        for (int z = 0; z < n*n; ++z) { //una iteración por cada Celda de la fila (recorremos las columnas de esta fila)
                            int posicion = j*(n*n) + z; //Fórmula de AC de: posicion = nFila*CuantasColumnas + nColumna
                            vCellasAux.addElement(super.getCella(posicion));
                        }
                        rs[(i*n*n)+j] = new RegioSudoku(n,vCellasAux,tipoRS);
                    }
                    break;
                case 1: //Columnas
                    tipoRS = tipoRegioSudoku.columna;
                    for (int j = 0; j < n*n; ++j) { //Una iteración por columna
                        vCellasAux = new Vector();
                        for (int z = 0; z < n*n; ++z) { //una iteración por cada Celda de la columna (recorremos las filas de esta columna)
                            int posicion = z*(n*n) + j; //Fórmula de AC de: posicion = nFila*CuantasColumnas + nColumna
                            vCellasAux.addElement(super.getCella(posicion));
                        }
                        rs[(i*n*n)+j] = new RegioSudoku(n,vCellasAux,tipoRS);
                    }
                    break;
                default: //Cuadrados
                    tipoRS = tipoRegioSudoku.cuadrado;
                    for (int j = 0; j < n; ++j) { //Una iteración por cada "fila de cuadrado"
                        for (int z = 0; z < n; ++z) { //una iteración por cada "columna de cuadrado" dentro de esa "fila de cuadrado"
                            //EMPIEZA CODIGO PARA UNA SOLA REGION-CUADRADO
                            vCellasAux = new Vector();
                            for (int a1 = 0; a1 < n; ++a1) { //Para recorrer las filas de celdas dentro del cuadrado
                                int numFilaGlobal = j*n + a1;
                                for (int a2 = 0; a2 < n; ++a2) { //Para recorrer las columnas de celdas dentro del cuadrado
                                    int numColumnaGlobal = z*n + a2;
                                    int posicion = numFilaGlobal * (n*n) + numColumnaGlobal;
                                    vCellasAux.addElement(super.getCella(posicion));
                                }
                            }
                            rs[(i*n*n)+(j*n+z)] = new RegioSudoku(n,vCellasAux,tipoRS);
                            //ACABA CODIGO PARA UNA SOLA REGION-CUADRADO
                        }
                    }
                    break;
            }
        }
    }
    
    public boolean esPosible(int x, int y, int val){
    	//CALCULA POSICIONES:
        //posición de la región fila en el vector rs: x + 0
        int posRegFila = x + 0;
        //posición de la región columna en el vector rs: y + (n*n)
        int posRegColumna = y + (n*n);
        //posición de la región cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
            //número de fila de región cuadrado (no de la celda): fmc = x/n (es x/n truncado)
            //número de col. de región cuadrado (no de la celda): cmc = y/n
        int fmc = x/n;
        int cmc = y/n;
        int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
 
        boolean posible = true;
        posible = ! rs[posRegFila].estaNumero(val);
        if (posible) posible = ! rs[posRegColumna].estaNumero(val);
        if (posible) posible = ! rs[posRegCuadrado].estaNumero(val);
        
        return posible;
    }
    
    private void fijar(int x, int y) {
    	//CALCULA POSICIONES:
        //posición de la región fila en el vector rs: x + 0
        int posRegFila = x + 0;
        //posición de la región columna en el vector rs: y + (n*n)
        int posRegColumna = y + (n*n);
        //posición de la región cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
            //número de fila de región cuadrado (no de la celda): fmc = x/n (es x/n truncado)
            //número de col. de región cuadrado (no de la celda): cmc = y/n
        int fmc = x/n;
        int cmc = y/n;
        int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
        
        rs[posRegFila].getCella(y).fijar(); //Con hacerlo para una región ya vale porque se hace en la fila realmente
        
    }
    
    private void SetNumEnFila(int x, int y, int val) {
    	//CALCULA POSICION:
        //posición de la región fila en el vector rs: x + 0
        int posRegFila = x + 0;
        
        rs[posRegFila].setNumero(y, val);
    }
    
    private void SetNumEnColumna(int x, int y, int val) {
    	//CALCULA POSICION:
        int posRegColumna = y + (n*n);
        
        rs[posRegColumna].setNumero(x, val);
    }
    
    private void SetNumEnCuadrado(int x, int y, int val) {
    	//CALCULA POSICION:
        //posición de la región cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
            //número de fila de región cuadrado (no de la celda): fmc = x/n (es x/n truncado)
            //número de col. de región cuadrado (no de la celda): cmc = y/n
        int fmc = x/n;
        int cmc = y/n;
        int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
        
        int modFila = x%n;
        int modColu = y%n;
        int posDentroDelCuadrado = modFila*n + modColu; //posicion dentro del cuadrado del 0 a n*n: modFila*n + modColu
        rs[posRegCuadrado].setNumero(posDentroDelCuadrado, val);
    }
    
    private void borraNumEnFila(int x, int y) {
    	//CALCULA POSICION:
        //posición de la región fila en el vector rs: x + 0
        int posRegFila = x + 0;
        
        rs[posRegFila].borra(y);
    }
    
    private void borraNumEnColumna(int x, int y) {
    	//CALCULA POSICION:
        int posRegColumna = y + (n*n);
        
        rs[posRegColumna].borra(x);
    }
    
    private void borraNumEnCuadrado(int x, int y) {
    	//CALCULA POSICION:
        //posición de la región cuadrado en el vector rs: (fmc*n + cmc) + (n*n * 2)
            //número de fila de región cuadrado (no de la celda): fmc = x/n (es x/n truncado)
            //número de col. de región cuadrado (no de la celda): cmc = y/n
        int fmc = x/n;
        int cmc = y/n;
        int posRegCuadrado = (fmc*n + cmc) + (n*n * 2);
        
        int modFila = x%n;
        int modColu = y%n;
        int posDentroDelCuadrado = modFila*n + modColu; //posicion dentro del cuadrado del 0 a n*n: modFila*n + modColu
        rs[posRegCuadrado].borra(posDentroDelCuadrado);
    }
    
     

	public void borraNumCelda(int x, int y) {
		super.borra(x, y);
		borraNumEnFila(x,y);
		borraNumEnColumna(x,y);
		borraNumEnCuadrado(x,y);
	}





	//private Vector<Cella> vCellas; //AHORA EN TAULER
	private RegioSudoku[] rs;
	private int n;
	//private int[][][] posAfectadas;
}