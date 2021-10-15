

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDatos extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501157757070073220L;
	private JTextField nombre_tf;
	private JTextField altura_tf;
	private JTextField edad_tf;
	private JTextField meta_tf;
	private JTextField peso_tf;
	
	int id;

	public PanelDatos(int id_) {
		super();
		
		id = id_;
		
		setLayout(null);
		
		JLabel titulo_l = new JLabel("Datos");
		titulo_l.setBounds(36, 16, 61, 16);
		add(titulo_l);
		
		JLabel nombre_l = new JLabel("Nombre");
		nombre_l.setBounds(36, 44, 61, 16);
		add(nombre_l);
		
		nombre_tf = new JTextField();
		nombre_tf.setBounds(36, 72, 130, 26);
		add(nombre_tf);
		nombre_tf.setColumns(10);
		
		JLabel altura_l = new JLabel("Altura");
		altura_l.setBounds(206, 44, 61, 16);
		add(altura_l);
		
		altura_tf = new JTextField();
		altura_tf.setBounds(204, 72, 130, 26);
		add(altura_tf);
		altura_tf.setColumns(10);
		
		JLabel edad_l = new JLabel("Edad");
		edad_l.setBounds(36, 133, 61, 16);
		add(edad_l);
		
		edad_tf = new JTextField();
		edad_tf.setBounds(36, 166, 130, 26);
		add(edad_tf);
		edad_tf.setColumns(10);
		
		meta_tf = new JTextField();
		meta_tf.setBounds(36, 232, 130, 26);
		add(meta_tf);
		meta_tf.setColumns(10);
		
		JLabel meta_l = new JLabel("Meta");
		meta_l.setBounds(36, 204, 61, 16);
		add(meta_l);
		
		JLabel peso_l = new JLabel("Peso");
		peso_l.setBounds(206, 133, 61, 16);
		add(peso_l);
		
		peso_tf = new JTextField();
		peso_tf.setBounds(206, 166, 130, 26);
		add(peso_tf);
		peso_tf.setColumns(10);
		
		JButton aceptar_b = new JButton("Aceptar");
		aceptar_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre_usuario = nombre_tf.getText();
					int edad = Integer.valueOf(edad_tf.getText());
					int altura = Integer.valueOf(altura_tf.getText());
					int meta = Integer.valueOf(meta_tf.getText());
					int peso = Integer.valueOf(peso_tf.getText());
					Controlador.actualizarDatos(id, nombre_usuario, edad, altura, peso, meta);
					setVisible(false);
				} catch (Exception ex) {}
			}
		});
		aceptar_b.setBounds(217, 232, 117, 29);
		add(aceptar_b);
	}
}