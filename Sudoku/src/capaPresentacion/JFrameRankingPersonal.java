package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

import DataTransferObjects.DTORankingPersonal;

import javax.swing.JLabel;




public class JFrameRankingPersonal extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	JPanel pan=new JPanel();
	private JLabel titulo=new JLabel("RANKING PERSONAL:");
	private JButton Volver = new JButton("Volver");
    private JButton Salir = new JButton("Salir");
	private JLabel usu=new JLabel("USUARIO");
	private JLabel dif=new JLabel("Dificultad");
	private JLabel facil=new JLabel("4x4");
	private JLabel normal=new JLabel("9x9");
	private JLabel dificil=new JLabel("16x16");
	private JLabel sudokusResueltos=new JLabel("Sudokus Resueltos:");
	private JLabel media=new JLabel("Media pistas/partida:");
	private JLabel mejt=new JLabel("Mejor tiempo:");
	
	private JTextField x= new JTextField("");
	private JTextField p= new JTextField("");
	private JTextField t4= new JTextField("");
	private JTextField t9= new JTextField("");
	private JTextField t16= new JTextField("");
	
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
	
	public void muestraDatos(DTORankingPersonal infoRankingPersonal) {
		x.setText(infoRankingPersonal.getnSudokusResueltos() + "");
		p.setText(infoRankingPersonal.getnPistas() + "");
		t4.setText(infoRankingPersonal.getMejorTiempo4().getHoras() + ":" + infoRankingPersonal.getMejorTiempo4().getMinutos() + ":" + infoRankingPersonal.getMejorTiempo4().getSegundos());
		t9.setText(infoRankingPersonal.getMejorTiempo9().getHoras() + ":" + infoRankingPersonal.getMejorTiempo9().getMinutos() + ":" + infoRankingPersonal.getMejorTiempo9().getSegundos());
		t16.setText(infoRankingPersonal.getMejorTiempo16().getHoras() + ":" + infoRankingPersonal.getMejorTiempo16().getMinutos() + ":" + infoRankingPersonal.getMejorTiempo16().getSegundos());
	}
	
	
	public JFrameRankingPersonal(){
		super("Ranking Personal");
		
		setSize(400,300);
		setMinimumSize(new Dimension(400, 300));
		setResizable(false);
		
		pan.setLayout(null);
		Volver.setBounds(5,5,80,30);
		Salir.setBounds(310,5,80,30);
		dif.setBounds(20,-30,200,200);
		facil.setBounds(140,-30,200,200);
		normal.setBounds(240,-30,200,200);
		dificil.setBounds(340,-30,200,200);
		sudokusResueltos.setBounds(0,10,200,200);
		media.setBounds(0,50,200,200);
		mejt.setBounds(0,90,200,200);
		x.setBounds(140,100,30,20);
		
		p.setBounds(140,140,30,20);
		
		t4.setBounds(140,180,30,20);
		t9.setBounds(240,180,30,20);
		t16.setBounds(340,180,30,20);
		
		titulo.setBounds(140,10,200,30);
		labMensajeError = new JLabel();
		
		x.setEditable(false);
		p.setEditable(false);
		t4.setEditable(false);
		t9.setEditable(false);
		t16.setEditable(false);
		
		
		
		pan.add(Volver);
		pan.add(Salir);
		pan.add(usu);
		pan.add(dif);
		pan.add(facil);
		pan.add(normal);
		pan.add(dificil);
		pan.add(sudokusResueltos);
		pan.add(media);
		pan.add(mejt);
		pan.add(x);
		pan.add(p);
		pan.add(t4);
		pan.add(t9);
		pan.add(t16);
		pan.add(titulo);
		pan.add(labMensajeError);
		
		add(pan);
			
		
		setVisible(true);
	}
}