package Paneles;

import javax.swing.*;

public class PanelGeneral extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5751748113985052922L;

	public PanelGeneral(){
		super();
		
		JLabel lblNewLabel = new JLabel("Titulo");
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1);
	}
}
