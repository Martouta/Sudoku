package capaPresentacion;

import java.util.*;
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
        frameMenuSudoku = new JFrameMenuSudoku();
        frameMenuSudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuSudoku.pack();
	}
	
	private void initListeners() {
		initListenersMenuPrincipal();
		initListenersIniciarSesion();
		initListenersRegistrarse();
		initListenersMenuOpciones();
		initListenersMenuSudoku();
	}
	
	private void initListenersMenuPrincipal() {
		//LISTENERS DE MENU PRINCIPAL:
		((JFrameMenuPrincipal) frameMenuPrincipal).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
		    }
		});
		((JFrameMenuPrincipal) frameMenuPrincipal).getButIniciarSesion().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					frameMenuPrincipal.setVisible(false);
					frameIniciarSesion.setVisible(true);
				}
		});
		((JFrameMenuPrincipal) frameMenuPrincipal).getButRegistrarse().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					frameMenuPrincipal.setVisible(false);
					frameRegistrarse.setVisible(true);
				}
		});
	}
	
	private void initListenersIniciarSesion() {
		//LISTENERS DE INICIAR SESIÓN:
		((JFrameIniciarSesion) frameIniciarSesion).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameIniciarSesion) frameIniciarSesion).getButIniciarSesion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion = new CtrlCasoUsoIniciarSesion();
				try {
					nombreUsuario = ((JFrameIniciarSesion) frameIniciarSesion).getNombreUsuario();
					if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
					String contrasena = ((JFrameIniciarSesion) frameIniciarSesion).getContrasena();
					ctrlCUIniciarSesion.iniciarSesion(nombreUsuario, contrasena);
					//Si llega hasta aqui es que ha funcionado sin ninguna excepcion
					frameIniciarSesion.setVisible(false);
					frameMenuOpciones.setVisible(true);
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
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameRegistrarse) frameRegistrarse).getButRegistrarse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
					frameMenuOpciones.setVisible(true);
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
	
	private void initListenersMenuOpciones() {
		//LISTENERS DE MENU OPCIONES:
		((JFrameMenuOpciones) frameMenuOpciones).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameMenuOpciones) frameMenuOpciones).getButCerrarSesion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER //PUEDE QUE YA SEA POSIBLE
			}
		});
		((JFrameMenuOpciones) frameMenuOpciones).getButGestionPerfilUsu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER //AUN NO ES POSIBLE
			}
		});
		((JFrameMenuOpciones) frameMenuOpciones).getButSelectSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuOpciones.setVisible(false);
				frameMenuSudoku.setVisible(true);
			}
		});
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarRankingLocal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER //AUN NO ES POSIBLE
			}
		});
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarRankingGlobal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER //AUN NO POSIBLE
			}
		});
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarEstadisticasGenerales().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER
			}
		});
	}
	
	private void initListenersMenuSudoku() {
		//LISTENERS DE MENU SUDOKU:
		((JFrameMenuSudoku) frameMenuSudoku).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameMenuSudoku) frameMenuSudoku).getButVolverMenuOpciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER
			}
		});
		((JFrameMenuSudoku) frameMenuSudoku).getButSelectsudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String tipoSudoku = ((JFrameMenuSudoku) frameMenuSudoku).tipoSudokuElegido();
				String tamanoSudoku = ((JFrameMenuSudoku) frameMenuSudoku).tamanoElegido();
				String dificultadSudoku = ((JFrameMenuSudoku) frameMenuSudoku).dificultadElegida();
				try{
					//
				} catch (Exception e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				}
			}
		});
		
		//LISTENERS DE LOS RADIOBUTTONS DE MENU SUDOKU:
		((JFrameMenuSudoku) frameMenuSudoku).getRbBD().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				((JFrameMenuSudoku) frameMenuSudoku).setMensaje("");
			}
		});
		((JFrameMenuSudoku) frameMenuSudoku).getRbGenerado().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				((JFrameMenuSudoku) frameMenuSudoku).setMensaje("");
			}
		});
		((JFrameMenuSudoku) frameMenuSudoku).getRbReanudarPartida().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				((JFrameMenuSudoku) frameMenuSudoku).setMensaje("");
			}
		});
		((JFrameMenuSudoku) frameMenuSudoku).getRbProponer().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				((JFrameMenuSudoku) frameMenuSudoku).setMensaje("Para el Sudoku propuesto, se ignorará la dificultad seleccionada");
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
