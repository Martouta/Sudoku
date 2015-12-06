package capaPresentacion;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import DataTransferObjects.DTOCeldaFija;

public class JFrameJuego4x4 extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int n;
	private int nn;
	private Vector<DTOCeldaFija> vCeldasFijas;
	private boolean modoActivo = false; //false (0) = valor / true (1) = marcas
	
	private JPanel panPrincipal;
    private JPanel panSudoku;
    private Vector<JPanel> vPanCeldas;
    private boolean[][] esCeldaFija;
    private JLabel[][][] vLabMarcas;
    private JLabel[][] vLabValores;
    private JPanel[][][] vPanCelVM;
	
	public JFrameJuego4x4(Vector<DTOCeldaFija> vCeldasFijas, String nombreSudoku) {
		this.vCeldasFijas = vCeldasFijas;
		initComponents(nombreSudoku);
		ponerCeldasFijas();
		ponerValorCasilla(1,1,4); //haciendo pruebas
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
            .addGap(0, 169, Short.MAX_VALUE)
        );

        GroupLayout panPrincipalLayout = new GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
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
        
        rellenarPanelSudoku();
        
		add(panPrincipal);
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
				panAux.setSize(new Dimension(40, 40));

				rellenarLabelsPanel(panAux,i,j);
				int espacioJ = espReg * (j/n+1);
				int espacioI = espReg * (i/n+1);
				panAux.setLocation(j*40+espacioJ, i*40+espacioI);
				vPanCeldas.addElement(panAux);
				panSudoku.add(panAux);
			}
		}
	}

	private void rellenarLabelsPanel(JPanel panAux, int i, int j) { //SE TENDRA QUE MODIFICAR PORQUE AUN SE VEN LOS NUMEROS DE LAS MARCAS
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
		panAux.setName("panCelda" + i + "" + j);
		panMarcas.setName("panMarcas" + i + "" + j);
		panValor.setName("panValor" + i + "" + j);
		
		JLabel labValor = new JLabel("");
		labValor.setSize(new Dimension(40, 40));
		labValor.setLocation(0,0);
		labValor.setFont(new Font("Tahoma", 0, 24));
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
			labAux.setOpaque(true);
			labAux.setText(z + " "); //labAux.setText("  ");
			vLabMarcas[i][j][z] = labAux;
			panMarcas.add(labAux);
		}
	}
	
	private void ponerValorCasilla(int i, int j, int val) {
		quitarMarcasCasilla(i, j); //oculta panel marcas + quita el valor a los labels de las marcas
		vLabValores[i][j].setText(val + ""); //pone valor al label
		vPanCelVM[i][j][0].setVisible(true); //muestra panel valor
	}
	
	private void ponerMarcaCasilla(int i, int j, int val) {
		vPanCelVM[i][j][0].setVisible(false); //oculta panel valor
		vLabMarcas[i][j][val-1].setText(val + " ");
		vPanCelVM[i][j][1].setVisible(true); //muestra panel marcas
	}
	
	private void quitarMarcasCasilla(int i, int j){
		vPanCelVM[i][j][1].setVisible(false);
		for (int z = 0; z < nn; ++z) {
			vLabMarcas[i][j][z].setText("");
		}
	}
	
	private void ponerCeldasFijas(){
		//guardarme algo para saber que no es editable (ni el valor ni las marcas)
		for (DTOCeldaFija celdaFija : vCeldasFijas) {
			int i = celdaFija.getFila();
			int j = celdaFija.getColumna();
			esCeldaFija[i][j] = true;
			ponerValorCasilla(i,j,celdaFija.getValor());
			vLabValores[i][j].setForeground(new Color(160, 160, 60));
			//vPanCelVM[i][j][0].setBackground(new Color(230, 230, 230));
			//vPanCelVM[i][j][0].setOpaque(true);
		}
	}
	
	private void cambiarModoActivo() {
		if (modoActivo) {modoActivo = false; /*---mostrar en el label/boton;*/}
		else {modoActivo = true; /*---mostrar en el label/boton;*/};
	}
	
}
