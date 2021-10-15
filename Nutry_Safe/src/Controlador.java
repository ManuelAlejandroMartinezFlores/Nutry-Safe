import java.util.ArrayList;

public class Controlador {
	
	public Controlador() {
		
		
	}
	
	public static void actualizarDatos(int id, String nombre_usuario_, int edad_, int altura_, int peso_, int caloria_objetivo_) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		usuarios.get(id).setDatos( nombre_usuario_,  edad_,  altura_,  peso_,  caloria_objetivo_);
		Archivos.Escribiendo(usuarios);
	}
	
}