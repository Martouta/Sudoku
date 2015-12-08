package capaDomini;

//CLASE LISTA PARA SER PROGRAMADA

import persistencia.*;
import excepciones.*;

public class CtrlCasoUsoGestionPerfil {
	
	public CtrlCasoUsoGestionPerfil() {
		//AQUI VAN LOS .init() NECESARIOS PARA QUE EL RESTO DEL CODIGO FUNCIONE
	}
	
	public void eliminarSudokusComoAutor(String nombreUsuario) throws ExcepcionHayPartidaConSudoku {
		/*
		 ESTA FUNCION HACE LO SIGUIENTE:
		 ·elimina todos los sudokus de la BD en los que el autor es el usuario "nombreUsuario",
		 PERO si alguno de ellos esta siendo jugado por alguna partida (ya sea acabada o no), se debe hacer: throw new ExcepcionHayPartidaConSudoku;
		 ·Si haciendo algo de todo esto te sale algun error de excepcion no cubierta, pon en la cabecera de la funcion throws nombreExcepcion, y pon tantas como te salgan, divididas por comas
		 */
	}
	
	public void eliminarPerfilUsuario(String nombreUsuario){
		/*
		 ESTA FUNCION HACE LO SIGUIENTE:
		 ·elimina de la BD todas las partidas del usuario "nombreUsuario" (ya estén a medias o acabadas).
		 ·elimina de la BD el usario "nombreUsuario"
		 ·NO elimina de la BD los sudokus de los cuales es autor, ni los sudokus de las partidas borradas tampoco.
		 ·Si haciendo algo de todo esto te sale algun error de excepcion no cubierta, pon en la cabecera de la funcion throws nombreExcepcion, y pon tantas como te salgan, divididas por comas
		 */
	}
	
	public void eliminarEstadisticasDeUsuario(String nombreUsuario){
		/*
		 ESTA FUNCION HACE LO SIGUIENTE:
		 ·elimina de la BD todas las partidas del usuario "nombreUsuario" (ya estén a medias o acabadas).
		 ·NO elimina de la BD el usario "nombreUsuario", ni ningún sudoku
		 ·Si haciendo algo de todo esto te sale algun error de excepcion no cubierta, pon en la cabecera de la funcion throws nombreExcepcion, y pon tantas como te salgan, divididas por comas
		 */
	}
}
