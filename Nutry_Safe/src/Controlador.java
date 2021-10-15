import java.util.ArrayList;

public class Controlador {
	
	
	public static void actualizarDatos(int id, String nombre_usuario_, int edad_, int altura_, int peso_,
										int caloria_objetivo_) throws Exception {
		
		if (nombre_usuario_.length() == 0 || edad_ < 0 || altura_ < 0 || peso_ < 0 || caloria_objetivo_ < 0) {
			throw new Exception();
		}
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		usuarios.get(id).setDatos(nombre_usuario_,  edad_,  altura_,  peso_,  caloria_objetivo_);
		Archivos.Escribiendo(usuarios);
	}
	
	public static boolean usuarioExiste(String usuario) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		for (int i=0; i<usuarios.size(); i++) {
			if (usuarios.get(i).getNombre_usuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}
	
	public static int getIdUsuario(String usuario) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		if (!usuarioExiste(usuario)) {
			usuarios.add(new Usuario(usuario));
			Archivos.Escribiendo(usuarios);
			return usuarios.size() - 1;
		} else {
			for (int i=0; i<usuarios.size(); i++) {
				if (usuarios.get(i).getNombre_usuario().equals(usuario)) {
					return i;
				}
			}
		}
		return 0;
	}
	
	public static int calDisponiblesUsuario(int id) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		return usuarios.get(id).getCaloriaDisponible();
	}
	
	public static int calMetaUsuario(int id) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		return usuarios.get(id).getCaloria_objetivo();
	}
	
	public static void contarCalUsuario(int id, int caloria) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		usuarios.get(id).contarCaloria(caloria);
		Archivos.Escribiendo(usuarios);
	}
}