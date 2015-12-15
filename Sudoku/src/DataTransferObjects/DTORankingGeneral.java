package DataTransferObjects;

public class DTORankingGeneral {
	
	int jocs;
	int usuaris;
	int partidas;
	String popular;
	
	public DTORankingGeneral(int j, int u, int p, String pop){
		
		this.jocs=j;
		this.usuaris=u;
		this.partidas = p;
		this.popular=pop;
		
	}

	public int getnjocs() {
		return jocs;
	}

	public int getnusuaris() {
		return usuaris;
	}

	public int getnpartides() {
		return partidas;
	}

	public String getpopular() {
		return popular;
	}
	
}
