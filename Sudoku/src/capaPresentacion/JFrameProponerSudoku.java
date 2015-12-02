package capaPresentacion;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class JFrameProponerSudoku extends JFrame{
	private int nn;
	private Vector<JTextField> vCeldas;
	
	private JPanel panSudoku;
	private JPanel panProponerSudoku;
	private JButton butJugarSudoku;
	private JButton butVolverMenuSudoku;
	private JButton butSalir;
	private JLabel labMensError;
	
	public JFrameProponerSudoku() {
		initComponents();
	}
	
	private void rellenaPanelSudoku() {
		int n  = 3;
		nn=9;
		panSudoku.setBackground(new Color(0, 0, 0));
		panSudoku.setOpaque(true);
		//panSudoku.setLayout(new GridLayout(nn, nn));
		//panSudoku.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
		
		int espacioRegiones = 3;
		int espacioJ = 0;
		int espacioI = 0;
		vCeldas = new Vector<JTextField>();
		for (int i = 0; i < nn; ++i){
			for (int j = 0; j < nn; ++j){
				int valTemp = (i*nn)+j+1;
				JTextField tfAux = new JTextField(i + "" + j); //deberia estar vacio!!!!!
				tfAux.setName("tf"+i+j);
				tfAux.setSize(40, 40);
				tfAux.setFont(new Font("Tahoma", 0, 24));
				tfAux.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
				tfAux.setHorizontalAlignment(JTextField.CENTER);
				
				if (j%n == 0) espacioJ=espacioRegiones;
				else espacioJ=0;
				
				if (i%n == 0) espacioI=espacioRegiones;
				else espacioI=0;
				
				tfAux.setLocation(j*40+espacioJ, i*40+espacioI);
				
				vCeldas.addElement(tfAux);
				panSudoku.add(tfAux);
			}
		}
		
	}
	
	private void initComponents() {
		setTitle("Proponer Sudoku");
		setSize(430,530); //ancho por alto
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
		panProponerSudoku = new JPanel();
        panSudoku = new JPanel();
        labMensError = new JLabel("123");
        butJugarSudoku = new JButton("Jugar Sudoku");
        butVolverMenuSudoku = new JButton("Volver al menu Sudoku");
        butSalir = new JButton("Salir");
		
		labMensError.setHorizontalAlignment(JLabel.CENTER);
		labMensError.setVerticalAlignment(JLabel.CENTER);
		
		rellenaPanelSudoku();
		
		GroupLayout panSudokuLayout = new GroupLayout(panSudoku);
        panSudoku.setLayout(panSudokuLayout);
        panSudokuLayout.setHorizontalGroup(
            panSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );
        panSudokuLayout.setVerticalGroup(
            panSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );
		
		GroupLayout panProponerSudokuLayout = new GroupLayout(panProponerSudoku);
        panProponerSudoku.setLayout(panProponerSudokuLayout);
        panProponerSudokuLayout.setHorizontalGroup(
            panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addComponent(butVolverMenuSudoku)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butSalir))
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labMensError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, panProponerSudokuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(butJugarSudoku)
                .addGap(164, 164, 164))
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panProponerSudokuLayout.setVerticalGroup(
            panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butJugarSudoku)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panProponerSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
		
		add(panProponerSudoku);
	}
	
}
