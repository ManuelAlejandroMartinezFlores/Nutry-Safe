

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIngreso extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2305229489239812396L;

	public PanelIngreso(int id_) {
		super();
		int id = id_;
		setLayout(null);
		
		
		
		// No tocar
		
		
		
		PanelGeneral panel = new PanelGeneral(id);
		panel.setBounds(0, 300, 10, 500);
		panel.setVisible(false);
		add(panel);
		
		JButton salir_b = new JButton("Salir");
		salir_b.setBounds(16, 231, 117, 29);
		salir_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				salir_b.setVisible(false);
			}
		});
		salir_b.setVisible(false);
		add(salir_b);
		
		
	}

}
