import java.time.LocalDate; 

public class Usuario {
    
    private String nombre_usuario;
    private String nombre;
    private int edad;
    private int altura;
    private int caloria_objetivo;
    private int calorias_consumidas;
    private String ultima_fecha;


    /**
     * Constructor para usuario existente
     * @param nombre_usuario_
     * @param nombre_
     * @param edad_
     * @param altura_
     * @param caloria_objetivo_
     * @param calorias_consumidas_
     */
    Usuario(String nombre_usuario_, String nombre_, int edad_, int altura_, int caloria_objetivo_, int calorias_consumidas_){
        setNombre_usuario(nombre_usuario_);
        setNombre(nombre_);
        setEdad(edad_);
        setAltura(altura_);
        setCaloria_objetivo(caloria_objetivo_);
        setCalorias_consumidas(calorias_consumidas_);
        ultima_fecha = LocalDate.now().toString();
    }

    /**
     * Constructor para usuario nuevo
     * @param nombre_usuario_
     */
    Usuario(String nombre_usuario_){
        setNombre_usuario(nombre_usuario_);
        setNombre(nombre_usuario_);
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

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
