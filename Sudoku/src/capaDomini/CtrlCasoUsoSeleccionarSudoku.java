package capaDomini;

//LISTO PARA SER PROGRAMADO

import persistencia.*;
import java.util.*;
import DataTransferObjects.*;
import excepciones.*;
import capaDomini.Partida;

public class CtrlCasoUsoSeleccionarSudoku {
	private Partida p;
	
	public Vector<DTOPartidaAMedias> obtenerPartidas(String nombreUsuario, tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		Vector<DTOPartidaAMedias> V = new Vector<DTOPartidaAMedias>();
		CtrlPartida.init();
		ArrayList<Partida> A = CtrlPartida.getTaula();
		
		for(Partida p : A ){
			if(p.getUsuario().getUsername()==nombreUsuario && p.getJocSudoku().getDificultad()==dificultad && p.getJocSudoku().getTauler().getAncho()==n){
				//partidas del usuario nombreUsuario dificultad dificultad y n n
			}
				int s=p.getSegundos();
				int m=p.getMinutos();
				int h=p.getHoras();		
				DTOTiempo t = new DTOTiempo (s,m,h);
				String id=p.getJocSudoku().getId();
				Date d=p.getDataIni();
				DTOPartidaAMedias aux = new DTOPartidaAMedias(id,d, t, p.getNumPistas());
				if(p.getResuelto()) V.add(aux); //if(no resuelto) V.add
		}
		
		if(V.size()==0) throw new ExcepcionNoHaySudokuConCaracteristicasSeleccionadas();
		
		return V;
		
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 crear un vector de tipo Vector<DTOPartidaAMedias>,
		 que contiene todas las partidas a medias del usuario "nombreUsuario" con dificultad "dificultad" y con la n "n".
		 Si al final de la funcion, antes del return, el vector no contiene ningun elemento, hay que activar la excepcion ExcepcionNoHaySudokuConCaracteristicasSeleccionada
		 
		 */ 
	}

	public Vector<DTOSudokuDeLaBD> obtenerSudokusDeLaBD(tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		
		Vector<DTOSudokuDeLaBD> V = new Vector<DTOSudokuDeLaBD>();
		CtrlJocSudoku.init();
		ArrayList<JocSudoku> A = CtrlJocSudoku.getTaula();
		for(JocSudoku j : A){
			if(j.getDificultad()==dificultad && j.getTauler().getAncho()==n){ //jocs de dificultad dificultad i n n
				String nom = j.getId();
				int c=j.getTauler().getNumCeldasRellenas();
				DTOSudokuDeLaBD aux = new DTOSudokuDeLaBD(nom,c); 
				V.add(aux);
			}
		}
		
		if (V.size()==0) throw new ExcepcionNoHaySudokuConCaracteristicasSeleccionadas();
		return V;
		
		
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 crear un vector de tipo Vector<DTOSudokuDeLaBD>,
		 que contiene todos los sudokus de la base de datos (que no son partidas a medias) con dificultad "dificultad" y con la n "n".
		 Si al final de la funcion, antes del return, el vector no contiene ningun elemento, hay que activar la excepcion ExcepcionNoHaySudokuConCaracteristicasSeleccionadas
		 */
		
	}
	
	public Vector<DTOCeldaFija> obtenerSudokuGenerado(String nombreUsuario, tipoDificultad dificultad, int n) throws ExcepcionMaquinaNoGeneraTriviales, ExcepcionTimerYaEnEjecucion, ExcepcionTamanoIncorrecto, ExcepcionPosicionFueraRango, ExcepcionNumCeldasDiferenteTamano, ExcepcionCasillaBloqueada, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable{
		
		if(dificultad==tipoDificultad.trivial) throw new ExcepcionMaquinaNoGeneraTriviales();
		
		TaulerSudoku t = GeneradorSudoku.generaSudoku2(n,dificultad);
		TaulerSudoku tsol = ResolvedorSudoku.resuelveSudoku3(t); //espero que resuelveSudoku3 no machaque t
		
		//String id = nombreUsuario; //("Your number is " + theNumber + "!");
		
		Date date = new Date();
		String idSudoku = nombreUsuario + date.toString();
		
		JocSudoku j = new JocSudoku(idSudoku, t, tsol); 
		//el ID como se genera? podríamos hacer algun contador o algo, para cada usuario, o para los juegos?
		
		User u = CtrlUser.getUsuari(nombreUsuario);
		p = new Partida(u,j);
		
		CtrlJocSudoku.init();
		CtrlJocSudoku.afegeixJocSudoku(j, idSudoku); //afegir sudoku
		
		CtrlPartida.init();
		CtrlPartida.afegeixPartida(p,idSudoku); //afegir partida. Ha de ser el mateix id oi?
		
		Vector<DTOCeldaFija> V = new Vector<DTOCeldaFija>();
		
		for(int i=0; i < t.getNN(); ++i){
			for(int k=0; k < t.getNN(); ++k){
				if(!t.estaVacia(i, k)){
					DTOCeldaFija aux = new DTOCeldaFija(i,k,t.getNumero(i, k));
					V.add(aux);
				}
			}
		}
		return V;
		
		
		/*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 Si "dificultad" es del tipo "trivial", activa la excepcion ExcepcionMaquinaNoGeneraTriviales, si no:
		 Genera un Sudoku nuevo con la dificultad "dificultad", la n "n", y la partida con este sudoku y el usuario "nombreUsuario".
		 Devuelve las celdas fijas de este sudoku.
		 NUEVO: La partida se guarda tambien en memoria en el atributo "p" privado de esta clase
		 */
		
		//
	}
	
