package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JButton;

import javax.swing.JLabel;



//HAY MAIN ABAJO

public class JFrameRankingGlobal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JPanel p=new JPanel();
	private JButton Volver = new JButton("Volver");
    private JButton Salir = new JButton("Salir");
	private JLabel facil=new JLabel("Facil");
	private JLabel normal=new JLabel("Normal");
	private JLabel dificil=new JLabel("Dificil");
	private JLabel uYt=new JLabel("Usuarios y tiempos por dificultad:");
	private JLabel labMensajeError = new JLabel();
	
	 public void setMensajeError(String msj){
			labMensajeError.setText(msj);
		}
	
	public JButton getButVolverMenuOpciones() {
		return Volver;
	}
	
	public JButton getButSalir() {
		return Salir;
	}
	
	public JFrameRankingGlobal(){
		super("Basic Swing App");
		
		setSize(400,300);
		setMinimumSize(new Dimension(400, 300));
		setResizable(false);
		
		p.setLayout(null);
		Volver.setBounds(5,5,80,30);
		Salir.setBounds(310,5,80,30);
		facil.setBounds(60,-30,200,200);
		normal.setBounds(180,-30,200,200);
		dificil.setBounds(300,-30,200,200);
		uYt.setBounds(100,-70,200,200);
		
		
		p.add(Volver);
		p.add(Salir);
		p.add(facil);
		p.add(normal);
		p.add(dificil);
		p.add(uYt);
		p.add(labMensajeError);
		
		add(p);
			
		
		setVisible(true);
	}
}