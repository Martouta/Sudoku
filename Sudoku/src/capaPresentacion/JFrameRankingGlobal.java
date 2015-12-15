package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DataTransferObjects.DTORankingPerTipus;
import Ranking.Tupla;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;


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
	private JLabel f1 = new JLabel();
	
	
	
	
	 public void setMensajeError(String msj){
			labMensajeError.setText(msj);
		}
	
	public JButton getButVolverMenuOpciones() {
		return Volver;
	}
	
	public JButton getButSalir() {
		return Salir;
	}
	
	public void muestraDatos(DTORankingPerTipus infoRankingPerTipus) {
		f1.setText(infoRankingPerTipus.getf1());
		
	}
	
	
	
	public JFrameRankingGlobal(){
		super("Ranking Global");
		
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
		f1.setBounds(110,100,40,20);
		
		p.add(Volver);
		p.add(Salir);
		p.add(facil);
		p.add(normal);
		p.add(dificil);
		p.add(uYt);
		p.add(labMensajeError);
		p.add(f1);
		
		add(p);
			
		
		setVisible(true);
	}
}