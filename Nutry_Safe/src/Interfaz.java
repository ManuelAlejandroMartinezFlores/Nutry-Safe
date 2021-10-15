import javax.swing.*;
import java.awt.Dimension;
import Paneles.*;

public class Interfaz extends JFrame {
	
	public Interfaz() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,300));
		PanelDatos p = new PanelDatos();
		p.setOpaque(true);
		
		setContentPane(p);

        //Display the window.
        pack();
        setVisible(true);
		
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