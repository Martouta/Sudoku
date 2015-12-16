package capaPresentacion;

import java.util.*;
import javax.swing.*;

import DataTransferObjects.*;

import java.awt.event.*;
import capaDomini.*;
import excepciones.*;
import excepciones.excUsuario.*;

public class CtrlCapaPresentacion {
	private static JFrameGestionPerfiles frameGestionPerfiles;
	private static JFrameConfirmacionBorrarPerfil frameConfirmacionBorrarPerfil;
	private static JFrameConfirmacionResetearEstadisticas frameConfirmacionResetearEstadisticas;
	private static JFrame frameMenuPrincipal;
    private static JFrame frameIniciarSesion;
    private static JFrame frameRegistrarse;
    private static JFrame frameMenuOpciones;
    private static JFrame frameMenuSudoku;
    private static JFrame frameSeleccionarSudokuBD;
    private static JFrame frameSeleccionarPartidaReanudar;
    private static JFrame frameProponerSudoku4x4;
    private static JFrame frameProponerSudoku9x9;
    private static JFrame frameProponerSudoku16x16;
    private static JFrameJuego4x4 frameJuego4x4;
    private static JFrameJuego9x9 frameJuego9x9;
    private static JFrameJuego16x16 frameJuego16x16;
    private static JFrameRankingGlobal frameRankingGlobal;
    private static JFrameRankingPersonal frameRankingpersonal;
    private static JFrameEstadisticasGenerales frameEstadisticasGenerales;
    
    private CtrlCasoUsoSeleccionarSudoku ctrlCUSeleccionarJugarSudoku;
    
    
	private static String nombreUsuario;

	
	public CtrlCapaPresentacion() {
		initComponents();
		initListeners();
		frameMenuPrincipal.setVisible(true);
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
        
        //INIT GESTION PERFILES:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameGestionPerfiles = new JFrameGestionPerfiles();
        frameGestionPerfiles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGestionPerfiles.pack();
        
        //INIT GESTION PERFILES:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameGestionPerfiles = new JFrameGestionPerfiles();
        frameGestionPerfiles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGestionPerfiles.pack();
        
        //INIT GESTION PERFILES:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameGestionPerfiles = new JFrameGestionPerfiles();
        frameGestionPerfiles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGestionPerfiles.pack();
        
        //INIT CONFIRMACION BORRAR PERFIL:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameConfirmacionBorrarPerfil = new JFrameConfirmacionBorrarPerfil();
        frameConfirmacionBorrarPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConfirmacionBorrarPerfil.pack();
        
        //INIT CONFIRMACION RESETEAR ESTADISTICAS:
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameConfirmacionResetearEstadisticas = new JFrameConfirmacionResetearEstadisticas();
        frameConfirmacionResetearEstadisticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConfirmacionResetearEstadisticas.pack();
        
        //INIT RANKKING GLOBAL
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameRankingGlobal = new JFrameRankingGlobal();
        frameRankingGlobal .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRankingGlobal .pack();
        frameRankingGlobal.setVisible(false);
        
        //INIT RANKKING PERSONAL
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameRankingpersonal = new JFrameRankingPersonal();
        frameRankingpersonal .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRankingpersonal .pack();
        frameRankingpersonal.setVisible(false);
        
        //INIT ESTADISTICAS GENERALES
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameEstadisticasGenerales = new JFrameEstadisticasGenerales();
        frameEstadisticasGenerales .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEstadisticasGenerales .pack();
        frameEstadisticasGenerales.setVisible(false);
	}
	
	private void initListeners() {
		initListenersMenuPrincipal();
		initListenersIniciarSesion();
		initListenersRegistrarse();
		initListenersMenuOpciones();
		initListenersMenuSudoku();
		initListenersGestionPerfiles();
		initListenersConfirmacionResetearEstadisticas();
		initListenersConfirmacionBorrarPerfil();
		initListenersRankingGlobal();
		initListenersRankingPersonal();
		initListenersEstadisticasGenerales();
	}
	
