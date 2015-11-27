package capaPresentacion;

import javax.swing.*;
import java.awt.event.*;
import capaDomini.*;
import excepciones.*;
import excepciones.excUsuario.ExcepcionContrasenaIncorrecta;
import excepciones.excUsuario.ExcepcionUsuarioNoExiste;

public class CtrlCapaPresentacion {
	private static JFrame frameMenuPrincipal;
    private static JFrame frameIniciarSesion;
    
    private static FactoryCtrlCasosUso facCtrlCU;
    
	private static Boolean cambiosParaBD;
	private static String nombreUsuario;

	
	public CtrlCapaPresentacion() {
		facCtrlCU = new FactoryCtrlCasosUso();
		cambiosParaBD = false; //el boleano es porque si no ha hecho cambios, no hace falta que lo guarde todo en la base de datos
		initComponents();
		initListeners();
		frameMenuPrincipal.setVisible(true); //mostrarMenuPrincipal();
	}
	
	private void initComponents() {
		//INIT MENU PRINCIPAL:
		JFrame.setDefaultLookAndFeelDecorated(true);
        frameMenuPrincipal = new JFrameMenuPrincipal();
        frameMenuPrincipal.setTitle("My First Swing Application");
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.pack();
        
        //INIT INICIAR SESIÓN:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameIniciarSesion = new JFrameIniciarSesion();
        frameIniciarSesion.setTitle("My First Swing Application");
        frameIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIniciarSesion.pack();
	}
	
	private void initListeners() {
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
                //FALTA: ocultar esta ventana y abrir la de registrarse
            }
        });
		
		//LISTENERS DE INICIAR SESIÓN:
		((JFrameIniciarSesion) frameIniciarSesion).getButSalir().addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressSalir();
            }
        });
		((JFrameIniciarSesion) frameIniciarSesion).getButIniciarSesion().addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion = facCtrlCU.getCtrlCasoUsoIniciarSesion();
            	try {
            		nombreUsuario = ((JFrameIniciarSesion) frameIniciarSesion).getNombreUsuario();
            		if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
            		String contrasena = ((JFrameIniciarSesion) frameIniciarSesion).getContrasena();
            		ctrlCUIniciarSesion.iniciarSesion(nombreUsuario, contrasena);
            		//Si llega hasta aqui es que ha funcionado sin ninguna excepcion
            		frameIniciarSesion.setVisible(false);
            		//FALTA abrir venatana de "MenuOpciones"
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

    
    private void pressSalir() {
		//FALTA: guardar en txt o no, dependera del valor cambiosParaBD
		System.out.println("Salir pulsado");
	}
	
}
