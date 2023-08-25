package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Comandos;
import controlador.ControlPrincipal;
import controlador.ControlVPrincipal;
import gui.Ventana;
import modelo.dao.ImagenDAO;

public class Principal {

	public static void main(String[] args) {
		//VARIABLES NECESARIAS
		ControlPrincipal CP; //CONTROL PRINCIPAL
				
		Ventana Vent;
		ControlVPrincipal CV; //VENTANA Y SU CONTROL
		
		//DAO
		ImagenDAO imgDAO;
				
		//CONEXI�N A LA BASE DE DATOS
		Connection conn = getDBConnection();
				
		if(conn != null){
			//CREACION DE LOS OBJETOS
			CV = new ControlVPrincipal();
			Vent = new Ventana();
			
			imgDAO = new ImagenDAO(conn);
			
			//INYECCION DE DEPENDENCIAS		
			CP = new ControlPrincipal(CV, Vent);//VENTANA Y CONTROL EN EL PRINCIPAL
			CV.setDao(imgDAO);
										
			//CONTROL DE LA VENTANA
			Vent.setControl(CV);
			Vent.llenar();
					
					
			//INICIA EL PROGRAMA
			CP.ejecutaComando(Comandos.INICIA, null, null);	
		}
				
	}//FIN MAIN
	
	public static Connection getDBConnection() 
    {
        String url          = "jdbc:derby://localhost:1527/BLOBColletion;create=false";//CORREGIR XD
        try
        {
            Connection conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Conectado exitosamente");
            return conn;
        }
        catch (SQLException e)
        {
              JOptionPane.showMessageDialog(null, "Falló la conexión " + e);  
              return null;
        }       
    }//FIN GETCONN
}//FIN CLASE PRINCIPAL
