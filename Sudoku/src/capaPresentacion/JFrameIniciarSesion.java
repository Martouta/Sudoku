package capaPresentacion;

import java.awt.*;
import javax.swing.*;



public class JFrameIniciarSesion extends javax.swing.JFrame{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton butIniciarSesion;
    private javax.swing.JButton butSalir;
    private javax.swing.JLabel labNombreUsuario;
    private javax.swing.JLabel labContrasena;
    private javax.swing.JPanel panIniciarSesion;
    private javax.swing.JPasswordField passwordfieldContrasena;
    private javax.swing.JTextField textfieldNombreUsuario;
    private javax.swing.JLabel labMensajeError;
    
    public JFrameIniciarSesion() {
		initComponents();
	}
    
       
    public javax.swing.JButton getButIniciarSesion() {
		return butIniciarSesion;
	}

	public javax.swing.JButton getButSalir() {
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
        panIniciarSesion = new javax.swing.JPanel();
        labNombreUsuario = new javax.swing.JLabel();
        labContrasena = new javax.swing.JLabel();
        labMensajeError = new javax.swing.JLabel();
        butIniciarSesion = new javax.swing.JButton();
        butSalir = new javax.swing.JButton();
        textfieldNombreUsuario = new javax.swing.JTextField();
        passwordfieldContrasena = new javax.swing.JPasswordField();

        labNombreUsuario.setText("Nombre de usuario: ");
        labContrasena.setText("Contrasena: ");
        labMensajeError.setText("");
        butIniciarSesion.setText("Iniciar Sesion");
        butSalir.setText("Salir");
        textfieldNombreUsuario.setText("");
        passwordfieldContrasena.setText("");
        
        textfieldNombreUsuario.setPreferredSize(new Dimension(50, 20));
        passwordfieldContrasena.setPreferredSize(new Dimension(50, 20)); 
        labNombreUsuario.setPreferredSize(new Dimension(150, 20));
        labContrasena.setPreferredSize(new Dimension(150, 20));

        javax.swing.GroupLayout panIniciarSesionLayout = new javax.swing.GroupLayout(panIniciarSesion);
        panIniciarSesion.setLayout(panIniciarSesionLayout);
        panIniciarSesionLayout.setHorizontalGroup(
            panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIniciarSesionLayout.createSequentialGroup()
                .addGroup(panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panIniciarSesionLayout.createSequentialGroup()
                        .addGroup(panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panIniciarSesionLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panIniciarSesionLayout.createSequentialGroup()
                                        .addComponent(labContrasena)
                                        .addGap(45, 45, 45)
                                        .addComponent(passwordfieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panIniciarSesionLayout.createSequentialGroup()
                                        .addComponent(labNombreUsuario)
                                        .addGap(58, 58, 58)
                                        .addComponent(textfieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panIniciarSesionLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(butSalir)
                                    .addComponent(butIniciarSesion))))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(panIniciarSesionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labMensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panIniciarSesionLayout.setVerticalGroup(
            panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIniciarSesionLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labNombreUsuario)
                    .addComponent(textfieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labContrasena)
                    .addComponent(passwordfieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(labMensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(butIniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }
}
