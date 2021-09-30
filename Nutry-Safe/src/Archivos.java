/**Se crea la clase archivos donde se almacenaran los datos del usuario, 
 * de manera que se utiliza el objeto usuario definido en la clase Usuario para 
 * crear un arreglo con los datos correspondientes. 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void DatosUsuario(){
        System.out.print("Por favor ingrese los datos solicitados a continuación\n");
        System.out.print("Su nombre completo\n");
        this.nombre=scan.nextLine();
        System.out.print("Su edad\n");
        this.edadUsuario=scan.nextInt();
        scan.nextLine();
        System.out.print("Su altura en metros\n");
        this.alturaUsuario=scan.nextInt();
        scan.nextLine();
        System.out.print("Su meta de calorías diaria\n");
        this.ObjetivoCal=scan.nextInt();
        scan.nextLine();

        /**Se agregan los datos solicitados a un arreglo que se encargará de almacenar los datos en el archivo .txt */
        Us[0].setNombre_usuario(this.nombre);
        Us[0].setEdad(this.edadUsuario);
        Us[0].setAltura(this.alturaUsuario);
        Us[0].setCaloria_objetivo(ObjetivoCal);
        Us[0].setCalorias_consumidas(Consumo);

    }
    public void Escribiendo(){
        
        try{
            // En caso de que el archivo.txt no exista, se crea
            File datosU= new File("datosU.txt");
            if (datosU.createNewFile()) {
                System.out.println("Archivo creado: " + datosU.getName());
            } else {
                System.out.println("Archivo ya existe.");
            }
            // Se guardan los datos en el archivo correspondiente
            FileWriter myWriter = new FileWriter(datosU,true);
            for (int i=0; i<Us.length; i++){
                myWriter.append("Nombre: " + Us[0].getNombre_usuario());
                myWriter.append("Edad: " + Us[0].getEdad());
                myWriter.append("Altura: " + Us[0].getAltura() + " metros.");
                myWriter.append("Objetivo de calorías diario: " + Us[0].getCaloria_objetivo());
            }
            myWriter.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); }
        
        

    }


    
}
