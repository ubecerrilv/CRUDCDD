package gui;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controlador.Control;

@SuppressWarnings("serial")
public abstract class VentanaAGeneral extends JFrame implements ActionListener {

/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	Control control;
		
/**********************************************************************************************************************************************
 * 
 * 																M�TODOS
 * 
 *********************************************************************************************************************************************/

		public VentanaAGeneral(String titulo) {
			super(titulo);
		
		}
		
		public VentanaAGeneral(Control control) {
			this.control=control;
		}
			
		
		public VentanaAGeneral() {
			super();
		}
			
		
		public void setControl(Control control) {
			this.control = control;
		}
}//FIN CLASE
