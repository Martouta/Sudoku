package capaPresentacion;

import java.util.*;
import javax.swing.*;

import DataTransferObjects.DTOCeldaFija;
import DataTransferObjects.DTOPartidaAMedias;
import DataTransferObjects.DTOSudokuDeLaBD;
import DataTransferObjects.tipoDificultad;

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
    private static JFrame frameSeleccionarSudokuBD;
    private static JFrame frameSeleccionarPartidaReanudar;
    private static JFrame frameProponerSudoku4x4;
    private static JFrame frameProponerSudoku9x9;
    private static JFrame frameProponerSudoku16x16;
    
    
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
				if (cambiosParaBD) guardarTodo();
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
	
	private int NfromTamanoSudoku(String tamanoSudoku){
		int nn = Integer.parseInt(tamanoSudoku.substring(0, 1));
		return (int) Math.sqrt(nn);
	}
	
	private tipoDificultad tipoDificultadFromStringDificultad(String dificultadSudoku){
		if (dificultadSudoku == "trivial") return tipoDificultad.trivial;
		if (dificultadSudoku == "facil") return tipoDificultad.facil;
		if (dificultadSudoku == "medio") return tipoDificultad.medio;
		return tipoDificultad.dificil; //else
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
				CtrlCasoUsoSeleccionarSudoku ctrlCUSeleccionarJugarSudoku = new CtrlCasoUsoSeleccionarSudoku();
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
				        //Ocultar vista actual y mostrar la siguiente:
				        frameMenuSudoku.setVisible(false);
				        frameSeleccionarSudokuBD.setVisible(true);
					} else if (tipoSudoku == "tsGenerado") { //FALTA POR HACER
						Vector<DTOCeldaFija> celdasFijas = ctrlCUSeleccionarJugarSudoku.obtenerSudokuGenerado(nombreUsuario, dificultad, n);
					} else if (tipoSudoku == "tsProponer") { 
						if (n == 2) {
							//INIT SELECCIONAR SUDOKU DE LA BD:
					        JFrame.setDefaultLookAndFeelDecorated(true);
					        frameProponerSudoku4x4 = new JFrameProponerSudoku4x4();
					        frameProponerSudoku4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frameProponerSudoku4x4.pack();
					        //Ocultar vista actual y mostrar la siguiente:
					        frameMenuSudoku.setVisible(false);
					        frameProponerSudoku4x4.setVisible(true);
						} else if (n == 3) {
							//INIT SELECCIONAR SUDOKU DE LA BD:
					        JFrame.setDefaultLookAndFeelDecorated(true);
					        frameProponerSudoku9x9 = new JFrameProponerSudoku9x9();
					        frameProponerSudoku9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frameProponerSudoku9x9.pack();
					        //Ocultar vista actual y mostrar la siguiente:
					        frameMenuSudoku.setVisible(false);
					        frameProponerSudoku9x9.setVisible(true);
						} else { //n == 4
							//INIT SELECCIONAR SUDOKU DE LA BD:
					        JFrame.setDefaultLookAndFeelDecorated(true);
					        frameProponerSudoku16x16 = new JFrameProponerSudoku16x16();
					        frameProponerSudoku16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frameProponerSudoku16x16.pack();
					        //Ocultar vista actual y mostrar la siguiente:
					        frameMenuSudoku.setVisible(false);
					        frameProponerSudoku16x16.setVisible(true);
						}
						//ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, "TEMPORAL-NOMBRESUDOKU", new Vector<DTOCeldaFija>());//Vector celdas fijas //FALTA LO DEL NOMBRE DE SUDOKU + abrir la vista nueva y ocultar esta
					} else { //tipo tsReanudarPartida
						Vector<DTOPartidaAMedias> infoPartidasAMedias = ctrlCUSeleccionarJugarSudoku.obtenerPartidas(nombreUsuario, dificultad, n);
						//INIT SELECCIONAR PARTIDA A REANUDAR:
				        JFrame.setDefaultLookAndFeelDecorated(true);
				        frameSeleccionarPartidaReanudar = new JFrameSeleccionarPartidaReanudar(infoPartidasAMedias);
				        frameSeleccionarPartidaReanudar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frameSeleccionarPartidaReanudar.pack();
				        //Ocultar vista actual y mostrar la siguiente:
				        frameMenuSudoku.setVisible(false);
				        frameSeleccionarPartidaReanudar.setVisible(true);
					}
				} catch (ExcepcionNoHaySudokuConCaracteristicasSeleccionadas e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				} 
				/* catch (ExcepcionSudokuYaExiste e) {
					((JFrameMenuSudoku) frameMenuSudoku).setMensaje(e.getMessage());
				}*/
				catch (ExcepcionMaquinaNoGeneraTriviales e) {
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
		if (cambiosParaBD) guardarTodo(); 
		System.out.println("Salir pulsado");
	}
    
    private void cargarTodo() {
		//POR HACER
	}
    
    private void guardarTodo() {
		//POR HACER
	}
	
}
