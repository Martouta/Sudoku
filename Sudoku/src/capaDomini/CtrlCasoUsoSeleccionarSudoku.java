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
	
	//PROBLEMAS PARA ESTA FUNCION
	public void proponerNuevoSudoku(String nombreUsuario, Vector<DTOCeldaFija> celdasFijas){
		/*
		Problema: en la ventana aun no hay ningun campo de texto para incluir un nuevo nombre al sudoku, creo que deberia anadirlo
		y en ese caso tendre que anadir bastantes cosas por lo que aun no se podra implementar esta funcion
		 */
		//AUN NO HE PUESTO NI LOS PARAMETROS CORRECTOS NI LAS EXCEPCIONES, PORQUE PRIMERO HAY QUE ACLARAR EL PROBLEMA
	}
	
	
	
	
}
