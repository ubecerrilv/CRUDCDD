package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


import controlador.Comandos;
import modelo.Imagen;


@SuppressWarnings("serial")
public class Ventana extends VentanaAGeneral{
	BufferedImage imagenAct ;
	
	JPanel principal, arriba, abajo, der, iz;
	JLabel nombre, PDF, etqdes, etqdesC;
	JTextArea clave, des, desC;
	JButton insertar, selecArch, consultar;
	JComboBox<String> combo;
	JFileChooser file;
	GridBagConstraints rest;
	String ruta;
	
	
	public Ventana() {
		super("PDF o imagenes en base de datos");
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		rest = new GridBagConstraints();
	
		//CREAR PANELES
		iz = new JPanel();
		iz.setLayout(new GridLayout(2,1));
		
		arriba = new JPanel();
		arriba.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),"Insertar documento",TitledBorder.CENTER,TitledBorder.TOP));
		arriba.setLayout(new GridBagLayout());
		//ELEMENTOS DEL PANEL DE ARRIBA
			selecArch = new JButton("Seleccionar archivo");
			selecArch.addActionListener(this);
			selecArch.setActionCommand(Comandos.SELECCIONAR);
			rest.weighty=1.0;
			rest.gridx = 0;
			rest.gridy = 0;
			rest.gridwidth = 1;
			rest.gridheight = 1;
			arriba.add(selecArch, rest);
			
			nombre = new JLabel("No haz seleccionado ningún archivo");
			rest.gridx = 0;
			rest.gridy = 1;
			rest.gridwidth = 1;
			rest.gridheight = 1;
			arriba.add(nombre, rest);
			
			etqdes = new JLabel("Ingresa una descripción:");
			rest.gridx = 0;
			rest.gridy = 2;
			rest.gridwidth = 1;
			rest.gridheight = 1;
			arriba.add(etqdes, rest);
			
			des = new JTextArea();
			rest.gridx = 0;
			rest.gridy = 3;
			rest.gridwidth = 2;
			rest.gridheight = 1;
			rest.fill=GridBagConstraints.BOTH;
			arriba.add(des, rest);
			rest.fill=GridBagConstraints.NONE;
			
			insertar = new JButton("Insertar");
			insertar.addActionListener(this);
			insertar.setActionCommand(Comandos.INSERTAR);
			rest.gridx = 1;
			rest.gridy = 0;
			rest.gridwidth = 1;
			rest.gridheight = 2;
			rest.weightx=1.0;
			arriba.add(insertar, rest);
			rest.weightx=0;
			
			

			
			
		abajo= new JPanel();
		abajo.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),"Consultar documento",TitledBorder.CENTER,TitledBorder.TOP));
		abajo.setLayout(new GridBagLayout());
			//ELEMENTOS DEL PANEL DE ABAJO
			//ELEMENTO TEMPORAL PARA EL COMBO
			combo = new JComboBox<String>();
			//combo.setModel(null);
			rest.gridx = 0;
			rest.gridy = 0;
			rest.gridwidth = 2;
			rest.gridheight = 1;
			rest.weightx=1.0;
			rest.fill=GridBagConstraints.HORIZONTAL;
			abajo.add(combo, rest);
			rest.fill=GridBagConstraints.NONE;
			
			consultar = new JButton("Consultar");
			consultar .addActionListener(this);
			consultar .setActionCommand(Comandos.CONSULTAR);
			rest.gridx = 0;
			rest.gridy = 1;
			rest.gridwidth = 1;
			rest.gridheight = 1;
			abajo.add(consultar , rest);
			
			clave= new JTextArea("Llave primaria: ");
			clave.setEditable(false);
			rest.gridx = 1;
			rest.gridy = 1;
			rest.gridwidth = 1;
			rest.gridheight = 1;
			rest.fill=GridBagConstraints.HORIZONTAL;
			abajo.add(clave , rest);
			rest.fill=GridBagConstraints.NONE;
			
			etqdesC = new JLabel("Descripción:");
			rest.gridx = 0;
			rest.gridy = 2;
			rest.gridwidth = 1;
			rest.gridheight = 1;
			abajo.add(etqdesC, rest);
			
			desC = new JTextArea();
			desC.setEditable(false);
			rest.gridx = 0;
			rest.gridy = 3;
			rest.gridwidth = 2;
			rest.gridheight = 1;
			rest.fill=GridBagConstraints.BOTH;
			abajo.add(desC, rest);
			rest.fill=GridBagConstraints.NONE;
			
			rest.weightx=0;
			rest.weighty=0;
		
			
		
		iz.add(arriba);
		iz.add(abajo);
		
		//PANEL DE LA DERECHA
		der= new JPanel();
		der.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),"DOCUMENTO",TitledBorder.CENTER,TitledBorder.TOP));
		der.setLayout(new GridLayout(1,1));
		
		PDF = new JLabel();
		der.add(PDF);
		
		//PANEL PRINCIPAL
		principal = new JPanel();
		principal.setLayout(new GridLayout(1,2));
		principal.add(iz);
		principal.add(der);
		
		//CREANDO ELEMENTOS
		//FILE CHOOSER, PARA PODER SELECCIONAR ELEMENTOS
		file = new JFileChooser();
		file.setFileFilter(new FileNameExtensionFilter ("PDF", "pdf", "png","PNG", "jpg", "JPG", "tif", "TIF", "tiff", "TIFF", "avif", "AVIF", "jpeg", "JPEG", "bmp", "BMP", "ppm", "PPM"));
		
		//CREAR ETIQUETA PARA MOSTRAR LOS DOCUMENTOS
		
		
		//AGREGAR LOS PANELES A LA VENTANA
		this.add(principal, BorderLayout.CENTER);
		
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//FIN CONSTRUCTOR DE LA VENTANA

