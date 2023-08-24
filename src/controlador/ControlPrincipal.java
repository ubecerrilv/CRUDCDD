package controlador;


import gui.Ventana;
import modelo.Data;

public class ControlPrincipal extends ControlAbs{
	
/*
 * Esta clase es creada como un control de las ventanas, dirige cuando mostrase u ocultarse
 */
	
/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/
	
	private Ventana vent;
	
				
/**********************************************************************************************************************************************
 * 
 * 																M�TODOS
 * 
 *********************************************************************************************************************************************/

	public ControlPrincipal(ControlVPrincipal CVP, Ventana venta) {
		this.vent = venta;
	}
	
	@Override
	public Data ejecutaComando(String c, Data d, Data d2) {
		switch(c) {
		case Comandos.INICIA:
			vent.setBounds(0, 0, 500, 600);
			vent.setLocationRelativeTo(null);
			vent.setVisible(true);
			
		break;	
		}
		return null;	
		
	}

}//FIN CLASE
