

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGeneral extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5751748113985052922L;

	
	
	private PanelDatos datos_p;
	private PanelReceta receta_p;
	private PanelConsejos consejos_p;
	private PanelCalorias calorias_p;
	String id;
	
	
	public PanelGeneral(String id_){
		super();
		setLayout(null);
		id = id_;
		
		datos_p = new PanelDatos(id);
		datos_p.setBounds(151, 0, 349, 273);
		datos_p.setVisible(true);
		add(datos_p);
		
		consejos_p = new PanelConsejos(id);
		consejos_p.setBounds(151, 0, 349, 273);
		consejos_p.setVisible(false);
		add(consejos_p);
		
		receta_p = new PanelReceta(id);
		receta_p.setBounds(151, 0, 349, 273);
		receta_p.setVisible(false);
		add(receta_p);
		
		calorias_p = new PanelCalorias(id);
		calorias_p.setBounds(151, 0, 349, 273);
		calorias_p.setVisible(false);
		add(calorias_p);
		
		JLabel opciones_l = new JLabel("Opciones");
		opciones_l.setBounds(22, 21, 61, 16);
		add(opciones_l);
		
		JButton recetas_b = new JButton("Recetas");
		recetas_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consejos_p.setVisible(false);
				datos_p.setVisible(false);
				mostrarReceta();
				calorias_p.setVisible(false);
			}
		});
		recetas_b.setBounds(22, 60, 117, 29);
		add(recetas_b);
		
		
		
		JButton consejos_b = new JButton("Consejos");
		consejos_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConsejos();
				datos_p.setVisible(false);
				receta_p.setVisible(false);
				calorias_p.setVisible(false);
			}
		});
		consejos_b.setBounds(22, 101, 117, 29);
		add(consejos_b);
		
		JButton calorias_b = new JButton("Calorias");
		calorias_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consejos_p.setVisible(false);
				datos_p.setVisible(false);
				receta_p.setVisible(false);
				mostrarCalorias();
			}
		});
		calorias_b.setBounds(22, 142, 117, 29);
		add(calorias_b);
		
		
		
		JButton datos_b = new JButton("Datos");
		datos_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consejos_p.setVisible(false);
				mostrarDatos();
				receta_p.setVisible(false);
				calorias_p.setVisible(false);
			}
		});
		datos_b.setBounds(22, 183, 117, 29);
		add(datos_b);
		
	
		
	}
	
	private void mostrarDatos() {
		remove(datos_p);
		datos_p = new PanelDatos(id);
		datos_p.setBounds(151, 0, 349, 273);
		datos_p.setVisible(true);
		add(datos_p);
		datos_p.revalidate();
		datos_p.repaint();
	}
	
	private void mostrarReceta() {
		remove(receta_p);
		receta_p = new PanelReceta(id);
		receta_p.setBounds(151, 0, 349, 273);
		receta_p.setVisible(true);
		add(receta_p);
		receta_p.revalidate();
		receta_p.repaint();
	}
	
	private void mostrarConsejos() {
		remove(consejos_p);
		consejos_p = new PanelConsejos(id);
		consejos_p.setBounds(151, 0, 349, 273);
		consejos_p.setVisible(true);
		add(consejos_p);
		consejos_p.revalidate();
		consejos_p.repaint();
	}
	
	private void mostrarCalorias() {
		remove(calorias_p);
		calorias_p = new PanelCalorias(id);
		calorias_p.setBounds(151, 0, 349, 273);
		calorias_p.setVisible(true);
		add(calorias_p);
		calorias_p.revalidate();
		calorias_p.repaint();
	}
}
