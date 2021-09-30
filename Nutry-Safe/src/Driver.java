import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Archivos a= new Archivos();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Usuario1", 18,160,2000,100,"2021-09-30"));
        usuarios.add(new Usuario("Usuario2", 20,175,2200,500,"2021-09-30"));
        Archivos.Escribiendo(usuarios);
    }

    

    
}