	private void initListenersRankingGlobal() {
		frameRankingGlobal.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
		    }
		});
		frameRankingGlobal.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameRankingGlobal.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameRankingGlobal.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameRankingGlobal.getButVolverMenuOpciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameRankingGlobal.setVisible(false);
				frameMenuOpciones.setVisible(true);
		    }
		});
		
		frameRankingGlobal.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameRankingGlobal.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){
		        	frameRankingGlobal.setVisible(false);
					frameMenuOpciones.setVisible(true);
		        }
		});
		
		frameRankingGlobal.getButVolverMenuOpciones().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				frameRankingGlobal.setVisible(false);
				frameMenuOpciones.setVisible(true);
			}
		});
	}
	
	
	private void initListenersRankingPersonal() {
		frameRankingpersonal.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
		    }
		});
		
		frameRankingpersonal.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		
		frameRankingpersonal.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameRankingpersonal.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){
		        	frameRankingpersonal.setVisible(false);
					frameMenuOpciones.setVisible(true);
		        }
		});
		
		frameRankingpersonal.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameRankingpersonal.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameRankingpersonal.getButVolverMenuOpciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameRankingpersonal.setVisible(false);
				frameMenuOpciones.setVisible(true);
		    }
		});
		
		frameRankingpersonal.getButVolverMenuOpciones().addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {}
				@Override
				public void keyReleased(KeyEvent e) {}
				@Override
				public void keyPressed(KeyEvent e) {
					frameRankingpersonal.setVisible(false);
					frameMenuOpciones.setVisible(true);
				}
		});
	}
	
	private void initListenersEstadisticasGenerales() {
		frameEstadisticasGenerales.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
		    }
		});
		
		frameEstadisticasGenerales.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameEstadisticasGenerales.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameEstadisticasGenerales.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){
		        	frameEstadisticasGenerales.setVisible(false);
					frameMenuOpciones.setVisible(true);
		        }
		});
		
		frameEstadisticasGenerales.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameEstadisticasGenerales.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameEstadisticasGenerales.getButVolverMenuOpciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameEstadisticasGenerales.setVisible(false);
				frameMenuOpciones.setVisible(true);
		    }
		});
		
		frameEstadisticasGenerales.getButVolverMenuOpciones().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				frameEstadisticasGenerales.setVisible(false);
				frameMenuOpciones.setVisible(true);
			}
	});
	}
	
	//1------------------------------------------------------------
	
	private void initListenersMenuPrincipal() {
		//LISTENERS DE MENU PRINCIPAL:
		((JFrameMenuPrincipal) frameMenuPrincipal).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
		    }
		});
		
		((JFrameMenuPrincipal) frameMenuPrincipal).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameMenuPrincipal) frameMenuPrincipal).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameMenuPrincipal) frameMenuPrincipal).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		((JFrameMenuPrincipal) frameMenuPrincipal).getButIniciarSesion().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					frameMenuPrincipal.setVisible(false);
					((JFrameIniciarSesion) frameIniciarSesion).cleanValues();
					frameIniciarSesion.setVisible(true);
				}
		});
		((JFrameMenuPrincipal) frameMenuPrincipal).getButRegistrarse().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					frameMenuPrincipal.setVisible(false);
					((JFrameRegistrarse) frameRegistrarse).cleanValues();
					frameRegistrarse.setVisible(true);
				}
		});
		
		((JFrameMenuPrincipal) frameMenuPrincipal).getButIniciarSesion().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuPrincipal.setVisible(false);
					((JFrameIniciarSesion) frameIniciarSesion).cleanValues();
					frameIniciarSesion.setVisible(true);
				}
			}
		});
		
		((JFrameMenuPrincipal) frameMenuPrincipal).getButRegistrarse().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuPrincipal.setVisible(false);
					((JFrameRegistrarse) frameRegistrarse).cleanValues();
					frameRegistrarse.setVisible(true);
				}
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
		
		((JFrameIniciarSesion) frameIniciarSesion).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameIniciarSesion) frameIniciarSesion).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameIniciarSesion) frameIniciarSesion).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		((JFrameIniciarSesion) frameIniciarSesion).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				((JFrameIniciarSesion) frameIniciarSesion).getRootPane().getActionMap().put("Volver", new AbstractAction()
				{ public void actionPerformed(ActionEvent e){
					frameIniciarSesion.setVisible(false);
					frameMenuPrincipal.setVisible(true);
				}
		});
		
		((JFrameIniciarSesion) frameIniciarSesion).getButVolverMenuPrincipal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameIniciarSesion.setVisible(false);
				frameMenuPrincipal.setVisible(true);
			}
		});
		((JFrameIniciarSesion) frameIniciarSesion).getButVolverMenuPrincipal().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameIniciarSesion.setVisible(false);
					frameMenuPrincipal.setVisible(true);
				}
			}
		});
		
		
		((JFrameIniciarSesion) frameIniciarSesion).getButIniciarSesion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressIniciarSesion();
			}
		});
		((JFrameIniciarSesion) frameIniciarSesion).getButIniciarSesion().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER==e.getKeyCode()){
					pressIniciarSesion();
				}
			}
		});
	}
	
	private void pressIniciarSesion() {
		CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion = new CtrlCasoUsoIniciarSesion();
		try {
			nombreUsuario = ((JFrameIniciarSesion) frameIniciarSesion).getNombreUsuario();
			if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
			String contrasena = ((JFrameIniciarSesion) frameIniciarSesion).getContrasena();
			if (nombreUsuario.contains(" ") || contrasena.contains(" ")) throw (new ExcepcionNombreConEspaciosEnBlanco());
			ctrlCUIniciarSesion.iniciarSesion(nombreUsuario, contrasena);
			//Si llega hasta aqui es que ha funcionado sin ninguna excepcion
			frameIniciarSesion.setVisible(false);
			frameMenuOpciones.setVisible(true);
			//System.out.println("[Mensaje temporal] Sesion iniciada con el usuario " + nombreUsuario + " con contrasena " + contrasena);		
		} catch (ExcepcionNombreConEspaciosEnBlanco e) {
			nombreUsuario = "";
			((JFrameIniciarSesion) frameIniciarSesion).setMensajeError(e.getMessage());
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
	
	private void initListenersRegistrarse() {
		//LISTENERS DE REGISTRARSE:
		((JFrameRegistrarse) frameRegistrarse).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		((JFrameRegistrarse) frameRegistrarse).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameRegistrarse) frameRegistrarse).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameRegistrarse) frameRegistrarse).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        {public void actionPerformed(ActionEvent e){pressSalir();}
		});
				
		((JFrameRegistrarse) frameRegistrarse).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				((JFrameRegistrarse) frameRegistrarse).getRootPane().getActionMap().put("Volver", new AbstractAction()
				{public void actionPerformed(ActionEvent e){
					frameRegistrarse.setVisible(false);
					frameMenuPrincipal.setVisible(true);
				}
		});
		
		((JFrameRegistrarse) frameRegistrarse).getButVolverMenuPrincipal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameRegistrarse.setVisible(false);
				frameMenuPrincipal.setVisible(true);
			}
		});
		
		((JFrameRegistrarse) frameRegistrarse).getButVolverMenuPrincipal().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameRegistrarse.setVisible(false);
					frameMenuPrincipal.setVisible(true);
				}
			}
		});
		
		((JFrameRegistrarse) frameRegistrarse).getButRegistrarse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressRegistrarse();
			}
		});
		
		((JFrameRegistrarse) frameRegistrarse).getButRegistrarse().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER==e.getKeyCode()){
					pressRegistrarse();
				}
			}
		});
	}
	
	private void pressRegistrarse() {
		CtrlCasoUsoRegistrarse ctrlCURegistrarse = new CtrlCasoUsoRegistrarse();
		try {
			nombreUsuario = ((JFrameRegistrarse) frameRegistrarse).getNombreUsuario();
			if (nombreUsuario.isEmpty()) throw (new ExcepcionCamposVacios());
			String contrasena = ((JFrameRegistrarse) frameRegistrarse).getContrasena();
			if (nombreUsuario.contains(" ") || contrasena.contains(" ")) throw (new ExcepcionNombreConEspaciosEnBlanco());
			String confirmContrasena = ((JFrameRegistrarse) frameRegistrarse).getConfirmContrasena();
			if (! contrasena.equals(confirmContrasena)) throw (new ExcepcionContrasenasNoCoinciden());
			ctrlCURegistrarse.registrarse(nombreUsuario, contrasena);
			//Si llega hasta aqui es que ha funcionado sin ninguna excepcion
			frameRegistrarse.setVisible(false);
			frameMenuOpciones.setVisible(true);
			//System.out.println("[Mensaje temporal] Registrado con el usuario " + nombreUsuario + " con contrasena " + contrasena);		
		} catch (ExcepcionNombreConEspaciosEnBlanco e) {
			nombreUsuario = "";
			((JFrameRegistrarse) frameRegistrarse).setMensajeError(e.getMessage());
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
	
	//2-----------------------------------------------------------
	
	private void initListenersMenuOpciones() {
		//LISTENERS DE MENU OPCIONES:
		((JFrameMenuOpciones) frameMenuOpciones).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				((JFrameMenuOpciones) frameMenuOpciones).getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressCerrarSesion(frameMenuOpciones);}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameMenuOpciones) frameMenuOpciones).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButCerrarSesion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressCerrarSesion(frameMenuOpciones);
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButCerrarSesion().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressCerrarSesion(frameMenuOpciones);
				}
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButGestionPerfilUsu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuOpciones.setVisible(false);
				frameGestionPerfiles.setVisible(true);
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButGestionPerfilUsu().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuOpciones.setVisible(false);
					frameGestionPerfiles.setVisible(true);
				}
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButSelectSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuOpciones.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButSelectSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuOpciones.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarRankingLocal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuOpciones.setVisible(false);
				CtrlCasoUsoEstadisticas ctrlCUEstadisticas = new CtrlCasoUsoEstadisticas();
				DTORankingPersonal infoRankingPersonal = ctrlCUEstadisticas.GetDataRankingPersonal(nombreUsuario);
				frameRankingpersonal.muestraDatos(infoRankingPersonal);
				frameRankingpersonal.setVisible(true);
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarRankingLocal().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuOpciones.setVisible(false);
					CtrlCasoUsoEstadisticas ctrlCUEstadisticas = new CtrlCasoUsoEstadisticas();
					DTORankingPersonal infoRankingPersonal = ctrlCUEstadisticas.GetDataRankingPersonal(nombreUsuario);
					frameRankingpersonal.muestraDatos(infoRankingPersonal);
					frameRankingpersonal.setVisible(true);
				}
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarRankingGlobal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuOpciones.setVisible(false);
				CtrlCasoUsoEstadisticas ctrlCUEstadisticas = new CtrlCasoUsoEstadisticas();
				DTORankingPerTipus infoRankingPerTipus = ctrlCUEstadisticas.GetDataRankingPerTipus();
				frameRankingGlobal.muestraDatos(infoRankingPerTipus);
				frameRankingGlobal.setVisible(true);
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarRankingGlobal().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuOpciones.setVisible(false);
					CtrlCasoUsoEstadisticas ctrlCUEstadisticas = new CtrlCasoUsoEstadisticas();
					DTORankingPerTipus infoRankingPerTipus = ctrlCUEstadisticas.GetDataRankingPerTipus();
					frameRankingGlobal.muestraDatos(infoRankingPerTipus);
					frameRankingGlobal.setVisible(true);
				}
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarEstadisticasGenerales().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuOpciones.setVisible(false);
				CtrlCasoUsoEstadisticas ctrlCUEstadisticas = new CtrlCasoUsoEstadisticas();
				DTORankingGeneral infoRankingGeneral = ctrlCUEstadisticas.GetDataEstadisticasGenerales();
				frameEstadisticasGenerales.muestraDatos(infoRankingGeneral);
				frameEstadisticasGenerales.setVisible(true);
			}
		});
		
		((JFrameMenuOpciones) frameMenuOpciones).getButConsultarEstadisticasGenerales().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuOpciones.setVisible(false);
					CtrlCasoUsoEstadisticas ctrlCUEstadisticas = new CtrlCasoUsoEstadisticas();
					DTORankingGeneral infoRankingGeneral = ctrlCUEstadisticas.GetDataEstadisticasGenerales();
					frameEstadisticasGenerales.muestraDatos(infoRankingGeneral);
					frameEstadisticasGenerales.setVisible(true);
				}
			}
		});
	}
	
	private int NfromTamanoSudoku(String tamanoSudoku){
		int nn = Integer.parseInt(tamanoSudoku.substring(0, 1));
		if (nn == 1) nn =  16;			// todo calculado
		return (int) Math.sqrt(nn);
	}
	
	private tipoDificultad tipoDificultadFromStringDificultad(String dificultadSudoku){
		if (dificultadSudoku.equals("Trivial")) return tipoDificultad.trivial;
		if (dificultadSudoku.equals("Facil")) return tipoDificultad.facil;
		if (dificultadSudoku.equals("Medio")) return tipoDificultad.medio;
		return tipoDificultad.dificil; //else
	}
	
	//3-------------------------------------------------------------
	
	private void initListenersGestionPerfiles() {
		//LISTENERS DE GESTION PERFILES:
		frameGestionPerfiles.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameGestionPerfiles.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameGestionPerfiles.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameGestionPerfiles.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		
		frameGestionPerfiles.getButVolverMenuOpciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameGestionPerfiles.setVisible(false);
				frameMenuOpciones.setVisible(true);
			}
		});
		
		frameGestionPerfiles.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameGestionPerfiles.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameGestionPerfiles.setVisible(false);
						frameMenuOpciones.setVisible(true);
		            }
		});
		
		frameGestionPerfiles.getButVolverMenuOpciones().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameGestionPerfiles.setVisible(false);
					frameMenuOpciones.setVisible(true);
				}
			}
		});
		
		frameGestionPerfiles.getButResetearEstadisticasPerfil().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameGestionPerfiles.setVisible(false);
				frameConfirmacionResetearEstadisticas.setVisible(true);
			}
		});
		
		frameGestionPerfiles.getButResetearEstadisticasPerfil().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameGestionPerfiles.setVisible(false);
					frameConfirmacionResetearEstadisticas.setVisible(true);
				}
			}
		});
		
		frameGestionPerfiles.getButBorrarPerfil().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameGestionPerfiles.setVisible(false);
				frameConfirmacionBorrarPerfil.setVisible(true);
			}
		});
		
		frameGestionPerfiles.getButBorrarPerfil().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameGestionPerfiles.setVisible(false);
					frameConfirmacionBorrarPerfil.setVisible(true);
				}
			}
		});
	}
	
	private void initListenersConfirmacionResetearEstadisticas() {
		CtrlCasoUsoGestionPerfil ctrlCUGestionPerfil = new CtrlCasoUsoGestionPerfil();
		frameConfirmacionResetearEstadisticas.getButResetear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ctrlCUGestionPerfil.eliminarEstadisticasDeUsuario(nombreUsuario);
				frameConfirmacionResetearEstadisticas.setVisible(false);
				frameGestionPerfiles.setVisible(true);
			}
		});
		
		frameConfirmacionResetearEstadisticas.getButResetear().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					ctrlCUGestionPerfil.eliminarEstadisticasDeUsuario(nombreUsuario);
					frameConfirmacionResetearEstadisticas.setVisible(false);
					frameGestionPerfiles.setVisible(true);
				}
			}
		});
		
		frameConfirmacionResetearEstadisticas.getButNoResetear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameConfirmacionResetearEstadisticas.setVisible(false);
				frameGestionPerfiles.setVisible(true);
			}
		});
		
		frameConfirmacionResetearEstadisticas.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameConfirmacionResetearEstadisticas.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameConfirmacionResetearEstadisticas.setVisible(false);
						frameGestionPerfiles.setVisible(true);
		            }
		});
		
		frameConfirmacionResetearEstadisticas.getButNoResetear().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameConfirmacionResetearEstadisticas.setVisible(false);
					frameGestionPerfiles.setVisible(true);
				}
			}
		});
		
	}
	
	private void initListenersConfirmacionBorrarPerfil() {
		CtrlCasoUsoGestionPerfil ctrlCUGestionPerfil = new CtrlCasoUsoGestionPerfil();
		
		frameConfirmacionBorrarPerfil.getButEliminarPerfSud().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					ctrlCUGestionPerfil.eliminarSudokusComoAutor(nombreUsuario);
					ctrlCUGestionPerfil.eliminarPerfilUsuario(nombreUsuario);
					nombreUsuario = "";
					frameConfirmacionBorrarPerfil.setVisible(false);
					frameMenuPrincipal.setVisible(true);
				} catch (ExcepcionHayPartidaConSudoku e) {
					frameConfirmacionBorrarPerfil.setMensajeError(e.getMessage());
				}
			}
		});
		frameConfirmacionBorrarPerfil.getButEliminarPerfSud().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e1) {
				if (e1.VK_ENTER == e1.getKeyCode()) {
					try {
						ctrlCUGestionPerfil.eliminarSudokusComoAutor(nombreUsuario);
						ctrlCUGestionPerfil.eliminarPerfilUsuario(nombreUsuario);
						nombreUsuario = "";
						frameConfirmacionBorrarPerfil.setVisible(false);
						frameMenuPrincipal.setVisible(true);
					} catch (ExcepcionHayPartidaConSudoku e2) {
						frameConfirmacionBorrarPerfil.setMensajeError(e2.getMessage());
					}
				}
			}
		});
		frameConfirmacionBorrarPerfil.getButEliminarPerfil().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ctrlCUGestionPerfil.eliminarPerfilUsuario(nombreUsuario);
				nombreUsuario = "";
				frameConfirmacionBorrarPerfil.setVisible(false);
				frameMenuPrincipal.setVisible(true);
			}
		});
		frameConfirmacionBorrarPerfil.getButEliminarPerfil().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					ctrlCUGestionPerfil.eliminarPerfilUsuario(nombreUsuario);
					nombreUsuario = "";
					frameConfirmacionBorrarPerfil.setVisible(false);
					frameMenuPrincipal.setVisible(true);
				}
			}
		});
		frameConfirmacionBorrarPerfil.getButNoEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameConfirmacionBorrarPerfil.setVisible(false);
				frameGestionPerfiles.setVisible(true);
			}
		});
		
		frameConfirmacionBorrarPerfil.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameConfirmacionBorrarPerfil.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameConfirmacionBorrarPerfil.setVisible(false);
						frameGestionPerfiles.setVisible(true);
		            }
		});
		
		frameConfirmacionBorrarPerfil.getButNoEliminar().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameConfirmacionBorrarPerfil.setVisible(false);
					frameGestionPerfiles.setVisible(true);
				}
			}
		});
	}
	
	//4------------------------------------------------------------------
	
	private void pressSeleccionarSudoku() {
		String tipoSudoku = ((JFrameMenuSudoku) frameMenuSudoku).tipoSudokuElegido();
		String tamanoSudoku = ((JFrameMenuSudoku) frameMenuSudoku).tamanoElegido();
		String dificultadSudoku = ((JFrameMenuSudoku) frameMenuSudoku).dificultadElegida();
		ctrlCUSeleccionarJugarSudoku = new CtrlCasoUsoSeleccionarSudoku();
		int n = NfromTamanoSudoku(tamanoSudoku);
		tipoDificultad dificultad = tipoDificultadFromStringDificultad(dificultadSudoku);
		try{
			if (tipoSudoku == "tsBD") {
				Vector<DTOSudokuDeLaBD> infoSudokusDeLaBD = ctrlCUSeleccionarJugarSudoku.obtenerSudokusDeLaBD(dificultad, n);
				//INIT SELECCIONAR SUDOKU DE LA BD:
		        JFrame.setDefaultLookAndFeelDecorated(true);
		        frameSeleccionarSudokuBD = new JFrameSeleccionarSudokuBD(infoSudokusDeLaBD);
		        frameSeleccionarSudokuBD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frameSeleccionarSudokuBD.pack();
		        //activar listeners de la vista:
		        initListenersJFrameSeleccionarSudokuBD();
		        //Ocultar vista actual y mostrar la siguiente:
		        frameMenuSudoku.setVisible(false);
		        frameSeleccionarSudokuBD.setVisible(true);
			} else if (tipoSudoku == "tsGenerado") {
				try {
					DTOSudokuGenerado infoSudokuGenerado = ctrlCUSeleccionarJugarSudoku.obtenerSudokuGenerado(nombreUsuario, dificultad, n);
					frameMenuSudoku.setVisible(false);
					Vector<DTOCeldaFija> vCeldasFijas = infoSudokuGenerado.getCeldasFijas();
					String nomSudoku = infoSudokuGenerado.getNombreSudoku();
					if (n==2) {
						//Mostrar juego:
						JFrame.setDefaultLookAndFeelDecorated(true);
						frameJuego4x4 = new JFrameJuego4x4(vCeldasFijas,nomSudoku);
						frameJuego4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameJuego4x4.pack();
						initListenersJFrameJuego4x4();
						frameJuego4x4.setVisible(true);
					} else if (n==3) {
						//Mostrar juego:
						JFrame.setDefaultLookAndFeelDecorated(true);
						frameJuego9x9 = new JFrameJuego9x9(vCeldasFijas,nomSudoku);
						frameJuego9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameJuego9x9.pack();
						initListenersJFrameJuego9x9();
						frameJuego9x9.setVisible(true);
					} else {
						//Mostrar juego:
						JFrame.setDefaultLookAndFeelDecorated(true);
						frameJuego16x16 = new JFrameJuego16x16(vCeldasFijas,nomSudoku);
						frameJuego16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameJuego16x16.pack();
						initListenersJFrameJuego16x16();
						frameJuego16x16.setVisible(true);
					}
				} catch (ExcepcionTimerYaEnEjecucion e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionTamanoIncorrecto e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionPosicionFueraRango e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionNumCeldasDiferenteTamano e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionCasillaBloqueada e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionValorFueraRango e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionNumeroFijo e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionValorYaPuesto e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} catch (ExcepcionCasillaVaciaNoFijable e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				}
			} else if (tipoSudoku == "tsProponer") { 
				if (n == 2) {
					//INIT SELECCIONAR SUDOKU PROPUESTO:
			        JFrame.setDefaultLookAndFeelDecorated(true);
			        frameProponerSudoku4x4 = new JFrameProponerSudoku4x4();
			        frameProponerSudoku4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frameProponerSudoku4x4.pack();
			        //activar listeners de la vista:
			        initListenersJFrameProponerSudoku4x4((JFrameProponerSudoku4x4) frameProponerSudoku4x4);
			        //Ocultar vista actual y mostrar la siguiente:
			        frameMenuSudoku.setVisible(false);
			        frameProponerSudoku4x4.setVisible(true);
				} else if (n == 3) {
					//INIT SELECCIONAR SUDOKU PROPUESTO:
			        JFrame.setDefaultLookAndFeelDecorated(true);
			        frameProponerSudoku9x9 = new JFrameProponerSudoku9x9();
			        frameProponerSudoku9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frameProponerSudoku9x9.pack();
			        //activar listeners de la vista:
			        initListenersJFrameProponerSudoku9x9((JFrameProponerSudoku9x9) frameProponerSudoku9x9);
			        //Ocultar vista actual y mostrar la siguiente:
			        frameMenuSudoku.setVisible(false);
			        frameProponerSudoku9x9.setVisible(true);
				} else { //n == 4
					//INIT SELECCIONAR SUDOKU PROPUESTO:
			        JFrame.setDefaultLookAndFeelDecorated(true);
			        frameProponerSudoku16x16 = new JFrameProponerSudoku16x16();
			        frameProponerSudoku16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frameProponerSudoku16x16.pack();
			        //activar listeners de la vista:
			        initListenersJFrameProponerSudoku16x16((JFrameProponerSudoku16x16) frameProponerSudoku16x16);
			        //Ocultar vista actual y mostrar la siguiente:
			        frameMenuSudoku.setVisible(false);
			        frameProponerSudoku16x16.setVisible(true);
				}
			} else { //tipo tsReanudarPartida
				Vector<DTOPartidaAMedias> infoPartidasAMedias = ctrlCUSeleccionarJugarSudoku.obtenerPartidas(nombreUsuario, dificultad, n);
				//INIT SELECCIONAR PARTIDA A REANUDAR:
		        JFrame.setDefaultLookAndFeelDecorated(true);
		        frameSeleccionarPartidaReanudar = new JFrameSeleccionarPartidaReanudar(infoPartidasAMedias);
		        frameSeleccionarPartidaReanudar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frameSeleccionarPartidaReanudar.pack();
		        //activar listeners de la vista:
		        initListenersJFrameSeleccionarPartidaReanudar();
		        //Ocultar vista actual y mostrar la siguiente:
		        frameMenuSudoku.setVisible(false);
		        frameSeleccionarPartidaReanudar.setVisible(true);
			}
		} catch (ExcepcionNoHaySudokuConCaracteristicasSeleccionadas e) {
			((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
		}
		catch (ExcepcionMaquinaNoGeneraTriviales e) {
			((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
		}
	}
	
	private void initListenersMenuSudoku() {
		//LISTENERS DE MENU SUDOKU:
		((JFrameMenuSudoku) frameMenuSudoku).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		((JFrameMenuSudoku) frameMenuSudoku).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameMenuSudoku) frameMenuSudoku).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameMenuSudoku) frameMenuSudoku).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		
		((JFrameMenuSudoku) frameMenuSudoku).getButVolverMenuOpciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameMenuSudoku.setVisible(false);
				frameMenuOpciones.setVisible(true);
			}
		});
		
		((JFrameMenuSudoku) frameMenuSudoku).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				((JFrameMenuSudoku) frameMenuSudoku).getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameMenuSudoku.setVisible(false);
						frameMenuOpciones.setVisible(true);
		            }
		});
		
		((JFrameMenuSudoku) frameMenuSudoku).getButVolverMenuOpciones().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameMenuSudoku.setVisible(false);
					frameMenuOpciones.setVisible(true);
				}
			}
		});
		
		((JFrameMenuSudoku) frameMenuSudoku).getButSelectsudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSeleccionarSudoku();
			}
		});
		
		((JFrameMenuSudoku) frameMenuSudoku).getButSelectsudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSeleccionarSudoku();
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
	
	//5-------------------------------------------------------------
	
	private void pressGetSudokuBDSeleccionado() {
		try {
			int nSelect = ((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getCuantosSeleccionados();
			if (nSelect == 0) throw new ExcepcionNingunSudokuSeleccionado();
			if (nSelect > 1) throw new ExcepcionMasDeUnSudokuSeleccionado();
			
			String nomSudoku = ((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getNombreSudokuSeleccionado();
			
			Vector<DTOCeldaFija> vCeldasFijas = ctrlCUSeleccionarJugarSudoku.obtenerSudoku(nomSudoku, nombreUsuario);
			frameSeleccionarSudokuBD.setVisible(false);
			
			int n = ctrlCUSeleccionarJugarSudoku.getNSudoku(nomSudoku);
			if (n==2) {
				//Mostrar juego:
				JFrame.setDefaultLookAndFeelDecorated(true);
				frameJuego4x4 = new JFrameJuego4x4(vCeldasFijas,nomSudoku);
				frameJuego4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego4x4.pack();
				initListenersJFrameJuego4x4();
				frameJuego4x4.setVisible(true);
			} else if (n==3) {
				//Mostrar juego:
				JFrame.setDefaultLookAndFeelDecorated(true);
				frameJuego9x9 = new JFrameJuego9x9(vCeldasFijas,nomSudoku);
				frameJuego9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego9x9.pack();
				initListenersJFrameJuego9x9();
				frameJuego9x9.setVisible(true);
			} else {
				//Mostrar juego:
				JFrame.setDefaultLookAndFeelDecorated(true);
				frameJuego16x16 = new JFrameJuego16x16(vCeldasFijas,nomSudoku);
				frameJuego16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego16x16.pack();
				initListenersJFrameJuego16x16();
				frameJuego16x16.setVisible(true);
			}
		} catch (ExcepcionNingunSudokuSeleccionado e) {
			((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).setMensaje(e.getMessage());
		} catch (ExcepcionMasDeUnSudokuSeleccionado e) {
			((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEnEjecucion e) {
			((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).setMensaje(e.getMessage());
		}
	}
	
	private void initListenersJFrameSeleccionarSudokuBD() {
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameSeleccionarSudokuBD.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameSeleccionarSudokuBD.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameSeleccionarSudokuBD.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressGetSudokuBDSeleccionado();
			}
		});
		
		((JFrameSeleccionarSudokuBD) frameSeleccionarSudokuBD).getJugarSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressGetSudokuBDSeleccionado();
				}
			}
		});
		
	}
	
	private void pressGetSudokuPartidaSeleccionado() {
		try {
			int nSelect = ((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getCuantosSeleccionados();
			if (nSelect == 0) throw new ExcepcionNingunSudokuSeleccionado();
			if (nSelect > 1) throw new ExcepcionMasDeUnSudokuSeleccionado();
			
			String nomSudoku = ((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getNombreSudokuSeleccionado();
			String fechaSudoku = ((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getFechaSudokuSeleccionado();
			
			DTOInfoPartida infoPartida = ctrlCUSeleccionarJugarSudoku.obtenerDatosPartida(nomSudoku, fechaSudoku, nombreUsuario);
			frameSeleccionarPartidaReanudar.setVisible(false);
			Vector<DTOCeldaFija> vCeldasFijas = infoPartida.getCeldasFijas();
			Vector<DTOCeldaFija> vCeldasNoFijas = infoPartida.getCeldasNoFijas();
			Vector<DTOCeldaFija> vMarcas = infoPartida.getMarcas();
			
			int n = ctrlCUSeleccionarJugarSudoku.getNSudoku(nomSudoku);
			if (n==2) {
				//Mostrar juego:
				JFrame.setDefaultLookAndFeelDecorated(true);
				frameJuego4x4 = new JFrameJuego4x4(vCeldasFijas,nomSudoku);
				for (DTOCeldaFija celdaNoFija : vCeldasNoFijas) {
					frameJuego4x4.ponerValorCasilla(celdaNoFija.getFila(), celdaNoFija.getColumna(), celdaNoFija.getValor());
				}
				for (DTOCeldaFija marca : vMarcas) {
					frameJuego4x4.ponerMarcaCasilla(marca.getFila(), marca.getColumna(), marca.getValor());
				}
				frameJuego4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego4x4.pack();
				initListenersJFrameJuego4x4();
				frameJuego4x4.setVisible(true);
			} else if (n==3) {
				//Mostrar juego:
				JFrame.setDefaultLookAndFeelDecorated(true);
				frameJuego9x9 = new JFrameJuego9x9(vCeldasFijas,nomSudoku);
				for (DTOCeldaFija celdaNoFija : vCeldasNoFijas) {
					frameJuego9x9.ponerValorCasilla(celdaNoFija.getFila(), celdaNoFija.getColumna(), celdaNoFija.getValor());
				}
				for (DTOCeldaFija marca : vMarcas) {
					frameJuego9x9.ponerMarcaCasilla(marca.getFila(), marca.getColumna(), marca.getValor());
				}
				frameJuego9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego9x9.pack();
				initListenersJFrameJuego9x9();
				frameJuego9x9.setVisible(true);
			} else {
				//Mostrar juego:
				JFrame.setDefaultLookAndFeelDecorated(true);
				frameJuego16x16 = new JFrameJuego16x16(vCeldasFijas,nomSudoku);
				for (DTOCeldaFija celdaNoFija : vCeldasNoFijas) {
					frameJuego16x16.ponerValorCasilla(celdaNoFija.getFila(), celdaNoFija.getColumna(), celdaNoFija.getValor());
				}
				for (DTOCeldaFija marca : vMarcas) {
					frameJuego16x16.ponerMarcaCasilla(marca.getFila(), marca.getColumna(), marca.getValor());
				}
				frameJuego16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameJuego16x16.pack();
				initListenersJFrameJuego16x16();
				frameJuego16x16.setVisible(true);
			}
		} catch (ExcepcionValorFueraRango e) {
			((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).setMensaje(e.getMessage());
		} catch (ExcepcionNingunSudokuSeleccionado e) {
			((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).setMensaje(e.getMessage());
		} catch (ExcepcionMasDeUnSudokuSeleccionado e) {
			((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEnEjecucion e) {
			((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).setMensaje(e.getMessage());
		}
	}
	
	private void initListenersJFrameSeleccionarPartidaReanudar() {
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameSeleccionarPartidaReanudar.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameSeleccionarPartidaReanudar.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameSeleccionarPartidaReanudar.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressGetSudokuPartidaSeleccionado();
			}
		});
		
		((JFrameSeleccionarPartidaReanudar) frameSeleccionarPartidaReanudar).getJugarSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressGetSudokuPartidaSeleccionado();
				}
			}
		});
	}
	
	//6-------------------------------------------------------------
	
	private void pressJugarJuegoPropuesto4x4(JFrameProponerSudoku4x4 frameProponerSudoku4x4) {
		int nn = frameProponerSudoku4x4.getNN();
		int n = (int) Math.sqrt(nn);
		String nombreSudoku = frameProponerSudoku4x4.getNombreSudoku();
		Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
		try {
			if (nombreSudoku.isEmpty()) throw new ExcepcionCamposVacios();
			if (nombreSudoku.contains(" ")) throw new ExcepcionNombreConEspaciosEnBlanco();
			frameProponerSudoku4x4.setMensaje("");
			for (int i = 0; i < nn; ++i) { 
				for (int j = 0; j < nn; ++j) {	
					//valor 0 significa vacio
					int valor = frameProponerSudoku4x4.getValorCelda(i, j);
					if (valor != 0) vCeldasFijas.addElement(new DTOCeldaFija(i, j, valor));
				}
			}
			ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, nombreSudoku, vCeldasFijas, n);
			
			frameProponerSudoku4x4.setVisible(false);
			
			//Mostrar juego:
			JFrame.setDefaultLookAndFeelDecorated(true);
			frameJuego4x4 = new JFrameJuego4x4(vCeldasFijas,nombreSudoku);
			frameJuego4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameJuego4x4.pack();
			initListenersJFrameJuego4x4();
			frameJuego4x4.setVisible(true);
		} catch (ExcepcionNombreConEspaciosEnBlanco e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuYaExiste e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCamposVacios e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuSinSolucion e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuConMasDe1Solucion e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionTamanoIncorrecto e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionNumCeldasDiferenteTamano e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEnEjecucion e) {
			frameProponerSudoku4x4.setMensaje(e.getMessage());
		}
	}
	
	private void pressJugarJuegoPropuesto9x9(JFrameProponerSudoku9x9 frameProponerSudoku9x9) {
		int nn = frameProponerSudoku9x9.getNN();
		int n = (int) Math.sqrt(nn);
		String nombreSudoku = frameProponerSudoku9x9.getNombreSudoku();
		Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
		try {
			if (nombreSudoku.isEmpty()) throw new ExcepcionCamposVacios();
			if (nombreSudoku.contains(" ")) throw new ExcepcionNombreConEspaciosEnBlanco();
			frameProponerSudoku9x9.setMensaje("");
			for (int i = 0; i < nn; ++i) { 
				for (int j = 0; j < nn; ++j) {	
					//valor 0 significa vacio
					int valor = frameProponerSudoku9x9.getValorCelda(i, j);
					if (valor != 0) vCeldasFijas.addElement(new DTOCeldaFija(i, j, valor));
				}
			}
			ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, nombreSudoku, vCeldasFijas, n);
			
			frameProponerSudoku9x9.setVisible(false);
			
			//Mostrar juego:
			JFrame.setDefaultLookAndFeelDecorated(true);
			frameJuego9x9 = new JFrameJuego9x9(vCeldasFijas,nombreSudoku);
			frameJuego9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameJuego9x9.pack();
			initListenersJFrameJuego9x9();
			frameJuego9x9.setVisible(true);
		} catch (ExcepcionNombreConEspaciosEnBlanco e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuYaExiste e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCamposVacios e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuSinSolucion e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuConMasDe1Solucion e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionTamanoIncorrecto e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionNumCeldasDiferenteTamano e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEnEjecucion e) {
			frameProponerSudoku9x9.setMensaje(e.getMessage());
		}
	}
	
	private void pressJugarJuegoPropuesto16x16(JFrameProponerSudoku16x16 frameProponerSudoku16x16) {
		int nn = frameProponerSudoku16x16.getNN();
		int n = (int) Math.sqrt(nn);
		String nombreSudoku = frameProponerSudoku16x16.getNombreSudoku();
		Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
		try {
			if (nombreSudoku.isEmpty()) throw new ExcepcionCamposVacios();
			if (nombreSudoku.contains(" ")) throw new ExcepcionNombreConEspaciosEnBlanco();
			frameProponerSudoku16x16.setMensaje("");
			for (int i = 0; i < nn; ++i) { 
				for (int j = 0; j < nn; ++j) {	
					//valor 0 significa vacio
					int valor = frameProponerSudoku16x16.getValorCelda(i, j);
					if (valor != 0) vCeldasFijas.addElement(new DTOCeldaFija(i, j, valor));
				}
			}
			ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, nombreSudoku, vCeldasFijas, n);
			
			frameProponerSudoku16x16.setVisible(false);
			
			//Mostrar juego:
			JFrame.setDefaultLookAndFeelDecorated(true);
			frameJuego16x16 = new JFrameJuego16x16(vCeldasFijas,nombreSudoku);
			frameJuego16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameJuego16x16.pack();
			initListenersJFrameJuego16x16();
			frameJuego16x16.setVisible(true);
		} catch (ExcepcionNombreConEspaciosEnBlanco e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuYaExiste e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCamposVacios e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuSinSolucion e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionSudokuConMasDe1Solucion e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionTamanoIncorrecto e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionNumCeldasDiferenteTamano e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEnEjecucion e) {
			frameProponerSudoku16x16.setMensaje(e.getMessage());
		}
	}
	
	private void initListenersJFrameProponerSudoku4x4(JFrameProponerSudoku4x4 frameProponerSudoku4x4) {
		//LISTENERS DE PROPONER SUDOKU 4X4:
		frameProponerSudoku4x4.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameProponerSudoku4x4.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameProponerSudoku4x4.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameProponerSudoku4x4.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameProponerSudoku4x4.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameProponerSudoku4x4.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		frameProponerSudoku4x4.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameProponerSudoku4x4.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameProponerSudoku4x4.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		frameProponerSudoku4x4.getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameProponerSudoku4x4.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		
		frameProponerSudoku4x4.getButJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressJugarJuegoPropuesto4x4(frameProponerSudoku4x4);
			}
		});
		
		frameProponerSudoku4x4.getButJugarSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressJugarJuegoPropuesto4x4(frameProponerSudoku4x4);
				}
			}
		});
		
	}
	
	private void initListenersJFrameProponerSudoku9x9(JFrameProponerSudoku9x9 frameProponerSudoku9x9) {
		//LISTENERS DE PROPONER SUDOKU 9x9:
		frameProponerSudoku9x9.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameProponerSudoku9x9.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameProponerSudoku9x9.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameProponerSudoku9x9.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameProponerSudoku9x9.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameProponerSudoku9x9.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		frameProponerSudoku9x9.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameProponerSudoku9x9.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameProponerSudoku9x9.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		frameProponerSudoku9x9.getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameProponerSudoku9x9.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		
		frameProponerSudoku9x9.getButJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressJugarJuegoPropuesto9x9(frameProponerSudoku9x9);
			}
		});
		
		frameProponerSudoku9x9.getButJugarSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressJugarJuegoPropuesto9x9(frameProponerSudoku9x9);
				}
			}
		});
		
	}
	
	private void initListenersJFrameProponerSudoku16x16(JFrameProponerSudoku16x16 frameProponerSudoku16x16) {
		//LISTENERS DE PROPONER SUDOKU 16x16:
		frameProponerSudoku16x16.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameProponerSudoku16x16.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameProponerSudoku16x16.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameProponerSudoku16x16.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameProponerSudoku16x16.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameProponerSudoku16x16.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		frameProponerSudoku16x16.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameProponerSudoku16x16.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	frameProponerSudoku16x16.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		frameProponerSudoku16x16.getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameProponerSudoku16x16.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		
		frameProponerSudoku16x16.getButJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressJugarJuegoPropuesto16x16(frameProponerSudoku16x16);
			}
		});
		
		frameProponerSudoku16x16.getButJugarSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressJugarJuegoPropuesto16x16(frameProponerSudoku16x16);
				}
			}
		});
		
	}
	
	//7------------------------------------------------
	
	private void pressPedirPista4x4() {
		try {
			DTOCeldaFija celdaPista;
			celdaPista = ctrlCUSeleccionarJugarSudoku.pedirPista();
			frameJuego4x4.nuevaPista(celdaPista.getFila(), celdaPista.getColumna(), celdaPista.getValor());
			frameJuego4x4.setMensaje("Pista anadida, el numero " + celdaPista.getValor() + " en la posicion [" + (celdaPista.getFila()+1) + "," + (celdaPista.getColumna()+1) + "]");
			if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {frameJuego4x4.setMensaje("Pista anadida, el numero " + celdaPista.getValor() + " en la posicion [" + (celdaPista.getFila()+1) + "," + (celdaPista.getColumna()+1) + "]" + " ¡Sudoku resuelto! :)"); mostrarTiempos4x4(); pressGuardarPartida(4);}
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEstaParado e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionNoQuedanCeldasVacias e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameJuego4x4.setMensaje("El valor de la pista ya esta puesto en una de sus regiones");
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameJuego4x4.setMensaje(e.getMessage());
		}
	}
	
	private void pressVaciarTablero4x4() {
		try {
			ctrlCUSeleccionarJugarSudoku.vaciarTablero();
			frameJuego4x4.vaciarTablero();
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		}
	}
	
	private void pressResuelveSistema4x4() {
		try {
			int nn = frameJuego4x4.getNN();
			Vector<DTOCeldaFija> vCeldasSudoku = ctrlCUSeleccionarJugarSudoku.resuelveSistema(nn);
			pressGuardarPartida(nn);
			for (DTOCeldaFija celdaSudoku : vCeldasSudoku) {
				int i = celdaSudoku.getFila();
				int j = celdaSudoku.getColumna();
				int val = celdaSudoku.getValor();
				if (!frameJuego4x4.esCeldaFija(i, j)) {frameJuego4x4.ponerValorCasilla(i, j, val); frameJuego4x4.descolorearCasilla(i, j);}
			}
			mostrarTiempos4x4();
			frameJuego4x4.setMensaje("Sudoku resuelto por el sistema");
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEstaParado e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameJuego4x4.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameJuego4x4.setMensaje(e.getMessage());
		}
	}
	
	private void pressGuardarPartida4x4(){
		try {
			if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) throw new ExcepcionPartidaYaAcabada();
			pressGuardarPartida(4);
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego4x4.setMensaje(e.getMessage());
		}
	}
	
	private void listenersPanOpciones4x4() {
		Vector<JButton> vButOpciones = frameJuego4x4.getVButOpciones();
		for (JButton butOpcion : vButOpciones) {
			butOpcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int valor = Integer.parseInt(butOpcion.getText());
					frameJuego4x4.desactivarPanelOpciones();
					int i = frameJuego4x4.getFilaActiva();
					int j = frameJuego4x4.getColumnaActiva();
					boolean modoActivo = frameJuego4x4.getModoActivo();
					try {
						if (!modoActivo) { //modo activo = introducir valor a casilla
							if (!ctrlCUSeleccionarJugarSudoku.esValorCelda(i, j, valor)) { //si no es el valor que ya esta puesto, lo anade
								ctrlCUSeleccionarJugarSudoku.quitarValorCelda(i, j); //tiene que estar, por si en la funcion siguiente salta excepcion, que se haya borrado lo que habia
								ctrlCUSeleccionarJugarSudoku.anadirValorCelda(i, j, valor);
								frameJuego4x4.ponerValorCasilla(i, j, valor);
							} else {
								ctrlCUSeleccionarJugarSudoku.quitarValorCelda(i, j);
								frameJuego4x4.quitarValorCasilla(i, j);
							}
							frameJuego4x4.setMensaje("");
							if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {frameJuego4x4.setMensaje("Sudoku resuelto con exito! :)"); mostrarTiempos4x4(); pressGuardarPartida(4);}
						}
						else { //modo activo = introducir marca a casilla
							if (ctrlCUSeleccionarJugarSudoku.estaMarca(i, j, valor)) { //quitar marca
								ctrlCUSeleccionarJugarSudoku.quitarMarca(i, j, valor);
								frameJuego4x4.quitarMarcaCasilla(i,j,valor);
							} else { //poner marca
								ctrlCUSeleccionarJugarSudoku.anadirMarca(i, j, valor);
								frameJuego4x4.ponerMarcaCasilla(i,j,valor);
							}
							frameJuego4x4.setMensaje("");
						}
						frameJuego4x4.descolorearCasilla(i,j);
					} catch (ExcepcionTimerYaEstaParado e) {
						frameJuego4x4.setMensaje(e.getMessage());
					} catch (ExcepcionValorFueraRango e) {
						frameJuego4x4.setMensaje(e.getMessage());
					} catch (ExcepcionPosicionFueraRango e) {
						frameJuego4x4.setMensaje(e.getMessage());
					} catch (ExcepcionNumeroFijo e) {
						frameJuego4x4.setMensaje(e.getMessage());
					} catch (ExcepcionCasillaBloqueada e) {
						frameJuego4x4.setMensaje(e.getMessage());
					} catch (ExcepcionValorYaPuesto e) {
						frameJuego4x4.setMensaje(e.getMessage());
						frameJuego4x4.colorearCasillaInvalida(i, j);
						frameJuego4x4.quitarValorCasilla(i, j);
					} catch (ExcepcionCasillaVaciaNoFijable e) {
						frameJuego4x4.setMensaje(e.getMessage());
					} catch (ExcepcionPartidaYaAcabada e) {
						frameJuego4x4.setMensaje(e.getMessage());
					}
				}
			});
		}
	}
	
	private void listenersCeldasNumeros4x4() {
		Vector<JPanel> vPanCeldas = frameJuego4x4.getVPanCeldas();
		for (JPanel panCelda : vPanCeldas) {
			panCelda.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {/*System.out.println("pruebas: mouseReleased");*/}
				@Override
				public void mousePressed(MouseEvent e) {/*System.out.println("pruebas: mousePressed");*/}
				@Override
				public void mouseExited(MouseEvent e) {/*System.out.println("pruebas: mouseExited");*/}
				@Override
				public void mouseEntered(MouseEvent e) {/*System.out.println("pruebas: mouseEntered");*/}
				@Override
				public void mouseClicked(MouseEvent e) {
					/*System.out.println("pruebas: mouseClicked");*/
					String nombreCelda = panCelda.getName();
					String strFila = nombreCelda.substring(8, 9);
					String strColu = nombreCelda.substring(9, 10);
					int i = Integer.parseInt(strFila);
					int j = Integer.parseInt(strColu);
					frameJuego4x4.colorearCasillaActiva(i,j);
					if (!frameJuego4x4.esCeldaFija(i,j) && !ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {
						frameJuego4x4.guardarCoordenadasActivas(i,j);
						frameJuego4x4.activarPanelOpciones();
					} else frameJuego4x4.desactivarPanelOpciones();
					frameJuego4x4.setMensaje("");
				}
			});
		}
	}
	
	private void initListenersJFrameJuego4x4(){
		frameJuego4x4.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameJuego4x4.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameJuego4x4.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameJuego4x4.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameJuego4x4.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ctrlCUSeleccionarJugarSudoku = null;
				frameJuego4x4.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		frameJuego4x4.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameJuego4x4.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	ctrlCUSeleccionarJugarSudoku = null;
						frameJuego4x4.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		frameJuego4x4.getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					ctrlCUSeleccionarJugarSudoku = null;
					frameJuego4x4.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		frameJuego4x4.getButPedirPista().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressPedirPista4x4();
			}
		});
		frameJuego4x4.getButPedirPista().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressPedirPista4x4();
				}
			}
		});
		frameJuego4x4.getButVaciarTablero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressVaciarTablero4x4();
			}
		});
		frameJuego4x4.getButVaciarTablero().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressVaciarTablero4x4();
				}
			}
		});
		frameJuego4x4.getButActivarDesModoEdicion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameJuego4x4.cambiarModoActivo();
				frameJuego4x4.setMensaje("");
			}
		});
		frameJuego4x4.getButActivarDesModoEdicion().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameJuego4x4.cambiarModoActivo();
					frameJuego4x4.setMensaje("");
				}
			}
		});
		frameJuego4x4.getButResuelveSistema().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressResuelveSistema4x4();
			}
		});
		frameJuego4x4.getButResuelveSistema().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressResuelveSistema4x4();
				}
			}
		});
		frameJuego4x4.getButMostrarTiempos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mostrarTiempos4x4();
			}
		});
		frameJuego4x4.getButMostrarTiempos().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					mostrarTiempos4x4();
				}
			}
		});
		frameJuego4x4.getButGuardarPartida().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressGuardarPartida4x4();
			}
		});
		frameJuego4x4.getButGuardarPartida().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressGuardarPartida4x4();
				}
			}
		});
		
		listenersPanOpciones4x4();
		listenersCeldasNumeros4x4();
		
	}
	
	
	//8------------------------------------------------------------------------
	
	private void pressPedirPista9x9() {
		try {
			DTOCeldaFija celdaPista;
			celdaPista = ctrlCUSeleccionarJugarSudoku.pedirPista();
			frameJuego9x9.nuevaPista(celdaPista.getFila(), celdaPista.getColumna(), celdaPista.getValor());
			frameJuego9x9.setMensaje("Pista anadida, el numero " + celdaPista.getValor() + " en la posicion [" + (celdaPista.getFila()+1) + "," + (celdaPista.getColumna()+1) + "]");
			if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {frameJuego9x9.setMensaje("Pista anadida, el numero " + celdaPista.getValor() + " en la posicion [" + (celdaPista.getFila()+1) + "," + (celdaPista.getColumna()+1) + "]" + " ¡Sudoku resuelto! :)"); mostrarTiempos9x9(); pressGuardarPartida(9);}
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEstaParado e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionNoQuedanCeldasVacias e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameJuego9x9.setMensaje("El valor de la pista ya esta puesto en una de sus regiones");
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameJuego9x9.setMensaje(e.getMessage());
		}
	}
	
	private void pressVaciarTablero9x9() {
		try {
			ctrlCUSeleccionarJugarSudoku.vaciarTablero();
			frameJuego9x9.vaciarTablero();
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		}
	}
	
	private void pressResuelveSistema9x9() {
		try {
			int nn = frameJuego9x9.getNN();
			Vector<DTOCeldaFija> vCeldasSudoku = ctrlCUSeleccionarJugarSudoku.resuelveSistema(nn);
			pressGuardarPartida(nn);
			for (DTOCeldaFija celdaSudoku : vCeldasSudoku) {
				int i = celdaSudoku.getFila();
				int j = celdaSudoku.getColumna();
				int val = celdaSudoku.getValor();
				if (!frameJuego9x9.esCeldaFija(i, j)) {frameJuego9x9.ponerValorCasilla(i, j, val); frameJuego9x9.descolorearCasilla(i, j);}
			}
			mostrarTiempos9x9();
			frameJuego9x9.setMensaje("Sudoku resuelto por el sistema");
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEstaParado e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameJuego9x9.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameJuego9x9.setMensaje(e.getMessage());
		}
	}
	
	private void pressGuardarPartida9x9(){
		try {
			if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) throw new ExcepcionPartidaYaAcabada();
			pressGuardarPartida(9);
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego9x9.setMensaje(e.getMessage());
		}
	}
	
	private void listenersPanOpciones9x9() {
		Vector<JButton> vButOpciones = frameJuego9x9.getVButOpciones();
		for (JButton butOpcion : vButOpciones) {
			butOpcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int valor = Integer.parseInt(butOpcion.getText());
					frameJuego9x9.desactivarPanelOpciones();
					int i = frameJuego9x9.getFilaActiva();
					int j = frameJuego9x9.getColumnaActiva();
					boolean modoActivo = frameJuego9x9.getModoActivo();
					try {
						if (!modoActivo) { //modo activo = introducir valor a casilla
							if (!ctrlCUSeleccionarJugarSudoku.esValorCelda(i, j, valor)) { //si no es el valor que ya esta puesto, lo anade
								ctrlCUSeleccionarJugarSudoku.quitarValorCelda(i, j); //tiene que estar, por si en la funcion siguiente salta excepcion, que se haya borrado lo que habia
								ctrlCUSeleccionarJugarSudoku.anadirValorCelda(i, j, valor);
								frameJuego9x9.ponerValorCasilla(i, j, valor);
							} else {
								ctrlCUSeleccionarJugarSudoku.quitarValorCelda(i, j);
								frameJuego9x9.quitarValorCasilla(i, j);
							}
							frameJuego9x9.setMensaje("");
							if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {frameJuego9x9.setMensaje("Sudoku resuelto con exito! :)"); mostrarTiempos9x9(); pressGuardarPartida(9);}
						}
						else { //modo activo = introducir marca a casilla
							if (ctrlCUSeleccionarJugarSudoku.estaMarca(i, j, valor)) { //quitar marca
								ctrlCUSeleccionarJugarSudoku.quitarMarca(i, j, valor);
								frameJuego9x9.quitarMarcaCasilla(i,j,valor);
							} else { //poner marca
								ctrlCUSeleccionarJugarSudoku.anadirMarca(i, j, valor);
								frameJuego9x9.ponerMarcaCasilla(i,j,valor);
							}
							frameJuego9x9.setMensaje("");
						}
						frameJuego9x9.descolorearCasilla(i,j);
					} catch (ExcepcionTimerYaEstaParado e) {
						frameJuego9x9.setMensaje(e.getMessage());
					} catch (ExcepcionValorFueraRango e) {
						frameJuego9x9.setMensaje(e.getMessage());
					} catch (ExcepcionPosicionFueraRango e) {
						frameJuego9x9.setMensaje(e.getMessage());
					} catch (ExcepcionNumeroFijo e) {
						frameJuego9x9.setMensaje(e.getMessage());
					} catch (ExcepcionCasillaBloqueada e) {
						frameJuego9x9.setMensaje(e.getMessage());
					} catch (ExcepcionValorYaPuesto e) {
						frameJuego9x9.setMensaje(e.getMessage());
						frameJuego9x9.colorearCasillaInvalida(i, j);
						frameJuego9x9.quitarValorCasilla(i, j);
					} catch (ExcepcionCasillaVaciaNoFijable e) {
						frameJuego9x9.setMensaje(e.getMessage());
					} catch (ExcepcionPartidaYaAcabada e) {
						frameJuego9x9.setMensaje(e.getMessage());
					}
				}
			});
		}
	}
	
	private void listenersCeldasNumeros9x9() {
		Vector<JPanel> vPanCeldas = frameJuego9x9.getVPanCeldas();
		for (JPanel panCelda : vPanCeldas) {
			panCelda.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {/*System.out.println("pruebas: mouseReleased");*/}
				@Override
				public void mousePressed(MouseEvent e) {/*System.out.println("pruebas: mousePressed");*/}
				@Override
				public void mouseExited(MouseEvent e) {/*System.out.println("pruebas: mouseExited");*/}
				@Override
				public void mouseEntered(MouseEvent e) {/*System.out.println("pruebas: mouseEntered");*/}
				@Override
				public void mouseClicked(MouseEvent e) {
					/*System.out.println("pruebas: mouseClicked");*/
					String nombreCelda = panCelda.getName();
					String strFila = nombreCelda.substring(8, 9);
					String strColu = nombreCelda.substring(9, 10);
					int i = Integer.parseInt(strFila);
					int j = Integer.parseInt(strColu);
					frameJuego9x9.colorearCasillaActiva(i,j);
					if (!frameJuego9x9.esCeldaFija(i,j) && !ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {
						frameJuego9x9.guardarCoordenadasActivas(i,j);
						frameJuego9x9.activarPanelOpciones();
					} else frameJuego9x9.desactivarPanelOpciones();
					frameJuego9x9.setMensaje("");
				}
			});
		}
	}
	
	private void initListenersJFrameJuego9x9(){
		frameJuego9x9.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameJuego9x9.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameJuego9x9.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameJuego9x9.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameJuego9x9.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ctrlCUSeleccionarJugarSudoku = null;
				frameJuego9x9.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		frameJuego9x9.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameJuego9x9.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	ctrlCUSeleccionarJugarSudoku = null;
						frameJuego9x9.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		frameJuego9x9.getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					ctrlCUSeleccionarJugarSudoku = null;
					frameJuego9x9.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		frameJuego9x9.getButPedirPista().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressPedirPista9x9();
			}
		});
		frameJuego9x9.getButPedirPista().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressPedirPista9x9();
				}
			}
		});
		frameJuego9x9.getButVaciarTablero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressVaciarTablero9x9();
			}
		});
		frameJuego9x9.getButVaciarTablero().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressVaciarTablero9x9();
				}
			}
		});
		frameJuego9x9.getButActivarDesModoEdicion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameJuego9x9.cambiarModoActivo();
				frameJuego9x9.setMensaje("");
			}
		});
		frameJuego9x9.getButActivarDesModoEdicion().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameJuego9x9.cambiarModoActivo();
					frameJuego9x9.setMensaje("");
				}
			}
		});
		frameJuego9x9.getButResuelveSistema().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressResuelveSistema9x9();
			}
		});
		frameJuego9x9.getButResuelveSistema().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressResuelveSistema9x9();
				}
			}
		});
		frameJuego9x9.getButMostrarTiempos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mostrarTiempos9x9();
			}
		});
		frameJuego9x9.getButMostrarTiempos().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					mostrarTiempos9x9();
				}
			}
		});
		frameJuego9x9.getButGuardarPartida().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressGuardarPartida9x9();
			}
		});
		frameJuego9x9.getButGuardarPartida().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressGuardarPartida9x9();
				}
			}
		});
		
		listenersPanOpciones9x9();
		listenersCeldasNumeros9x9();
		
	}
	
	private void pressPedirPista16x16() {
		try {
			DTOCeldaFija celdaPista;
			celdaPista = ctrlCUSeleccionarJugarSudoku.pedirPista();
			frameJuego16x16.nuevaPista(celdaPista.getFila(), celdaPista.getColumna(), celdaPista.getValor());
			frameJuego16x16.setMensaje("Pista anadida, el numero " + celdaPista.getValor() + " en la posicion [" + (celdaPista.getFila()+1) + "," + (celdaPista.getColumna()+1) + "]");
			if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {frameJuego16x16.setMensaje("Pista anadida, el numero " + celdaPista.getValor() + " en la posicion [" + (celdaPista.getFila()+1) + "," + (celdaPista.getColumna()+1) + "]" + " ¡Sudoku resuelto! :)"); mostrarTiempos16x16(); pressGuardarPartida(16);}
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEstaParado e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionNoQuedanCeldasVacias e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameJuego16x16.setMensaje("El valor de la pista ya esta puesto en una de sus regiones");
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameJuego16x16.setMensaje(e.getMessage());
		}
	}
	
	private void pressVaciarTablero16x16() {
		try {
			ctrlCUSeleccionarJugarSudoku.vaciarTablero();
			frameJuego16x16.vaciarTablero();
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		}
	}
	
	private void pressResuelveSistema16x16() {
		try {
			int nn = frameJuego16x16.getNN();
			Vector<DTOCeldaFija> vCeldasSudoku = ctrlCUSeleccionarJugarSudoku.resuelveSistema(nn);
			pressGuardarPartida(nn);
			for (DTOCeldaFija celdaSudoku : vCeldasSudoku) {
				int i = celdaSudoku.getFila();
				int j = celdaSudoku.getColumna();
				int val = celdaSudoku.getValor();
				if (!frameJuego16x16.esCeldaFija(i, j)) {frameJuego16x16.ponerValorCasilla(i, j, val); frameJuego16x16.descolorearCasilla(i, j);}
			}
			mostrarTiempos16x16();
			frameJuego16x16.setMensaje("Sudoku resuelto por el sistema");
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionPosicionFueraRango e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionTimerYaEstaParado e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionValorYaPuesto e) {
			frameJuego16x16.setMensaje(e.getMessage());
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			frameJuego16x16.setMensaje(e.getMessage());
		}
	}
	
	private void pressGuardarPartida16x16(){
		try {
			if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) throw new ExcepcionPartidaYaAcabada();
			pressGuardarPartida(16);
		} catch (ExcepcionPartidaYaAcabada e) {
			frameJuego16x16.setMensaje(e.getMessage());
		}
	}
	
	private void listenersPanOpciones16x16() {
		Vector<JButton> vButOpciones = frameJuego16x16.getVButOpciones();
		for (JButton butOpcion : vButOpciones) {
			butOpcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int valor = Integer.parseInt(butOpcion.getText());
					frameJuego16x16.desactivarPanelOpciones();
					int i = frameJuego16x16.getFilaActiva();
					int j = frameJuego16x16.getColumnaActiva();
					boolean modoActivo = frameJuego16x16.getModoActivo();
					try {
						if (!modoActivo) { //modo activo = introducir valor a casilla
							if (!ctrlCUSeleccionarJugarSudoku.esValorCelda(i, j, valor)) { //si no es el valor que ya esta puesto, lo anade
								ctrlCUSeleccionarJugarSudoku.quitarValorCelda(i, j); //tiene que estar, por si en la funcion siguiente salta excepcion, que se haya borrado lo que habia
								ctrlCUSeleccionarJugarSudoku.anadirValorCelda(i, j, valor);
								frameJuego16x16.ponerValorCasilla(i, j, valor);
							} else {
								ctrlCUSeleccionarJugarSudoku.quitarValorCelda(i, j);
								frameJuego16x16.quitarValorCasilla(i, j);
							}
							frameJuego16x16.setMensaje("");
							if (ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {frameJuego16x16.setMensaje("Sudoku resuelto con exito! :)"); mostrarTiempos16x16(); pressGuardarPartida(16);}
						}
						else { //modo activo = introducir marca a casilla
							if (ctrlCUSeleccionarJugarSudoku.estaMarca(i, j, valor)) { //quitar marca
								ctrlCUSeleccionarJugarSudoku.quitarMarca(i, j, valor);
								frameJuego16x16.quitarMarcaCasilla(i,j,valor);
							} else { //poner marca
								ctrlCUSeleccionarJugarSudoku.anadirMarca(i, j, valor);
								frameJuego16x16.ponerMarcaCasilla(i,j,valor);
							}
							frameJuego16x16.setMensaje("");
						}
						frameJuego16x16.descolorearCasilla(i,j);
					} catch (ExcepcionTimerYaEstaParado e) {
						frameJuego16x16.setMensaje(e.getMessage());
					} catch (ExcepcionValorFueraRango e) {
						frameJuego16x16.setMensaje(e.getMessage());
					} catch (ExcepcionPosicionFueraRango e) {
						frameJuego16x16.setMensaje(e.getMessage());
					} catch (ExcepcionNumeroFijo e) {
						frameJuego16x16.setMensaje(e.getMessage());
					} catch (ExcepcionCasillaBloqueada e) {
						frameJuego16x16.setMensaje(e.getMessage());
					} catch (ExcepcionValorYaPuesto e) {
						frameJuego16x16.setMensaje(e.getMessage());
						frameJuego16x16.colorearCasillaInvalida(i, j);
						frameJuego16x16.quitarValorCasilla(i, j);
					} catch (ExcepcionCasillaVaciaNoFijable e) {
						frameJuego16x16.setMensaje(e.getMessage());
					} catch (ExcepcionPartidaYaAcabada e) {
						frameJuego16x16.setMensaje(e.getMessage());
					}
				}
			});
		}
	}
	
	private void listenersCeldasNumeros16x16() {
		Vector<JPanel> vPanCeldas = frameJuego16x16.getVPanCeldas();
		for (JPanel panCelda : vPanCeldas) {
			panCelda.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {/*System.out.println("pruebas: mouseReleased");*/}
				@Override
				public void mousePressed(MouseEvent e) {/*System.out.println("pruebas: mousePressed");*/}
				@Override
				public void mouseExited(MouseEvent e) {/*System.out.println("pruebas: mouseExited");*/}
				@Override
				public void mouseEntered(MouseEvent e) {/*System.out.println("pruebas: mouseEntered");*/}
				@Override
				public void mouseClicked(MouseEvent e) {
					/*System.out.println("pruebas: mouseClicked");*/
					String nombreCelda = panCelda.getName();
					String strFila = nombreCelda.substring(8, 10);
					String strColu = nombreCelda.substring(10, 12);
					int i = Integer.parseInt(strFila);
					int j = Integer.parseInt(strColu);
					frameJuego16x16.colorearCasillaActiva(i,j);
					if (!frameJuego16x16.esCeldaFija(i,j) && !ctrlCUSeleccionarJugarSudoku.partidaAcabada()) {
						frameJuego16x16.guardarCoordenadasActivas(i,j);
						frameJuego16x16.activarPanelOpciones();
					} else frameJuego16x16.desactivarPanelOpciones();
					frameJuego16x16.setMensaje("");
				}
			});
		}
	}
	
	private void initListenersJFrameJuego16x16(){
		frameJuego16x16.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		
		frameJuego16x16.getButSalir().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressSalir();
				}
			}
		});
		
		frameJuego16x16.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
				frameJuego16x16.getRootPane().getActionMap().put("Cancel", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){pressSalir();}
		});
		
		frameJuego16x16.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ctrlCUSeleccionarJugarSudoku = null;
				frameJuego16x16.setVisible(false);
				((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
				frameMenuSudoku.setVisible(true);
			}
		});
		
		frameJuego16x16.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Volver"); //$NON-NLS-1$
				frameJuego16x16.getRootPane().getActionMap().put("Volver", new AbstractAction()
		        { 
		            public void actionPerformed(ActionEvent e){
		            	ctrlCUSeleccionarJugarSudoku = null;
						frameJuego16x16.setVisible(false);
						((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
						frameMenuSudoku.setVisible(true);
		            }
		});
		
		frameJuego16x16.getButVolverMenuSudoku().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					ctrlCUSeleccionarJugarSudoku = null;
					frameJuego16x16.setVisible(false);
					((JFrameMenuSudoku) frameMenuSudoku).cleanValues();
					frameMenuSudoku.setVisible(true);
				}
			}
		});
		frameJuego16x16.getButPedirPista().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressPedirPista16x16();
			}
		});
		frameJuego16x16.getButPedirPista().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressPedirPista16x16();
				}
			}
		});
		frameJuego16x16.getButVaciarTablero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressVaciarTablero16x16();
			}
		});
		frameJuego16x16.getButVaciarTablero().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressVaciarTablero16x16();
				}
			}
		});
		frameJuego16x16.getButActivarDesModoEdicion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameJuego16x16.cambiarModoActivo();
				frameJuego16x16.setMensaje("");
			}
		});
		frameJuego16x16.getButActivarDesModoEdicion().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					frameJuego16x16.cambiarModoActivo();
					frameJuego16x16.setMensaje("");
				}
			}
		});
		frameJuego16x16.getButResuelveSistema().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressResuelveSistema16x16();
			}
		});
		frameJuego16x16.getButResuelveSistema().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressResuelveSistema16x16();
				}
			}
		});
		frameJuego16x16.getButMostrarTiempos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mostrarTiempos16x16();
			}
		});
		frameJuego16x16.getButMostrarTiempos().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					mostrarTiempos16x16();
				}
			}
		});
		frameJuego16x16.getButGuardarPartida().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressGuardarPartida16x16();
			}
		});
		frameJuego16x16.getButGuardarPartida().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.VK_ENTER == e.getKeyCode()) {
					pressGuardarPartida16x16();
				}
			}
		});
		
		listenersPanOpciones16x16();
		listenersCeldasNumeros16x16();
		
	}
	
	private void mostrarTiempos4x4(){
		DTOTiempo tiempoResolviendo = ctrlCUSeleccionarJugarSudoku.tiempoResolviendo();
		DTOTiempo tiempoPenalizaciones = ctrlCUSeleccionarJugarSudoku.tiempoPenalizaciones();
		DTOTiempo tiempoTotal = ctrlCUSeleccionarJugarSudoku.tiempoTotal(tiempoResolviendo, tiempoPenalizaciones);
		frameJuego4x4.mostrarTiempos(tiempoResolviendo, tiempoPenalizaciones, tiempoTotal);
	}
	
	private void mostrarTiempos9x9(){
		DTOTiempo tiempoResolviendo = ctrlCUSeleccionarJugarSudoku.tiempoResolviendo();
		DTOTiempo tiempoPenalizaciones = ctrlCUSeleccionarJugarSudoku.tiempoPenalizaciones();
		DTOTiempo tiempoTotal = ctrlCUSeleccionarJugarSudoku.tiempoTotal(tiempoResolviendo, tiempoPenalizaciones);
		frameJuego9x9.mostrarTiempos(tiempoResolviendo, tiempoPenalizaciones, tiempoTotal);
	}
	
	private void mostrarTiempos16x16(){
		DTOTiempo tiempoResolviendo = ctrlCUSeleccionarJugarSudoku.tiempoResolviendo();
		DTOTiempo tiempoPenalizaciones = ctrlCUSeleccionarJugarSudoku.tiempoPenalizaciones();
		DTOTiempo tiempoTotal = ctrlCUSeleccionarJugarSudoku.tiempoTotal(tiempoResolviendo, tiempoPenalizaciones);
		frameJuego16x16.mostrarTiempos(tiempoResolviendo, tiempoPenalizaciones, tiempoTotal);
	}
    
    private void pressSalir() {
    	System.exit(0);
	}
    
    private void pressGuardarPartida(int nn) throws ExcepcionPartidaYaAcabada {
    	Date fechaGuardado;
		fechaGuardado = ctrlCUSeleccionarJugarSudoku.guardarPartida();
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(fechaGuardado);   // assigns calendar to given date 
		int intHoraGuardado = calendar.get(Calendar.HOUR_OF_DAY);
		String strHoraGuardado = intHoraGuardado + "";
		if (intHoraGuardado <= 9) strHoraGuardado = "0" + strHoraGuardado;
		int intMinutoGuardado = calendar.get(Calendar.MINUTE);
		String strMinutoGuardado = intMinutoGuardado + "";
		if (intMinutoGuardado <= 9) strMinutoGuardado = "0" + strMinutoGuardado;
		if (nn == 4) frameJuego4x4.setMensaje("Partida guardada por ultima vez a las: " + strHoraGuardado + ":" + strMinutoGuardado);
		else if (nn == 9) frameJuego9x9.setMensaje("Partida guardada por ultima vez a las: " + strHoraGuardado + ":" + strMinutoGuardado);
		else frameJuego16x16.setMensaje("Partida guardada por ultima vez a las: " + strHoraGuardado + ":" + strMinutoGuardado); //16x16
	}
    
    private void pressCerrarSesion(JFrame frameDondeEstaba) {
    	nombreUsuario = "";
    	ctrlCUSeleccionarJugarSudoku = null;
		frameDondeEstaba.setVisible(false);
		frameMenuPrincipal.setVisible(true);
	}
    
	
}
