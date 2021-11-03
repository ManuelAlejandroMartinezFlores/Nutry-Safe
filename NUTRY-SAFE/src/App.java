/**
 * Driver.
 *
 * Interactua con el usuario mostrando y recibiendo mensajes.
 * Funciona como menú del programa.
 *
 * @version Entrega 2
 */

import java.awt.Dimension;
import javax.swing.JFrame;


public class App {

    /**
     * Contiene el menú del programa.
     * Muestra y recibe mensajes.
     * @param args
     */
    public static void main(String[] args) {

    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
            		createAndShowGUI();
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            }
        });

    }

    public static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500,375));
		PanelIngreso p = new PanelIngreso();
		p.setOpaque(false);

		frame.setContentPane(p);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
}
