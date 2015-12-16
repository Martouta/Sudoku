package capaPresentacion;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

import DataTransferObjects.DTOSudokuDeLaBD;

public class JFrameSeleccionarSudokuBD extends JFrame{
	private static final long serialVersionUID = 1L;
	
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
	
	public JFrameSeleccionarSudokuBD(Vector<DTOSudokuDeLaBD> infoSudokusDeLaBD) {
		rellenaDatos(infoSudokusDeLaBD);
		initComponents();
	}
	
	public JButton getButSalir() {
		return butSalir;
	}
	
	public JButton getButVolverMenuSudoku() {
		return butVolverMenuSudoku;
	}
	
	public JButton getJugarSudoku() {
		return butJugarSudoku;
	}
	
	public void setMensaje(String msj){
		labMensError.setText(msj);
	}
	
	private void initComponents() {
		
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
	
	private void rellenaDatos(Vector<DTOSudokuDeLaBD> infoSudokusDeLaBD) {
		infoSudokusDeLaBD.size();
		datosARellenar = new Vector<String>();
		nombresSudokus = new Vector<String>();
		int cont = 1;
		for (DTOSudokuDeLaBD infoSudokuBD : infoSudokusDeLaBD) {
			String rellena = cont + ", " + infoSudokuBD.getNombreSudoku() + ", numero de casillas rellenas: " + infoSudokuBD.getNumeroCasillasRellenas();
			datosARellenar.addElement(rellena);
			demoList.addElement(rellena);
			nombresSudokus.addElement(infoSudokuBD.getNombreSudoku());
			++cont;
		}
	}

	private void rellenarPanelMenu() {
        listSudokus = new JList(demoList);
        scrollPane.setViewportView(listSudokus);
        
        panSelectSudokuBD.add(panMenu);
	}
	
	public int getCuantosSeleccionados() {
		return listSudokus.getSelectedValuesList().size();
	}
	
	public String getNombreSudokuSeleccionado() {
		String seleccion = (String) listSudokus.getSelectedValue();
		int pos = Integer.parseInt(seleccion.substring(0, 1));
		--pos;
		String nomsudoku = nombresSudokus.get(pos);
		return nomsudoku;
	}
}
