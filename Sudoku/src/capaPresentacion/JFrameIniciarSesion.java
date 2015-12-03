package capaPresentacion;

import java.awt.*;
import javax.swing.*;


public class JFrameIniciarSesion extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton butIniciarSesion;
    private JButton butSalir;
    private JLabel labNombreUsuario;
    private JLabel labContrasena;
    private JPanel panIniciarSesion;
    private JPasswordField passwordfieldContrasena;
    private JTextField textfieldNombreUsuario;
    private JLabel labMensajeError;
    
    public JFrameIniciarSesion() {
		initComponents();
	}
    
       
    public JButton getButIniciarSesion() {
		return butIniciarSesion;
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
	
	public void setMensajeError(String msj){
		labMensajeError.setText(msj);
	}

	
	private void initComponents() {
		setTitle("Iniciar Sesion");
		setSize(310,275);
		setMinimumSize(new Dimension(310, 275));
		setResizable(true);
		
		panIniciarSesion = new JPanel();
		labNombreUsuario = new JLabel();
        labContrasena = new JLabel();
        labMensajeError = new JLabel();
        butIniciarSesion = new JButton();
        butSalir = new JButton();
        textfieldNombreUsuario = new JTextField();
        passwordfieldContrasena = new JPasswordField();

        labNombreUsuario.setText("Nombre de usuario: ");
        labContrasena.setText("Contrasena: ");
        labMensajeError.setText("");
        butIniciarSesion.setText("Iniciar Sesion");
        butSalir.setText("Salir");
        textfieldNombreUsuario.setText("");
        passwordfieldContrasena.setText("");
        
        textfieldNombreUsuario.setPreferredSize(new Dimension(100, 20));
        passwordfieldContrasena.setPreferredSize(new Dimension(100, 20)); 
        labNombreUsuario.setPreferredSize(new Dimension(120, 20));
        labContrasena.setPreferredSize(new Dimension(120, 20));

        panIniciarSesion.setLayout(new GridLayout(5,1,0,1));
		JPanel panNameUser = new JPanel();
		panNameUser.setLayout(new FlowLayout(FlowLayout.CENTER));
		panNameUser.add(labNombreUsuario);
		panNameUser.add(textfieldNombreUsuario);
		JPanel panPassword = new JPanel();
		panPassword.setLayout(new FlowLayout(FlowLayout.CENTER));
		panPassword.add(labContrasena);
		panPassword.add(passwordfieldContrasena);
		JPanel panMensError = new JPanel();
		panMensError.setLayout(new FlowLayout(FlowLayout.CENTER));
		panMensError.add(labMensajeError);
		JPanel panButIniciarSesion = new JPanel();
		panButIniciarSesion.setLayout(new FlowLayout(FlowLayout.CENTER));
		//panButIniciarSesion.setBackground(new Color(0,0,0));
		//panButIniciarSesion.setPreferredSize(butIniciarSesion.getSize());//VOY POR AQUI
		panButIniciarSesion.add(butIniciarSesion);
		JPanel panButSalir = new JPanel();
		panButSalir.setLayout(new FlowLayout(FlowLayout.CENTER));
		panButSalir.add(butSalir);

		panIniciarSesion.add(panNameUser);
		panIniciarSesion.add(panPassword);
		panIniciarSesion.add(panMensError);
		panIniciarSesion.add(panButIniciarSesion);
		panIniciarSesion.add(panButSalir);
		add(panIniciarSesion);
    }
	
}
