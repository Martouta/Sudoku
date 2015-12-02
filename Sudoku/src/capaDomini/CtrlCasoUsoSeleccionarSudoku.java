package capaDomini;

import java.util.*;
import DataTransferObjects.*;
import excepciones.*;

public class CtrlCasoUsoSeleccionarSudoku {
	public Vector<DTOPartidaAMedias> obtenerPartidas(String nombreUsuario, tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 crear un vector de tipo Vector<DTOPartidaAMedias>,
		 que contiene todas las partidas a medias del usuario "nombreUsuario" con dificultad "dificultad" y con la n "n".
		 Si al final de la funcion, antes del return, el vector no contiene ningun elemento, hay que activar la excepcion ExcepcionNoHaySudokuConCaracteristicasSeleccionada
		 */
		return new Vector<DTOPartidaAMedias>(); //Esta linea esta solo para que no pete por faltar un return
	}

	public Vector<DTOSudokuDeLaBD> obtenerSudokuDeLaBD(tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 crear un vector de tipo Vector<DTOSudokuDeLaBD>,
		 que contiene todos los sudokus de la base de datos (que no son partidas a medias) con dificultad "dificultad" y con la n "n".
		 Si al final de la funcion, antes del return, el vector no contiene ningun elemento, hay que activar la excepcion ExcepcionNoHaySudokuConCaracteristicasSeleccionada
		 */
		return new Vector<DTOSudokuDeLaBD>(); //Esta linea esta solo para que no pete por faltar un return
	}
}
