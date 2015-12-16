package Ranking;

import java.util.*;

public class RankingGeneral extends Ranking {
	int nJocs;
	int nUsuaris;
	int nPartides;
	String popular;

	public RankingGeneral() {
		this.nJocs = 0;
		this.nUsuaris = 0;
		this.nPartides = 0;
		this.popular = "-";
		inicialitza();
	}
	
	public void inicialitza() {
		//nombre de jocs
		CTRLRanking.carregar(this, "jocs");
		this.nJocs = Info.size();
		
		//nombre d'usuaris
		CTRLRanking.carregar(this, "users");
		this.nUsuaris = Info.size();
		
		//nombre de partides
		CTRLRanking.carregar(this, "partidas");
		this.nPartides = Info.size();
		
		//joc mes popular
		Map<String,Integer> cont = new HashMap<>();
		CTRLRanking.carregar(this, "partidas");
		for (int i = 0; i < Info.size(); ++i) {	//presencia d'un joc a Partides
			ArrayList<String> s = Info.get(i);	//agafem linia per linia la informacio Info
			String id = s.get(1);	//prenem el valor identificador que ens interessa
			if (!(cont.containsKey(id))) {	//no havia aparegut
				cont.put(id,1);	//afegim <Key = id, value = 1> a la primera posicio lliure
			}
			else {	//ja havia aparegut
				int value = cont.get(id);	//consultem el valor del Key = id
				cont.put(id,++value);	//afegim <value += 1> a la posicio de Key = id
			}
		}
		Map.Entry<String,Integer> entry;
		int max = -1;	//assignem valor a max
		int visitats = 0;	//posicions visitades
    	while (visitats <= cont.size()) {
    		if(Info.size()<=0) break;
    		entry = cont.entrySet().iterator().next();	//prenem els valors de la primera posicio
    		if (max < entry.getValue()) {
    			max = entry.getValue();
    			this.popular = entry.getKey();
    		}
    		++visitats;
    		cont.remove(entry.getKey());
    	}
	}
	
	public int getnJocs() {					
		return this.nJocs;
    }
	
	public int getnUsuaris() {
		return this.nUsuaris;
	}
	
	public int getnPartides() {
		return this.nPartides;
	}
	
	public String getPopular() {	
    	return this.popular;
	}
}