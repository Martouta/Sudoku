package capaPresentacion;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import DataTransferObjects.DTOCeldaFija;

public class JFrameJuego4x4 extends JFrame{
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
	
	public JFrameJuego4x4(Vector<DTOCeldaFija> vCeldasFijas, String nombreSudoku) {
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
		nn = 4;
		n = 2;
		setTitle("Jugar Sudoku: " + nombreSudoku);
		setSize(650,420); //ancho por alto
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        panPrincipal = new JPanel();
        panSudoku = new JPanel();
        panOpciones = new JPanel();
        butPedirPista = new JButton("Pedir pista");
        butActivarDesModoEdicion = new JButton("Activar modo edicion de marcas");
        butMostrarTiempos = new JButton("Mostrar tiempos");
        butVaciarTablero = new JButton("Vaciar tablero");
        butResuelveSistema = new JButton("Resuelve sistema");
        butGuardarPartida = new JButton("Guardar partida");
        labMensError = new JLabel("");
        labNumeroPistas = new JLabel("Numero de pistas: " + numeroPistas);
        labModoEdicion = new JLabel("Modo activo: Edicion de casillas");
        butVolverMenuSudoku = new JButton("<html>Volver al<br>Menu Sudoku<br>(No se guardaran<br>los cambios)</html>");
        butSalir = new JButton("<html>Salir<br>(No se guardaran<br>los cambios)</html>");
        
        labMensError.setHorizontalAlignment(SwingConstants.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panPrincipal.setMaximumSize(new java.awt.Dimension(650, 420));
        panPrincipal.setMinimumSize(new java.awt.Dimension(650, 420));

        panSudoku.setMaximumSize(new java.awt.Dimension(169, 169));
        panSudoku.setMinimumSize(new java.awt.Dimension(169, 169));

        GroupLayout panSudokuLayout = new GroupLayout(panSudoku);
        panSudoku.setLayout(panSudokuLayout);
        panSudokuLayout.setHorizontalGroup(
            panSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        panSudokuLayout.setVerticalGroup(
            panSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panOpciones.setMaximumSize(new java.awt.Dimension(40, 169));
        panOpciones.setMinimumSize(new java.awt.Dimension(40, 169));

        GroupLayout panOpcionesLayout = new GroupLayout(panOpciones);
        panOpciones.setLayout(panOpcionesLayout);
        panOpcionesLayout.setHorizontalGroup(
            panOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panOpcionesLayout.setVerticalGroup(
            panOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        
        labMensError.setMaximumSize(new java.awt.Dimension(357, 60));
        labMensError.setMinimumSize(new java.awt.Dimension(357, 60));

        labNumeroPistas.setMaximumSize(new java.awt.Dimension(227, 30));
        labNumeroPistas.setMinimumSize(new java.awt.Dimension(227, 30));

        labModoEdicion.setMaximumSize(new java.awt.Dimension(227, 30));
        labModoEdicion.setMinimumSize(new java.awt.Dimension(227, 30));

        butVolverMenuSudoku.setMaximumSize(new java.awt.Dimension(140, 80));
        butVolverMenuSudoku.setMinimumSize(new java.awt.Dimension(140, 80));

        butSalir.setMaximumSize(new java.awt.Dimension(140, 80));
        butSalir.setMinimumSize(new java.awt.Dimension(140, 80));

        GroupLayout panPrincipalLayout = new GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labModoEdicion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, panPrincipalLayout.createSequentialGroup()
                        .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panOpciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(labNumeroPistas, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(butPedirPista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butActivarDesModoEdicion, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(butMostrarTiempos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(butVaciarTablero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butResuelveSistema, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(butGuardarPartida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(labMensError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butVolverMenuSudoku, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butSalir, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(butVaciarTablero, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(butPedirPista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(butResuelveSistema, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(butActivarDesModoEdicion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(butMostrarTiempos, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(butGuardarPartida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panOpciones, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(labNumeroPistas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labModoEdicion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butVolverMenuSudoku, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butSalir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        rellenarPanelOpciones();
        rellenarPanelSudoku();
		add(panPrincipal);
	}
	
	private void rellenarPanelOpciones() {
		vButOpciones = new Vector<JButton>();
		panOpciones.setVisible(false);
		int locI = 3;
		for (int i = 0; i < nn; ++i) {
			JButton butAux = new JButton((i+1) + "");
			butAux.setFont(new Font("Tahoma", Font.PLAIN, 10));
			butAux.setName("butOpc" + i);
			butAux.setSize(40, 40);
			butAux.setLocation(0, locI);
			locI += 40;
			vButOpciones.addElement(butAux);
			panOpciones.add(butAux);
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
				panAux.setSize(new Dimension(40, 40));
				panAux.setName("panCelda" + i + "" + j);
				rellenarLabelsPanel(panAux,i,j);
				int espacioJ = espReg * (j/n+1);
				int espacioI = espReg * (i/n+1);
				panAux.setLocation(j*40+espacioJ, i*40+espacioI);
				vPanCeldas.addElement(panAux);
				panSudoku.add(panAux);
			}
		}
	}

	private void rellenarLabelsPanel(JPanel panAux, int i, int j) {
		esCeldaFija[i][j] = false;
		JPanel panValor = new JPanel();
		JPanel panMarcas = new JPanel();
		panMarcas.setSize(new Dimension(40, 40));
		panMarcas.setLayout(new GridLayout(n, n));
		vPanCelVM[i][j][0] = panValor;
		vPanCelVM[i][j][1] = panMarcas;
		panAux.add(panValor);
		panValor.setVisible(false);
		panAux.add(panMarcas);
		panMarcas.setName("panMarcas" + i + "" + j);
		panValor.setName("panValor" + i + "" + j);
		
		JLabel labValor = new JLabel("");
		labValor.setSize(new Dimension(20, 20));//40,40
		labValor.setLocation(0,0);
		labValor.setFont(new Font("Tahoma", 0, 19));//24
		vLabValores[i][j] = labValor;
		panValor.add(labValor);
		//int zf = 0;
		//int zc = 0;
		int dim = 40/n;
		for (int z = 0; z < nn; ++z) {
			//zf = z / n;
			//zc = z % n;
			JLabel labAux = new JLabel("");
			labAux.setSize(new Dimension(dim, dim));
			labAux.setFont(new Font("Tahoma", 0, 12));
			labAux.setForeground(new Color(60, 60, 60));
			//labAux.setBackground(new Color(255, 255, 0));
			labAux.setText("  ");//labAux.setText((z+1) + " ");
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
	
	public void guardarCoordenadasActivas(int i, int j) {
		fActiva = i;
		cActiva = j;
	}
	
	public void activarPanelOpciones(){
		panOpciones.setVisible(true);
	}
	
	public void desactivarPanelOpciones(){
		panOpciones.setVisible(false);
	}
	
	public int getFilaActiva(){
		return fActiva;
	}
	
	public int getColumnaActiva(){
		return cActiva;
	}
	
	//FALTA VACIAR CELDA CON VALOR PARA QUE PUEDA VOLVER A PONER MARCAS
	
}
