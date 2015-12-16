package capaPresentacion;

import java.awt.*;
import java.util.Enumeration;
import javax.swing.*;


public class JFrameMenuSudoku extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel panMenuSudoku;
	private JLabel labSeleccioneFuncion;
	private JLabel labTamanoSudoku;
	private JLabel labDificultad;
	private JLabel labInfo;
	private JButton butSelectsudoku;
	private JButton butVolverMenuOpciones;
	private JButton butSalir;
	private ButtonGroup bgOpcSudoku;
	private JRadioButton rbBD;
	private JRadioButton rbGenerado;
	private JRadioButton rbProponer;
	private JRadioButton rbReanudarPartida;
	String[] vsTamanosPosibles;
	String[] vsDificultadesPosibles;
	SpinnerListModel modelTamanosPosibles;
	SpinnerListModel modelDificultadesPosibles;
	JSpinner spinnerTamanosPosibles;
	JSpinner spinnerDificultadesPosibles;
	
	public JFrameMenuSudoku(){
		initComponents();
	}
	
	public void cleanValues() {
		labInfo.setText("");
	}

	public String tipoSudokuElegido(){
		String tipoSudoku = "";
		for (Enumeration<AbstractButton> buttons = bgOpcSudoku.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
            	tipoSudoku = button.getName();
            }
        }
		return tipoSudoku;
	}
	
	public JRadioButton getRbBD() {
		return rbBD;
	}

	public JRadioButton getRbGenerado() {
		return rbGenerado;
	}

	public JRadioButton getRbProponer() {
		return rbProponer;
	}

	public JRadioButton getRbReanudarPartida() {
		return rbReanudarPartida;
	}

	public String tamanoElegido(){
		return (String) spinnerTamanosPosibles.getValue();
	}
	
	public String dificultadElegida(){
		return (String) spinnerDificultadesPosibles.getValue();
	}
	
	public JButton getButSelectsudoku() {
		return butSelectsudoku;
	}

	public JButton getButVolverMenuOpciones() {
		return butVolverMenuOpciones;
	}

	public JButton getButSalir() {
		return butSalir;
	}
	
	public void activarSeleccionarSudoku() {
		butSelectsudoku.setEnabled(true);
	}
	
	public void desactivarSeleccionarSudoku() {
		butSelectsudoku.setEnabled(false);
	}

	public void setMensaje(String msj){
		labInfo.setText(msj);
	}
	
	
	private void initComponents() {
		setTitle("Menu Sudoku");
		setSize(400,800); //ancho por alto
		setMinimumSize(new Dimension(400, 550));
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        
		labSeleccioneFuncion = new JLabel();
    	labTamanoSudoku = new JLabel();
    	labDificultad = new JLabel();
    	labInfo = new JLabel();
    	butSelectsudoku = new JButton();
    	butVolverMenuOpciones = new JButton();
    	butSalir = new JButton();
        
    	bgOpcSudoku = new ButtonGroup();
    	rbBD = new JRadioButton("De la base de datos", true);
    	rbBD.setName("tsBD");
    	rbGenerado = new JRadioButton("Generado por la maquina", false);
    	rbGenerado.setName("tsGenerado");
    	rbProponer = new JRadioButton("Proponer nuevo", false);
    	rbProponer.setName("tsProponer");
    	rbReanudarPartida = new JRadioButton("Reanudar partida", false);
    	rbReanudarPartida.setName("tsReanudarPartida");
    	bgOpcSudoku.add(rbBD);
    	bgOpcSudoku.add(rbGenerado);
    	bgOpcSudoku.add(rbProponer);
    	bgOpcSudoku.add(rbReanudarPartida);
    	
    	vsTamanosPosibles = new String[3];
    	vsDificultadesPosibles = new String[4];
    	vsTamanosPosibles[0] = "4x4";vsTamanosPosibles[1] = "9x9";vsTamanosPosibles[2] = "16x16";
    	vsDificultadesPosibles[0] = "Trivial";vsDificultadesPosibles[1] = "Facil";vsDificultadesPosibles[2] = "Medio";vsDificultadesPosibles[3] = "Dificil";
    	modelTamanosPosibles = new SpinnerListModel(vsTamanosPosibles);
    	modelDificultadesPosibles = new SpinnerListModel(vsDificultadesPosibles);
    	spinnerTamanosPosibles = new JSpinner(modelTamanosPosibles);
    	spinnerDificultadesPosibles = new JSpinner(modelDificultadesPosibles);
    	spinnerTamanosPosibles.setPreferredSize(new Dimension(50, 20));
    	spinnerDificultadesPosibles.setPreferredSize(new Dimension(50, 20));
    	
    	labSeleccioneFuncion.setText("Selecione una funcion:");
		labTamanoSudoku.setText("Tamano del Sudoku: ");
		labDificultad.setText("Dificultad: ");
		labInfo.setText("");
		butSelectsudoku.setText("Selecciona Sudoku");
        butSalir.setText("Salir");
        StringBuilder sb = new StringBuilder(64);
        sb.append("<html>Volver al")
        		.append("<br/>menu opciones</html>");
        butVolverMenuOpciones.setText(sb.toString());
        
        butVolverMenuOpciones.setPreferredSize(new Dimension(110, 10));
        butSalir.setPreferredSize(new Dimension(110, 10));

        panMenuSudoku = new JPanel();
        panMenuSudoku.setLayout(new GridLayout(7,1));
        
        JPanel panLabSeleccioneFuncion = new JPanel();
        panLabSeleccioneFuncion.setLayout(new FlowLayout(FlowLayout.CENTER));
        panLabSeleccioneFuncion.add(labSeleccioneFuncion);
        JPanel panOpc = new JPanel();
        panOpc.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel panOpcInterno = new JPanel();
        panOpcInterno.setLayout(new GridLayout(4,1));
        panOpcInterno.add(rbBD);
        panOpcInterno.add(rbGenerado);
        panOpcInterno.add(rbProponer);
        panOpcInterno.add(rbReanudarPartida);
        panOpc.add(panOpcInterno);
        JPanel panTamano = new JPanel();
        panTamano.setLayout(new FlowLayout(FlowLayout.CENTER));
        panTamano.add(labTamanoSudoku);
        panTamano.add(spinnerTamanosPosibles);
        JPanel panDificultad = new JPanel();
        panDificultad.setLayout(new FlowLayout(FlowLayout.CENTER));
        panDificultad.add(labDificultad);
        panDificultad.add(spinnerDificultadesPosibles);
        JPanel panInfo = new JPanel();
        panInfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panInfo.add(labInfo);
        JPanel panButSelectSudoku = new JPanel();
        panButSelectSudoku.setLayout(new FlowLayout(FlowLayout.CENTER));
        panButSelectSudoku.add(butSelectsudoku);
        JPanel panButExtras = new JPanel();
        panButExtras.setLayout(new BorderLayout());
        panButExtras.add(butVolverMenuOpciones, BorderLayout.WEST);
        panButExtras.add(butSalir, BorderLayout.EAST);
		
		panMenuSudoku.add(panLabSeleccioneFuncion);
		panMenuSudoku.add(panOpc);
		panMenuSudoku.add(panTamano);
		panMenuSudoku.add(panDificultad);
		panMenuSudoku.add(panInfo);
		panMenuSudoku.add(panButSelectSudoku);
        panMenuSudoku.add(panButExtras);
		add(panMenuSudoku);
    }
}
