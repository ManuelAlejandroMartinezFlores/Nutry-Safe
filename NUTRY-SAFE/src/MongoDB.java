/**
 * MongoDB.
 * Contiene la lógica para acceso a la nube y queries en la base de datos.
 * 
 * @version Entrega 3
 */

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDB {
    
    /** 
     * Obtiene un usuario a partir de un ID
     * @param id
     * @return Usuario
     */
    public static Usuario getUsuario(String id){
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        return docToUsuario(collection.find(query).iterator().next());
    }
    
    /** 
     * Escribe un usuario en la nube
     * @param usuario
     * @param collection
     */
    private static void escribirUsuario(Usuario usuario, MongoCollection<Document> collection){
            try {
                collection.insertOne(usuarioToDoc(usuario));
            } catch (Exception e) {
                Document query = new Document("_id", new ObjectId(usuario.getId()));
                collection.deleteOne(query);
                collection.insertOne(usuarioToDoc(usuario));
            }
    }
 
    /** 
     * Obtiene el ID del usuario a partir del nombre.
     * Si el usuario es nuevo lo crea
     * @param nombre de usuario
     * @param nuevo si es nuevo o no
     * @param contrasena contrasena
     * @return String
     * @throws UsuarioExisteException
     * @throws UsuarioContrasenaException
     */
    public static String getIdUsuario(String nombre, String contrasena, boolean nuevo) throws UsuarioExisteException, UsuarioContrasenaException{
        MongoCollection<Document> collection = getCollection();

        long countC = collection.countDocuments(new Document("nombre_usuario", new Document("$eq", nombre)).append("contrasena", new Document("$eq", contrasena)));
        long countN = collection.countDocuments(new Document("nombre_usuario", new Document("$eq", nombre)));
        if (countC >= 1 && !nuevo){
            Document query = new Document("nombre_usuario", nombre).append("contrasena", contrasena);
            Document doc =  collection.find(query).iterator().next();
            return doc.getObjectId("_id").toHexString();
        } else if (countN >= 1 && nuevo) {
            throw new UsuarioExisteException();
        } else if (countN < 1 && nuevo) {
            String id = new ObjectId().toHexString();
            escribirUsuario(new Usuario(nombre, id, contrasena), collection);
            return id;
        } else {
            throw new UsuarioContrasenaException();
        }
        
    }
    
     /** 
     * Actualiza los datos del usuario en la nube
     * @param id
     * @param edad
     * @param altura
     * @param peso
     * @param cal_obj
     * @return String
     */
    public static String actualizarDatos(String id, int edad, int altura, int peso, int cal_obj) {
        MongoCollection<Document> collection = getCollection();

        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Usuario usuario = docToUsuario(doc);
        usuario.setDatos(edad, altura, peso, cal_obj);
        escribirUsuario(usuario, collection);;
        return usuario.toString();
    }
    
    /** 
     * Inicia sesión y obtiene la colección de documentos MongoDB
     * @return MongoCollection<Document>
     */
    private static MongoCollection<Document> getCollection(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        
        return database.getCollection("usuarios");
    }
    
    /** 
     * Realiza la acción de contarCaloria en la nube
     * @param id
     * @param caloria
     * @return Integer[] información de calorías
     */
    public static Integer[] contarCaloria(String id, int caloria) {
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Usuario usuario = docToUsuario(doc);
        usuario.contarCaloria(caloria);
        Integer[] data = new Integer[3];
        data[0] = usuario.getCaloria_objetivo();
        data[1] = usuario.getCaloriaDisponible();
        data[2] = usuario.getCalorias_consumidas();
        escribirUsuario(usuario, collection);

        return data;
    }
    
    /** 
     * Indica información de calorías
     * @param id
     * @return Integer[] información de calorías
     */
    public static Integer[] getCalorias(String id) {
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Integer[] data = new Integer[3];
        Usuario usuario = docToUsuario(doc);
        data[0] = usuario.getCaloria_objetivo();
        data[1] = usuario.getCaloriaDisponible();
        data[2] = usuario.getCalorias_consumidas();
        return data;
    }
    /** 
     * Indica la caloría meta del usuario 
     * @param id
     * @return int caloría meta
     */
    public static int calMetaUsuario(String id){
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        return doc.getInteger("caloria_objetivo");
    }  

    /**
     * Obtiene un arreglo de HashMap<String, Integer> que contienen fechas y calorías
     * @param id id del usuario
     * @return arreglo con históricos
     */
    public static Object[] getHist(String id){
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Object[] res = new Object[2];
        res[0] = docToUsuario(doc).getConHist();
        res[1] = docToUsuario(doc).getObjHist();
        return res;
    }

    /**
     * Transforma documento BSON a Usuario
     * @param doc
     * @return Usuario
     */
    private static Usuario docToUsuario(Document doc){
        String nombre = doc.getString("nombre_usuario");
        int edad = doc.getInteger("edad");
        int altura = doc.getInteger("altura");
        int peso = doc.getInteger("peso");
        int cal_obj = doc.getInteger("caloria_objetivo");
        int cal_con = doc.getInteger("caloria_consumida");
        String fecha = doc.getString("ultima_fecha");
        String id = doc.getObjectId("_id").toHexString();
        String con = doc.getString("contrasena");
        List<String> h_f = (List<String>) doc.get("hist_fechas");
        List<Integer> h_c = (List<Integer>) doc.get("hist_con");
        List<Integer> h_o = (List<Integer>) doc.get("hist_obj");
        HashMap<String, Integer> hist = new HashMap<String, Integer>();
        HashMap<String, Integer> hist_obj = new HashMap<>();
        for (int i=0; i<h_f.size(); i++){
            hist.put(h_f.get(i), h_c.get(i));
            hist_obj.put(h_f.get(i), h_o.get(i));
        }
        return new Usuario(nombre, edad, altura, peso, cal_obj, cal_con, fecha, id, con, hist, hist_obj);
    }

    /**
     * Transforma Usuario a documento BSON
     * @param usuario
     * @return documento
     */
    private static Document usuarioToDoc(Usuario usuario){
        List<String> h_f = new ArrayList<>();
        List<Integer> h_c = new ArrayList<>();
        List<Integer> h_o = new ArrayList<>();
        for (String key : usuario.getConHist().keySet()){
            h_f.add(key);
            h_c.add(usuario.getConHist().get(key));
            h_o.add(usuario.getObjHist().get(key));
        }
        Document doc = new Document("_id", new ObjectId(usuario.getId()))
                                            .append("nombre_usuario", usuario.getNombre_usuario())
                                            .append("edad", usuario.getEdad())
                                            .append("altura", usuario.getAltura())
                                            .append("peso", usuario.getPeso())
                                            .append("caloria_objetivo", usuario.getCaloria_objetivo())
                                            .append("caloria_consumida", usuario.getCalorias_consumidas())
                                            .append("ultima_fecha", usuario.getUltima_fecha())
                                            .append("contrasena", usuario.getContrasena())
                                            .append("hist_fechas", h_f)
                                            .append("hist_con", h_c)
                                            .append("hist_obj", h_o);

        return doc;
    }

    /**
     * Obtiene un arreglo con los consejos desde la nube.
     * @return Lista con los consejos
     */
    public static List<String> getConsejos(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        
        MongoCollection<Document> collection = database.getCollection("utils");
        Document query = new Document("nombre", "consejos");
        Document doc = collection.find(query).iterator().next();
        return (List<String>) doc.get("lista");
    }
}
