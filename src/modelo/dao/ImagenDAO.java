package modelo.dao;

import java.sql.Connection;

import modelo.Imagen;

public class ImagenDAO {
	private Connection conn;

	public ImagenDAO() {

	}
	public Imagen consulta(Imagen i) {//COMPLETAR**
		return null;
	}
	
	public Imagen inserta(Imagen i) {//COMPLETAR**
		return null;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ImagenDAO(Connection conn) {
		super();
		this.conn = conn;
	}

}
