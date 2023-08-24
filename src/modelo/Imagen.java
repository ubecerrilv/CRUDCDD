package modelo;

public class Imagen implements Data {
	
	private String nombre, descripcion;
	private int LP;
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

	
}
