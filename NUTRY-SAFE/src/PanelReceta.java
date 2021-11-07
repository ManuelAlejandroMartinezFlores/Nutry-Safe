/**
 * PanelReceta.
 * Muestra GUI para generar Recetas.
 * 
 * @version Entrega 3
 */

import javax.swing.*;
import java.awt.Font;
import java.awt.Desktop;
import java.net.URI;

public class PanelReceta extends JPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6725610609109086538L;
	String id;
	JTextPane textPane;
	
	/**
	 * Muestra las recetas al usuario en GUI 
	 * @param id_
	 */
	public PanelReceta() {
		super();
		setLayout(null);
		// id = id_;
		
		JLabel titulo_l = new JLabel("Receta");
		titulo_l.setBounds(42, 21, 61, 16);
		add(titulo_l);

		/**
		 * Relaciona la interfaz con su método correspondiente de la clase controlador
		 */
		textPane = new JTextPane();
		Font f = new Font(Font.SANS_SERIF, 1, 10);
		textPane.setFont(f);
		textPane.setText("");
		textPane.setBounds(6, 48, 342, 220);
		add(textPane);

		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(new URI(Controlador.darReceta()));
				textPane.setText("Se está reproduciendo el video en el browser por defecto del usuario");
			} catch (Exception e){
				textPane.setText("Error");
			}
		} else {
			textPane.setText("No se puede abrir el browser");
		}
	}

}
