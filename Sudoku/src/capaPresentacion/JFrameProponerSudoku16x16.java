package capaPresentacion;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class JFrameProponerSudoku16x16 extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int nn;
	private Vector<JTextField> vCeldas;
	
	private JPanel panSudoku;
	private JPanel panProponerSudoku;
	private JButton butJugarSudoku;
	private JButton butVolverMenuSudoku;
	private JButton butSalir;
	private JLabel labMensError;
	
	public JFrameProponerSudoku16x16() {
		initComponents();
	}
	
	private void rellenaPanelSudoku() {
		int n  = 4;
		nn=16;
		panSudoku.setBackground(new Color(0, 0, 0));
		panSudoku.setOpaque(true);
		//panSudoku.setLayout(new GridLayout(nn, nn));
		//panSudoku.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
		
		int espReg = 3;
		vCeldas = new Vector<JTextField>();
		for (int i = 0; i < nn; ++i){
			for (int j = 0; j < nn; ++j){
				int valTemp = (i*nn)+j+1;
				JTextField tfAux = new JTextField(i + "" + j); //deberia estar vacio!!!!! //i + "" + j
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
		setSize(870,700); //ancho por alto
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
            .addGap(0, 655, Short.MAX_VALUE)
        );
        panSudokuLayout.setVerticalGroup(
            panSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
		GroupLayout panProponerSudokuLayout = new GroupLayout(panProponerSudoku);
        panProponerSudoku.setLayout(panProponerSudokuLayout);
        panProponerSudokuLayout.setHorizontalGroup(
            panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(butSalir, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(labMensError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butJugarSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butVolverMenuSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panProponerSudokuLayout.setVerticalGroup(
            panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panProponerSudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProponerSudokuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panProponerSudokuLayout.createSequentialGroup()
                        .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butJugarSudoku, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butVolverMenuSudoku, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(butSalir, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                    .addComponent(panSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panProponerSudoku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panProponerSudoku, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        
		
		add(panProponerSudoku);
	}
	
}
