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
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDB {
    
    /** 
     * Transforma un Usuario a un Documento BSON
     * @param usuario
     * @return Document
     */
    private static Document usuarioToDoc(Usuario usuario){
        Document objeto = new Document("_id", new ObjectId(usuario.getId()))
                                            .append("nombre_usuario", usuario.getNombre_usuario())
                                            .append("edad", usuario.getEdad())
                                            .append("altura", usuario.getAltura())
                                            .append("peso", usuario.getPeso())
                                            .append("caloria_objetivo", usuario.getCaloria_objetivo())
                                            .append("caloria_consumida", usuario.getCalorias_consumidas())
                                            .append("ultima_fecha", usuario.getUltima_fecha());

        return objeto;
    }
    
    /** 
     * Transforma un documento BSON a un Usuario
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
        return new Usuario(nombre, edad, altura, peso, cal_obj, cal_con, fecha, id);
    }
    
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
     * @param nombre
     * @param nuevo si es nuevo o no
     * @return String
     */
    public static String getIdUsuario(String nombre, boolean nuevo){
        MongoCollection<Document> collection = getCollection();

        long count = collection.countDocuments(new Document("nombre_usuario", new Document("$eq", nombre)));

        if (count >= 1 && !nuevo){
            Document query = new Document("nombre_usuario", nombre);
            Document doc =  collection.find(query).iterator().next();
            return doc.getObjectId("_id").toHexString();
        } else if (count >= 1 && nuevo) {
            return "";
        } else if (count < 1 && nuevo) {
            String id = new ObjectId().toHexString();
            collection.insertOne(usuarioToDoc(new Usuario(nombre, id)));
            return id;
        } else {
            return "";
        }
        
    }
    
     /** 
     * Actualiza los datos del usuario en la nube
     * @param id
     * @param nombre
     * @param edad
     * @param altura
     * @param peso
     * @param cal_obj
     * @return String
     */
    public static String actualizarDatos(String id, String nombre, int edad, int altura, int peso, int cal_obj) {
        MongoCollection<Document> collection = getCollection();

        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Usuario usuario = docToUsuario(doc);
        usuario.setDatos(nombre, edad, altura, peso, cal_obj);
        escribirUsuario(usuario, collection);
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
}
