public class Receta {
    
    Usuario usuario = new Usuario();

    public void darReceta(Usuario U){
        if(U.getEdad >=19 && U.getEdad <= 25) {
            System.out.println("La caloria necesaria para un joven es aproximadamente 2900 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".");
        }


        else if(U.getEdad >=26 && U.getEdad <= 45) {
            System.out.println("La caloria necesaria para un adulto es aproximadamente 2600 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".");
        }
        
        else if(U.getEdad >=46 && U.getEdad <= 65) {
            System.out.println("La caloria necesaria para un adulto mayor es aproximadamente 2400 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".");
        }
        
        else if(U.getEdad >=66) {
            System.out.println("La caloria necesaria para un gente de tercer edad es aproximadamente 2200 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".");
        }
    
        else if(U.getEdad >=10 && U.getEdad <= 18) {
            System.out.println("La caloria necesaria para un niño es aproximadamente 2000 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".");
        }
    
    }
    

    
    




}
