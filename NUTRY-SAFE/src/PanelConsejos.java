

import javax.swing.*;
import java.awt.Font;

public class PanelConsejos extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3749871797146343742L;
	String id;
	
	public PanelConsejos(String id_) {
		super();
		setLayout(null);
		id = id_;
		
		JLabel titulo_l = new JLabel("Consejos");
		titulo_l.setBounds(42, 21, 61, 16);
		add(titulo_l);

		JTextPane textPane = new JTextPane();
		Font f = new Font(Font.SANS_SERIF, 1, 10);
		textPane.setFont(f);
		textPane.setText(Controlador.darConsejo(id));
		textPane.setBounds(6, 48, 291, 98);
		add(textPane);
		
		
		
	}

}