/**Se crea la clase archivos donde se almacenaran los datos del usuario, 
 * de manera que se utiliza el objeto usuario definido en la clase Usuario para 
 * crear un arreglo con los datos correspondientes. 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos {
    Usuario [] Us;
    Scanner scan= new Scanner(System.in);
    private String nombre;
    private int edadUsuario;
    private int alturaUsuario;
    private int ObjetivoCal;
    private int Consumo;
    private String Fecha;
/**Se crean el set y get de cada atributo */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }public int getEdadUsuario() {
        return edadUsuario;
    }
    public void setAlturaUsuario(int alturaUsuario) {
        this.alturaUsuario = alturaUsuario;
    }
    public int getAlturaUsuario() {
        return alturaUsuario;
    }
    public void setObjetivoCal(int objetivoCal) {
        ObjetivoCal = objetivoCal;
    }
    public int getObjetivoCal() {
        return ObjetivoCal;
    }public void setConsumo(int consumo) {
        Consumo = consumo;
    }
    public int getConsumo() {
        return Consumo;
    }
    public void setFecha(String fecha) {
        Fecha = fecha;
    }
    public String getFecha() {
        return Fecha;
    }

    /**Se define el constructor de la clase, de manera que establece la cantidad de datos en el arreglo y 
     * los valores iniciales de los atributos*/
    Archivos(){
        Us= new Usuario[1];
        for (int k=0; k<Us.length; k++){
            Us[k]= new Usuario("Nombre completo", 0, 0, 0, 0, "");
        }
        this.nombre= "";
        this.edadUsuario=0;
        this.alturaUsuario=0;
        this.ObjetivoCal=0;
        this.Consumo=0;
        this.Fecha="";
    }

    public static void Escribiendo(ArrayList<Usuario> usuarios){
        
        try{
            // En caso de que el archivo.txt no exista, se crea
            File datosU= new File("src/Data/Usuarios.txt");
            datosU.createNewFile();
            // Se guardan los datos en el archivo correspondiente
            FileWriter myWriter = new FileWriter(datosU,false);
            String txt = "";
            for (int i=0; i<usuarios.size(); i++){
                txt += usuarios.get(i).toString() + "\n";
    
            }
            myWriter.write(txt);
            myWriter.close();
            
        } catch (IOException e) {}
        
        

    }


    
}
