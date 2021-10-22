

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCalorias extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6672415721443347853L;
	
	String id;
	JTextField textField;
	JLabel indicador;
	Integer[] data;
	JLabel ind_obj;
	JLabel ind_disp;
	JLabel ind_con;
	JLabel error_l;


	public PanelCalorias(String id_) {
		super();
		setLayout(null);
		id = id_;
		
	}

	
}
