package capaPresentacion;

import javax.swing.*;

public class CtrlCapaPresentacion {
	private static JFrame frameMenuPrincipal;
    private static JFrame frameIniciarSesion;
	private static Boolean cambiosParaBD;
	
	public static void main(String[] args) {
		mostrarMenuPrincipal();
	}
	
	public CtrlCapaPresentacion() {
		cambiosParaBD = false; //el boleano es porque si no ha hecho cambios, no hace falta que lo guarde todo en la base de datos
	}
	
	public static void pressVentanaIniciarSesion(){
		ocultarMenuPrincipal();
		mostrarIniciarSesion();
	}
	
	public static void pressVentanaRegistrarse(){
		ocultarMenuPrincipal();
		//mostrarRegistrarse();
	}
	
	public static void pressSalir() {
		//
		System.out.println("Salir pulsado");
	}
	
	public static void pressIniciarSesion(){
		//
	}
	
	public static void pressRegistrarse(){
		//
	}
	
	public static void pressVentanaMenuPrincipal(){
		//
	}
	
	public static void pressVentanaMenuOpciones(){
		//
	}
	
	public static void pressVentanaMenuSudoku(){
		//
	}
	
	
	
	
	
	
	
	
	
	
	
	private static void ocultarTodo() {
		ocultarMensajeAviso();
		ocultarMenuPrincipal();
		ocultarIniciarSesion();
		//...
	}
	
	private static void mostrarMensajeAviso(String mensaje) {
        //
    }
	
	private static void ocultarMensajeAviso() {
        //
    }

	private static void mostrarMenuPrincipal() {
		JFrame.setDefaultLookAndFeelDecorated(true);
        frameMenuPrincipal = new JFrameMenuPrincipal();
        frameMenuPrincipal.setTitle("My First Swing Application");
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.pack();
        frameMenuPrincipal.setVisible(true);
    }
    
    private static void ocultarMenuPrincipal() {
        frameMenuPrincipal.setVisible(false);
    }
    
    private static void mostrarIniciarSesion() {
    	JFrame.setDefaultLookAndFeelDecorated(true);
        frameIniciarSesion = new JFrameIniciarSesion();
        frameIniciarSesion.setTitle("My First Swing Application");
        frameIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIniciarSesion.pack();
        frameIniciarSesion.setVisible(true);
    }
    
    private static void ocultarIniciarSesion() {
        frameIniciarSesion.setVisible(false);
    }
	
}
