

import javax.swing.*;

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(169, 45, 61, 16);
		add(lblNewLabel);
		
		
	}

}
