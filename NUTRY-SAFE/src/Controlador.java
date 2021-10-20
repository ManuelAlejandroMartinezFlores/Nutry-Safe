import java.util.ArrayList;

import com.mongodb.client.MongoDatabase;

public class Controlador {
	
	
	public static void actualizarDatos(String id, String nombre, int edad_, int altura_, int peso_,
										int caloria_objetivo_) throws Exception {
		
		if (nombre.length() == 0 || edad_ < 0 || altura_ < 0 || peso_ < 0 || caloria_objetivo_ < 0) {
			throw new Exception();
		}
		Usuario usuario = MongoDB.getUsuario(id);
		usuario.setDatos(nombre,  edad_,  altura_,  peso_,  caloria_objetivo_);
		MongoDB.escribirUsuario(usuario);
	}
	
	public static boolean usuarioExiste(String usuario) {
		return MongoDB.usuarioExiste(usuario);
	}
	
	public static String getIdUsuarioEx(String nombre) {
		return MongoDB.getIdUsuario(nombre);
	}

	public static String getIdUsuarioNu(String nombre) {
		String id = MongoDB.nuevoId();
		Usuario usuario = new Usuario(nombre, id);
		MongoDB.escribirUsuario(usuario);
		return id;
	}
	
	public static int calDisponiblesUsuario(String id) {
		Usuario usuario = MongoDB.getUsuario(id);
		return usuario.getCaloriaDisponible();
	}
	
	public static int calMetaUsuario(String id) {
		Usuario usuario = MongoDB.getUsuario(id);
		return usuario.getCaloria_objetivo();
	}
	
	public static void contarCalUsuario(String id, int caloria) {
		Usuario usuario = MongoDB.getUsuario(id);
		usuario.contarCaloria(caloria);
		MongoDB.escribirUsuario(usuario);
	}
	
	public static String nombreUsuario(String id) {
		Usuario usuario = MongoDB.getUsuario(id);
		return usuario.getNombre_usuario();
	}
	
	public static int edadUsuario(String id) {
		Usuario usuario = MongoDB.getUsuario(id);
		return usuario.getEdad();
	}
	
	public static int alturaUsuario(String id) {
		Usuario usuario = MongoDB.getUsuario(id);
		return usuario.getAltura();
	}
	
	public static int pesoUsuario(String id) {
		Usuario usuario = MongoDB.getUsuario(id);
		return usuario.getPeso();
	}
}