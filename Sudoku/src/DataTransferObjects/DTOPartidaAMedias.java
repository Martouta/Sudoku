package DataTransferObjects;

import java.util.*;

public class DTOPartidaAMedias {
	private String nombreSudoku;
	private Date fechaIni;
	private DTOTiempo tiempoEjecutandose;
	private int numeroPistas;
	
	public DTOPartidaAMedias(String nombreSudoku, Date fechaIni, DTOTiempo tiempoEjecutandose, int numeroPistas) {
		this.nombreSudoku = nombreSudoku;
		this.fechaIni = fechaIni;
		this.tiempoEjecutandose = tiempoEjecutandose;
		this.numeroPistas = numeroPistas;
	}

	public String getNombreSudoku() {
		return nombreSudoku;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public int getSegundos() {
		return tiempoEjecutandose.getSegundos();
	}
	public int getMinutos() {
		return tiempoEjecutandose.getMinutos();
	}
	public int getHoras() {
		return tiempoEjecutandose.getHoras();
	}

	public int getNumeroPistas() {
		return numeroPistas;
	}
	
}
