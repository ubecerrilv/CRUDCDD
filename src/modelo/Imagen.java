package modelo;

import javax.swing.ImageIcon;

public class Imagen implements Data {
	
	private String nombre, descripcion, ruta;
	private int LP;
	private String [] nombres;
	private ImageIcon icono;
	//FALTA IMAGEN COMO TAL

	public Imagen() {
	}

	public Imagen(String nombre, String descripcion, int lP) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		LP = lP;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getLP() {
		return LP;
	}

	public void setLP(int lP) {
		LP = lP;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}

	public ImageIcon getIcono() {
		return icono;
	}

	public void setIcono(ImageIcon icono) {
		this.icono = icono;
	}
	
	
}
