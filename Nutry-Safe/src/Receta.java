public class Receta {;

    public static String recetaCalorias(Usuario u){
        if (u.getCaloria_objetivo() <= 2400) {
            return "Desayuno: \n\t-1 taza de café cpn leche desnatda. \n\t-2 tostadas integrales con mermelada de frutas. \nMerienda: \n\t-1 yogurt desntado. \n\t-5 nueces. \n\t-1 plátano en rodajas. \nAlmuerzo: \n\t-Macarrones con brócoli. \n\t-1 pechuga de pollo a la plancha. \n\t-1 manzana. \nCena: \n\t-Merluza ala plancha. \n\t-1 taza de puré de calabaza. \n\t-1 infusión de lo que desee. ";
        }
        else {
             return "Desayuno: \n\t-250g tortilla francesa. \n\t-100g de avena. \n\t-1 vaso de leche. \n\t-10 almendras. \nMerienda: \n\t-150g de pavo. \n\t-2 rebanadas de pan integral. \n\t-1 manzana. \nAlmuerzo: \n\t-2 latas de atún. \n\t-2 rebanadas de pan integral. \n\t-1 naranja. \nCena: \n\t-100g de salmón. \n\t-150g de ensalda con agucate y con 15g de aceite de oliva.";
         }
    }
    
    public static String darConsejo(Usuario U){
        if(U.getEdad() >=19 && U.getEdad() <= 25) {
            return "La caloria necesaria para un joven es aproximadamente 2900 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".";
        }

        else if(U.getEdad() >=26 && U.getEdad() <= 45) {
            return "La caloria necesaria para un adulto es aproximadamente 2600 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".";
        }
        
        else if(U.getEdad() >=46 && U.getEdad() <= 65) {
            return "La caloria necesaria para un adulto mayor es aproximadamente 2400 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".";
        }
        
        else if(U.getEdad() >=66) {
            return "La caloria necesaria para un gente de tercer edad es aproximadamente 2200 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".";
        }
    
        else {
            return "La caloria necesaria para un niño es aproximadamente 2000 calorias. La caloria que usted desea consumir es" + " " + U.getCaloria_objetivo() + ".";
        }
    
    }
    

    
    




}
