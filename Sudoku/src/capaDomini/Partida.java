package capaDomini;

import java.util.*;
import excepciones.*;

public class Partida { 
	//DATO1: supongo que no puede estar m�s de 24 horas resolviendo un sudoku XD si no, ya se arreglar�
	//esto afecta a que no digo dias...horas...minutos...segundos..., me salto d�as
	//tambien afteca a que no controlo que tiempoSegundos no siga sumando si da una burrada
	
	//DATO2: "resuelto" y "DataFi" estan relacionados
	
	//FALTAN JocSudoku y Usuario? depende de si hay navegabilidad
	
	private int tiempoSegundos;
	private Timer timer;
	private boolean enEjecucion;
	
	private int nPistas;
	
	private Date dataFi; //para saber si est� resuelto o no y para que no se pueda solapar 2 veces el mismo sudoku por la misma persona cuando aun no lo ha acabado de antes
	private Date dataIni;
	
	public Partida () {
		nPistas = 0;
		dataFi = null;
		tiempoSegundos = 0; //para hacer pruebas he puesto 4200 y ha ido bien
		dataIni = getFechaActual();
		
		enEjecucion = false;
		startTiempo();
	}
	
	public void startTiempo() {
		try {
			if (enEjecucion) throw (new ExcepcionTimerYaEnEjecucion());
			timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					tiempoSegundos++;
				}
			}, 0, 1000);
			enEjecucion = true;
		} catch (ExcepcionTimerYaEnEjecucion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void pauseTiempo() {
		try {
			if (!enEjecucion) throw (new ExcepcionTimerYaEstaParado());
			timer.cancel();
			enEjecucion = false;
		} catch (ExcepcionTimerYaEstaParado e) {
			System.out.println(e.getMessage());
		}
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
	
	public Date getDataFi() {
		try {
			if(dataFi == null) throw (new ExcepcionJuegoAunNoResuelto());
			return dataFi;
		}
		catch (ExcepcionJuegoAunNoResuelto e) {
			System.out.println(e.getMessage());
		}
		return getFechaActual();
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
	
}