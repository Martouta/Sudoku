package capaPresentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class JFrameGestionPerfiles extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panGestionPerfil;
	private JLabel labSeleccioneFuncion;
	private JButton butVolverMenuOpciones;
    private JButton butSalir;
    private JButton butResetearEstadisticasPerfil;
    private JButton butBorrarPerfil;
    private JLabel labMensajeError;
    
    public JFrameGestionPerfiles() {
    	initComponents();
    }
    
    public void setMensajeError(String msj){
		labMensajeError.setText(msj);
	}
    
    public JButton getButSalir() {
    	return butSalir;
    }
    
    public JButton getButVolverMenuOpciones() {
    	return butVolverMenuOpciones;
    }
    
    public JButton getButResetearEstadisticasPerfil() {
    	return butResetearEstadisticasPerfil;
    }
    
    public JButton getButBorrarPerfil() {
    	return butBorrarPerfil;
    }
    
    private void initComponents() {
    	JLabel labEspacioBlanco = new JLabel();
		labEspacioBlanco.setText("");
		
		setTitle("Gestion de Perfil");
		setSize(400,400); //ancho por alto
		setMinimumSize(new Dimension(400, 400));
		setResizable(true);
		
		labSeleccioneFuncion = new JLabel();
    	butBorrarPerfil = new JButton();
    	butResetearEstadisticasPerfil = new JButton();
    	butVolverMenuOpciones = new JButton();
    	butSalir = new JButton();
    	labMensajeError = new JLabel();
    	
    	labSeleccioneFuncion.setText("Selecione una funcion:");
    	butBorrarPerfil.setText("Borrar Perfil");
    	butResetearEstadisticasPerfil.setText("Resetear Estadisticas del Perfil");
    	StringBuilder sb = new StringBuilder(64);
        sb.append("<html>Volver al")
        		.append("<br/>menu opciones</html>");
    	butVolverMenuOpciones.setText(sb.toString());
    	butSalir.setText("Salir");
    	labMensajeError.setText("");
    	
    	
    	labSeleccioneFuncion.setBounds(125, 25, 220, 50);
    	butBorrarPerfil.setBounds(80, 100, 220, 50); //x,y,weight,height
    	butResetearEstadisticasPerfil.setBounds(80, 165, 220, 50);
    	butVolverMenuOpciones.setBounds(50, 280, 140, 50);
    	butSalir.setBounds(200, 280, 140, 50);
   	
    	panGestionPerfil = new JPanel();
    	panGestionPerfil.setLayout(new GridLayout(9,1));
    	panGestionPerfil.add(labSeleccioneFuncion);
    	panGestionPerfil.add(butBorrarPerfil);
    	panGestionPerfil.add(butResetearEstadisticasPerfil);
    	panGestionPerfil.add(labEspacioBlanco);
    	panGestionPerfil.add(butVolverMenuOpciones);
    	panGestionPerfil.add(butSalir);
    	JPanel panMensError = new JPanel(); //
		panMensError.setLayout(new FlowLayout(FlowLayout.CENTER));
		panMensError.add(labMensajeError);
		panGestionPerfil.add(panMensError); //
		panGestionPerfil.setLayout(null);
    	add(panGestionPerfil);
    }
}
