package capaPresentacion;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;

import DataTransferObjects.DTOPartidaAMedias;
import DataTransferObjects.DTOSudokuDeLaBD;

public class JFrameSeleccionarPartidaReanudar extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int numSudokus;
	private Vector<String> datosARellenar;
	private Vector<String> nombresSudokus;
	private JList listPartidas;
	DefaultListModel demoList = new DefaultListModel();
	private JPanel panMenu;
	
	private JPanel panSelectPartidaRanudar;
	private JScrollPane scrollPane;
	private JButton butJugarSudoku;
	private JButton butVolverMenuSudoku;
	private JButton butSalir;
	private JLabel labMensError;
	
	public JFrameSeleccionarPartidaReanudar(Vector<DTOPartidaAMedias> infoPartidasAMedias) {
		rellenaDatos(infoPartidasAMedias);
		initComponents();
	}
	
	private void initComponents() {
		setTitle("Seleccionar partida a reanudar");
		setSize(700,480); //ancho por alto
		setMinimumSize(new Dimension(700, 480));
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
		panSelectPartidaRanudar = new JPanel();
		panMenu = new JPanel();
		scrollPane = new JScrollPane();
		butJugarSudoku = new JButton("Jugar sudoku");
		butVolverMenuSudoku = new JButton("Volver al Menu Sudoku");
		butSalir = new JButton("Salir");
		labMensError = new JLabel("");
		
		labMensError.setHorizontalAlignment(JLabel.CENTER);
		labMensError.setVerticalAlignment(JLabel.CENTER);
		
		
		GroupLayout jPanel2Layout = new GroupLayout(panMenu);
		panMenu.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        
        scrollPane.setViewportView(panMenu);
        
		
        GroupLayout panSelectPartidaRanudarLayout = new GroupLayout(panSelectPartidaRanudar);
        panSelectPartidaRanudar.setLayout(panSelectPartidaRanudarLayout);
        panSelectPartidaRanudarLayout.setHorizontalGroup(
            panSelectPartidaRanudarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
            .addGroup(panSelectPartidaRanudarLayout.createSequentialGroup()
                .addComponent(butVolverMenuSudoku)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butSalir))
            .addGroup(panSelectPartidaRanudarLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(butJugarSudoku)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labMensError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panSelectPartidaRanudarLayout.setVerticalGroup(
            panSelectPartidaRanudarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panSelectPartidaRanudarLayout.createSequentialGroup()
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butJugarSudoku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labMensError, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panSelectPartidaRanudarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butVolverMenuSudoku)
                    .addComponent(butSalir)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panSelectPartidaRanudar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSelectPartidaRanudar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        
        rellenarPanelMenu();
        
		
		add(panSelectPartidaRanudar);
	}
	
	private void rellenaDatos(Vector<DTOPartidaAMedias> infoPartidasAMedias) {
		/*datosARellenar = new Vector<String>();
		nombresSudokus = new Vector<String>();
		datosARellenar.addElement("1, sudo01, empezado el 24/11/2015, tiempo ejecutandose: 02:30:26, numero de pistas: 4");
		datosARellenar.addElement("2, sudo02, empezado el 24/11/2015, tiempo ejecutandose: 02:30:02, numero de pistas: 0");
		datosARellenar.addElement("3, sudo05, empezado el 24/11/2015, tiempo ejecutandose: 11:30:00, numero de pistas: 10");
		datosARellenar.addElement("4, sudo06, empezado el 24/11/2015, tiempo ejecutandose: 01:00:59, numero de pistas: 2");
		demoList.addElement(datosARellenar.get(0));
		demoList.addElement(datosARellenar.get(1));
		demoList.addElement(datosARellenar.get(2));
		demoList.addElement(datosARellenar.get(3));
		nombresSudokus.addElement("sudo01");
		nombresSudokus.addElement("sudo02");
		nombresSudokus.addElement("sudo05");
		nombresSudokus.addElement("sudo06");*/
		
		numSudokus = infoPartidasAMedias.size(); //NECESITAMOS ESTA VARIABLE???!!!
		datosARellenar = new Vector<String>();
		nombresSudokus = new Vector<String>();
		int cont = 1;
		for (DTOPartidaAMedias infoPartida : infoPartidasAMedias) {
			String rellena = cont + ", " + infoPartida.getNombreSudoku() + ", tiempo de partida real: ";
			
			int intHoras = infoPartida.getHoras();
			int intMinutos = infoPartida.getMinutos();
			int intSegundos = infoPartida.getSegundos();
			String strHoras = intHoras + "";
			if (intHoras <= 9) strHoras = "0" + intHoras;
			String strMinutos = intMinutos + "";
			if (intMinutos <= 9) strMinutos = "0" + intMinutos;
			String strSegundos = intSegundos + "";
			if (intSegundos <= 9) strSegundos = "0" + intSegundos;
			
			rellena = rellena + strHoras + ":" + strMinutos + ":" + strSegundos;
			rellena = rellena + ", numero de pistas: ";
			rellena = rellena + infoPartida.getNumeroPistas();
			
			datosARellenar.addElement(rellena);
			demoList.addElement(rellena);
			nombresSudokus.addElement(infoPartida.getNombreSudoku());
			++cont;
		}
	}

	private void rellenarPanelMenu() {
        listPartidas = new JList(demoList);
        scrollPane.setViewportView(listPartidas);
        listPartidas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;
				
				if (listPartidas.getSelectedValuesList().size() > 1) System.out.println("más de uno");
				else {
					String seleccion = (String) listPartidas.getSelectedValue();
					int pos = Integer.parseInt(seleccion.substring(0, 1));
					--pos;
					String nomsudoku = nombresSudokus.get(pos);
					System.out.println(nomsudoku);
				}
			}
		});
        
        panSelectPartidaRanudar.add(panMenu);
	}
}
