package capaDomini;

import persistencia.CtrlJocSudoku;
import persistencia.CtrlPartida;
import persistencia.CtrlUser;
import DataTransferObjects.DTORankingPersonal;
import DataTransferObjects.DTOTiempo;
import Ranking.*;

public class CtrlCasoUsoEstadisticas {
	
	
	
	
	
	public CtrlCasoUsoEstadisticas(){
		//AQUI VAN LOS .init() NECESARIOS PARA QUE EL RESTO DEL CODIGO FUNCIONE
				CtrlUser.init();
				CtrlJocSudoku.init(); //necesario para borrar los sudokus de un usuario
				CtrlPartida.init(); //necesaria para borrar las partidas de los usuarios
	}
	
	private DTOTiempo segundostotalesADTOTiempo(Double segundosTotales) {
		System.out.println("holaaaaa: " + segundosTotales);
		if(segundosTotales==null) segundosTotales=0.0; 
		int tiempoSegundos = segundosTotales.intValue();
		int segundos = tiempoSegundos%60;
		int minutos = (tiempoSegundos/60)%60;
		int horas = (tiempoSegundos/(60*60))%60;
		DTOTiempo tiempo = new DTOTiempo(segundos, minutos, horas);
		return tiempo;
	}
	
	public DTORankingPersonal GetDataRankingPersonal(String nomUsuari){
		RankingPersonal rp = new RankingPersonal(nomUsuari);
		DTOTiempo mejorTiempo4 = segundostotalesADTOTiempo(rp.getBestTime("facil"));
		DTOTiempo mejorTiempo9 = segundostotalesADTOTiempo(rp.getBestTime("medio"));
		DTOTiempo mejorTiempo16 = segundostotalesADTOTiempo(rp.getBestTime("dificil"));
		
		Double dPistes = rp.getPistes();
		int nPistes = dPistes.intValue();
		DTORankingPersonal infoRankingPersonal = new DTORankingPersonal(nPistes, rp.getResolts(), mejorTiempo4, mejorTiempo9, mejorTiempo16);
		
		return infoRankingPersonal;
	}
	
}
