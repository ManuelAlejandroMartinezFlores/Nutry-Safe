/**
 * PanelConsejos.
 * Muestra la GUI para generar consejos.
 * 
 * @version Entrega 3
 */

import javax.swing.*;
import java.awt.Font;

public class PanelConsejos extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3749871797146343742L;
	String id;

	/**
	 * Muestra los consejos al usuario en GUI
	 * @param id_
	 */
	public PanelConsejos(String id_) {
		super();
		setLayout(null);
		id = id_;
		JLabel titulo_l = new JLabel("Consejos");
		titulo_l.setBounds(42, 21, 61, 16);
		add(titulo_l);
		/**
		 * Se relaciona la interfaz gráfica con su método correspondiente de la clase controlador
		 */
		JTextPane textPane = new JTextPane();
		Font f = new Font(Font.SANS_SERIF, 1, 10);
		textPane.setFont(f);
		textPane.setText(Controlador.darConsejo(id));
		textPane.setBounds(6, 48, 291, 98);
		add(textPane);
		
		
		
	}

}
