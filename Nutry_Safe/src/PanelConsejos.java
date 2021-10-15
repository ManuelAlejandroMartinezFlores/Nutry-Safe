

import javax.swing.*;

public class PanelConsejos extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3749871797146343742L;
	int id;
	
	public PanelConsejos(int id_) {
		super();
		setLayout(null);
		int id = id_;
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(169, 45, 61, 16);
		add(lblNewLabel);
		
		
	}

}
