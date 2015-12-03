package capaDomini;

//NO ACABADO

import java.util.*;
import DataTransferObjects.*;
import excepciones.*;

public class CtrlCasoUsoSeleccionarJugarSudoku {
	private Partida partida;
	
	public Vector<DTOPartidaAMedias> obtenerPartidas(String nombreUsuario, tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 crear un vector de tipo Vector<DTOPartidaAMedias>,
		 que contiene todas las partidas a medias del usuario "nombreUsuario" con dificultad "dificultad" y con la n "n".
		 Si al final de la funcion, antes del return, el vector no contiene ningun elemento, hay que activar la excepcion ExcepcionNoHaySudokuConCaracteristicasSeleccionada
		 */
		return new Vector<DTOPartidaAMedias>(); //Esta linea esta solo para que no pete por faltar un return
	}

	public Vector<DTOSudokuDeLaBD> obtenerSudokusDeLaBD(tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 crear un vector de tipo Vector<DTOSudokuDeLaBD>,
		 que contiene todos los sudokus de la base de datos (que no son partidas a medias) con dificultad "dificultad" y con la n "n".
		 Si al final de la funcion, antes del return, el vector no contiene ningun elemento, hay que activar la excepcion ExcepcionNoHaySudokuConCaracteristicasSeleccionada
		 */
		return new Vector<DTOSudokuDeLaBD>(); //Esta linea esta solo para que no pete por faltar un return
	}
	
	//AUN NO SE QUE TENDRA QUE HACER Y DEVOLVER ESTA FUNCION EXACTAMENTE
	public void obtenerSudokuGenerado(String nombreUsuario, tipoDificultad dificultad, int n) throws ExcepcionMaquinaNoGeneraTriviales{
		//AUN NO SE QUE TENDRA QUE HACER Y DEVOLVER ESTA FUNCION EXACTAMENTE
		//PERO LO QUE ES SEGURO: Si "dificultad" es del tipo "trivial", activa la excepcion ExcepcionMaquinaNoGeneraTriviales
	}
	
	public void proponerNuevoSudoku(String nombreUsuario, String nombreSudoku, Vector<DTOCeldaFija> celdasFijas) throws ExcepcionSudokuYaExiste{
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 Si ya existe un Sudoku con el nombre "nombreSudoku", se activa la excepcion ExcepcionSudokuYaExiste, si no:
		 Crea un Sudoku con el nombre "nombreSudoku", que tenga de autor "nombreUuario"
		 el tablero y las regiones se crean a partir de las celdas de "celdasFijas" (todo eso se hace desde su TaulerSudoku y te puedes orientar con la clase DriverPartidaUsuario que hacia algo parecido)
		 crea la partida con el usuario "nombreUsuario" y el sudoku recien creado y la guarda como variable local en "partida"
		 */
	}
	
	
	
	
}
