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
		
		ArrayList<Tupla> Tf = rtf.getTempsJugador();
		
		//////////////////////
		////////FACIL////////
		/////////////////////
		String f1, f2, f3, m1,m2,m3,d1,d2,d3;
		int t,s,m,h;
		
		if(Tf.size()<=0) f1 = "-";
		else{
			t=Tf.get(0).getTemps().intValue();
			s=t%60;
			m=(t/60)%60;
			h=t/3600;
			f1 = Tf.get(0).getUser() + " " + h + ":" + m + ":" + s;
		}
		
		if(Tf.size()<=1) f2 = "-";
		else{
		t=Tf.get(1).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		f2 = Tf.get(1).getUser() + " " + h + ":" + m + ":" + s;
		}
		if(Tf.size()<=2) f3 = "-";
		else{
		t=Tf.get(2).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		f3 = Tf.get(2).getUser() + " " + h + ":" + m + ":" + s;
		}
		//////////////////////
		////////MEDIO////////
		/////////////////////
		RankingPerTipus rtm = new RankingPerTipus("medio",3);
		ArrayList<Tupla> Tm = rtm.getTempsJugador();
		if(Tm.size()<=0) m1 = "-";
		else{
		t=Tm.get(0).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		m1 = Tm.get(0).getUser() + " " + h + ":" + m + ":" + s;
		}
		if(Tm.size()<=1) m2 = "-";
		else{
		t=Tm.get(1).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		m2 = Tm.get(1).getUser() + " " + h + ":" + m + ":" + s;
		}
		if(Tm.size()<=2) m3 = "-";
		else{
		t=Tm.get(2).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		m3 = Tm.get(2).getUser() + " " + h + ":" + m + ":" + s;
		}
		//////////////////////
		////////DIFICIL///////
		/////////////////////
		RankingPerTipus rtd = new RankingPerTipus("dificil",3);
		ArrayList<Tupla> Td = rtd.getTempsJugador();
		if(Td.size()<=0) d1 = "-";
		else{
		t=Td.get(0).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		d1 = Td.get(0).getUser() + " " + h + ":" + m + ":" + s;
		}
		if(Td.size()<=1) d2 = "-";
		else{
		t=Td.get(1).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		d2=Td.get(1).getUser() + " " + h + ":" + m + ":" + s;
		}
		if(Td.size()<=2) d3 = "-";
		else{
		t=Td.get(2).getTemps().intValue();
		s=t%60;
		m=(t/60)%60;
		h=t/3600;
		d3 = Td.get(2).getUser() + " " + h + ":" + m + ":" + s;
		}
		
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
