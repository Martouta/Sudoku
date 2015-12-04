package capaPresentacion;

import java.awt.Dimension;
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
    
    public JFrameGestionPerfiles() {
    	initComponents();
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
    	
    	labSeleccioneFuncion.setText("Selecione una funcion:");
    	butBorrarPerfil.setText("Borrar Perfil");
    	butResetearEstadisticasPerfil.setText("Resetear Estadisticas del Perfil");
    	butVolverMenuPrincipal.setText("Volver al menu opciones");
    	butSalir.setText("Salir");
    	
    	panGestionPerfil = new JPanel();
    	panGestionPerfil.setLayout(new GridLayout(9,1));
    	panGestionPerfil.add(labSeleccioneFuncion);
    	panGestionPerfil.add(butBorrarPerfil);
    	panGestionPerfil.add(butResetearEstadisticasPerfil);
    	panGestionPerfil.add(labEspacioBlanco);
    	panGestionPerfil.add(butVolverMenuPrincipal);
    	panGestionPerfil.add(butSalir);
    	add(panGestionPerfil);
    }
}
