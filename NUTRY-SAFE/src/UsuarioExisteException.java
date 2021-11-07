public class UsuarioExisteException extends Exception {
    
    UsuarioExisteException(){
        super("Nombre de usuario ya existe");
    }

}
