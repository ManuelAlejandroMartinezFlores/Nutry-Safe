import java.util.ArrayList;

public class Controlador {
	
	public Controlador() {
		
		
	}
	
	public static void actualizarDatos(int id, String nombre_usuario_, int edad_, int altura_, int peso_, int caloria_objetivo_) {
		ArrayList<Usuario> usuarios = Archivos.Leyendo();
		usuarios.get(id).setDatos( nombre_usuario_,  edad_,  altura_,  peso_,  caloria_objetivo_);
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
}