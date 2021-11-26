import java.util.List;
import java.util.Random;

/**
 * Receta.
 * 
 * Contiene recetas y consejos acorde a los objetivos del usuario
 * @version Entrega 1
 */

public class Receta {;

    
    /**
     * Genera un consejo aleatorio
     * @param consejos lista de consejos
     * @return consejo
     */
    public static String darConsejo(List<String> consejos){
        Random rand = new Random();
        return consejos.get(rand.nextInt(consejos.size()));
    }
    
    /**
     * Genera una receta aleatoria
     * @param recetas lista de recetas
     * @return receta
     */
    public static String darReceta(List<String> recetas){
        Random rand = new Random();
        return recetas.get(rand.nextInt(recetas.size()));
    }



}