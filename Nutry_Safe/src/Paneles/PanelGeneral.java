package Paneles;

import javax.swing.*;

public class PanelGeneral extends JPanel {
	
	PanelGeneral(){
		super();
		
		JLabel lblNewLabel = new JLabel("Titulo");
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
	}
}
