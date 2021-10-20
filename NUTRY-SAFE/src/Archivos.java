/**
 * Archivos.
 * 
 * Escribe y lee archivos .txt que contiene la infomación los usuarios que utilizan el programa.
 * @version Entrega 1
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Archivos {

    
    /** 
     * Escribe un usuario por linea en src/Data/Usuarios.txt
     * @param usuarios los usuarios a guardar
     */
    public static void Escribiendo(ArrayList<Usuario> usuarios){
        
        try{
            // En caso de que el archivo.txt no exista, se crea
            File datosU= new File("src/Usuarios.txt");
            datosU.createNewFile();
            // Se guardan los datos en el archivo correspondiente
            FileWriter myWriter = new FileWriter(datosU,false);
            String txt = "";
            for (int i=0; i<usuarios.size(); i++){
                txt += usuarios.get(i).toString() + "\n";
                System.out.println(txt);
    
            }
            myWriter.write(txt);
            myWriter.close();
            
        } catch (IOException e) {}
    }

    
    /** 
     * Lee los usuarios del archivo src/Data/Usuarios.txt
     * @return ArrayList<Usuario> los usuarios contenidos en el archivo
     */
    public static ArrayList<Usuario> Leyendo(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Path path = Paths.get("Usuarios.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Usuarios.txt"));
            String row;
            while ((row = reader.readLine()) != null){
                String[] data = row.split(",");
                String nombre_u = data[0];
                int edad = Integer.valueOf(data[1]);
                int altura = Integer.valueOf(data[2]);
                int peso = Integer.valueOf(data[3]);
                int caloria_objetivo = Integer.valueOf(data[4]);
                int calorias_consumidas = Integer.valueOf(data[5]);
                String fecha = data[6];
                String id = data[7];
                usuarios.add(new Usuario(nombre_u, edad, altura, peso, caloria_objetivo, calorias_consumidas, fecha, id));
            }
            reader.close();
        } catch (IOException e){
            System.out.println(e);
         }
        
        return usuarios;
    }
    
}
