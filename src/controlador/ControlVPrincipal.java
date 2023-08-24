package controlador;

import modelo.Data;
import modelo.Imagen;
import modelo.dao.ImagenDAO;

public class ControlVPrincipal extends ControlAbs {
	ImagenDAO dao;

	@Override
	public Data ejecutaComando(String c, Data d, Data d2) {//EN ESTA CLASE, REALIZAR TRABAJOS DEL MODELO
		switch(c) {
		case Comandos.INSERTAR:
			Imagen img =(Imagen)d;
			return dao.inserta(img);
			
			
		case Comandos.CONSULTAR:
			Imagen img2 = (Imagen)d;
			return dao.consulta(img2);
			
		}
		
				
		return null;//REGRESAR UN MODELO
	}

	public ImagenDAO getDao() {
		return dao;
	}

	public void setDao(ImagenDAO dao) {
		this.dao = dao;
	}

	
}
