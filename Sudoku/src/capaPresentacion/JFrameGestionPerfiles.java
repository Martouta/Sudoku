package capaPresentacion;

import javax.swing.*;

public class JFrameGestionPerfiles {

	private static final long serialVersionUID = 1L;
	
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
    
    private void initComponents() {
    	butSalir = new JButton();
    	butVolverMenuPrincipal = new JButton();
    	butResetearEstadisticasPerfil = new JButton();
    	butBorrarPerfil = new JButton();
    	
    	
    	butSalir.setText("Salir");
    	butVolverMenuPrincipal.setText("Volver al menu opciones");
    	butResetearEstadisticasPerfil.setText("Resetear Estadisticas del Perfil");
    	butBorrarPerfil.setText("Borrar Perfil");
    }
}
