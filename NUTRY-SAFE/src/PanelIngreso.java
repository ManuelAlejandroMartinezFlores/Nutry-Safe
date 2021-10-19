

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIngreso extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2305229489239812396L;
	int id;
	PanelGeneral panel;
	JButton salir_b;

	public PanelIngreso() {
		super();
		int id = 0;
		setLayout(null);
		
		
		
		// No tocar
		
		// panel = new PanelGeneral(id);
		// panel.setBounds(0, 0, 500, 300);
		// panel.setVisible(false);
		// add(panel);
		
		// salir_b = new JButton("Salir");
		// salir_b.setBounds(10, 304, 117, 29);
		// salir_b.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		panel.setVisible(false);
		// 		salir_b.setVisible(false);
		// 	}
		// });
		// salir_b.setVisible(false);
		// add(salir_b);
		
		// mostrarGeneral();
	}
	
	// public void mostrarGeneral() {
	// 	remove(panel);
	// 	panel = new PanelGeneral(id);
	// 	panel.setBounds(0, 0, 500, 300);
	// 	panel.setVisible(true);
	// 	add(panel);
	// 	panel.revalidate();
	// 	panel.repaint();
	// 	salir_b.setVisible(true);
	// }
}
