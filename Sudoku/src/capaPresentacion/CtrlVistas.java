package capaPresentacion;

import javax.swing.*;

public class CtrlVistas {
	private static JFrame frameMenuPrincipal;
    private static JFrame frameIniciarSesion;

	public static void main(String[] args) {
		mostrarMenuPrincipal();
	}
	
	public static void mostrarMensajeAviso(String mensaje) {
        //
    }
	
	public static void ocultarMensajeAviso() {
        //
    }

	public static void mostrarMenuPrincipal() {
		JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frameMenuPrincipal = new JFrameMenuPrincipal();
        frameMenuPrincipal.setTitle("My First Swing Application");
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.pack();
        frameMenuPrincipal.setVisible(true);
    }
    
    public static void ocultarMenuPrincipal() {
        frameMenuPrincipal.setVisible(false);
    }
    
    public static void mostrarIniciarSesion() {
    	JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frameIniciarSesion = new JFrameIniciarSesion();
        frameIniciarSesion.setTitle("My First Swing Application");
        frameIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIniciarSesion.pack();
        frameIniciarSesion.setVisible(true);
    }
    
    public static void ocultarIniciarSesion() {
        frameIniciarSesion.setVisible(false);
    }

}
