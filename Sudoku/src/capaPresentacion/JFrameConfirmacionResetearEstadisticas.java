package capaPresentacion;

import javax.swing.*;
import java.awt.*;

public class JFrameConfirmacionResetearEstadisticas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panConfirmacionResetearEstadisticas;
	private JLabel labConfirmacionResetearEstadisticas;
	private JButton butResetear;
	private JButton butNoResetear;
	
	public JFrameConfirmacionResetearEstadisticas() {
		initComponents();
	}
	
	private void initComponents() {
		JLabel labEspacioBlanco = new JLabel();
		labEspacioBlanco.setText("");
		
		setTitle("Confirmacion Resetear Estadisticas");
		setSize(400,500); //ancho por alto
		setMinimumSize(new Dimension(400, 500));
		setResizable(true);
		
		labConfirmacionResetearEstadisticas = new JLabel();
		butResetear = new JButton();
		butNoResetear = new JButton();
		
		//COMO PONER UN NEWLINE EN MEDIO DE LA FRASE
		labConfirmacionResetearEstadisticas.setText("¿Está seguro de que desea eliminar sus estadísticas? También se recalcularán las estadísticas globales y los rankings");
		butResetear.setText("Sí, resetear");
		butNoResetear.setText("No resetear");
		
		panConfirmacionResetearEstadisticas = new JPanel();
		panConfirmacionResetearEstadisticas.setLayout(new GridLayout(9,1));
		panConfirmacionResetearEstadisticas.add(labConfirmacionResetearEstadisticas);
		panConfirmacionResetearEstadisticas.add(labEspacioBlanco);
		panConfirmacionResetearEstadisticas.add(butResetear);
		panConfirmacionResetearEstadisticas.add(butNoResetear);
		add(panConfirmacionResetearEstadisticas);
	}
	
	public JButton getButResetear() {
		return butResetear;
	}
	
	public JButton getButNoResetear() {
		return butNoResetear;
	}
}
