package capaDomini;

import java.util.*;
import excepciones.*;

public class Partida { 
	//DATO1: supongo que no puede estar más de 24 horas resolviendo un sudoku XD si no, ya se arreglará
	//esto afecta a que no digo dias...horas...minutos...segundos..., me salto días
	//tambien afteca a que no controlo que tiempoSegundos no siga sumando si da una burrada
	
	//DATO2: "resuelto" y "DataFi" estan relacionados
	
	//JocSudoku y Usuario? depende de si hay navegabilidad
	private User usuario;
	private JocSudoku sudoku;
	private Vector<CjtoMarcas> vCjtoMarcas;
	int nn;
	
	private int tiempoSegundos;
	private Timer timer;
	private boolean enEjecucion;
	
	private int nPistas;
	
	private Date dataFi; //para saber si está resuelto o no y para que no se pueda solapar 2 veces el mismo sudoku por la misma persona cuando aun no lo ha acabado de antes
	private Date dataIni;
	
	public Partida () throws ExcepcionTimerYaEnEjecucion {//CONSTRUCTOR TEMPORAL PARA EL DRIVER
		nPistas = 0;
		dataFi = null;
		tiempoSegundos = 0; //para hacer pruebas he puesto 4200 y ha ido bien
		dataIni = getFechaActual();
		
		enEjecucion = false;
		startTiempo();
	}
	
	public Partida (User usuario, JocSudoku sudoku) throws ExcepcionTimerYaEnEjecucion {
		this.usuario = usuario;
		this.sudoku = sudoku;
		
		int numCeldasTablero = sudoku.getTauler().getNumCeldas();
		vCjtoMarcas = new Vector<CjtoMarcas>(numCeldasTablero);
		nn = (int) Math.pow(numCeldasTablero,0.5);
		for (int i = 0; i < numCeldasTablero; ++i) {
			vCjtoMarcas.addElement(new CjtoMarcas(nn));
		}
		
		nPistas = 0;
		dataFi = null;
		tiempoSegundos = 0; //para hacer pruebas he puesto 4200 y ha ido bien
		dataIni = getFechaActual();
		
		enEjecucion = false;
		startTiempo();
	}
	
	public void startTiempo() throws ExcepcionTimerYaEnEjecucion {
		if (enEjecucion) throw (new ExcepcionTimerYaEnEjecucion());
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				tiempoSegundos++;
			}
		}, 0, 1000);
		enEjecucion = true;
	}
	
	public void pauseTiempo() throws ExcepcionTimerYaEstaParado {
		if (!enEjecucion) throw (new ExcepcionTimerYaEstaParado());
		timer.cancel();
		enEjecucion = false;
	}
	
	public boolean getEstadoTimer() {
		return enEjecucion;
	}
	
	public int getSegundosTotales() {
		return tiempoSegundos;
	}
	
	public int getSegundos() {
		return tiempoSegundos%60;
	}
	
	public int getMinutos() {
		return (tiempoSegundos/60)%60;
	}
	
	public int getHoras() {
		return (tiempoSegundos/(60*60))%60;
	}
	
	
	public int getNumPistas() {
		return nPistas;
	}
	
	public void incrementaPista() {
		++nPistas;
	}

	public boolean getResuelto() {
		return (dataFi == null);
	}
	
	public Date getDataFi() throws ExcepcionJuegoAunNoResuelto {
		if(dataFi == null) throw (new ExcepcionJuegoAunNoResuelto());
		return dataFi;
	}

	public void yaResuelto() {
		dataFi = getFechaActual();
	}
	
	private Date getFechaActual() {
		return new Date();
	}
	
	public Date getDataIni() {
		return dataIni;
	}
	
	public void marcarNumero(int x, int y, int val) throws ExcepcionValorFueraRango {
		vCjtoMarcas.get(x*nn + y).marcarNumero(val);
	}
	
	public void desmarcarNumero(int x, int y, int val) throws ExcepcionValorFueraRango {
		vCjtoMarcas.get(x*nn + y).desmarcarNumero(val);
	}
	
	public boolean estaMarcado(int x, int y, int val) throws ExcepcionValorFueraRango{
		return vCjtoMarcas.get(x*nn + y).estaMarcado(val);
	}
	
	public void mostrarMarcasPosicion(int x, int y) throws ExcepcionValorFueraRango{
		for (int i = 1; i <= nn; ++i) {
			if (vCjtoMarcas.get(x*nn + y).estaMarcado(i)) System.out.println(i + " ");
		}
	}
	
	public void setDataIni(Date d) {	// para cargar partidas
		dataIni = d;
	}
	
	public void setSegundos(int s) {	// idem
		tiempoSegundos = s;
	}
	
	public void setNPistas(int n) {		// idem
		nPistas = n;
	}
	
	public JocSudoku getJocSudoku() {
		return sudoku;
	}
	
	public User getUsuario() {
		return usuario;
	}
}
