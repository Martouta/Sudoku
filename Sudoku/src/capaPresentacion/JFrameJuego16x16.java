package capaPresentacion;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import DataTransferObjects.DTOCeldaFija;
import DataTransferObjects.DTOTiempo;

public class JFrameJuego16x16 extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int n;
	private int nn;
	private int numeroPistas;
	private Vector<DTOCeldaFija> vCeldasFijas;
	private boolean modoActivo = false; //false (0) = valor / true (1) = marcas
	private int fActiva;
	private int cActiva;
	
	private JPanel panPrincipal;
    private JPanel panSudoku;
    private Vector<JPanel> vPanCeldas;
    private boolean[][] esCeldaFija;
    private JLabel[][][] vLabMarcas;
    private JLabel[][] vLabValores;
    private JPanel[][][] vPanCelVM;
    private Vector<JButton> vButOpciones;
    private JLabel labTiempos;
    
    private JButton butActivarDesModoEdicion;
    private JButton butGuardarPartida;
    private JButton butMostrarTiempos;
    private JButton butPedirPista;
    private JButton butResuelveSistema;
    private JButton butSalir;
    private JButton butVaciarTablero;
    private JButton butVolverMenuSudoku;
    private JLabel labMensError;
    private JLabel labModoEdicion;
    private JLabel labNumeroPistas;
    private JPanel panOpciones;
    private JPanel panTiempos;
    private JScrollPane spJugar;
    private JPanel panJugar;
    private JPanel panBotonesFuera;
	
	public JFrameJuego16x16(Vector<DTOCeldaFija> vCeldasFijas, String nombreSudoku) {
		numeroPistas = fActiva = cActiva = 0;
		this.vCeldasFijas = vCeldasFijas;
		initComponents(nombreSudoku);
		ponerCeldasFijas();
	}
	
	
	public Vector<JButton> getVButOpciones() {
		return vButOpciones;
	}
	
	public Vector<JPanel> getVPanCeldas() {
		return vPanCeldas;
	}
	
	public void setMensaje(String msj){
		labMensError.setText(msj);
	}
	
	public int getN() {
		return n;
	}

	public int getNN() {
		return nn;
	}

	public int getNumeroPistas() {
		return numeroPistas;
	}
	
	public int getNumeroCeldasFijas() {
		return vCeldasFijas.size();
	}

	public boolean getModoActivo() {
		return modoActivo;
	}

	public JButton getButActivarDesModoEdicion() {
		return butActivarDesModoEdicion;
	}

	public JButton getButGuardarPartida() {
		return butGuardarPartida;
	}

	public JButton getButMostrarTiempos() {
		return butMostrarTiempos;
	}

	public JButton getButPedirPista() {
		return butPedirPista;
	}

	public JButton getButResuelveSistema() {
		return butResuelveSistema;
	}

	public JButton getButSalir() {
		return butSalir;
	}

	public JButton getButVaciarTablero() {
		return butVaciarTablero;
	}

	public JButton getButVolverMenuSudoku() {
		return butVolverMenuSudoku;
	}

	private void initComponents(String nombreSudoku) {
		nn = 16;
		n = 4;
		setTitle("Jugar Sudoku: " + nombreSudoku);
		setSize(890,506); //ancho por alto
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        panPrincipal = new JPanel();
        panSudoku = new JPanel();
        panOpciones = new JPanel();
        panTiempos = new JPanel();
        butPedirPista = new JButton("Pedir pista");
        butActivarDesModoEdicion = new JButton("Activar modo edicion de marcas");
        butMostrarTiempos = new JButton("Mostrar tiempos");
        butVaciarTablero = new JButton("Vaciar tablero");
        butResuelveSistema = new JButton("Resuelve sistema");
        butGuardarPartida = new JButton("Guardar partida");
        labMensError = new JLabel("");
        labNumeroPistas = new JLabel("Numero de pistas: " + numeroPistas);
        labModoEdicion = new JLabel("Modo activo: Edicion de casillas");
        butVolverMenuSudoku = new JButton("<html>Volver al Menu Sudoku (No se guardaran los cambios)</html>");
        butSalir = new JButton("<html>Salir (No se guardaran los cambios)");
        spJugar = new JScrollPane();
        panJugar = new JPanel();
        panBotonesFuera = new JPanel();
        
        labMensError.setHorizontalAlignment(SwingConstants.CENTER);

        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        panPrincipal.setPreferredSize(new Dimension(890, 506));
        
        spJugar.setPreferredSize(new Dimension(500, 400));

        GroupLayout panJugarLayout = new GroupLayout(panJugar);
        panJugar.setLayout(panJugarLayout);
        panJugarLayout.setHorizontalGroup(
            panJugarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        panJugarLayout.setVerticalGroup(
            panJugarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        spJugar.setViewportView(panJugar);

        panBotonesFuera.setMaximumSize(new Dimension(500, 100));
        panBotonesFuera.setMinimumSize(new Dimension(500, 100));


        GroupLayout panBotonesFueraLayout = new GroupLayout(panBotonesFuera);
        panBotonesFuera.setLayout(panBotonesFueraLayout);
        panBotonesFueraLayout.setHorizontalGroup(
            panBotonesFueraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesFueraLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(panBotonesFueraLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(butSalir, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butVolverMenuSudoku, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panBotonesFueraLayout.setVerticalGroup(
            panBotonesFueraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesFueraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butVolverMenuSudoku, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butSalir, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        butPedirPista.setPreferredSize(new Dimension(150, 40));
        butActivarDesModoEdicion.setPreferredSize(new Dimension(150, 50));
        butVaciarTablero.setPreferredSize(new Dimension(150, 40));
        butResuelveSistema.setPreferredSize(new Dimension(150, 50));
        butGuardarPartida.setPreferredSize(new Dimension(150, 40));
        labMensError.setPreferredSize(new Dimension(357, 60));
        labNumeroPistas.setPreferredSize(new Dimension(227, 30));
        labModoEdicion.setPreferredSize(new Dimension(227, 30));

        GroupLayout panTiemposLayout = new GroupLayout(panTiempos);
        panTiempos.setLayout(panTiemposLayout);
        panTiemposLayout.setHorizontalGroup(
            panTiemposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panTiemposLayout.setVerticalGroup(
            panTiemposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout panPrincipalLayout = new GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(spJugar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panBotonesFuera, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(butPedirPista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butActivarDesModoEdicion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butMostrarTiempos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(butVaciarTablero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butResuelveSistema, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butGuardarPartida, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labNumeroPistas, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labModoEdicion, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addComponent(panTiempos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addComponent(spJugar, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panBotonesFuera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butPedirPista, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butVaciarTablero, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(butResuelveSistema, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butActivarDesModoEdicion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(butMostrarTiempos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butGuardarPartida, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labNumeroPistas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labModoEdicion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panTiempos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        
        rellenarPanelJugar();
        rellenarPanelTiempos();
        rellenarPanelOpciones();
        rellenarPanelSudoku();
		add(panPrincipal);
	}
	
	
	private void rellenarPanelJugar() {
		panJugar.setPreferredSize(new Dimension(1055, 982));//panJugar.setPreferredSize(new Dimension(1200, 1100));
		
		panSudoku.setPreferredSize(new Dimension(975, 975)); //new Dimension(1100, 1200)
		panSudoku.setLayout(null);
		panOpciones.setPreferredSize(new Dimension(75, 975));
		panJugar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panSudoku.setLocation(0,0);
		JPanel panProva = new JPanel();
		panProva.setLayout(new BorderLayout());
		panProva.add(panSudoku, BorderLayout.CENTER);
		panProva.add(panOpciones, BorderLayout.EAST);
		panJugar.add(panProva);
	}
	
	private void rellenarPanelTiempos() {
		labTiempos = new JLabel("");
	    panTiempos.add(labTiempos);
	}
	
	private void rellenarPanelOpciones() {
		vButOpciones = new Vector<JButton>();
		panOpciones.setVisible(true);
		panOpciones.setLayout(null);
		Insets insets = panOpciones.getInsets();
		int tam = 60;
		int espReg = 3;
		for (int i = 0; i < nn; ++i) {
			JButton butAux = new JButton((i+1) + "");
			butAux.setFont(new Font("Tahoma", Font.PLAIN, 10));
			butAux.setName("butOpc" + i);
			//butAux.setPreferredSize(new Dimension(60, tam));
			//butAux.setLocation(15, locI);
			int espacioI = insets.top + espReg * (i/n+1);
			butAux.setBounds(7 + insets.left, i*60+espacioI, 60, tam);
			//butAux.setBounds(0,locI,40,60);
			butAux.setVisible(false);
			vButOpciones.addElement(butAux);
			panOpciones.add(butAux);
			//VOY POR AQUI
		}
	}

	private void rellenarPanelSudoku() {
		vLabMarcas = new JLabel[nn][nn][nn];
		vLabValores = new JLabel[nn][nn];
		vPanCelVM = new JPanel[nn][nn][2];
		esCeldaFija = new boolean[nn][nn];
		int espReg = 3;
		panSudoku.setBackground(new Color(0, 0, 0));
		panSudoku.setOpaque(true);
		Insets insets = panSudoku.getInsets();
		vPanCeldas = new Vector<JPanel>();
		for (int i = 0; i < nn; ++i) {
			String strFila;
			if (i < 10) strFila = "0" + i;
			else strFila = i + "";
			for (int j = 0; j < nn; ++j) {
				JPanel panAux = new JPanel();
				String strColumna;
				if (j < 10) strColumna = "0" + j;
				else strColumna = j + "";
				panAux.setName("panCella" + strFila + strColumna);
				panAux.setBorder(BorderFactory.createLineBorder(Color.black));
				//panAux.setPreferredSize(new Dimension(60, 60));
				panAux.setName("panCelda" + strFila + "" + strColumna);
				rellenarLabelsPanel(panAux,i,j);
				int espacioJ = insets.left + espReg * (j/n+1);
				int espacioI = insets.top + espReg * (i/n+1);
				//panAux.setLocation(j*60+espacioJ, i*60+espacioI);
				panAux.setBounds(j*60+espacioJ, i*60+espacioI, 60, 60);
				vPanCeldas.addElement(panAux);
				panSudoku.add(panAux);
			}
		}
	}

	private void rellenarLabelsPanel(JPanel panAux, int i, int j) {
		esCeldaFija[i][j] = false;
		JPanel panValor = new JPanel();
		JPanel panMarcas = new JPanel();
		panMarcas.setSize(new Dimension(60, 60));
		panMarcas.setLayout(new GridLayout(n, n));
		vPanCelVM[i][j][0] = panValor;
		vPanCelVM[i][j][1] = panMarcas;
		panAux.add(panValor);
		panValor.setVisible(false);
		panAux.add(panMarcas);
		panMarcas.setName("panMarcas" + i + "" + j);
		panValor.setName("panValor" + i + "" + j);
		
		/*panValor.setVisible(true);
		panMarcas.setVisible(false);
		panValor.setPreferredSize(new Dimension(50, 50));
		panValor.setBackground(new Color(255, 233, 28));
		panValor.setOpaque(true);*/
		
		JLabel labValor = new JLabel("");
		labValor.setSize(new Dimension(40, 40));//60,60
		labValor.setLocation(0,0);
		labValor.setFont(new Font("Tahoma", 0, 24));//19
		vLabValores[i][j] = labValor;
		panValor.add(labValor);
		//int zf = 0;
		//int zc = 0;
		//int dim = 60/n;
		
		
		/*String nombreCelda = panAux.getName();
		String strFila = nombreCelda.substring(8, 10);
		String strColu = nombreCelda.substring(10, 12);
		panValor.setVisible(true);
		panMarcas.setVisible(false);
		labValor.setText(strFila+"-"+strColu);*/
		
		for (int z = 0; z < nn; ++z) {
			//zf = z / n;
			//zc = z % n;
			JLabel labAux = new JLabel("");
			//labAux.setSize(new Dimension(dim, dim));
			labAux.setFont(new Font("Tahoma", 0, 9));
			labAux.setForeground(new Color(60, 60, 60));
			//labAux.setBackground(new Color(255, 255, 0));
			/*labAux.setText(panAux.getName());*//*labAux.setText("  ");*/labAux.setText((z+1) + " ");
			vLabMarcas[i][j][z] = labAux;
			panMarcas.add(labAux);
		}
	}
	
	public void ponerValorCasilla(int i, int j, int val) {
		quitarMarcasCasilla(i, j); //oculta panel marcas + quita el valor a los labels de las marcas
		vLabValores[i][j].setText(val + ""); //pone valor al label
		vPanCelVM[i][j][0].setVisible(true); //muestra panel valor
	}
	
	public void ponerMarcaCasilla(int i, int j, int val) {
		vLabValores[i][j].setText("");
		vPanCelVM[i][j][0].setVisible(false); //oculta panel valor
		vLabMarcas[i][j][val-1].setText(val + " ");
		vPanCelVM[i][j][1].setVisible(true); //muestra panel marcas
	}
	
	public void quitarMarcaCasilla(int i, int j, int val){
		vPanCelVM[i][j][0].setVisible(false); //oculta panel valor
		vLabMarcas[i][j][val-1].setText("  ");
		vPanCelVM[i][j][1].setVisible(true); //muestra panel marcas
	}
	
	private void quitarMarcasCasilla(int i, int j){
		vPanCelVM[i][j][1].setVisible(false);
		for (int z = 0; z < nn; ++z) {
			vLabMarcas[i][j][z].setText("  ");
		}
	}
	
	private void ponerCeldasFijas(){
		for (DTOCeldaFija celdaFija : vCeldasFijas) {
			int i = celdaFija.getFila();
			int j = celdaFija.getColumna();
			esCeldaFija[i][j] = true;
			ponerValorCasilla(i,j,celdaFija.getValor());
			vLabValores[i][j].setForeground(new Color(160, 160, 60));
		}
	}
	
	public void cambiarModoActivo() {
		if (modoActivo) {modoActivo = false; labModoEdicion.setText("Modo activo: Edicion de casillas"); butActivarDesModoEdicion.setText("Activar modo edicion de marcas");}
		else {modoActivo = true; labModoEdicion.setText("Modo activo: Edicion de marcas"); butActivarDesModoEdicion.setText("Activar modo edicion de casillas");}
	}
	
	public void nuevaPista(int i, int j, int val) { //DUDA: esta casilla la marco como fija? de momento la pongo no fija (hay que ser consistentes con como esta guardada esta casilla en Cella.java)
		ponerValorCasilla(i,j,val);
		vLabValores[i][j].setForeground(new Color(100, 40, 160));
		++numeroPistas;
		labNumeroPistas.setText("Numero de pistas: " + numeroPistas);
		//Calcular tiempo penalizacion? o que lo haga la otra ventana
	}
	
	public boolean esCeldaFija(int i, int j){
		return esCeldaFija[i][j];
	}
	
	public boolean estaVacia(int i, int j) {
		return (vLabValores[i][j].getText() == "");
	}
	
	private void colorearInterno(int i, int j, Color color) {
		JPanel panCelda = vPanCeldas.get(i*nn + j);
		panCelda.setBackground(color);
		panCelda.setOpaque(true);
		
		vPanCelVM[i][j][0].setOpaque(true);
		vPanCelVM[i][j][0].setBackground(color);
		vPanCelVM[i][j][1].setOpaque(true);
		vPanCelVM[i][j][1].setBackground(color);
		
		vLabValores[i][j].setOpaque(true);
		vLabValores[i][j].setBackground(color);
		for (int z = 0; z < nn; ++z) {
			vLabMarcas[i][j][z].setOpaque(true);
			vLabMarcas[i][j][z].setBackground(color);
		}
	}
	
	private void descolorearTodo() {
		for (int i = 0; i < nn; ++i) {
			for (int j = 0; j < nn; ++j) {
				descolorearCasilla(i,j);
			}
		}
	}
	
	public void colorearCasillaActiva(int i, int j) {
		descolorearTodo();
		Color color = new Color(98, 255, 151);
		colorearInterno(i,j,color);
	}
	
	public void descolorearCasilla(int i, int j) {
		Color color = new Color(238, 238, 238);
		colorearInterno(i,j,color);
	}
	
	public void colorearCasillaInvalida(int i, int j) {
		descolorearTodo();
		Color color = new Color(255, 98, 98);
		colorearInterno(i,j,color);
	}
	
	public void quitarValorCasilla(int i, int j) {
		quitarMarcasCasilla(i, j); //oculta panel marcas + quita el valor a los labels de las marcas
		vLabValores[i][j].setText(""); //pone valor al label
		vPanCelVM[i][j][0].setVisible(true); //muestra panel valor
	}
	
	public void guardarCoordenadasActivas(int i, int j) {
		fActiva = i;
		cActiva = j;
	}
	
	public void activarPanelOpciones(){
		//panOpciones.setVisible(true);
		for (JButton butAux : vButOpciones) {
			butAux.setVisible(true);
		}
	}
	
	public void desactivarPanelOpciones(){
		//panOpciones.setVisible(false);
		for (JButton butAux : vButOpciones) {
			butAux.setVisible(false);
		}
	}
	
	public int getFilaActiva(){
		return fActiva;
	}
	
	public int getColumnaActiva(){
		return cActiva;
	}
	
	public void vaciarTablero() {
		for (int i = 0; i < nn; ++i) {
			for (int j = 0; j < nn; ++j) {
				if (!esCeldaFija[i][j]) quitarValorCasilla(i,j);
			}
		}
	}
	
	public void mostrarTiempos(DTOTiempo tiempoResolviendo, DTOTiempo tiempoPenalizaciones, DTOTiempo tiempoTotal) {
		int intTiempoResolHoras = tiempoResolviendo.getHoras();
		int intTiempoResolMinutos = tiempoResolviendo.getMinutos();
		int intTiempoResolSegundos = tiempoResolviendo.getSegundos();
		String strTiempoResolHoras = intTiempoResolHoras + "";
		if (intTiempoResolHoras <= 9) strTiempoResolHoras = "0" + intTiempoResolHoras;
		String strTiempoResolMinutos = intTiempoResolMinutos + "";
		if (intTiempoResolMinutos <= 9) strTiempoResolMinutos = "0" + intTiempoResolMinutos;
		String strTiempoResolSegundos = intTiempoResolSegundos + "";
		if (intTiempoResolSegundos <= 9) strTiempoResolSegundos = "0" + intTiempoResolSegundos;
		//---
		int intTiempoPenalHoras = tiempoPenalizaciones.getHoras();
		int intTiempoPenalMinutos = tiempoPenalizaciones.getMinutos();
		int intTiempoPenalSegundos = tiempoPenalizaciones.getSegundos();
		String strTiempoPenalHoras = intTiempoPenalHoras + "";
		if (intTiempoPenalHoras <= 9) strTiempoPenalHoras = "0" + intTiempoPenalHoras;
		String strTiempoPenalMinutos = intTiempoPenalMinutos + "";
		if (intTiempoPenalMinutos <= 9) strTiempoPenalMinutos = "0" + intTiempoPenalMinutos;
		String strTiempoPenalSegundos = intTiempoPenalSegundos + "";
		if (intTiempoPenalSegundos <= 9) strTiempoPenalSegundos = "0" + intTiempoPenalSegundos;
		//---
		int intTiempoTotalHoras = tiempoTotal.getHoras();
		int intTiempoTotalMinutos = tiempoTotal.getMinutos();
		int intTiempoTotalSegundos = tiempoTotal.getSegundos();
		String strTiempoTotalHoras = intTiempoTotalHoras + "";
		if (intTiempoTotalHoras <= 9) strTiempoTotalHoras = "0" + intTiempoTotalHoras;
		String strTiempoTotalMinutos = intTiempoTotalMinutos + "";
		if (intTiempoTotalMinutos <= 9) strTiempoTotalMinutos = "0" + intTiempoTotalMinutos;
		String strTiempoTotalSegundos = intTiempoTotalSegundos + "";
		if (intTiempoTotalSegundos <= 9) strTiempoTotalSegundos = "0" + intTiempoTotalSegundos;
		
		String strHtmlTiempos = "<html><ul><li>Tiempo resolviendo: " + strTiempoResolHoras + ":" + strTiempoResolMinutos + ":" + strTiempoResolSegundos + "</li>";
		strHtmlTiempos = strHtmlTiempos + "<li>Tiempo de penalización: "  + strTiempoPenalHoras + ":" + strTiempoPenalMinutos + ":" + strTiempoPenalSegundos + "</li>";
		strHtmlTiempos = strHtmlTiempos + "<li>Tiempo total: "  + strTiempoTotalHoras + ":" + strTiempoTotalMinutos + ":" + strTiempoTotalSegundos + "</li>";
		
	    Date date = new Date();
	    Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		int intHoraActual = calendar.get(Calendar.HOUR_OF_DAY);
		String strHoraActual = intHoraActual + "";
		if (intHoraActual <= 9) strHoraActual = "0" + strHoraActual;
		int intMinutoActual = calendar.get(Calendar.MINUTE);
		String strMinutoActual = intMinutoActual + "";
		if (intMinutoActual <= 9) strMinutoActual = "0" + strMinutoActual;
		String strTiemposMostradoHora = "<li>Tiempos reales actualizados<br>por ultima vez a las: "+ strHoraActual + ":" + strMinutoActual +"</li>";
		
		strHtmlTiempos = strHtmlTiempos + strTiemposMostradoHora + "</ul></html>";
		labTiempos.setText(strHtmlTiempos);
		
		labTiempos.setSize(labTiempos.getPreferredSize());
		labTiempos.setLocation(0, 20);
	}
	
}
