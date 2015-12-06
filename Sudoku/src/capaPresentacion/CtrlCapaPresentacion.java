package capaPresentacion;

import java.util.*;
import javax.swing.*;

import DataTransferObjects.*;

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
    private static JFrameJuego4x4 frameJuego4x4;
    //private static JFrameJuego9x9 frameJuego9x9;
    //private static JFrameJuego16x16 frameJuego16x16;
    
    private CtrlCasoUsoSeleccionarSudoku ctrlCUSeleccionarJugarSudoku;
    
    
	private static Boolean cambiosParaBD;
	private static String nombreUsuario;
	private int numCeldasRellenas;

	
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
		//LISTENERS DE INICIAR SESI�N:
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
				        //Ocultar vista actual y mostrar la siguiente:
				        frameMenuSudoku.setVisible(false);
				        frameSeleccionarSudokuBD.setVisible(true);
					} else if (tipoSudoku == "tsGenerado") { //FALTA POR HACER
						try {
							Vector<DTOCeldaFija> celdasFijas = ctrlCUSeleccionarJugarSudoku.obtenerSudokuGenerado(nombreUsuario, dificultad, n);
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
							//INIT SELECCIONAR SUDOKU DE LA BD:
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
							//INIT SELECCIONAR SUDOKU DE LA BD:
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
							//INIT SELECCIONAR SUDOKU DE LA BD:
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
				((JFrameMenuSudoku) frameMenuSudoku).setMensaje("Para el Sudoku propuesto, se ignorar� la dificultad seleccionada");
			}
		});
	}
	
	private void initListenersJFrameProponerSudoku4x4(JFrameProponerSudoku4x4 frameProponerSudoku4x4) {
		//LISTENERS DE PROPONER SUDOKU 4X4:
		frameProponerSudoku4x4.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		frameProponerSudoku4x4.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameProponerSudoku4x4.setVisible(false);
				frameMenuSudoku.setVisible(true);
			}
		});
		frameProponerSudoku4x4.getButJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int nn = frameProponerSudoku4x4.getNN();
				String nombreSudoku = frameProponerSudoku4x4.getNombreSudoku();
				Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
				try {
					if (nombreSudoku.isEmpty()) throw new ExcepcionCamposVacios();
					frameProponerSudoku4x4.setMensaje("");
					for (int i = 0; i < nn; ++i) { 
						for (int j = 0; j < nn; ++j) {	
							//valor 0 significa vacio
							int valor = frameProponerSudoku4x4.getValorCelda(i, j);
							if (valor != 0) vCeldasFijas.addElement(new DTOCeldaFija(i, j, valor));
						}
					}
					ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, nombreSudoku, vCeldasFijas);
					frameProponerSudoku4x4.setVisible(false);
					
					//Mostrar juego:
					JFrame.setDefaultLookAndFeelDecorated(true);
					frameJuego4x4 = new JFrameJuego4x4(vCeldasFijas,nombreSudoku);
					frameJuego4x4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frameJuego4x4.pack();
					numCeldasRellenas = vCeldasFijas.size();
					initListenersJFrameJuego4x4();
					frameJuego4x4.setVisible(true);
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
		frameProponerSudoku9x9.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameProponerSudoku9x9.setVisible(false);
				frameMenuSudoku.setVisible(true);
			}
		});
		frameProponerSudoku9x9.getButJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int nn = frameProponerSudoku9x9.getNN();
				String nombreSudoku = frameProponerSudoku9x9.getNombreSudoku();
				Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
				try {
					if (nombreSudoku.isEmpty()) throw new ExcepcionCamposVacios();
					frameProponerSudoku9x9.setMensaje("");
					for (int i = 0; i < nn; ++i) { 
						for (int j = 0; j < nn; ++j) {	
							//valor 0 significa vacio
							int valor = frameProponerSudoku9x9.getValorCelda(i, j);
							if (valor != 0) vCeldasFijas.addElement(new DTOCeldaFija(i, j, valor));
						}
					}
					ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, nombreSudoku, vCeldasFijas);
					frameProponerSudoku9x9.setVisible(false);
					
					//Mostrar juego:
					JFrame.setDefaultLookAndFeelDecorated(true);
					numCeldasRellenas = vCeldasFijas.size();
					//JFrameJuego9x9 frameJuego9x9 = new JFrameJuego4x4(vCeldasFijas,nombreSudoku);
					//frameJuego9x9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//frameJuego9x9.pack();
					//frameJuego9x9.setVisible(true);
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
		frameProponerSudoku16x16.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameProponerSudoku16x16.setVisible(false);
				frameMenuSudoku.setVisible(true);
			}
		});
		frameProponerSudoku16x16.getButJugarSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int nn = frameProponerSudoku16x16.getNN();
				String nombreSudoku = frameProponerSudoku16x16.getNombreSudoku();
				Vector<DTOCeldaFija> vCeldasFijas = new Vector<DTOCeldaFija>();
				try {
					if (nombreSudoku.isEmpty()) throw new ExcepcionCamposVacios();
					frameProponerSudoku16x16.setMensaje("");
					for (int i = 0; i < nn; ++i) { 
						for (int j = 0; j < nn; ++j) {	
							//valor 0 significa vacio
							int valor = frameProponerSudoku16x16.getValorCelda(i, j);
							if (valor != 0) vCeldasFijas.addElement(new DTOCeldaFija(i, j, valor));
						}
					}
					ctrlCUSeleccionarJugarSudoku.proponerNuevoSudoku(nombreUsuario, nombreSudoku, vCeldasFijas);
					frameProponerSudoku16x16.setVisible(false);
					
					//Mostrar juego:
					JFrame.setDefaultLookAndFeelDecorated(true);
					numCeldasRellenas = vCeldasFijas.size();
					//JFrameJuego16x16 frameJuego16x16 = new JFrameJuego4x4(vCeldasFijas,nombreSudoku);
					//frameJuego16x16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//frameJuego16x16.pack();
					//frameJuego16x16.setVisible(true);
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
				}
			}
		});
	}
	
	private void initListenersJFrameJuego4x4(){
		frameJuego4x4.getButSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pressSalir();
			}
		});
		frameJuego4x4.getButVolverMenuSudoku().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameJuego4x4.setVisible(false);
				frameMenuSudoku.setVisible(true);
			}
		});
		frameJuego4x4.getButPedirPista().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DTOCeldaFija celdaPista = new DTOCeldaFija(1, 1, 4); //TEMPORAL
					//DTOCeldaFija celdaPista = ctrlCUSeleccionarJugarSudoku.pedirPista();
					frameJuego4x4.nuevaPista(celdaPista.getFila(), celdaPista.getColumna(), celdaPista.getValor());
					++numCeldasRellenas;
				} catch (Exception e) {
					frameJuego4x4.setMensaje(e.getMessage());
				}/* catch (ExcepcionNoQuedanCeldasVacias e) {
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
					frameJuego4x4.setMensaje(e.getMessage());
				} catch (ExcepcionCasillaVaciaNoFijable e) {
					frameJuego4x4.setMensaje(e.getMessage());
				}*/
			}
		});
		frameJuego4x4.getButVaciarTablero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				numCeldasRellenas = frameJuego4x4.getNumeroCeldasFijas();
				//POR HACER
			}
		});
		frameJuego4x4.getButActivarDesModoEdicion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameJuego4x4.cambiarModoActivo();
			}
		});
		frameJuego4x4.getButResuelveSistema().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int nn = frameJuego4x4.getNN();
				numCeldasRellenas = nn*nn;
				//POR HACER
			}
		});
		frameJuego4x4.getButMostrarTiempos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER
			}
		});
		frameJuego4x4.getButGuardarPartida().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//POR HACER
			}
		});
		
		Vector<JButton> vButOpciones = frameJuego4x4.getVButOpciones();
		for (JButton butOpcion : vButOpciones) {
			butOpcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int valor = Integer.parseInt(butOpcion.getText());
					frameJuego4x4.desactivarPanelOpciones();
					int i = frameJuego4x4.getFilaActiva();
					int j = frameJuego4x4.getColumnaActiva();
					frameJuego4x4.ponerValorCasilla(i,j,valor);
					frameJuego4x4.descolorearCasilla(i,j);
				}
			});
		}
		Vector<JPanel> vPanCeldas = frameJuego4x4.getVPanCeldas();
		for (JPanel panCelda : vPanCeldas) {
			panCelda.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseClicked(MouseEvent e) {
					String nombreCelda = panCelda.getName();
					String strFila = nombreCelda.substring(8, 9);
					String strColu = nombreCelda.substring(9, 10);
					int i = Integer.parseInt(strFila);
					int j = Integer.parseInt(strColu);
					
					frameJuego4x4.colorearCasillaActiva(i,j);
					boolean modoActivo = frameJuego4x4.getModoActivo();
					if (!modoActivo && !frameJuego4x4.esCeldaFija(i,j)) {
						frameJuego4x4.guardarCoordenadasActivas(i,j);
						frameJuego4x4.activarPanelOpciones();
					} else {
						//FALTA ESTO
					}
				}
			});
		}
		
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
