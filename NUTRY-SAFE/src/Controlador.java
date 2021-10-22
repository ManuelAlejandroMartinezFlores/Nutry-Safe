public class Controlador {
	
	
	public static String[] actualizarDatos(String id, String nombre, int edad, int altura, int peso,
										int caloria_objetivo) throws Exception {
		
		if (nombre.length() == 0 || edad < 0 || altura < 0 || peso < 0 || caloria_objetivo < 0) {
			throw new Exception();
		}
		return  MongoDB.actualizarDatos(id, nombre, edad, altura, peso, caloria_objetivo).split(",");
	}
	
	public static String getIdUsuario(String nombre, boolean nuevo) {
		return MongoDB.getIdUsuario(nombre, nuevo);
	}
	
	// public static int calDisponiblesUsuario(String id) {
	// 	Usuario usuario = MongoDB.getUsuario(id);
	// 	return usuario.getCaloriaDisponible();
	// }
	
	// public static int calMetaUsuario(String id) {
	// 	Usuario usuario = MongoDB.getUsuario(id);
	// 	return usuario.getCaloria_objetivo();
	// }
	
	public static Integer[] contarCalUsuario(String id, int caloria) {
		return MongoDB.contarCaloria(id, caloria);
	}

	public static Integer[] getCalorias(String id) {
		return MongoDB.getCalorias(id);
	}
	
	// public static String nombreUsuario(String id) {
	// 	Usuario usuario = MongoDB.getUsuario(id);
	// 	return usuario.getNombre_usuario();
	// }
	
	// public static int edadUsuario(String id) {
	// 	Usuario usuario = MongoDB.getUsuario(id);
	// 	return usuario.getEdad();
	// }
	
	// public static int alturaUsuario(String id) {
	// 	Usuario usuario = MongoDB.getUsuario(id);
	// 	return usuario.getAltura();
	// }
	
	// public static int pesoUsuario(String id) {
	// 	Usuario usuario = MongoDB.getUsuario(id);
	// 	return usuario.getPeso();
	// }

	public static String[] getUsuario(String id) {
		return MongoDB.getUsuario(id).toString().split(",");
	}

	private static Integer[] getEdadCaloria(String id){
		String[] data = getUsuario(id); 
		Integer[] resultado = new Integer[2];
		resultado[0] = Integer.valueOf(data[1]);
		resultado[1] = Integer.valueOf(data[4]);
		return resultado;
	}

	public static String darConsejo(String id) {
		Integer[] data = getEdadCaloria(id);
		return Receta.darConsejo(data[0], data[1]);
	}

	public static String recetaCalorias(String id) {
		int caloria_obj = MongoDB.calMetaUsuario(id);
		return Receta.recetaCalorias(caloria_obj);
	}

	public static String inicioSesion(String nombre, boolean nuevo) throws Exception {
		if (nombre.length() == 0){
			throw new Exception();
		}
		String id = getIdUsuario(nombre, nuevo);
		if (id.length() == 0) {
			throw new Exception();
		}
		return id;
	} 

}