package capaPresentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class JFrameIniciarSesion extends javax.swing.JFrame{
	private javax.swing.JButton butIniciarSesion;
    private javax.swing.JButton butSalir;
    private javax.swing.JLabel labNombreUsuario;
    private javax.swing.JLabel labContrasena;
    private javax.swing.JPanel panIniciarSesion;
    private javax.swing.JPasswordField passwordfieldContrasena;
    private javax.swing.JTextField textfieldNombreUsuario;
    
    public JFrameIniciarSesion() {
		initComponents();
	}
    
    public JFrameIniciarSesion(String usuario, String contrasena) {
		initComponents();
		textfieldNombreUsuario.setText(usuario);
		passwordfieldContrasena.setText(contrasena);
	}
	
	private void initComponents() {
        panIniciarSesion = new javax.swing.JPanel();
        labNombreUsuario = new javax.swing.JLabel();
        labContrasena = new javax.swing.JLabel();
        butIniciarSesion = new javax.swing.JButton();
        butSalir = new javax.swing.JButton();
        textfieldNombreUsuario = new javax.swing.JTextField();
        passwordfieldContrasena = new javax.swing.JPasswordField();

        labNombreUsuario.setText("Nombre de usuario: ");
        labContrasena.setText("Contrasena: ");
        butIniciarSesion.setText("Iniciar Sesion");
        butSalir.setText("Salir");
        textfieldNombreUsuario.setText("");
        passwordfieldContrasena.setText("hola");
        
        butIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                CtrlCapaPresentacion ctrlCP = new CtrlCapaPresentacion();
                ctrlCP.pressIniciarSesion();
			}
		});
        butSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                CtrlCapaPresentacion ctrlCP = new CtrlCapaPresentacion();
                ctrlCP.pressSalir();
			}
		});

        javax.swing.GroupLayout panIniciarSesionLayout = new javax.swing.GroupLayout(panIniciarSesion);
        panIniciarSesion.setLayout(panIniciarSesionLayout);
        panIniciarSesionLayout.setHorizontalGroup(
            panIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(106, Short.MAX_VALUE))
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
                .addGap(56, 56, 56)
                .addComponent(butIniciarSesion)
                .addGap(34, 34, 34)
                .addComponent(butSalir)
                .addContainerGap(38, Short.MAX_VALUE))
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
