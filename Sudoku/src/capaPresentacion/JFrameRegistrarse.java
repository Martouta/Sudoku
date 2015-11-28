package capaPresentacion;

import java.awt.*;
import javax.swing.*;

//FALTA CAMBIAR EL ERROR INESPERADO, EL TAMANO Y HACERLO TODO MÁS BONITO

public class JFrameRegistrarse extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton butRegistrarse;
    private JButton butSalir;
    private JLabel labNombreUsuario;
    private JLabel labContrasena;
    private JLabel labConfirmContrasena;
    private JPanel panRegistrarse;
    private JPasswordField passwordfieldContrasena;
    private JPasswordField passwordfieldConfirmContrasena;
    private JTextField textfieldNombreUsuario;
    private JLabel labMensajeError;
    private JLabel labCamposObligatorios;
    
    public JFrameRegistrarse() {
		initComponents();
	}
    
    public JButton getButRegistrarse() {
		return butRegistrarse;
	}

	public JButton getButSalir() {
		return butSalir;
	}
	
	public String getNombreUsuario(){
		return textfieldNombreUsuario.getText();
	}
	
	public String getContrasena(){
		return new String(passwordfieldContrasena.getPassword());
	}
	
	public String getConfirmContrasena(){
		return new String(passwordfieldConfirmContrasena.getPassword());
	}
	
	public void setMensajeError(String msj){
		labMensajeError.setText(msj);
	}
	
	private void initComponents() {
		setTitle("Registrarse");
		setSize(500,400); //ancho por alto
		setMinimumSize(new Dimension(480, 400));
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panRegistrarse = new JPanel();
		labNombreUsuario = new JLabel();
        labContrasena = new JLabel();
        labConfirmContrasena = new JLabel();
        labMensajeError = new JLabel();
        labCamposObligatorios = new JLabel();
        butRegistrarse = new JButton();
        butSalir = new JButton();
        textfieldNombreUsuario = new JTextField();
        passwordfieldContrasena = new JPasswordField();
        passwordfieldConfirmContrasena = new JPasswordField();
        
        labNombreUsuario.setText("Nombre de usuario: ");
        labContrasena.setText("Contrasena: ");
        labConfirmContrasena.setText("Confirma la contrasena: ");
        labMensajeError.setText("ERROR INESPERADO [PARA HACER PRUEBAS]");
        butRegistrarse.setText("Iniciar Sesion");
        butSalir.setText("Salir");
        textfieldNombreUsuario.setText("");
        passwordfieldContrasena.setText("");
        passwordfieldConfirmContrasena.setText("");
        StringBuilder sb = new StringBuilder(64);
        sb.append("<html>Campos obligatorios")
                        .append("<br/>Si no desea tener contrasena, deje los 2 campos de contrasena en blanco</html>");
        labCamposObligatorios.setText(sb.toString());
        
        textfieldNombreUsuario.setPreferredSize(new Dimension(100, 20));
        passwordfieldContrasena.setPreferredSize(new Dimension(100, 20));
        passwordfieldConfirmContrasena.setPreferredSize(new Dimension(100, 20)); 
        labNombreUsuario.setPreferredSize(new Dimension(140, 20));
        labContrasena.setPreferredSize(new Dimension(140, 20));
        labConfirmContrasena.setPreferredSize(new Dimension(140, 20));
        
        
		panRegistrarse.setLayout(new GridLayout(7,1));
		JPanel panNameUser = new JPanel();
		panNameUser.setLayout(new FlowLayout(FlowLayout.CENTER));
		panNameUser.add(labNombreUsuario);
		panNameUser.add(textfieldNombreUsuario);
		JPanel panPassword = new JPanel();
		panPassword.setLayout(new FlowLayout(FlowLayout.CENTER));
		panPassword.add(labContrasena);
		panPassword.add(passwordfieldContrasena);
		JPanel panConfirmPassword = new JPanel();
		panConfirmPassword.setLayout(new FlowLayout(FlowLayout.CENTER));
		panConfirmPassword.add(labConfirmContrasena);
		panConfirmPassword.add(passwordfieldConfirmContrasena);
		JPanel panCamposObligatorios = new JPanel();
		panCamposObligatorios.setLayout(new FlowLayout(FlowLayout.CENTER));
		panCamposObligatorios.add(labCamposObligatorios);
		JPanel panMensError = new JPanel();
		panMensError.setLayout(new FlowLayout(FlowLayout.CENTER));
		panMensError.add(labMensajeError);
		JPanel panButRegistrarse = new JPanel();
		panButRegistrarse.setLayout(new FlowLayout(FlowLayout.CENTER));
		panButRegistrarse.setBackground(new Color(0,0,0));
		//panButRegistrarse.setPreferredSize(butRegistrarse.getSize());//VOY POR AQUI
		panButRegistrarse.add(butRegistrarse);
		JPanel panButSalir = new JPanel();
		panButSalir.setLayout(new FlowLayout(FlowLayout.CENTER));
		panButSalir.add(butSalir);

		panRegistrarse.add(panNameUser);
		panRegistrarse.add(panPassword);
		panRegistrarse.add(panConfirmPassword);
		panRegistrarse.add(panCamposObligatorios);
		panRegistrarse.add(panMensError);
		panRegistrarse.add(panButRegistrarse);
		panRegistrarse.add(panButSalir);
		add(panRegistrarse);
    }
	
}
