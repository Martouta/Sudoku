package capaPresentacion;

//FALTA REFINARLO ENTEROOOOOOOOOOO PERO FUNCIONA!

import javax.swing.*;


public class JFrameMenuPrincipal extends JFrame{
	
	private JButton butRegistrarse;
    private JButton butIniciarSesion;
    private JButton butSalir;
    private JLabel labSelectFunc;
    private JPanel panPrincipal;

	public JFrameMenuPrincipal() {
		initComponents();
	}
	
	public javax.swing.JButton getButRegistrarse() {
		return butRegistrarse;
	}

	public javax.swing.JButton getButIniciarSesion() {
		return butIniciarSesion;
	}

	public javax.swing.JButton getButSalir() {
		return butSalir;
	}
	
	private void initComponents() {
		panPrincipal = new JPanel();
        labSelectFunc = new JLabel();
        butRegistrarse = new JButton();
        butIniciarSesion = new JButton();
        butSalir = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labSelectFunc.setText("Seleccione una función:");
        butRegistrarse.setText("Registrarse");
        butIniciarSesion.setText("Iniciar sesión");
        butSalir.setText("Salir");

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(butIniciarSesion)
                            .addComponent(butRegistrarse, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(labSelectFunc)))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(butSalir)
                .addGap(170, 170, 170))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labSelectFunc)
                .addGap(31, 31, 31)
                .addComponent(butIniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butRegistrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(butSalir)
                .addGap(30, 30, 30))
        );

        butRegistrarse.getAccessibleContext().setAccessibleName("butRegistrarse");
        butIniciarSesion.getAccessibleContext().setAccessibleName("butIniciarSesion");
        butSalir.getAccessibleContext().setAccessibleName("butSalir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
