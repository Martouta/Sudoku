package DataTransferObjects;

public class DTORankingPersonal {
	int nPistas;
	int nSudokusResueltos;
	DTOTiempo mejorTiempo4;
	DTOTiempo mejorTiempo9;
	DTOTiempo mejorTiempo16;
	
	public DTORankingPersonal(int nPistas, int nSudokusResueltos, DTOTiempo mejorTiempo4, DTOTiempo mejorTiempo9,
			DTOTiempo mejorTiempo16) {
		this.nPistas = nPistas;
		this.nSudokusResueltos = nSudokusResueltos;
		this.mejorTiempo4 = mejorTiempo4;
		this.mejorTiempo9 = mejorTiempo9;
		this.mejorTiempo16 = mejorTiempo16;
	}

	public int getnPistas() {
		return nPistas;
	}

	public int getnSudokusResueltos() {
		return nSudokusResueltos;
	}

	public DTOTiempo getMejorTiempo4() {
		return mejorTiempo4;
	}

	public DTOTiempo getMejorTiempo9() {
		return mejorTiempo9;
	}

	public DTOTiempo getMejorTiempo16() {
		return mejorTiempo16;
	}
	
}
