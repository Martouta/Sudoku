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
		
		StringBuilder sb = new StringBuilder(64);
        sb.append("<html>�Est� seguro de que desea")
        		.append("<br/>eliminar el perfil?</html>");
        
		//labConfirmacionPerfil.setText("�Est� seguro de que desea eliminar el perfil?");
        labConfirmacionPerfil.setText(sb.toString());
        
        sb = new StringBuilder(64);
        sb.append("<html>�Tambi�n quiere eliminar de la")
        		.append("<br/>base de datos los sudokus</html>")
        		.append("<br/>de los cu�les es autor?</html>");
        
		labConfirmacionSudokus.setText("�Tambi�n quiere eliminar de la base de datos los sudokus de los cu�les es autor?");
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
		add(panConfirmacionBorrarPerfil);
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
