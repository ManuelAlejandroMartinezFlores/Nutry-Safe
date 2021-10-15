package Paneles;

import javax.swing.*;

public class PanelDatos extends PanelGeneral{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501157757070073220L;
	private JTextField nombre_tf;
	private JTextField altura_tf;
	private JTextField edad_tf;
	private JTextField meta_tf;
	private JTextField peso_tf;

	public PanelDatos() {
		super();
		
		JLabel titulo_l = new JLabel("Datos");
		titulo_l.setBounds(205, 19, 61, 16);
		add(titulo_l);
		
		JLabel nombre_l = new JLabel("Nombre");
		nombre_l.setBounds(154, 50, 61, 16);
		add(nombre_l);
		
		nombre_tf = new JTextField();
		nombre_tf.setBounds(151, 78, 130, 26);
		add(nombre_tf);
		nombre_tf.setColumns(10);
		
		JLabel altura_l = new JLabel("Altura");
		altura_l.setBounds(345, 50, 61, 16);
		add(altura_l);
		
		altura_tf = new JTextField();
		altura_tf.setBounds(345, 78, 130, 26);
		add(altura_tf);
		altura_tf.setColumns(10);
		
		JLabel edad_l = new JLabel("Edad");
		edad_l.setBounds(154, 133, 61, 16);
		add(edad_l);
		
		edad_tf = new JTextField();
		edad_tf.setBounds(151, 161, 130, 26);
		add(edad_tf);
		edad_tf.setColumns(10);
		
		meta_tf = new JTextField();
		meta_tf.setBounds(151, 232, 130, 26);
		add(meta_tf);
		meta_tf.setColumns(10);
		
		JLabel meta_l = new JLabel("Meta");
		meta_l.setBounds(154, 204, 61, 16);
		add(meta_l);
		
		JLabel peso_l = new JLabel("Peso");
		peso_l.setBounds(329, 133, 61, 16);
		add(peso_l);
		
		peso_tf = new JTextField();
		peso_tf.setBounds(329, 161, 130, 26);
		add(peso_tf);
		peso_tf.setColumns(10);
	}
}
