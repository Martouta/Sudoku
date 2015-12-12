package capaPresentacion;

import javax.swing.*;
import java.awt.*;

public class JFrameConfirmacionResetearEstadisticas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panConfirmacionResetearEstadisticas;
	private JLabel labConfirmacionResetearEstadisticas;
	private JButton butResetear;
	private JButton butNoResetear;
	private JLabel labMensajeError;
	
	public JFrameConfirmacionResetearEstadisticas() {
		initComponents();
	}
	
	public void setMensajeError(String msj){
		labMensajeError.setText(msj);
	}
	
	private void initComponents() {
		JLabel labEspacioBlanco = new JLabel();
		labEspacioBlanco.setText("");
		
		setTitle("Confirmacion Resetear Estadisticas");
		setSize(400,300); //ancho por alto
		setMinimumSize(new Dimension(400, 300));
		setResizable(false);
		
		labConfirmacionResetearEstadisticas = new JLabel();
		butResetear = new JButton();
		butNoResetear = new JButton();
		labMensajeError = new JLabel();
		
		//PROBAR PARA VER COMO QUEDA MEJOR
		StringBuilder sb = new StringBuilder(128);
        sb.append("<html><div style=\"text-align: center;\">¿Está seguro de que desea")
        		.append("<br/>eliminar sus estadísticas?")
        		.append("<br/>También se recalcularán las")
        		.append("<br/>estadísticas globales")
        		.append("<br/>y los rankings.</html>");

		//labConfirmacionResetearEstadisticas.setText("¿Está seguro de que desea eliminar sus estadísticas? También se recalcularán las estadísticas globales y los rankings");
        labConfirmacionResetearEstadisticas.setText(sb.toString());
        butResetear.setText("Sí, resetear");
		butNoResetear.setText("No resetear");
		labMensajeError.setText("");
		
		labConfirmacionResetearEstadisticas.setBounds(110, 15, 220, 100);
		butResetear.setBounds(50, 180, 110, 65);
		butNoResetear.setBounds(220, 180, 110, 65);
		
		panConfirmacionResetearEstadisticas = new JPanel();
		panConfirmacionResetearEstadisticas.setLayout(new GridLayout(9,1));
		panConfirmacionResetearEstadisticas.add(labConfirmacionResetearEstadisticas);
		panConfirmacionResetearEstadisticas.add(labEspacioBlanco);
		panConfirmacionResetearEstadisticas.add(butResetear);
		panConfirmacionResetearEstadisticas.add(butNoResetear);
		JPanel panMensError = new JPanel(); //
		panMensError.setLayout(new FlowLayout(FlowLayout.CENTER));
		panMensError.add(labMensajeError);
		panConfirmacionResetearEstadisticas.add(panMensError);
		panConfirmacionResetearEstadisticas.setLayout(null);
		add(panConfirmacionResetearEstadisticas);
	}
	
	public JButton getButResetear() {
		return butResetear;
	}
	
	public JButton getButNoResetear() {
		return butNoResetear;
	}
}
