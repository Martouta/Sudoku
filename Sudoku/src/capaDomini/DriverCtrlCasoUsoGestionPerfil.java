package capaDomini;

import excepciones.ExcepcionHayPartidaConSudoku;

public class DriverCtrlCasoUsoGestionPerfil {

	public static void main(String[] args) {
		CtrlCasoUsoGestionPerfil ctrl = new CtrlCasoUsoGestionPerfil();

		//ctrl.eliminarEstadisticasDeUsuario("aaa");
		//ctrl.eliminarPerfilUsuario("aaa");
		try {
			ctrl.eliminarSudokusComoAutor("aaa");
		} catch(ExcepcionHayPartidaConSudoku e) {
			System.out.println("Hay partidas jugadas en alguno de los sudokus de los cuales eres autor. No se pueden borrar");
		}
	}

}
