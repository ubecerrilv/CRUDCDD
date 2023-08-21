package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controlador.Comandos;


@SuppressWarnings("serial")
public class Ventana extends VentanaAGeneral{
	
	JPanel panelCent;
	JLabel paginas;
	JTextArea pag;
	JButton bBuscar;
	JScrollPane sP;
	GridBagConstraints rest;
	
	
	public Ventana() {
		super("<title>");
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setExtendedState(MAXIMIZED_BOTH);
		rest = new GridBagConstraints();
		
		//CREAR PANELES
		
		//EJEMPLO DE PANEL CON RESTRICCIONES
		JPanel maxmin = new JPanel();
		maxmin.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),"Maximos y minimos del histograma",TitledBorder.CENTER,TitledBorder.TOP));
		maxmin.setLayout(new GridBagLayout());
		
		JButton max = new JButton("Picos significativos del histograma");
		max.setActionCommand(Comandos.INICIA);
		max.addActionListener(this);
		rest.gridx = 0;
		rest.gridy = 0;
		rest.gridwidth = 1;
		rest.gridheight = 1;
		maxmin.add(max, rest);
		
		//PANEL CENTRAL
		panelCent = new JPanel(new GridLayout(1,2));
		panelCent.setBorder(new EmptyBorder(5,5,5,5));
		panelCent.setBackground(Color.BLACK);

		//CREAR ETIQUETAS
		paginas = new JLabel("PÁGINAS:");
		
		//CREAR TEXTAREAS
		pag = new JTextArea("");
			
		//CREAR BOTON DE MAPEAR
		bBuscar = new JButton("Mapear página");
		bBuscar.setActionCommand(controlador.Comandos.INICIA);//CREAR Y CAMBIAR COMANDO
		bBuscar.addActionListener(this);
		
		//CREAR SCROLLS
		sP = new JScrollPane(pag, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//CAMBIAR EL SETEO DEL TEXT AREA
		
		
		//AGREAGAR LOS ELEMENTOS A LOS PANELES
		//PANEL CENTRAL
			panelCent.add(sP);
		
		//AGREGAR LOS PANELES A LA VENTANA
		this.add(panelCent, BorderLayout.CENTER);
		
	
		//this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//FIN CONSTRUCTOR DE LA VENTANA

@Override
public void actionPerformed(ActionEvent e) {
		
	switch (e.getActionCommand()) {//CASO DE LOS COMANDOS (BOTONES)
	case "":
		
		break;		
		}//FIN SWITCH
	}//FIN ACTION
	
}//FIN CLASE VENTANA
