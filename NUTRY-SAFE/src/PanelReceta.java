

import javax.swing.*;
import java.awt.Font;

public class PanelReceta extends JPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6725610609109086538L;
	String id;
	JTextPane textPane;
	
	public PanelReceta(String id_) {
		super();
		setLayout(null);
		id = id_;
		
		JLabel titulo_l = new JLabel("Receta");
		titulo_l.setBounds(42, 21, 61, 16);
		add(titulo_l);

		textPane = new JTextPane();
		Font f = new Font(Font.SANS_SERIF, 1, 10);
		textPane.setFont(f);
		textPane.setText(Controlador.recetaCalorias(id));
		textPane.setBounds(6, 48, 342, 220);
		add(textPane);
	}

}
