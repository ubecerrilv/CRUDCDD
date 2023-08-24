package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.Document;

import org.apache.pdfbox.pdmodel.PDDocument;

import controlador.Comandos;


@SuppressWarnings("serial")
public class Ventana extends VentanaAGeneral{
	
	JPanel principal;
	JLabel nombre;
	JButton insertar, selecArch;
	JComboBox<String> combo;
	JScrollPane preview;
	JFileChooser file;
	GridBagConstraints rest;
	
	
	public Ventana() {
		super("PDF o imagenes en base de datos");
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//this.setExtendedState(MAXIMIZED_BOTH);
		rest = new GridBagConstraints();
		rest.fill = GridBagConstraints.HORIZONTAL;
		rest.weightx=1.0;
		rest.weighty=1.0;
		
		//CREAR PANELES
		principal = new JPanel();
		principal.setLayout(new GridBagLayout());
		
		//CREANDO ELEMENTOS
		//FILE CHOOSER, PARA PODER SELECCIONAR ELEMENTOS
		file = new JFileChooser();
		file.setFileFilter(new FileNameExtensionFilter ("PDF", "pdf", "png","PNG", "jpg", "JPG", "tif", "TIF", "tiff", "TIFF", "avif", "AVIF", "jpeg", "JPEG", "bmp", "BMP", "ppm", "PPM"));
		
		selecArch = new JButton("Seleccionar archivo");
		selecArch.addActionListener(this);
		selecArch.setActionCommand(Comandos.SELECCIONAR);
		rest.gridx = 0;
		rest.gridy = 0;
		rest.gridwidth = 2;
		rest.gridheight = 1;
		principal.add(selecArch, rest);
		//FALTACOMBOBOX****
		combo = new JComboBox<String>();
		rest.gridx = 0;
		rest.gridy = 1;
		rest.gridwidth = 2;
		rest.gridheight = 1;
		principal.add(combo, rest);
		
		
		nombre = new JLabel("Aquí aparecerá el nombre del archivo");
		rest.gridx = 0;
		rest.gridy = 2;
		rest.gridwidth = 2;
		rest.gridheight = 1;
		principal.add(nombre, rest);
		
		preview = new JScrollPane(null, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,//REEMPLAZAR EL AREA POR EL ELEMENTO PARA VER
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		rest.gridx = 0;
		rest.gridy = 3;
		rest.gridwidth = 2;
		rest.gridheight = 4;
		rest.fill = GridBagConstraints.BOTH;
		principal.add(preview, rest);
		rest.fill = GridBagConstraints.HORIZONTAL;
		
		insertar = new JButton("Insertar");
		insertar.addActionListener(this);
		insertar.setActionCommand(Comandos.INSERTAR);
		rest.gridx = 1;
		rest.gridy = 7;
		rest.gridwidth = 1;
		rest.gridheight = 1;
		principal.add(insertar, rest);
		
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
		String ruta = file.getSelectedFile().getPath();
		nombre.setText(file.getSelectedFile().getName());
		System.out.print(file.getSelectedFile().getName());
		this.repaint();
		
		/*if(ruta.indexOf("pdf")!=-1) {//ES PDF
			try {
				Document document = PDDocument.load(file.getSelectedFile());
				Image pdf = ImageIO.read(file.getSelectedFile());
				JLabel etq = new JLabel();
				etq.setIcon(new ImageIcon(pdf));
				preview.add(etq);
				this.repaint();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else {//ES IMAGEN
			
		}//FIN ES IMAGEN*/
		
		
		
		break;		
		}//FIN SWITCH
	}//FIN ACTION
	
}//FIN CLASE VENTANA
