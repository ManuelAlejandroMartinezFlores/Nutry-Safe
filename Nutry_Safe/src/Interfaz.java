import javax.swing.*;
import java.awt.Dimension;
import Paneles.*;

import java.util.ArrayList;

public class Interfaz {
	
	public Interfaz() {
		super();
		
		
	}
	
	public static void actualizarDatos(int id, String nombre_usuario_, int edad_, int altura_, int peso_, int caloria_objetivo_) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		usuarios.get(id).setDatos( nombre_usuario_,  edad_,  altura_,  peso_,  caloria_objetivo_);
		Archivos.Escribiendo(usuarios);
		
	}
	
//	public void addPaneles(JPanel panel){
//		
//	}
//	
//	public static void main(String[] args) {
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//            	try {
//            		createAndShowGUI();
//            	} catch (Exception e) {
//            		e.printStackTrace();
//            	}
//            }
//        });
//	}
//	
//	public static void createAndShowGUI() {
//		JFrame frame = new JFrame();
//		setDefaultCloseOperation(JEXIT_ON_CLOSE);
//		setPreferredSize(new Dimension(500,300));
//		PanelDatos p = new PanelDatos();
//		p.setOpaque(true);
//		
//		setContentPane(p);
//
//        //Display the window.
//        pack();
//        setVisible(true);
//	}
}