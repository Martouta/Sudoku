package capaPresentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class JFrameGestionPerfiles extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panGestionPerfil;
	private JLabel labSeleccioneFuncion;
	private JButton butVolverMenuPrincipal;
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
    
    public JButton getButVolverMenuPrincipal() {
    	return butVolverMenuPrincipal;
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
		setSize(400,500); //ancho por alto
		setMinimumSize(new Dimension(400, 500));
		setResizable(true);
		
		labSeleccioneFuncion = new JLabel();
    	butBorrarPerfil = new JButton();
    	butResetearEstadisticasPerfil = new JButton();
    	butVolverMenuPrincipal = new JButton();
    	butSalir = new JButton();
    	labMensajeError = new JLabel();
    	
    	labSeleccioneFuncion.setText("Selecione una funcion:");
    	butBorrarPerfil.setText("Borrar Perfil");
    	butResetearEstadisticasPerfil.setText("Resetear Estadisticas del Perfil");
    	StringBuilder sb = new StringBuilder(64);
        sb.append("<html>Volver al")
        		.append("<br/>menu opciones</html>");
    	butVolverMenuPrincipal.setText(sb.toString());
    	butSalir.setText("Salir");
    	labMensajeError.setText("");
    	
    	panGestionPerfil = new JPanel();
    	panGestionPerfil.setLayout(new GridLayout(9,1));
    	panGestionPerfil.add(labSeleccioneFuncion);
    	panGestionPerfil.add(butBorrarPerfil);
    	panGestionPerfil.add(butResetearEstadisticasPerfil);
    	panGestionPerfil.add(labEspacioBlanco);
    	panGestionPerfil.add(butVolverMenuPrincipal);
    	panGestionPerfil.add(butSalir);
    	JPanel panMensError = new JPanel();
		panMensError.setLayout(new FlowLayout(FlowLayout.CENTER));
		panMensError.add(labMensajeError);
		panGestionPerfil.add(panMensError);
    	add(panGestionPerfil);
    }
}