	public void proponerNuevoSudoku(String nombreUsuario, String nombreSudoku, Vector<DTOCeldaFija> celdasFijas, int n) throws ExcepcionSudokuYaExiste, ExcepcionSudokuSinSolucion, ExcepcionSudokuConMasDe1Solucion, ExcepcionTamanoIncorrecto, ExcepcionPosicionFueraRango, ExcepcionNumCeldasDiferenteTamano, ExcepcionCasillaBloqueada, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable, ExcepcionTimerYaEnEjecucion{
		
		CtrlJocSudoku.init();
		JocSudoku j = CtrlJocSudoku.getJocSudoku(nombreSudoku);
		if (!(j == null)) throw new ExcepcionSudokuYaExiste();
		
		
		TaulerSudoku t = new TaulerSudoku(n);
		for(DTOCeldaFija c : celdasFijas){ //introducimos las celdas fijas al sudoku
			t.setNumCelda(c.getFila(), c.getColumna(), c.getValor(), true);
		}
		
		int nSols = ResolvedorSudoku.sols3(t);
		if(nSols<1) throw new ExcepcionSudokuSinSolucion();
		if(nSols>1) throw new ExcepcionSudokuConMasDe1Solucion();
		
		TaulerSudoku tsol = ResolvedorSudoku.resuelveSudoku3(t);
		
		JocSudoku js = new JocSudoku(nombreSudoku,t,tsol); //crear JocSudoku
		CtrlJocSudoku.afegeixJocSudoku(js, nombreUsuario);//guardar
		
		User u = CtrlUser.getUsuari(nombreUsuario);
		Partida P = new Partida(u,js); //Crear Partida
		Date date = new Date();
		String idSudoku = nombreUsuario + date.toString();
		CtrlPartida.afegeixPartida(P,idSudoku); //Guardar Partida
		
		//fet, no provat
		 /*
		 FALTA HACER ESTA FUNCION, LO QUE HACE ES:
		 Si ya existe un Sudoku con el nombre "nombreSudoku", se activa la excepcion ExcepcionSudokuYaExiste, si no:
		 Crea un Sudoku con el nombre "nombreSudoku", que tenga de autor "nombreUuario"
		 el tablero y las regiones se crean a partir de las celdas de "celdasFijas" (todo eso se hace desde su TaulerSudoku y te puedes orientar con la clase DriverPartidaUsuario que hacia algo parecido)
		 NUEVO: La partida se guarda tambien en memoria en el atributo "p" privado de esta clase
		 NUEVO: con "int nSols = ResolvedorSudoku.sols3(TaulerSudoku);" puedes saber cuántas soluciones tiene,
		 	si tiene 0: Activa excepcion "ExcepcionSudokuSinSolucion",
		 	si tiene >1: Activa excepcion "ExcepcionSudokuConMasDe1Solucion".
		 NUEVO: cuando programes este codigo, te irán saliendo "errores de compilacion" que se arreglan haciendo click encima y clicando en "add throws declaration" (para encargarme de esas excepciones en la capa de presentacion)
		 */
	}
	
	public DTOCeldaFija pedirPista() throws ExcepcionNoQuedanCeldasVacias, ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable{
		return p.pedirPista();
	}
}