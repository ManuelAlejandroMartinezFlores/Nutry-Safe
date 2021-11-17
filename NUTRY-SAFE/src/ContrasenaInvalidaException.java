public class ContrasenaInvalidaException extends Exception {
    
    ContrasenaInvalidaException(){
        super("Contraseña debe contener al menos 8 caracteres, 1 mayúscula y 1 dígito");
    }
}
