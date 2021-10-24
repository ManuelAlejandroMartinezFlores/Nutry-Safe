public class Controlador {
	
	/** 
	 * @param id
	 * @param nombre
	 * @param edad
	 * @param altura
	 * @param peso
	 * @param caloria_objetivo
	 * @return String[]
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
	 * @param nombre
	 * @param nuevo
	 * @return String
	 */
	public static String getIdUsuario(String nombre, boolean nuevo) {
		return MongoDB.getIdUsuario(nombre, nuevo);
	}

	/** 
	 * @param id
	 * @param caloria
	 * @return Integer[]
	 */
	public static Integer[] contarCalUsuario(String id, int caloria) {
		return MongoDB.contarCaloria(id, caloria);
	}
	
	/** 
	 * @param id
	 * @return Integer[]
	 */
	public static Integer[] getCalorias(String id) {
		return MongoDB.getCalorias(id);
	}
	
	/** 
	 * @param id
	 * @return String[]
	 */
	public static String[] getUsuario(String id) {
		return MongoDB.getUsuario(id).toString().split(",");
	}
	
	/** 
	 * @param id
	 * @return Integer[]
	 */
	private static Integer[] getEdadCaloria(String id){
		String[] data = getUsuario(id); 
		Integer[] resultado = new Integer[2];
		resultado[0] = Integer.valueOf(data[1]);
		resultado[1] = Integer.valueOf(data[4]);
		return resultado;
	}
	
	/** 
	 * @param id
	 * @return String
	 */
	public static String darConsejo(String id) {
		Integer[] data = getEdadCaloria(id);
		return Receta.darConsejo(data[0], data[1]);
	}
	
	/** 
	 * @param id
	 * @return String
	 */
	public static String recetaCalorias(String id) {
		int caloria_obj = MongoDB.calMetaUsuario(id);
		return Receta.recetaCalorias(caloria_obj);
	}
	
	/** 
	 * @param nombre
	 * @param nuevo
	 * @return String
	 * @throws Exception
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
