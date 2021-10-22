

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
		
		data = Controlador.getCalorias(id);

		JLabel titulo_l = new JLabel("Ingreso calorias");
		titulo_l.setBounds(6, 20, 110, 16);
		add(titulo_l);
		
		JLabel disp_l = new JLabel("Calorias disponibles en el día");
		disp_l.setBounds(16, 56, 199, 16);
		add(disp_l);
		
		textField = new JTextField();
		textField.setBounds(182, 165, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel ingreso_l = new JLabel("Calorias a ingresar");
		ingreso_l.setBounds(16, 170, 139, 16);
		add(ingreso_l);
		
		JButton aceptar_b = new JButton("Aceptar");
		aceptar_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contarCaloria();
			}
		});
		aceptar_b.setBounds(108, 203, 117, 29);
		add(aceptar_b);
		
		ind_disp = new JLabel(Integer.toString(data[1]));
		ind_disp.setBounds(227, 56, 61, 16);
		add(ind_disp);
		
		JLabel con_l = new JLabel("Calorias consumidas en el día");
		con_l.setBounds(16, 96, 199, 16);
		add(con_l);
		
		ind_con = new JLabel(Integer.toString(data[2]));
		ind_con.setBounds(227, 96, 61, 16);
		add(ind_con);
		
		JLabel obj_l = new JLabel("Calorias objetivo en el día");
		obj_l.setBounds(16, 134, 199, 16);
		add(obj_l);
		
		ind_obj = new JLabel(Integer.toString(data[0]));
		ind_obj.setBounds(227, 134, 61, 16);
		add(ind_obj);

		error_l = new JLabel("", SwingConstants.CENTER);
		error_l.setBounds(90, 244, 172, 16);
		add(error_l);
	}

	public void contarCaloria(){
		try {
			int cal = Integer.valueOf(textField.getText());
			data = Controlador.contarCalUsuario(id, cal);
			ind_obj.setText(Integer.toString(data[0]));
			ind_con.setText(Integer.toString(data[2]));
			ind_disp.setText(Integer.toString(data[1]));
			textField.setText("");
			error_l.setText("Éxito");
	
		} catch (Exception ex) {
			error_l.setText("Ingrese un dato valido");
			textField.setText("");
			ex.printStackTrace(System.out);
		}
	}
}
