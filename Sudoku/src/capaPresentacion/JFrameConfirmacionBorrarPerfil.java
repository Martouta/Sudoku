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
	private JLabel labMensajeError;
	
	public JFrameConfirmacionBorrarPerfil() {
		initComponents();
	}
	
	public void setMensajeError(String msj){
		labMensajeError.setText(msj);
	}
	
	private void initComponents() {
		JLabel labEspacioBlanco = new JLabel();
		labEspacioBlanco.setText("");
		
		setTitle("Confirmacion Borrar Perfil");
		setSize(400,400); //ancho por alto
		setMinimumSize(new Dimension(400, 400));
		setResizable(true);
		
		labConfirmacionPerfil = new JLabel();
		labConfirmacionSudokus = new JLabel();
		butEliminarPerfSud = new JButton();
		butEliminarPerfil = new JButton();
		butNoEliminar = new JButton();
		labMensajeError = new JLabel();
		
		StringBuilder sb = new StringBuilder(64);
        sb.append("<html>¿Está seguro de que desea")
        		.append("<br/>eliminar el perfil?</html>");
        
		//labConfirmacionPerfil.setText("¿Está seguro de que desea eliminar el perfil?");
        labConfirmacionPerfil.setText(sb.toString());
        
        sb = new StringBuilder(64);
        sb.append("<html>¿También quiere eliminar de la")
        		.append("<br/>base de datos los sudokus")
        		.append("<br/>de los cuáles es autor?</html>");
        
		//labConfirmacionSudokus.setText("¿También quiere eliminar de la base de datos los sudokus de los cuáles es autor?");
        labConfirmacionSudokus.setText(sb.toString());
        
        sb = new StringBuilder(64);
        sb.append("<html>Eliminar Perfil")
        		.append("<br/>y Sudokus</html>");
        
		//butEliminarPerfSud.setText("Eliminar Perfil y Sudokus");
        butEliminarPerfSud.setText(sb.toString());
        
        sb = new StringBuilder(64);
        sb.append("<html>Eliminar Perfil")
        		.append("<br/>pero no Sudokus</html>");
        
		//butEliminarPerfil.setText("Eliminar Perfil pero no Sudokus");
        butEliminarPerfil.setText(sb.toString());
        
        sb = new StringBuilder(64);
        sb.append("<html>No eliminar")
        		.append("<br/>mi perfil</html>");
        
		butNoEliminar.setText(sb.toString());
		labMensajeError.setText("");
		
		labConfirmacionPerfil.setBounds(110, 30, 220, 50);
		labConfirmacionSudokus.setBounds(110, 130, 220, 50);
		butEliminarPerfSud.setBounds(20, 260, 110, 80);
		butEliminarPerfil.setBounds(140, 260, 110, 80);
		butNoEliminar.setBounds(260, 260, 110, 80);
		
		panConfirmacionBorrarPerfil = new JPanel();
		panConfirmacionBorrarPerfil.setLayout(new GridLayout(9,1));
		panConfirmacionBorrarPerfil.add(labConfirmacionPerfil);
		panConfirmacionBorrarPerfil.add(labConfirmacionSudokus);
		panConfirmacionBorrarPerfil.add(labConfirmacionSudokus);
		panConfirmacionBorrarPerfil.add(butEliminarPerfSud);
		panConfirmacionBorrarPerfil.add(butEliminarPerfil);
		panConfirmacionBorrarPerfil.add(butNoEliminar);
		JPanel panMensError = new JPanel(); //
		panMensError.setLayout(new FlowLayout(FlowLayout.CENTER));
		panMensError.add(labMensajeError);
		panConfirmacionBorrarPerfil.add(panMensError);
		panConfirmacionBorrarPerfil.setLayout(null);
		add(panConfirmacionBorrarPerfil);
	}
	
	public JButton getButEliminarPerfSud() {
		return butEliminarPerfSud;
	}
	
	public JButton getButEliminarPerfil() {
		return butEliminarPerfil;
	}
	
	public JButton getButNoEliminar() {
		return butNoEliminar;
	}
	
}
