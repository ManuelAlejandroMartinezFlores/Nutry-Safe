

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGeneral extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5751748113985052922L;

	
	
	protected JLabel opciones_l;
	protected JButton recetas_b;
	protected JButton consejos_b;
	protected JButton calorias_b;
	protected JButton datos_b;
	protected JButton salir_b;
	
	public PanelGeneral(int id){
		super();
		setLayout(null);
		
		PanelDatos datos_p = new PanelDatos(id);
		datos_p.setBounds(151, 0, 349, 273);
		datos_p.setVisible(false);
		add(datos_p);
		
		PanelConsejos consejos_p = new PanelConsejos();
		consejos_p.setBounds(151, 0, 349, 273);
		consejos_p.setVisible(false);
		add(consejos_p);
		
		PanelReceta receta_p = new PanelReceta();
		receta_p.setBounds(151, 0, 349, 273);
		receta_p.setVisible(false);
		add(receta_p);
		
		PanelCalorias calorias_p = new PanelCalorias();
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
				receta_p.setVisible(true);
				calorias_p.setVisible(false);
				
			}
		});
		recetas_b.setBounds(22, 60, 117, 29);
		add(recetas_b);
		
		
		
		JButton consejos_b = new JButton("Consejos");
		consejos_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consejos_p.setVisible(true);
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
				calorias_p.setVisible(true);
			}
		});
		calorias_b.setBounds(22, 142, 117, 29);
		add(calorias_b);
		
		
		
		JButton datos_b = new JButton("Datos");
		datos_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consejos_p.setVisible(false);
				datos_p.setVisible(true);
				receta_p.setVisible(false);
				calorias_p.setVisible(false);
			}
		});
		datos_b.setBounds(22, 183, 117, 29);
		add(datos_b);
		
	
		
	}
}