@Override
public void actionPerformed(ActionEvent e) {
		
	switch (e.getActionCommand()) {//CASO DE LOS COMANDOS (BOTONES)
	case Comandos.SELECCIONAR:
		
		file.showOpenDialog(this);
		ruta = file.getSelectedFile().getPath();
		nombre.setText(file.getSelectedFile().getName());
		
		if(ruta.indexOf("pdf")!=-1) {//ES PDF
			
		}else {//ES IMAGEN
			try {
				imagenAct = ImageIO.read(new File(file.getSelectedFile().getPath()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Icon icono = new ImageIcon(imagenAct.getScaledInstance(PDF.getWidth(), PDF.getHeight(), DO_NOTHING_ON_CLOSE));
			PDF.setIcon(icono);
			this.repaint();
		}//FIN ES IMAGEN
		
		des.setText("");
		desC.setText("");
		clave.setText("Llave primaria: ");
		
		break;
		
	case Comandos.INSERTAR:
		
		if(des.getText().compareToIgnoreCase("")!=0) { //O EL ARCHIVO ES NULO**
			//LOGICA PARA INSERTAR EN LA BASE
			Imagen img = new Imagen();
			//CREAR LA IMAGEN CON LOS CAMPOS ADECUADOS
			img.setRuta(ruta);
			img.setDescripcion(des.getText());
			img.setNombre(file.getSelectedFile().getName().substring(0,file.getSelectedFile().getName().indexOf(".")));
			
			
			Imagen res = (Imagen)this.control.ejecutaComando(Comandos.INSERTAR, img, null);
			
			if (res != null) {
				PDF.setIcon(null);
				JOptionPane.showMessageDialog(this, "!Imagen insertada¡");
				this.repaint();				
			}else {
				JOptionPane.showMessageDialog(this, "Error al insertar ):");
			}
			
			//ACTUALIZAR LISTA
			llenar();
			//LIMPIAR
			des.setText("");
			desC.setText("");
			clave.setText("Llave primaria: ");
			nombre.setText("No haz seleccionado ningún archivo");
			
		}else {
			JOptionPane.showMessageDialog(this, "Ingresa una descripción para la imagen");
		}
		
		break;
		
	case Comandos.CONSULTAR:
		//LOGICA PARA CONSULTAR UNA IMAGEN
		Imagen imagenI = new Imagen();//CREAR IMAGEN INCOMPLETA
		imagenI.setNombre(combo.getSelectedItem().toString().substring(combo.getSelectedItem().toString().indexOf(".")+2,combo.getSelectedItem().toString().length()));
		Imagen respuesta = (Imagen)this.control.ejecutaComando(Comandos.CONSULTAR, imagenI, null);//REGRESA IMAGEN COMPLETA
		
		if(respuesta != null) {
			Image original = respuesta.getIcono().getImage();
			Image nueva = original.getScaledInstance(PDF.getWidth(), PDF.getHeight(), DO_NOTHING_ON_CLOSE);
			
			this.PDF.setIcon(new ImageIcon(nueva));
			this.clave.setText("Lave primaria: "+respuesta.getLP());
			this.desC.setText(respuesta.getDescripcion());
			this.repaint();
		}else {
			JOptionPane.showMessageDialog(this, "Error en la consulta ):");
		}
		
		nombre.setText("No haz seleccionado ningún archivo");
		des.setText("");
		break;
		}//FIN SWITCH
	}//FIN ACTION

public void llenar() {
	Imagen aux = (Imagen)this.control.ejecutaComando(Comandos.NOMBRES, null, null);
	this.combo.setModel(new DefaultComboBoxModel<>(aux.getNombres()));
}
	
}//FIN CLASE VENTANA
