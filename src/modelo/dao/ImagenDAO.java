package modelo.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import modelo.Imagen;

public class ImagenDAO {
	private Connection conn;

	public ImagenDAO() {

	}
	public Imagen consulta(Imagen i) {//COMPLETAR**
		String selectQuery = "SELECT id, nombre, descripcion, objeto FROM datos WHERE nombre = ?";
        PreparedStatement preparedStatement;
        Imagen res = null;
		try {
			preparedStatement = conn.prepareStatement(selectQuery);
			preparedStatement.setString(1, i.getNombre());
			
			//EJECUTAR LA CONSULTA
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				//RECUPERAR DATOS DEL BLOB
				byte[] imageBytes = resultSet.getBytes("objeto");
				ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
				
				//CREAR EL ICONO
				ImageIcon imageIcon = new ImageIcon(ImageIO.read(bis));
				
				res = new Imagen();
				res.setIcono(imageIcon);
				
				//RECUPERAR RESTO DE DATOS
				res.setLP(resultSet.getInt("id"));
				res.setDescripcion(resultSet.getString("descripcion"));
				res.setNombre(resultSet.getString("nombre"));
				
				bis.close();
				return res;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Imagen inserta(Imagen i) {//COMPLETAR**
		// LEER IMAGEN DESDE LA RUTA
        File archivo = new File(i.getRuta());
        FileInputStream fis;
        String insertQuery = "INSERT INTO datos (nombre, descripcion, objeto) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        
		try {
			fis = new FileInputStream(archivo);
			
			try {
				preparedStatement = conn.prepareStatement(insertQuery);
				preparedStatement.setString(1, i.getNombre()); // Nombre de la imagen
				preparedStatement.setString(2, i.getDescripcion());
				preparedStatement.setBinaryStream(3, fis, (int) archivo.length()); // Datos BLOB
				
				//INSERTA
				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					return i;
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public Imagen obtenerNombres() {
		String selectQuery = "SELECT id, nombre FROM datos";
        PreparedStatement preparedStatement;
        List<Integer> ids = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        
		try {
			preparedStatement = conn.prepareStatement(selectQuery);
			// Ejecutar la consulta
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				
				ids.add(id);
				nombres.add(nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String resul [] =new String[ids.size()];
		for(int i =0; i<ids.size();i++) {
			resul [i] = ids.get(i) + ". "+ nombres.get(i);
		}
		
		Imagen img = new Imagen();
		img.setNombres(resul);
		
		return img;
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
