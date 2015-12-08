package Ranking;

import java.util.Scanner;

public class DriverRanking {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		DriverRankingGeneral.mostraRankingGeneral();
		DriverRankingPerTipus.mostraRankingPerTipus(entrada);
		 
	}

}
