package capaPresentacion;

import java.awt.*;
import javax.swing.*;

//FALTA CAMBIAR EL ERROR INESPERADO, EL TAMANO Y HACERLO TODO MÁS BONITO

public class JFrameMenuOpciones extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel panMenuOpciones;
	private JLabel labSeleccioneFuncion;
	private JButton butGestionPerfilUsu;
	private JButton butSelectSudoku;
	private JButton butConsultarRankingLocal;
	private JButton butConsultarRankingGlobal;
	private JButton butConsultarEstadisticasGenerales;
	private JButton butCerrarSesion;
	private JButton butSalir;
	
	public JFrameMenuOpciones(){
		initComponents();
	}
	
	public JButton getButSalir() {
		return butSalir;
	}
	
	private void initComponents(){
		JLabel labEspacioBlanco = new JLabel();
		labEspacioBlanco.setText("");
		
		setTitle("Menu Opciones");
		setSize(400,500); //ancho por alto
		setMinimumSize(new Dimension(400, 500));
		setResizable(true);
		
		labSeleccioneFuncion = new JLabel();
		butGestionPerfilUsu = new JButton();
		butSelectSudoku = new JButton();
		butConsultarRankingLocal = new JButton();
		butConsultarRankingGlobal = new JButton();
		butConsultarEstadisticasGenerales = new JButton();
		butCerrarSesion = new JButton();
        butSalir = new JButton();
        
        labSeleccioneFuncion.setText("Selecione una funcion:");
		butGestionPerfilUsu.setText("Gestion del perfil");
		butSelectSudoku.setText("Seleccionar Sudoku");
		butConsultarRankingLocal.setText("Consultar Ranking Local");
		butConsultarRankingGlobal.setText("Consultar Ranking Global");
		butConsultarEstadisticasGenerales.setText("Consultar Estadisticas generales");
		butCerrarSesion.setText("Cerrar Sesion"); //TENER EN CUENTA ESTE BOTON DE CARA A LO QUE SE GUARDA Y NO EN LA BD
        butSalir.setText("Salir");

        panMenuOpciones = new JPanel();
        panMenuOpciones.setLayout(new GridLayout(9,1));
        panMenuOpciones.add(labSeleccioneFuncion);
        panMenuOpciones.add(butGestionPerfilUsu);
        panMenuOpciones.add(butSelectSudoku);
        panMenuOpciones.add(butConsultarRankingLocal);
        panMenuOpciones.add(butConsultarRankingGlobal);
        panMenuOpciones.add(butConsultarEstadisticasGenerales);
        panMenuOpciones.add(labEspacioBlanco);
        panMenuOpciones.add(butCerrarSesion);
        panMenuOpciones.add(butSalir);
		add(panMenuOpciones);
	}
}
