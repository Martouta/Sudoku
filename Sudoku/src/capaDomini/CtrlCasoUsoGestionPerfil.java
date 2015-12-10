package capaDomini;

//CLASE LISTA PARA SER PROGRAMADA

import persistencia.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import excepciones.*;

public class CtrlCasoUsoGestionPerfil {
	
	public CtrlCasoUsoGestionPerfil() {
		//AQUI VAN LOS .init() NECESARIOS PARA QUE EL RESTO DEL CODIGO FUNCIONE
		CtrlUser.init();
		CtrlJocSudoku.init(); //necesario para borrar los sudokus de un usuario
		CtrlPartida.init(); //necesaria para borrar las partidas de los usuarios
	}
	
	public void eliminarSudokusComoAutor(String nombreUsuario) throws ExcepcionHayPartidaConSudoku {
		/*
		 ESTA FUNCION HACE LO SIGUIENTE:
		 ·elimina todos los sudokus de la BD en los que el autor es el usuario "nombreUsuario",
		 PERO si alguno de ellos esta siendo jugado por alguna partida (ya sea acabada o no), se debe hacer: throw new ExcepcionHayPartidaConSudoku;
		 ·Si haciendo algo de todo esto te sale algun error de excepcion no cubierta, pon en la cabecera de la funcion throws nombreExcepcion, y pon tantas como te salgan, divididas por comas
		 */
		ArrayList<JocSudoku> js = CtrlJocSudoku.getTaula();
		ArrayList<String> aut = CtrlJocSudoku.getAutores(); //quizas no sea necesario
		ArrayList<Partida> p = CtrlPartida.getTaula();
		ArrayList<String> nom = CtrlPartida.getNombresPartidas();
		for (int i = 0; i < aut.size(); ++i) { //recorro el vector d'autors per veure de quins sudokus n'es propietari
			if (aut.get(i).equals(nombreUsuario)) { //si en trobo algun del qual n'es propietari, haig de mirar que ningu hi estigui jugant
				
				//JocSudoku del qual usuari nombreUsuario es autor es el js.get(i)
				
				for (int j = 0; j < nom.size(); ++j) {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
	                Date d = p.get(j).getDataIni();
					if (nom.get(j).equals(js.get(i).getId()+ df.format(d)+nombreUsuario)) throw new ExcepcionHayPartidaConSudoku(); //si el nom de la partida es igual al nom del joc sudoku no es pot eliminar
				}
				CtrlJocSudoku.esborraJocSudoku(js.get(i).getId());
				js = CtrlJocSudoku.getTaula();
				i = -1;
			}
		}
		CtrlJocSudoku.end();
	}
	
	public void eliminarPerfilUsuario(String nombreUsuario){ 
		/*
		 ESTA FUNCION HACE LO SIGUIENTE:
		 ·elimina de la BD todas las partidas del usuario "nombreUsuario" (ya estén a medias o acabadas).
		 ·elimina de la BD el usario "nombreUsuario"
		 ·NO elimina de la BD los sudokus de los cuales es autor, ni los sudokus de las partidas borradas tampoco.
		 ·Si haciendo algo de todo esto te sale algun error de excepcion no cubierta, pon en la cabecera de la funcion throws nombreExcepcion, y pon tantas como te salgan, divididas por comas
		 */
		ArrayList<Partida> p = CtrlPartida.getTaula();
		for (int i = 0; i < p.size(); ++i) {
			Partida pp = p.get(i);
			if (pp.getUsuario().getUsername().equals(nombreUsuario)) { //si la partida es del usuario nombreUsuario se borra
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
                Date d = pp.getDataIni();
				String id = pp.getJocSudoku().getId() + df.format(d)+nombreUsuario;
				User usuario = CtrlUser.getUsuari(nombreUsuario);
				CtrlPartida.esborraPartida(id, usuario);
				p = CtrlPartida.getTaula();
				i = -1;
			}
		}
		CtrlPartida.end();
		CtrlUser.esborraUsuari(nombreUsuario);
		CtrlUser.end();
	}
	
	public void eliminarEstadisticasDeUsuario(String nombreUsuario){
		/*
		 ESTA FUNCION HACE LO SIGUIENTE:
		 ·elimina de la BD todas las partidas del usuario "nombreUsuario" (ya estén a medias o acabadas).
		 ·NO elimina de la BD el usario "nombreUsuario", ni ningún sudoku
		 ·Si haciendo algo de todo esto te sale algun error de excepcion no cubierta, pon en la cabecera de la funcion throws nombreExcepcion, y pon tantas como te salgan, divididas por comas
		 */
		ArrayList<Partida> p = CtrlPartida.getTaula();
		for (int i = 0; i < p.size(); ++i) {
			Partida pp = p.get(i);
			if (pp.getUsuario().getUsername().equals(nombreUsuario)) {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
                Date d = pp.getDataIni();
				String id = pp.getJocSudoku().getId() + df.format(d)+nombreUsuario;
				User usuario = CtrlUser.getUsuari(nombreUsuario);
				CtrlPartida.esborraPartida(id, usuario);
				p = CtrlPartida.getTaula();
				i = -1;
			}
		}
		CtrlPartida.end();
	}
}
