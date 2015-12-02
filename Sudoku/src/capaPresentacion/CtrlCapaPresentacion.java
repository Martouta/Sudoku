package capaPresentacion;

import javax.swing.*;
import java.awt.event.*;
import capaDomini.*;
import excepciones.*;
import excepciones.excUsuario.*;

public class CtrlCapaPresentacion {
	private static JFrame frameMenuPrincipal;
    private static JFrame frameIniciarSesion;
    private static JFrame frameRegistrarse;
    private static JFrame frameMenuOpciones;
    private static JFrame frameMenuSudoku;
    
    
	private static Boolean cambiosParaBD;
	private static String nombreUsuario;

	
	public CtrlCapaPresentacion() {
		cambiosParaBD = false; //el boleano es porque si no ha hecho cambios, no hace falta que lo guarde todo en la base de datos
		initComponents();
		initListeners();
		frameMenuPrincipal.setVisible(true);
		cargarTodo();
	}

	private void initComponents() {
		//INIT MENU PRINCIPAL:
		JFrame.setDefaultLookAndFeelDecorated(true);
        frameMenuPrincipal = new JFrameMenuPrincipal();
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.pack();
        
        //INIT INICIAR SESION:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameIniciarSesion = new JFrameIniciarSesion();
        frameIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIniciarSesion.pack();
        
        //INIT REGISTRARSE:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameRegistrarse = new JFrameRegistrarse();
        frameRegistrarse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarse.pack();
        
        //INIT MENU OPCIONES:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameMenuOpciones = new JFrameMenuOpciones();
        frameMenuOpciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuOpciones.pack();
        
        //INIT MENU SUDOKU:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameMenuSudoku = new JFrameRegistrarse();
        frameMenuSudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuSudoku.pack();
	}
	
	private void initListeners() {
		initListenersMenuPrincipal();
		initListenersIniciarSesion();
		initListenersRegistrarse();
	}
	
	private void initListenersMenuPrincipal() {
		//LISTENERS DE MENU PRINCIPAL:
		((JFrameMenuPrincipal) frameMenuPrincipal).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pressSalir();
		    }
		});
		((JFrameMenuPrincipal) frameMenuPrincipal).getButIniciarSesion().addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					frameMenuPrincipal.setVisible(false);
					frameIniciarSesion.setVisible(true);
				}
		});
		((JFrameMenuPrincipal) frameMenuPrincipal).getButRegistrarse().addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					frameMenuPrincipal.setVisible(false);
					frameRegistrarse.setVisible(true);
				}
		});
	}
	
	private void initListenersIniciarSesion() {
		//LISTENERS DE INICIAR SESIÓN:
		((JFrameIniciarSesion) frameIniciarSesion).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameIniciarSesion) frameIniciarSesion).getButIniciarSesion().addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion = new CtrlCasoUsoIniciarSesion();
				try {
					nombreUsuario = ((JFrameIniciarSesion) frameIniciarSesion).getNombreUsuario();
					if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
					String contrasena = ((JFrameIniciarSesion) frameIniciarSesion).getContrasena();
					ctrlCUIniciarSesion.iniciarSesion(nombreUsuario, contrasena);
					//Si llega hasta aqui es que ha funcionado sin ninguna excepcion
					frameIniciarSesion.setVisible(false);
					//FALTA abrir ventana de "MenuOpciones"
					System.out.println("[Mensaje temporal] Sesion iniciada con el usuario " + nombreUsuario + " con contrasena " + contrasena);		
				} catch (ExcepcionCamposVacios e) {
					nombreUsuario = "";
					((JFrameIniciarSesion) frameIniciarSesion).setMensajeError(e.getMessage());
				} catch (ExcepcionUsuarioNoExiste e) {
					nombreUsuario = "";
					((JFrameIniciarSesion) frameIniciarSesion).setMensajeError(e.getMessage());
				} catch (ExcepcionContrasenaIncorrecta e) {
					nombreUsuario = "";
					((JFrameIniciarSesion) frameIniciarSesion).setMensajeError(e.getMessage());
				}
			}
		});
	}
	
	private void initListenersRegistrarse() {
		//LISTENERS DE REGISTRARSE:
		((JFrameRegistrarse) frameRegistrarse).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameRegistrarse) frameRegistrarse).getButRegistrarse().addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CtrlCasoUsoRegistrarse ctrlCURegistrarse = new CtrlCasoUsoRegistrarse();
				try {
					nombreUsuario = ((JFrameRegistrarse) frameRegistrarse).getNombreUsuario();
					if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
					String contrasena = ((JFrameRegistrarse) frameRegistrarse).getContrasena();
					String confirmContrasena = ((JFrameRegistrarse) frameRegistrarse).getConfirmContrasena();
					if (! contrasena.equals(confirmContrasena)) throw (new ExcepcionContrasenasNoCoinciden());
					ctrlCURegistrarse.registrarse(nombreUsuario, contrasena);
					//Si llega hasta aqui es que ha funcionado sin ninguna excepcion
					frameRegistrarse.setVisible(false);
					cambiosParaBD = true;
					//FALTA abrir ventana de "MenuOpciones"
					System.out.println("[Mensaje temporal] Registrado con el usuario " + nombreUsuario + " con contrasena " + contrasena);		
				} catch (ExcepcionCamposVacios e) {
					nombreUsuario = "";
					((JFrameRegistrarse) frameRegistrarse).setMensajeError(e.getMessage());
				} catch (ExcepcionUsuarioYaExiste e) {
					nombreUsuario = "";
					((JFrameRegistrarse) frameRegistrarse).setMensajeError(e.getMessage());
				} catch (ExcepcionContrasenasNoCoinciden e) {
					nombreUsuario = "";
					((JFrameRegistrarse) frameRegistrarse).setMensajeError(e.getMessage());
				}
			}
		});
	}
    
    private void pressSalir() {
		//FALTA: guardar en txt o no, dependera del valor cambiosParaBD
		System.out.println("Salir pulsado");
	}
    
    private void cargarTodo() {
		//POR HACER
	}
	
}
