/**
 * PanelGeneral.
 * Contiene paneles y un menú para navegarlos.
 * 
 * @version Entrega 3
 */
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGeneral extends JPanel {
	
	/**
	 * atributos de la clase
	 */
	private static final long serialVersionUID = 5751748113985052922L;

	
	
	private PanelDatos datos_p = null;
	private PanelReceta receta_p = null;
	private PanelConsejos consejos_p = null;
	private PanelCalorias calorias_p = null;
	BarChart chart = null;
	String id;
	
	/**
	 * @param id_
	 * diseño del panel general
	 */
	public PanelGeneral(String id_){
		super();
		setLayout(null);
		id = id_;
		
		datos_p = new PanelDatos(id);
		datos_p.setBounds(151, 0, 349, 273);
		datos_p.setVisible(true);
		add(datos_p);
		
		JLabel opciones_l = new JLabel("Opciones");
		opciones_l.setBounds(22, 21, 61, 16);
		add(opciones_l);
		
		JButton recetas_b = new JButton("Recetas");
		recetas_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarReceta();
			}
		});
		recetas_b.setBounds(22, 60, 117, 29);
		add(recetas_b);
		
		
		
		JButton consejos_b = new JButton("Consejos");
		consejos_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConsejos();
			}
		});
		consejos_b.setBounds(22, 101, 117, 29);
		add(consejos_b);
		
		JButton calorias_b = new JButton("Calorias");
		calorias_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCalorias();
			}
		});
		calorias_b.setBounds(22, 142, 117, 29);
		add(calorias_b);
		
		
		
		JButton datos_b = new JButton("Datos");
		datos_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
			}
		});
		datos_b.setBounds(22, 183, 117, 29);
		add(datos_b);

		JButton hist_b = new JButton("Historial");
		hist_b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					
					 
					mostrarChart();
				
			} catch (Exception ex){System.out.println(ex.getStackTrace());}
			}
		});
		hist_b.setBounds(22, 232, 117, 29);
		add(hist_b);
		
	
		
	}
	
	/**
	 * @return void
	 * diseño del apartado de datos en el panel general.
	 */
	private void mostrarDatos() {
		if (datos_p != null) {remove(datos_p);}
		if (receta_p != null) {receta_p.setVisible(false);}
		if (consejos_p != null) {consejos_p.setVisible(false);}
		if (calorias_p != null) {calorias_p.setVisible(false);}
		if (chart != null) {chart.setVisible(false);}
		
		datos_p = new PanelDatos(id);
		datos_p.setBounds(151, 0, 349, 273);
		datos_p.setVisible(true);
		add(datos_p);
		datos_p.revalidate();
		datos_p.repaint();

	}
	
	/**
	 * @return void
	 * diseño del apartado de recetas en el panel general.
	 */
	private void mostrarReceta() {
		if (receta_p != null) {
			remove(receta_p);
		}
		if (datos_p != null) {datos_p.setVisible(false);}
		if (consejos_p != null) {consejos_p.setVisible(false);}
		if (calorias_p != null) {calorias_p.setVisible(false);}
		if (chart != null) {chart.setVisible(false);}

		receta_p = new PanelReceta(id);
		receta_p.setBounds(151, 0, 349, 273);
		receta_p.setVisible(true);
		add(receta_p);
		receta_p.revalidate();
		receta_p.repaint();
	}
	
	/**
	 * @return void
	 * diseño del apartado de consejos en el panel general.
	 */
	private void mostrarConsejos() {
		if (consejos_p != null) {
			remove(consejos_p);
		}
		if (receta_p != null) {receta_p.setVisible(false);}
		if (datos_p != null) {datos_p.setVisible(false);}
		if (calorias_p != null) {calorias_p.setVisible(false);}
		if (chart != null) {chart.setVisible(false);}

		consejos_p = new PanelConsejos(id);
		consejos_p.setBounds(151, 0, 349, 273);
		consejos_p.setVisible(true);
		add(consejos_p);
		consejos_p.revalidate();
		consejos_p.repaint();
	}
	
	/**
	 * @return void
	 * diseño del apartado de calorías en el panel general.
	 */
	private void mostrarCalorias() {
		if (calorias_p != null) {
			remove(calorias_p);
		}
		if (receta_p != null) {receta_p.setVisible(false);}
		if (consejos_p != null) {consejos_p.setVisible(false);}
		if (datos_p != null) {datos_p.setVisible(false);}
		if (chart != null) {chart.setVisible(false);}

		calorias_p = new PanelCalorias(id);
		calorias_p.setBounds(151, 0, 349, 273);
		calorias_p.setVisible(true);
		add(calorias_p);
		calorias_p.revalidate();
		calorias_p.repaint();
	}

	/**
	 * Muestra el barchart con el historial
	 */
	private void mostrarChart(){

		chart = new BarChart(id);  
		chart.setSize(800, 400);  
		chart.setLocationRelativeTo(null);  
		chart.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
		chart.setVisible(true); 
		chart.revalidate();
		chart.repaint();
	}
}
