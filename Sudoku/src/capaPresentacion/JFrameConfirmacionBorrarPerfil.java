package capaPresentacion;

import javax.swing.*;
import java.awt.*;

public class JFrameConfirmacionBorrarPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panConfirmacionBorrarPerfil;
	private JLabel labConfirmacionPerfil;
	private JLabel labConfirmacionSudokus;
	private JButton butEliminarPerfSud;
	private JButton butEliminarPerfil;
	private JButton butNoEliminar;
	
	public JFrameConfirmacionBorrarPerfil() {
		initComponents();
	}
	
	private void initComponents() {
		JLabel labEspacioBlanco = new JLabel();
		labEspacioBlanco.setText("");
		
		setTitle("Confirmacion Borrar Perfil");
		setSize(400,500); //ancho por alto
		setMinimumSize(new Dimension(400, 500));
		setResizable(true);
		
		labConfirmacionPerfil = new JLabel();
		labConfirmacionSudokus = new JLabel();
		butEliminarPerfSud = new JButton();
		butEliminarPerfil = new JButton();
		butNoEliminar = new JButton();
		
		labConfirmacionPerfil.setText("¿Está seguro de que desea eliminar el perfil?");
		labConfirmacionSudokus.setText("¿También quiere eliminar de la base de datos los sudokus de los cuáles es autor?");
		butEliminarPerfSud.setText("Eliminar Perfil y Sudokus");
		butEliminarPerfil.setText("Eliminar Perfil pero no Sudokus");
		butNoEliminar.setText("No eliminar mi perfil");
		
		panConfirmacionBorrarPerfil = new JPanel();
		panConfirmacionBorrarPerfil.setLayout(new GridLayout(9,1));
		panConfirmacionBorrarPerfil.add(labConfirmacionPerfil);
		panConfirmacionBorrarPerfil.add(labConfirmacionSudokus);
		panConfirmacionBorrarPerfil.add(labConfirmacionSudokus);
		panConfirmacionBorrarPerfil.add(butEliminarPerfSud);
		panConfirmacionBorrarPerfil.add(butEliminarPerfil);
		panConfirmacionBorrarPerfil.add(butNoEliminar);
	}
	
	public JButton getButEliminarPerfEst() {
		return butEliminarPerfSud;
	}
	
	public JButton getButEliminarPerfil() {
		return butEliminarPerfil;
	}
	
	public JButton getButNoEliminar() {
		return butNoEliminar;
	}
	
}
