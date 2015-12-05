package capaPresentacion;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import excepciones.ExcepcionValorFueraRango;

public class JFrameProponerSudoku4x4 extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int nn;
	private int anchoPantalla;
	private Vector<JTextField> vCeldas;
	
	private JPanel panSudoku;
	private JPanel panProponerSudoku;
	private JButton butJugarSudoku;
	private JButton butVolverMenuSudoku;
	private JButton butSalir;
	private JLabel labMensError;
	private JPanel panNombreSudoku;
	private JLabel labNombreSudoku;
	private JTextField tfNombreSudoku;
	
	public JFrameProponerSudoku4x4() {
		initComponents();
	}
	
	public String getNombreSudoku(){
		return tfNombreSudoku.getText();
	}
	
	//fila y columna van de 0 a nn-1
	//valor 0 significa vacio
	public int getValorCelda(int fila, int columna) throws ExcepcionValorFueraRango{
		int valor = -1;
		try{
			JTextField tfCelda = vCeldas.get((fila*nn)+columna);
			String strValor = tfCelda.getText();
			if (!strValor.isEmpty()) valor = Integer.parseInt(strValor);
			else valor = 0;
	        if ((!strValor.isEmpty()) && (valor < 1 || valor > nn)) throw (new ExcepcionValorFueraRango());
	    }catch(NumberFormatException e){
	        throw (new ExcepcionValorFueraRango());
	    }
		return valor;
	}

	public JButton getButJugarSudoku() {
		return butJugarSudoku;
	}

	public JButton getButVolverMenuSudoku() {
		return butVolverMenuSudoku;
	}

	public JButton getButSalir() {
		return butSalir;
	}
	
	public int getNN() {
		return nn;
	}

	public void setMensaje(String msj){
		labMensError.setText(msj);
	}

	private void rellenaPanelNombreSudoku() {
		labNombreSudoku = new JLabel("Nombre del sudoku: ");
		labNombreSudoku.setSize(120, 20);
		tfNombreSudoku = new JTextField("");
		tfNombreSudoku.setSize(120, 20);
		
		
		//panNombreSudoku.setBackground(new Color(0, 0, 0));
		//panNombreSudoku.setOpaque(true);
		
		panNombreSudoku.setLayout(new GridLayout(1, 2));
		panNombreSudoku.add(labNombreSudoku);
		panNombreSudoku.add(tfNombreSudoku);
		
		int location1 = (anchoPantalla-(120*2))/2;
		labNombreSudoku.setLocation(location1, 0);
		tfNombreSudoku.setLocation(location1+labNombreSudoku.getWidth()+2, 0);
	}

	private void rellenaPanelSudoku() {
		int n  = 2;
		nn=4;
		panSudoku.setBackground(new Color(0, 0, 0));
		panSudoku.setOpaque(true);
		//panSudoku.setLayout(new GridLayout(nn, nn));
		//panSudoku.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
		
		int espReg = 3;
		vCeldas = new Vector<JTextField>();
		for (int i = 0; i < nn; ++i){
			for (int j = 0; j < nn; ++j){
				//int valTemp = (i*nn)+j+1;  //i + "" + j
				JTextField tfAux = new JTextField("");
				tfAux.setName("tf"+i+j);
				tfAux.setSize(40, 40);
				tfAux.setFont(new Font("Tahoma", 0, 24));
				tfAux.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				tfAux.setHorizontalAlignment(JTextField.CENTER);
				
				int espacioJ = 0;
				int espacioI = 0;
				
				espacioJ = espReg * (j/n+1);
				espacioI = espReg * (i/n+1);
				
				tfAux.setLocation(j*40+espacioJ, i*40+espacioI);
				
				vCeldas.addElement(tfAux);
				panSudoku.add(tfAux);
			}
		}
		
	}
	
	private void initComponents() {
		setTitle("Proponer Sudoku");
		anchoPantalla = 360;
		setSize(anchoPantalla,378); //ancho por alto
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
		panProponerSudoku = new JPanel();
		panNombreSudoku = new JPanel();
        panSudoku = new JPanel();
        labMensError = new JLabel("");
        butJugarSudoku = new JButton("Jugar Sudoku");
        butVolverMenuSudoku = new JButton("Volver al menu Sudoku");
        butSalir = new JButton("Salir");
		
		labMensError.setHorizontalAlignment(JLabel.CENTER);
		labMensError.setVerticalAlignment(JLabel.CENTER);
		
		rellenaPanelSudoku();
		rellenaPanelNombreSudoku();
		
		panSudoku.setPreferredSize(new Dimension(169, 169));

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
        
        GroupLayout panNombreSudokuLayout = new GroupLayout(panNombreSudoku);
        panNombreSudoku.setLayout(panNombreSudokuLayout);
        panNombreSudokuLayout.setHorizontalGroup(
            panNombreSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panNombreSudokuLayout.setVerticalGroup(
            panNombreSudokuLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        GroupLayout panProponerSudokuLayout = new GroupLayout(panProponerSudoku);
        panProponerSudoku.setLayout(panProponerSudokuLayout);
        panProponerSudokuLayout.setHorizontalGroup(
            panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addComponent(butVolverMenuSudoku)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butSalir))
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(butJugarSudoku)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labMensError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panNombreSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panProponerSudokuLayout.setVerticalGroup(
            panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panNombreSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(butJugarSudoku)
                .addGap(18, 18, 18)
                .addGroup(panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butVolverMenuSudoku)
                    .addComponent(butSalir)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panProponerSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panProponerSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
		
		add(panProponerSudoku);
	}


	
}
