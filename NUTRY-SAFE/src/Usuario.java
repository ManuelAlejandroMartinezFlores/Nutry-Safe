/**
 * Usuarios.
 * 
 * Representa un usuario individual del programa que contiene la información personal de una persona.
 * @version Entrega 1
 */

import java.time.LocalDate; 

public class Usuario {
    
    private String nombre_usuario;
    private int edad;
    private int altura;
    private int peso;
    private int caloria_objetivo;
    private int calorias_consumidas;
    private String ultima_fecha;
    String id;


    /**
     * Constructor para usuario existente desde Archivos
     * @param nombre_usuario_ nombre usuario
     * @param edad_ en años
     * @param altura_ en cm
     * @param caloria_objetivo_ para el día
     * @param calorias_consumidas_ durante el día
     * @param ulitma_fecha_ en la que se inicio sesión
     */
    Usuario(String nombre_usuario_, int edad_, int altura_, int peso_, int caloria_objetivo_,
            int calorias_consumidas_, String ultima_fecha_, String id_){
        setNombre_usuario(nombre_usuario_);
        setEdad(edad_);
        setAltura(altura_);
        peso = peso_;
        setCaloria_objetivo(caloria_objetivo_);
        setCalorias_consumidas(calorias_consumidas_);
        ultima_fecha = ultima_fecha_;
        id = id_;
    }

    /**
     * Constructor para usuario nuevo
     * @param nombre_usuario_ nombre usuario
     */
    Usuario(String nombre_usuario_, String id_){
        setNombre_usuario(nombre_usuario_);
        setEdad(18);
        setAltura(160);
        setCaloria_objetivo(2000);
        setCalorias_consumidas(0);
        ultima_fecha = LocalDate.now().toString();
        id = id_;
        peso = 170;
    }

    /**
     * Añade calorias al contador diario
     * @param caloria cantidad de calorias consumidas
     */
    public void contarCaloria(int caloria){
        // Si es día diferente se reinicia el contador
        if (!ultima_fecha.equals(LocalDate.now().toString())){
            calorias_consumidas = 0;
            ultima_fecha = LocalDate.now().toString();
        }
        calorias_consumidas += caloria;
        
    }

    /**
     * Indica las calorias disponibles en el día
     * @return calorias disponibles en el día
     */
    public int getCaloriaDisponible(){
        // Si es día diferente se reinicia el contador
        if (!ultima_fecha.equals(LocalDate.now().toString())){
            calorias_consumidas = 0;
            ultima_fecha = LocalDate.now().toString();
        }
        if (calorias_consumidas > caloria_objetivo){
            return 0;
        } else {
            return caloria_objetivo - calorias_consumidas;
        }
    }

    /**
     * Genera un texto para facilitar el guardado en .txt
     */
    @Override
    public String toString(){
        String txt = "";
        txt += nombre_usuario + ",";
        txt += Integer.toString(edad) + ",";
        txt += Integer.toString(altura) + ",";
        txt += Integer.toString(peso) + ",";
        txt += Integer.toString(caloria_objetivo) + ",";
        txt += Integer.toString(calorias_consumidas) + ",";
        txt += ultima_fecha +",";
        txt += id;
        return txt;
    }

    
    /** 
     * Cambia los datos que se reciben en la sección Datos
     * @param edad_ en años
     * @param altura_ en cm
     * @param caloria_objetivo_ del día
     */
    public void setDatos(String nombre_usuario_, int edad_, int altura_, int peso_, int caloria_objetivo_){
    	setNombre_usuario(nombre_usuario_);
        setEdad(edad_);
        peso = peso_;
        setAltura(altura_);
        setCaloria_objetivo(caloria_objetivo_);
    }

    
    /** 
     * Indica el nombre de usuario
     * @return String nombre de usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    
    /** 
     * Cambia el nombre de usuario
     * @param nombre_usuario nombre de usuario
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    
    /** 
     * Indica la edad 
     * @return int edad en años
     */
    public int getEdad() {
        return edad;
    }

    
    /** 
     * Cambia la edad
     * @param edad en años
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    /** 
     * Indica la altura
     * @return int altura en cm
     */
    public int getAltura() {
        return altura;
    }

    
    /** 
     * Cambia la altura
     * @param altura en cm
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    
    /** 
     * Indica caloria objetivo
     * @return int caloria objetivo diaria
     */
    public int getCaloria_objetivo() {
        return caloria_objetivo;
    }

    
    /** 
     * Cambia la caloria objetivo
     * @param caloria_objetivo diaria
     */
    public void setCaloria_objetivo(int caloria_objetivo) {
        this.caloria_objetivo = caloria_objetivo;
    }

    
    /** 
     * Indica la cantidad de calorias consumidas
     * @return int calorias consumidas
     */
    public int getCalorias_consumidas() {
        return calorias_consumidas;
    }

    
    /** 
     * Cambia las calorias consumidas
     * @param calorias_consumidas en el día
     */
    public void setCalorias_consumidas(int calorias_consumidas) {
        this.calorias_consumidas = calorias_consumidas;
    }

    
    /** 
     * Indica la ultima fecha en la que se inició sesión
     * @return String
     */
    public String getUltima_fecha() {
        return ultima_fecha;
    }

	public int getPeso() {
		return peso;
	}

    public String getId() {
        return id;
    }
}
