package capaPresentacion;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;

public class JFrameSeleccionarSudokuBD extends JFrame{
	private int numSudokus;
	private Vector<String> datosARellenar;
	private Vector<String> nombresSudokus;
	private JList listSudokus;
	DefaultListModel demoList = new DefaultListModel();
	private JPanel panMenu;
	
	private JPanel panSelectSudokuBD;
	private JScrollPane scrollPane;
	private JButton butJugarSudoku;
	private JButton butVolverMenuSudoku;
	private JButton butSalir;
	private JLabel labMensError;
	
	public JFrameSeleccionarSudokuBD() {
		initComponents();
	}
	
	private void initComponents() {
numSudokus = 3; //70?
		
		setTitle("Seleccionar sudoku de la base de datos");
		setSize(700,480); //ancho por alto
		setMinimumSize(new Dimension(700, 480));
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
		panSelectSudokuBD = new JPanel();
		panMenu = new JPanel();
		scrollPane = new JScrollPane();
		butJugarSudoku = new JButton("Jugar sudoku");
		butVolverMenuSudoku = new JButton("Volver al Menu Sudoku");
		butSalir = new JButton("Salir");
		labMensError = new JLabel("");
		
		labMensError.setHorizontalAlignment(JLabel.CENTER);
		labMensError.setVerticalAlignment(JLabel.CENTER);
		
		
		GroupLayout jPanel2Layout = new GroupLayout(panMenu);
		panMenu.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        
        scrollPane.setViewportView(panMenu);
        
		
        GroupLayout panSelectSudokuBDLayout = new GroupLayout(panSelectSudokuBD);
        panSelectSudokuBD.setLayout(panSelectSudokuBDLayout);
        panSelectSudokuBDLayout.setHorizontalGroup(
            panSelectSudokuBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
            .addGroup(panSelectSudokuBDLayout.createSequentialGroup()
                .addComponent(butVolverMenuSudoku)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butSalir))
            .addGroup(panSelectSudokuBDLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(butJugarSudoku)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labMensError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panSelectSudokuBDLayout.setVerticalGroup(
            panSelectSudokuBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panSelectSudokuBDLayout.createSequentialGroup()
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butJugarSudoku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panSelectSudokuBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butVolverMenuSudoku)
                    .addComponent(butSalir)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panSelectSudokuBD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSelectSudokuBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        
        rellenarPanelMenu();
        
		
		add(panSelectSudokuBD);
	}
	
	private void rellenaDatos() {
		datosARellenar = new Vector<String>();
		nombresSudokus = new Vector<String>();
		datosARellenar.addElement("1, id01, numero de casillas rellenas: 30");
		datosARellenar.addElement("2, id02, numero de casillas rellenas: 30");
		datosARellenar.addElement("3, id03, numero de casillas rellenas: 30");
		datosARellenar.addElement("4, id06, numero de casillas rellenas: 31");
		demoList.addElement(datosARellenar.get(0));
		demoList.addElement(datosARellenar.get(1));
		demoList.addElement(datosARellenar.get(2));
		demoList.addElement(datosARellenar.get(3));
		nombresSudokus.addElement("id01");
		nombresSudokus.addElement("id02");
		nombresSudokus.addElement("id03");
		nombresSudokus.addElement("id06");
	}

	private void rellenarPanelMenu() {
rellenaDatos();
		
        listSudokus = new JList(demoList);

        scrollPane.setViewportView(listSudokus);
        
        listSudokus.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;
				
				if (listSudokus.getSelectedValuesList().size() > 1) System.out.println("m�s de uno");
				else {
					String seleccion = (String) listSudokus.getSelectedValue();
					int pos = Integer.parseInt(seleccion.substring(0, 1));
					--pos;
					String nomsudoku = nombresSudokus.get(pos);
					System.out.println(nomsudoku);
				}
			}
		});
        
        panSelectSudokuBD.add(panMenu);
	}
}