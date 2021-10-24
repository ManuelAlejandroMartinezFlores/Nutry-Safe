/**
 * Controlador.
 * Contiene la lógica de las operaciones de la aplicación
 * 
 * @version Entrega 3 
 */

public class Controlador {
	
	/** 
	 * @param id
	 * @param nombre
	 * @param edad
	 * @param altura
	 * @param peso
	 * @param caloria_objetivo
	 * @return String[] información del usuario
	 * @throws Exception
	 */
	public static String[] actualizarDatos(String id, String nombre, int edad, int altura, int peso,
										int caloria_objetivo) throws Exception {
		
		if (nombre.length() == 0 || edad < 0 || altura < 0 || peso < 0 || caloria_objetivo < 0) {
			throw new Exception();
		}
		return  MongoDB.actualizarDatos(id, nombre, edad, altura, peso, caloria_objetivo).split(",");
	}
	
	/** 
	 * Indica el id del usuario en la base de datos
	 * @param nombre
	 * @param nuevo si es nuevo usuario o no
	 * @return String
	 */
	public static String getIdUsuario(String nombre, boolean nuevo) {
		return MongoDB.getIdUsuario(nombre, nuevo);
	}

	/** 
	 * Añade caloría al control del usuario.
	 * @param id
	 * @param caloria
	 * @return Integer[] información de calorias 
	 */
	public static Integer[] contarCalUsuario(String id, int caloria) {
		return MongoDB.contarCaloria(id, caloria);
	}
	
	/** 
	 * Indica la información de calorias
	 * @param id
	 * @return Integer[] información de calorias
	 */
	public static Integer[] getCalorias(String id) {
		return MongoDB.getCalorias(id);
	}
	
	/**
	 * Indica la información del usuario 
	 * @param id
	 * @return String[]
	 */
	public static String[] getUsuario(String id) {
		return MongoDB.getUsuario(id).toString().split(",");
	}
	
	/** 
	 * Indica la edad y calorias objetivo del usuario
	 * @param id
	 * @return Integer[] edad y calorias
	 */
	private static Integer[] getEdadCaloria(String id){
		String[] data = getUsuario(id); 
		Integer[] resultado = new Integer[2];
		resultado[0] = Integer.valueOf(data[1]);
		resultado[1] = Integer.valueOf(data[4]);
		return resultado;
	}
	
	/** 
	 * Genera un consejo para el usuario
	 * @param id
	 * @return String consejo del usuario
	 */
	public static String darConsejo(String id) {
		Integer[] data = getEdadCaloria(id);
		return Receta.darConsejo(data[0], data[1]);
	}
	
	/** 
	 * Genera una receta para el usuario
	 * @param id
	 * @return String Receta
	 */
	public static String recetaCalorias(String id) {
		int caloria_obj = MongoDB.calMetaUsuario(id);
		return Receta.recetaCalorias(caloria_obj);
	}
	
	/** 
	 * Inicia seción
	 * @param nombre
	 * @param nuevo si es usuario nuevo
	 * @return String id de usuario
	 * @throws Exception si desea crear un usuario que ya existe o acceder a uno que no existe
	 */
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
