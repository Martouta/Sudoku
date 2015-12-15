package capaDomini;

import persistencia.CtrlJocSudoku;
import persistencia.CtrlPartida;
import persistencia.CtrlUser;
import DataTransferObjects.DTORankingPersonal;
import DataTransferObjects.DTOTiempo;

import java.util.ArrayList;

import DataTransferObjects.DTORankingGeneral;
import DataTransferObjects.DTORankingPerTipus;
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
	
	public DTORankingPerTipus GetDataRankingPerTipus(){
		
		RankingPerTipus rtf = new RankingPerTipus("facil",3);
		RankingPerTipus rtm = new RankingPerTipus("medio",3);
		RankingPerTipus rtd = new RankingPerTipus("dificil",3);
		
		ArrayList<Tupla> Tf = rtf.getTempsJugador();
		ArrayList<Tupla> Tm = rtm.getTempsJugador();
		ArrayList<Tupla> Td = rtd.getTempsJugador();
		
		//////////////////////
		////////FACIL////////
		/////////////////////
		int t=Tf.get(0).getTemps().intValue();
		int s=t%60;
		int m=(t/60)%60;
		int h=t/3600;
		String f1 = Tf.get(0).getUser() + " " + s + ":" + m + ":" + h;
		
		t=Tf.get(1).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String f2 = Tf.get(1).getUser() + " " + s + ":" + m + ":" + h;
		
		t=Tf.get(2).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String f3 = Tf.get(2).getUser() + " " + s + ":" + m + ":" + h;
		
		//////////////////////
		////////NORMAL///////
		/////////////////////
		t=Tm.get(0).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String m1 = Tm.get(0).getUser() + " " + s + ":" + m + ":" + h;
		
		t=Tm.get(1).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String m2 = Tf.get(1).getUser() + " " + s + ":" + m + ":" + h;
		
		t=Tm.get(2).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String m3 = Tm.get(2).getUser() + " " + s + ":" + m + ":" + h;
		
		//////////////////////
		////////DIFICIL///////
		/////////////////////
		t=Td.get(0).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String d1 = Tm.get(0).getUser() + " " + s + ":" + m + ":" + h;
		
		t=Td.get(1).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String d2 = Tf.get(1).getUser() + " " + s + ":" + m + ":" + h;
		
		t=Td.get(2).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		String d3 = Tm.get(2).getUser() + " " + s + ":" + m + ":" + h;
		
		
		DTORankingPerTipus infoRankingPerTipus = new DTORankingPerTipus(f1,f2,f3,m1,m2,m3,d1,d2,d3);
		return infoRankingPerTipus;
	}
	
	public DTORankingGeneral GetDataEstadisticasGenerales(){
		RankingGeneral eg = new RankingGeneral();
		eg.inicialitza();
		int j=eg.getnJocs();
		int u=eg.getnUsuaris();
		int p=eg.getnPartides();
		String pop = eg.getPopular();
		DTORankingGeneral infoRankingGeneral = new DTORankingGeneral(j,u,p,pop);
		return infoRankingGeneral;
	}
	
}
