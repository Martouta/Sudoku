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
	private JLabel f2 = new JLabel();
	private JLabel f3 = new JLabel();
	private JLabel m1 = new JLabel();
	private JLabel m2 = new JLabel();
	private JLabel m3 = new JLabel();
	private JLabel d1 = new JLabel();
	private JLabel d2 = new JLabel();
	private JLabel d3 = new JLabel();
	
	
	
	
	
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
		f2.setText(infoRankingPerTipus.getf2());
		f3.setText(infoRankingPerTipus.getf3());
		m1.setText(infoRankingPerTipus.getm1());
		m2.setText(infoRankingPerTipus.getm2());
		m3.setText(infoRankingPerTipus.getm3());
		d1.setText(infoRankingPerTipus.getd1());
		d2.setText(infoRankingPerTipus.getd2());
		d3.setText(infoRankingPerTipus.getd3());
		
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
		f1.setBounds(40,100,110,20);
		f2.setBounds(40,120,110,20);
		f3.setBounds(40,140,110,20);
		m1.setBounds(160,100,110,20);
		m2.setBounds(160,120,110,20);
		m3.setBounds(160,140,110,20);
		d1.setBounds(280,100,110,20);
		d2.setBounds(280,120,110,20);
		d3.setBounds(280,140,110,20);
		
		p.add(Volver);
		p.add(Salir);
		p.add(facil);
		p.add(normal);
		p.add(dificil);
		p.add(uYt);
		p.add(labMensajeError);
		p.add(f1);
		p.add(f2);
		p.add(f3);
		p.add(m1);
		p.add(m2);
		p.add(m3);
		p.add(d1);
		p.add(d2);
		p.add(d3);
		
		add(p);
			
		
		setVisible(true);
	}
}