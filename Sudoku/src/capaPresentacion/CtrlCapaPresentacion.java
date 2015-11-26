package capaPresentacion;

import javax.swing.*;
import java.awt.event.*;
import capaDomini.*;
import excepciones.*;

public class CtrlCapaPresentacion {
	private static JFrame frameMenuPrincipal;
    private static JFrame frameIniciarSesion;
    
    private static FactoryCtrlCasosUso facCtrlCU;
    
	private static Boolean cambiosParaBD;
	private static String nombreUsuario;
	private static String contrasena;

	
	public CtrlCapaPresentacion() {
		FactoryCtrlCasosUso facCtrlCU = new FactoryCtrlCasosUso();
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
                //ctrlCP.pressVentanaRegistrarse();
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
            	//CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion = facCtrlCU.getCtrlCasoUsoIniciarSesion();
            	facCtrlCU.prueba();
            	try {
            		nombreUsuario = ((JFrameIniciarSesion) frameIniciarSesion).getNombreUsuario();
            		if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
            		System.out.println("llega01: -" + nombreUsuario + "-");
            	} catch (ExcepcionCamposVacios e) {
            		System.out.println(e.getMessage());
            	}
            	//System.out.println(((JFrameIniciarSesion) frameIniciarSesion).getNombreUsuario() + " - " + ((JFrameIniciarSesion) frameIniciarSesion).getContrasena());
            }
        });
	}

    
    private void pressSalir() {
		//...
		System.out.println("Salir pulsado");
	}
	
}
