
/**
 * PanelDatos.
 * Muestra la GUI para el ingreso de datos.
 * 
 * @version Entrega 3
*/
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDatos extends JPanel{
	
	/**
	 * atributos de la clase para los text fields del GUI del panel de datos. 
	 */
	private static final long serialVersionUID = -7501157757070073220L;
	private JTextField altura_tf;
	private JTextField edad_tf;
	private JTextField meta_tf;
	private JTextField peso_tf;
	JLabel error_l;
	
	String id;
	String[] usuario;
	
	/**
	 *  @param id_ 
	 * Es el diseño de como se observa el panel de datos de los usuarios. 
	 */
	public PanelDatos(String id_) {
		super();
		
		id = id_;
		usuario = Controlador.getUsuario(id);
		
		setLayout(null);
		
		JLabel titulo_l = new JLabel("Datos");
		titulo_l.setBounds(36, 16, 61, 16);
		add(titulo_l);
		
		JLabel altura_l = new JLabel("Altura");
		altura_l.setBounds(206, 44, 61, 16);
		add(altura_l);
		
		altura_tf = new JTextField();
		altura_tf.setBounds(204, 72, 130, 26);
		add(altura_tf);
		altura_tf.setColumns(10);
		
		JLabel edad_l = new JLabel("Edad");
		edad_l.setBounds(36, 44, 130, 26);
		add(edad_l);
		
		edad_tf = new JTextField();
		edad_tf.setBounds(36, 72, 130, 26);
		add(edad_tf);
		edad_tf.setColumns(10);
		
		meta_tf = new JTextField();
		meta_tf.setBounds(204, 166, 130, 26);
		add(meta_tf);
		meta_tf.setColumns(10);
		
		JLabel meta_l = new JLabel("Meta");
		meta_l.setBounds(204, 133, 61, 16);
		add(meta_l);
		
		JLabel peso_l = new JLabel("Peso");
		peso_l.setBounds(36, 133, 61, 16);
		add(peso_l);
		
		peso_tf = new JTextField();
		peso_tf.setBounds(36, 166, 130, 26);
		add(peso_tf);
		peso_tf.setColumns(10);
		
		mostrarDatosTF();
		
		error_l = new JLabel("");
		error_l.setBounds(100, 255, 184, 16);
		add(error_l);
		
		JButton aceptar_b = new JButton("Aceptar");
		aceptar_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDatos();
			}
		});
		aceptar_b.setBounds(100, 220, 117, 29);
		add(aceptar_b);
	}
	
	/**
	 *  @return void
	 * Muestra los datos (altura, nombre, edad, meta & peso) al usuario en el GUI. 
	 */
	public void mostrarDatosTF() {
		altura_tf.setText(usuario[2]);
		edad_tf.setText(usuario[1]);
		meta_tf.setText(usuario[4]);
		peso_tf.setText(usuario[3]);
	}
	
	/**
	 *  @return void
	 * Es la actualización de los datos según como lo desee el usuario.
	 */
	public void actualizarDatos(){
		try {
			int edad = Integer.valueOf(edad_tf.getText());
			int altura = Integer.valueOf(altura_tf.getText());
			int meta = Integer.valueOf(meta_tf.getText());
			int peso = Integer.valueOf(peso_tf.getText());
			usuario = Controlador.actualizarDatos(id, edad, altura, peso, meta);
			error_l.setText("Éxito");
			mostrarDatosTF();
		} catch (Exception ex) {
			error_l.setText("Error en ingreso de datos");
			mostrarDatosTF();
		}
	}
}
