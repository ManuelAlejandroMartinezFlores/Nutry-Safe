import java.time.LocalDate; 

public class Usuario {
    
    private String nombre_usuario;
    private int edad;
    private int altura;
    private int caloria_objetivo;
    private int calorias_consumidas;
    private String ultima_fecha;


    /**
     * Constructor para usuario existente
     * @param nombre_usuario_
     * @param edad_
     * @param altura_
     * @param caloria_objetivo_
     * @param calorias_consumidas_
     * @param ulitma_fecha_
     */
    Usuario(String nombre_usuario_, int edad_, int altura_, int caloria_objetivo_,
            int calorias_consumidas_, String ultima_fecha_){
        setNombre_usuario(nombre_usuario_);
        setEdad(edad_);
        setAltura(altura_);
        setCaloria_objetivo(caloria_objetivo_);
        setCalorias_consumidas(calorias_consumidas_);
        ultima_fecha = ultima_fecha_;
    }

    /**
     * Constructor para usuario nuevo
     * @param nombre_usuario_
     */
    Usuario(String nombre_usuario_){
        setNombre_usuario(nombre_usuario_);
        setEdad(18);
        setAltura(160);
        setCaloria_objetivo(2000);
        setCalorias_consumidas(0);
        ultima_fecha = LocalDate.now().toString();
    }

    /**
     * Añade calorias al contador diario
     * @param caloria
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
     * @return
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
        String txt = "Usuario,";
        txt += nombre_usuario + ",";
        txt += Integer.toString(edad) + ",";
        txt += Integer.toString(altura) + ",";
        txt += Integer.toString(caloria_objetivo) + ",";
        txt += Integer.toString(calorias_consumidas) + ",";
        txt += ultima_fecha;
        return txt;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getCaloria_objetivo() {
        return caloria_objetivo;
    }

    public void setCaloria_objetivo(int caloria_objetivo) {
        this.caloria_objetivo = caloria_objetivo;
    }

    public int getCalorias_consumidas() {
        return calorias_consumidas;
    }

    public void setCalorias_consumidas(int calorias_consumidas) {
        this.calorias_consumidas = calorias_consumidas;
    }

    public String getUltima_fecha() {
        return ultima_fecha;
    }
}
