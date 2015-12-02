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

	public DTOTiempo getTiempoEjecutandose() {
		return tiempoEjecutandose;
	}

	public int getNumeroPistas() {
		return numeroPistas;
	}
	
}
