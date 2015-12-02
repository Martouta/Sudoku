package DataTransferObjects;

public class DTOTiempo {
	private int segundos;
	private int minutos;
	private int horas;
	
	public DTOTiempo(int segundos, int minutos, int horas) {
		this.segundos = segundos;
		this.minutos = minutos;
		this.horas = horas;
	}
	public int getSegundos() {
		return segundos;
	}
	public int getMinutos() {
		return minutos;
	}
	public int getHoras() {
		return horas;
	}
	
}
