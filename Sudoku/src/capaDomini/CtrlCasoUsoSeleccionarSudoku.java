package capaDomini;

//ACABADO PERO NO TESTEADO

import persistencia.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import DataTransferObjects.*;
import excepciones.*;
import capaDomini.Partida;

public class CtrlCasoUsoSeleccionarSudoku {
	private Partida p;
	
	public CtrlCasoUsoSeleccionarSudoku() {
		CtrlUser.init();
		CtrlJocSudoku.init();
		CtrlPartida.init();
	}
	
	public Vector<DTOPartidaAMedias> obtenerPartidas(String nombreUsuario, tipoDificultad dificultad, int n) throws ExcepcionNoHaySudokuConCaracteristicasSeleccionadas{
		Vector<DTOPartidaAMedias> V = new Vector<DTOPartidaAMedias>();
		
		//CtrlJocSudoku.init(); //aqui
		//CtrlPartida.init();
		ArrayList<Partida> A = CtrlPartida.getTaula();
		int nn=n*n;
		for(Partida p : A ){
			if(Objects.equals(p.getUsuario().getUsername(),nombreUsuario) && p.getJocSudoku().getDificultad()==dificultad && p.getJocSudoku().getTauler().getAncho()==nn){
				//partidas del usuario nombreUsuario dificultad dificultad y n n
			
				int s=p.getSegundos();
				int m=p.getMinutos();
				int h=p.getHoras();		
				DTOTiempo t = new DTOTiempo (s,m,h);
				String id=p.getJocSudoku().getId();
				Date d=p.getDataIni();
				DTOPartidaAMedias aux = new DTOPartidaAMedias(id,d, t, p.getNumPistas());
				if(!p.getResuelto()) V.add(aux); //if(no resuelto) V.add
			}
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
		
		//CtrlJocSudoku.init();
		ArrayList<JocSudoku> A = CtrlJocSudoku.getTaula();
		int nn=n*n;
		for(JocSudoku j : A){
			if(j.getDificultad()==dificultad && j.getTauler().getAncho()==nn){ //jocs de dificultad dificultad i n n
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
		
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy,HH:mm:ss");
		String idSudoku = nombreUsuario + df.format(date).toString();
		
		JocSudoku j = new JocSudoku(idSudoku, t, tsol); 
		
		User u = CtrlUser.getUsuari(nombreUsuario);
		p = new Partida(u,j);
		
		//CtrlJocSudoku.init();
		CtrlJocSudoku.afegeixJocSudoku(j, idSudoku); //afegir sudoku
		CtrlJocSudoku.end();
		
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
		//CtrlJocSudoku.init();
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
		//CtrlJocSudoku.init();
		CtrlJocSudoku.afegeixJocSudoku(js, nombreUsuario);//guardar
		CtrlJocSudoku.end();
		User u = CtrlUser.getUsuari(nombreUsuario);
		p = new Partida(u,js); //Crear Partida		
		
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
	
	public Vector<DTOCeldaFija> obtenerSudoku(String nomSudoku, String nomUsuari) throws ExcepcionTimerYaEnEjecucion, ExcepcionPosicionFueraRango {
		/*
		 Obtiene el sudoku de la BD, empieza la partida y devuelve sus celdas fijas
		 */
		JocSudoku js = CtrlJocSudoku.getJocSudoku(nomSudoku);
		User u = CtrlUser.getUsuari(nomUsuari);
		p = new Partida(u, js);
		
		Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
		TaulerSudoku ts = (TaulerSudoku) js.getTauler();
		for (int i = 0; i < ts.alto; ++i) {
			for (int j = 0; j < ts.ancho; ++j) {
				if (ts.estaFija(i, j)) vCeldasFijas.addElement(new DTOCeldaFija(i, j, ts.getNumero(i, j)));
			}
		}
		
		return vCeldasFijas;
	}
	
	public Vector<DTOInfoCelda> obtenerDatosPartida(String nomSudoku, String nomUsuari) {
		//POR HACER
		return new Vector<DTOInfoCelda>();
	}
	
	public int getNSudoku(String nomSudoku){
		JocSudoku js = CtrlJocSudoku.getJocSudoku(nomSudoku);
		TaulerSudoku ts = (TaulerSudoku) js.getTauler();
		return ts.getN();
	}
	
	public DTOCeldaFija pedirPista() throws ExcepcionNoQuedanCeldasVacias, ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable, ExcepcionTimerYaEstaParado, ExcepcionPartidaYaAcabada{
		if (p.getResuelto()) throw new ExcepcionPartidaYaAcabada();
		DTOCeldaFija celdaNueva = p.pedirPista();
		if (p.getJocSudoku().getTauler().getNumCeldasRellenas() == p.getJocSudoku().getTauler().getNumCeldas()) acabarPartida();
		return celdaNueva;
	}
	
	public Vector<DTOCeldaFija> resuelveSistema(int nn) throws ExcepcionPosicionFueraRango, ExcepcionTimerYaEstaParado, ExcepcionPartidaYaAcabada{
		if (p.getResuelto()) throw new ExcepcionPartidaYaAcabada();
		TaulerSudoku ts = p.getJocSudoku().getTaulerResuelto();
		Vector<DTOCeldaFija> vCeldasSudoku = new Vector<DTOCeldaFija>();
		for (int i = 0; i < nn; ++i) {
			for (int j = 0; j < nn; ++j) {
				DTOCeldaFija celdaSudoku;
				celdaSudoku = new DTOCeldaFija(i,j,ts.getNumero(i, j));
				vCeldasSudoku.addElement(celdaSudoku);
			}
		}
		acabarPartida();
		return vCeldasSudoku;
	}
	
	public boolean partidaAcabada() {
		return p.getResuelto();
	}
	
	public void acabarPartida() throws ExcepcionTimerYaEstaParado {
		p.pauseTiempo();
		p.yaResuelto();
	}
	
	public Date guardarPartida() throws ExcepcionPartidaYaAcabada {
		if (p.getResuelto()) throw new ExcepcionPartidaYaAcabada();
		//CtrlPartida.init();
		CtrlPartida.afegeixPartida(p,p.getJocSudoku().getId()); //Guarda partida en la bd
		CtrlPartida.end();
		return new Date();
	}
	
	public boolean esValorCelda(int i, int j, int val) throws ExcepcionPosicionFueraRango {
		TaulerSudoku ts = (TaulerSudoku) p.getJocSudoku().getTauler();
		if (ts.estaVacia(i, j)) return false;
		return (ts.getNumero(i, j) == val);
	}
	
	public void anadirValorCelda(int i, int j, int val) throws ExcepcionCasillaBloqueada, ExcepcionPosicionFueraRango, ExcepcionValorFueraRango, ExcepcionNumeroFijo, ExcepcionValorYaPuesto, ExcepcionCasillaVaciaNoFijable, ExcepcionTimerYaEstaParado{
		TaulerSudoku ts = (TaulerSudoku) p.getJocSudoku().getTauler();
		if (!ts.estaVacia(i, j)) ts.borraNumCelda(i,j);
		ts.setNumCelda(i,j,val,false);
		for (int z = 1; z <= ts.getNN(); ++z) {
			p.desmarcarNumero(i, j, z);
		}
		if (ts.getNumCeldas() == ts.getNumCeldasRellenas()) acabarPartida();
	}
	
	public void quitarValorCelda(int i, int j) throws ExcepcionValorFueraRango, ExcepcionPosicionFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada {
		TaulerSudoku ts = (TaulerSudoku) p.getJocSudoku().getTauler();
		if (!ts.estaVacia(i, j)) ts.borraNumCelda(i,j);
		for (int z = 1; z <= ts.getNN(); ++z) {
			p.desmarcarNumero(i, j, z);
		}
	}
	
	public void anadirMarca(int i, int j, int val) throws ExcepcionPosicionFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada, ExcepcionValorFueraRango{
		p.marcarNumero(i, j, val);
		TaulerSudoku ts = (TaulerSudoku) p.getJocSudoku().getTauler();
		if (!ts.estaVacia(i, j)) ts.borraNumCelda(i,j);
	}
	
	public void quitarMarca(int i, int j, int val) throws ExcepcionValorFueraRango{
		p.desmarcarNumero(i, j, val);
	}
	
	public boolean estaMarca(int i, int j, int val) throws ExcepcionValorFueraRango {
		return p.estaMarcado(i, j, val);
	}
	
	public void vaciarTablero() throws ExcepcionValorFueraRango, ExcepcionPosicionFueraRango, ExcepcionNumeroFijo, ExcepcionCasillaBloqueada, ExcepcionPartidaYaAcabada {
		if (partidaAcabada()) throw new ExcepcionPartidaYaAcabada();
		TaulerSudoku ts = (TaulerSudoku) p.getJocSudoku().getTauler();
		int nn = ts.getNN();
		for (int i = 0; i < nn; ++i) {
			for (int j = 0; j < nn; ++j) {
				if (!ts.estaFija(i, j)) {quitarValorCelda(i, j);}
			}
		}
	}
	
	public DTOTiempo tiempoResolviendo() {
		return new DTOTiempo(p.getSegundos(), p.getMinutos(), p.getHoras());
	}
	
	public DTOTiempo tiempoPenalizaciones() {
		int nPistas = p.getNumPistas();
		int minutos = (nPistas*10);
		int horas = 0;
		if (minutos >= 60) {
			horas = (minutos/60);
			minutos = (minutos%60);
			if (horas >= 24) {horas = 0;} //No contamos dias porque suponemos que siempre sera menor a 1 dia, pero mejor poner esto por si acaso, que por lo menos no muestre algo raro
		}
		return new DTOTiempo(0, minutos, horas);
	}
	
	public DTOTiempo tiempoTotal(DTOTiempo tiempoResolviendo, DTOTiempo tiempoPenalizaciones) {
		int segundos = tiempoResolviendo.getSegundos() + tiempoPenalizaciones.getSegundos();
		int minutos = tiempoResolviendo.getMinutos() + tiempoPenalizaciones.getMinutos();
		int horas = tiempoResolviendo.getHoras() + tiempoPenalizaciones.getHoras();
		if (segundos >= 60) {minutos += (segundos/60); segundos = (segundos%60);}
		if (minutos >= 60) {horas += (minutos/60); minutos = (minutos%60);}
		if (horas >= 24) {horas = 0;} //No contamos dias porque suponemos que siempre sera menor a 1 dia, pero mejor poner esto por si acaso, que por lo menos no muestre algo raro
		DTOTiempo tiempoTotal = new DTOTiempo(segundos, minutos, horas);
		return tiempoTotal;
	}
	
}