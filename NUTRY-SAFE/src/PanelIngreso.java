/**
 * Se importan las librerías a utilizar 
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIngreso extends JPanel {
	
	/**
	 * atributos de la clase.
	 */
	private static final long serialVersionUID = -2305229489239812396L;
	String id;
	PanelGeneral panel = null;
	JButton salir_b;
	JTextField textField;
	JLabel error_l;
	JLabel titulo_l;
	JLabel inst_l;
	JLabel ingreso_l;
	JButton nuevo_b;
	JButton existente_b;
	
	/**
	 *  diseño de como se observa el panel de ingreso (inicio de la app).
	 */
	public PanelIngreso() {
		super();
		id = "616f52297811334c6758a1c2";
		setLayout(null);

		titulo_l = new JLabel("Nutry-Safe");
		titulo_l.setBounds(128, 20, 110, 16);
		add(titulo_l);
		
		inst_l = new JLabel("Inicio de Sesión");
		inst_l.setBounds(115, 67, 110, 16);
		add(inst_l);
		
		textField = new JTextField();
		textField.setBounds(173, 107, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		ingreso_l = new JLabel("Usuario");
		ingreso_l.setBounds(79, 112, 53, 16);
		add(ingreso_l);
		
		nuevo_b = new JButton("Usuario Nuevo");
		nuevo_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioNuevo();
			}
		});
		nuevo_b.setBounds(44, 164, 117, 29);
		add(nuevo_b);
		
		existente_b = new JButton("Usuario Existente");
		existente_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioExistente();
			}
		});
		existente_b.setBounds(173, 164, 146, 29);
		add(existente_b);
		
		error_l = new JLabel("", SwingConstants.CENTER);
		error_l.setBounds(98, 214, 172, 16);
		add(error_l);

		//No tocar
		// panel = new PanelGeneral(id);
		// panel.setBounds(0, 0, 500, 300);
		// panel.setVisible(false);
		// add(panel);
		
		salir_b = new JButton("Salir");
		salir_b.setBounds(10, 304, 117, 29);
		salir_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		salir_b.setVisible(false);
		add(salir_b);
	}
	
	/**
	 *  @return void
	 * Método para usuario nuevo
	 */
	public void usuarioNuevo() {
		try {
			id = Controlador.inicioSesion(textField.getText(), true);
			mostrarGeneral();
			textField.setText("");
			error_l.setText("");
		} catch (Exception ex) {
			error_l.setText("Usuario ya existe");
			id = "616f52297811334c6758a1c2";
		}
	}
	
	/**
	 *  @return void
	 * Método para usuario existente
	 */
	public void usuarioExistente() {
		try {
			id = Controlador.inicioSesion(textField.getText(), false);
			mostrarGeneral();
			textField.setText("");
			error_l.setText("");
		} catch (Exception ex) {
			error_l.setText("Usuario no existe");
			id = "616f52297811334c6758a1c2";
			ex.printStackTrace(System.out);
		}
	}
	
	/**
	 *  @return void
	 * muestra  el panel general.
	 */
	public void mostrarGeneral() {
		if (panel != null){
			remove(panel);
		}
		panel = new PanelGeneral(id);
		panel.setBounds(0, 0, 500, 300);
		panel.setVisible(true);
		add(panel);
		panel.revalidate();
		panel.repaint();
		salir_b.setVisible(true);

		textField.setVisible(false);
		error_l.setVisible(false);
		titulo_l.setVisible(false);
		inst_l.setVisible(false);
		ingreso_l.setVisible(false);
		nuevo_b.setVisible(false);
		existente_b.setVisible(false);

	}
	
	/**
	 *  @return void
	 * método para salir del app 
	 */
	public void salir(){
		panel.setVisible(false);
		salir_b.setVisible(false);

		textField.setVisible(true);
		error_l.setVisible(true);
		titulo_l.setVisible(true);
		inst_l.setVisible(true);
		ingreso_l.setVisible(true);
		nuevo_b.setVisible(true);
		existente_b.setVisible(true);
	}
}
