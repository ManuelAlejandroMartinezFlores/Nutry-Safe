import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = Archivos.Leyendo();
        Scanner scan = new Scanner(System.in);
        int id_usuario = -1;
        int opcion = 0;

        while (opcion != 6){
            System.out.println("Bienvenido");
            System.out.println("1 - Ingreso de usuario");
            System.out.println("2 - Calorias");
            System.out.println("3 - Datos");
            System.out.println("4 - Consejos");
            System.out.println("5 - Recetas");
            System.out.println("6 - Salir");

            try {
                opcion = scan.nextInt();
            } catch (InputMismatchException e){
                opcion = 0;
                scan.nextLine();
            }

            switch (opcion){
                case 1:
                    System.out.println("1 - Nuevo");
                    System.out.println("2 - Existente");
                    int respuesta = -1;
                    while (respuesta < 1 || respuesta > 2){
                        try {
                            respuesta = scan.nextInt();
                        } catch (InputMismatchException e){
                            respuesta = -1;
                            scan.nextLine();
                        }
                    }

                    if (respuesta == 2) {
                        for (int i=0; i<usuarios.size(); i++){
                            System.out.println(Integer.toString(i) + " - " + usuarios.get(i).getNombre_usuario());
                        }
                        while (id_usuario < 0 || id_usuario > usuarios.size()-1){
                            try {
                                id_usuario = scan.nextInt();
                            } catch (InputMismatchException e){
                                id_usuario = -1;
                                scan.nextLine();
                            }
                        }
                    } else{
                        String n_usuario = "";
                        while( n_usuario.length() == 0){
                            n_usuario = scan.nextLine();
                        }
                        usuarios.add(new Usuario(n_usuario));
                    }
                    break;

                case 2:
                    int calorias = 0;
                    while (calorias <1){
                        try {
                            calorias = scan.nextInt();
                        } catch (InputMismatchException e) {
                            scan.nextLine();
                            calorias = 0;
                        }
                        if (id_usuario == -1){
                            System.out.println("No ha ingresado un usuario");
                        } else {
                            usuarios.get(id_usuario).contarCaloria(calorias);
                        }
                    }
                    break;

            }
        }




        System.out.println("Hello, World!");
        Archivos a= new Archivos();
        usuarios.add(new Usuario("Usuario1", 18,160,2000,100,"2021-09-30"));
        usuarios.add(new Usuario("Usuario2", 20,175,2200,500,"2021-09-30"));
        Archivos.Escribiendo(usuarios);
        usuarios = Archivos.Leyendo();
        System.out.println(usuarios.get(1).toString());
        usuarios.get(1).contarCaloria(100);
        Archivos.Escribiendo(usuarios);
        usuarios = Archivos.Leyendo();
        System.out.println(usuarios.get(1).toString());
        System.out.println(Receta.darConsejo(usuarios.get(1)));
    }   
}
