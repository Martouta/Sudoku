package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataTransferObjects.DTORankingPersonal;
import DataTransferObjects.DTORankingGeneral;

import java.awt.Dimension;

import javax.swing.JButton;

import javax.swing.JLabel;



//HAY MAIN ABAJO

public class JFrameEstadisticasGenerales extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JPanel p=new JPanel();
	private JButton Volver = new JButton("Volver");
    private JButton Salir = new JButton("Salir");
	private JLabel nj=new JLabel("Numero de juegos:");
	private JLabel nu=new JLabel("Numero de usuarios:");
	private JLabel np=new JLabel("Numero de Partidas acabadas:");
	private JLabel smj=new JLabel("Sudoku mas jugado:");
	private JLabel tit=new JLabel("ESTADÍSTICAS GENERALES");
	
	private JTextField xj= new JTextField("jocs");
	private JTextField xu= new JTextField("usuaris");
	private JTextField xp= new JTextField("partides");
	private JTextField xsmj= new JTextField("id sudoku mes jugat");
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
	
	public void setxj(int s){
		xj.setText(Integer.toString(s));
	}
	
	public void setxu(int s){
		xu.setText(Integer.toString(s));
	}
	
	public void setxp(int s){
		xp.setText(Integer.toString(s));
	}
	
	public void setxf(String s){
		xsmj.setText(s);
	}
	
	public void muestraDatos(DTORankingGeneral infoRankingGeneral) {
		xj.setText(infoRankingGeneral.getnjocs() + "");
		xu.setText(infoRankingGeneral.getnusuaris() + "");
		xp.setText(infoRankingGeneral.getnpartides() + "");
		xsmj.setText(infoRankingGeneral.getpopular() + "");
	}
	
	public JFrameEstadisticasGenerales(){
		super("Estadísticas Generales");
		
		setSize(400,300);
		setMinimumSize(new Dimension(400, 300));
		setResizable(false);
		
		p.setLayout(null);
		Volver.setBounds(5,5,80,30);
		Salir.setBounds(310,5,80,30);
		nj.setBounds(60,-30,200,200);
		nu.setBounds(60,20,200,200);
		np.setBounds(30, 70,200,200);
		smj.setBounds(60,120,200,200);
		tit.setBounds(122,-70,200,200);
		xj.setBounds(250,60,60,20);
		xu.setBounds(250,110,60,20);
		xp.setBounds(250,160,60,20);
		xsmj.setBounds(200,210,170,20);
		
		
		p.add(Volver);
		p.add(Salir);
		p.add(nj);
		p.add(nu);
		p.add(np);
		p.add(smj);
		p.add(tit);
		p.add(xj);
		p.add(xu);
		p.add(xp);
		p.add(xsmj);
		p.add(labMensajeError);
		
		add(p);
			
		
		setVisible(true);
	}
}