package Ranking;

import java.io.*;
import persistencia.*;

public class CTRLRanking {
		
	public static void carregar(Ranking r, String arxiu) {
		CtrlPersistencia.setSeparator(" ");
		try {
			r.Info = CtrlPersistencia.loadTable("src/data/" + arxiu + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}