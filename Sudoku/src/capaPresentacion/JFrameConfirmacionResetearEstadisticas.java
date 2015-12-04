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
		
		//PROBAR PARA VER COMO QUEDA MEJOR
		StringBuilder sb = new StringBuilder(128);
        sb.append("<html>�Est� seguro de que desea")
        		.append("<br/>eliminar sus estad�sticas?")
        		.append("<br/>Tambi�n se recalcular�n las estad�sticas")
        		.append("<br/>globales y los rankings</html>");

		//labConfirmacionResetearEstadisticas.setText("�Est� seguro de que desea eliminar sus estad�sticas? Tambi�n se recalcular�n las estad�sticas globales y los rankings");
        labConfirmacionResetearEstadisticas.setText(sb.toString());
        butResetear.setText("S�, resetear");
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
