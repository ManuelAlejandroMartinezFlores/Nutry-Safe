/**
 * Driver.
 * 
 * Interactua con el usuario mostrando y recibiendo mensajes.
 * Funciona como menú del programa.
 * 
 * @version Entrega 1
 */

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;


public class Driver {
    
    /** 
     * Contiene el menú del programa.
     * Muestra y recibe mensajes.
     * @param args
     */
    public static void main(String[] args) {
//
//        ArrayList<Usuario> usuarios = Archivos.Leyendo();
//        Scanner scan = new Scanner(System.in);
//        int id_usuario = -1;
//        int opcion = 0;
//        int calorias = 0;
//        String n_usuario = "";
//
//        int edad = 0;
//        int altura = 0;
//        int caloria_objetivo = 0;
//
//        while (opcion != 6){
//            System.out.println("\nBienvenido. Seleccione la opción que desee");
//            System.out.println("1 - Ingreso de usuario");
//            System.out.println("2 - Calorias");
//            System.out.println("3 - Datos");
//            System.out.println("4 - Consejos");
//            System.out.println("5 - Recetas");
//            System.out.println("6 - Salir\n");
//
//            try {
//                opcion = scan.nextInt();
//            } catch (InputMismatchException e){
//                opcion = 0;
//                scan.nextLine();
//            }
//
//            switch (opcion){
//                case 1:
//                    Archivos.Escribiendo(usuarios);
//                    usuarios = Archivos.Leyendo();
//                    System.out.println("\nSeleccione la opción que desee");
//                    System.out.println("1 - Nuevo");
//                    System.out.println("2 - Existente");
//                    int respuesta = -1;
//                    while (respuesta < 1 || respuesta > 2){
//                        try {
//                            respuesta = scan.nextInt();
//                        } catch (InputMismatchException e){
//                            respuesta = -1;
//                            scan.nextLine();
//                        }
//                    }
//
//                    id_usuario = -1;
//                    if (respuesta == 2) {
//                        System.out.println("\nSeleccione la opción que desee");
//                        for (int i=0; i<usuarios.size(); i++){
//                            System.out.println(Integer.toString(i) + " - " + usuarios.get(i).getNombre_usuario());
//                        }
//                        while (id_usuario < 0 || id_usuario > usuarios.size()-1){
//                            try {
//                                id_usuario = scan.nextInt();
//                            } catch (InputMismatchException e){
//                                id_usuario = -1;
//                                scan.nextLine();
//                            }
//                        }
//                    } else {
//                        n_usuario = "";
//                        System.out.println("\nIngrese nombre de usuario nuevo");
//                        while( n_usuario.length() == 0){
//                            n_usuario = scan.nextLine();
//                        }
//                        usuarios.add(new Usuario(n_usuario));
//                        id_usuario = usuarios.size() - 1;
//                    }
//                    break;
//
//                case 2:
//                    calorias = 0;
//                    System.out.println("Ingrese sus calorias consumidas");
//                    while (calorias < 1){
//                        try {
//                            calorias = scan.nextInt();
//                        } catch (InputMismatchException e) {
//                            scan.nextLine();
//                            calorias = 0;
//                        }
//                        if (id_usuario == -1){
//                            System.out.println("No ha ingresado un usuario");
//                        } else {
//                            usuarios.get(id_usuario).contarCaloria(calorias);
//                            System.out.print("Calorías disponibles en el día");
//                            System.out.println(usuarios.get(id_usuario).getCaloriaDisponible());
//                        }
//                    }
//                    break;
//                
//                case 3:
//                    System.out.println("Ingrese edad");
//                    edad = 0;
//                    while (edad < 1){
//                        try {
//                            edad = scan.nextInt();
//                        } catch (InputMismatchException e) {
//                            edad = 0;
//                            scan.nextLine();
//                        }
//                    }
//
//                    System.out.println("Ingrese altura (cm)");
//                    altura = 0;
//                    while (altura < 1){
//                        try {
//                            altura = scan.nextInt();
//                        } catch (InputMismatchException e) {
//                            altura = 0;
//                            scan.nextLine();
//                        }
//                    }
//
//                    System.out.println("Ingrese calorias objetivo");
//                    caloria_objetivo = 0;
//                    while (caloria_objetivo < 1500){
//                        try {
//                            caloria_objetivo = scan.nextInt();
//                        } catch (InputMismatchException e) {
//                            caloria_objetivo = 0;
//                            scan.nextLine();
//                        }
//                    }
//                    if (id_usuario == -1){
//                        System.out.println("No ha ingresado un usuario");
//                    } else {
//                        usuarios.get(id_usuario).setDatos(edad, altura, caloria_objetivo);
//                        System.out.print("Se han actualizado datos: ");
//                        System.out.println(usuarios.get(id_usuario).toString());
//                    }
//                    break;
//
//                case 4:
//                    if (id_usuario == -1){
//                        System.out.println("No ha ingresado un usuario");
//                    } else {
//                        System.out.println(Receta.darConsejo(usuarios.get(id_usuario)));
//                    }
//                    break;
//
//                case 5:
//                    if (id_usuario == -1){
//                        System.out.println("No ha ingresado un usuario");
//                    } else {
//                        System.out.println(Receta.recetaCalorias(usuarios.get(id_usuario)));
//                    }
//                    
//                    break;
//
//                case 6:
//                    System.out.println("Guardando...");
//                    Archivos.Escribiendo(usuarios);
//                    break;
//            }
//        }
//        scan.close();
//    	
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
		frame.setPreferredSize(new Dimension(500,300));
		PanelGeneral p = new PanelGeneral(0);
		p.setOpaque(true);
		
		frame.setContentPane(p);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
//		frame.setDefaultCloseOperation(JEXIT_ON_CLOSE);
//		frame.setPreferredSize(new Dimension(500,300));
//		PanelDatos p = new PanelDatos();
//		p.setOpaque(true);
//		
//		setContentPane(p);
//
//        //Display the window.
//        pack();
//        setVisible(true);
	}
}
