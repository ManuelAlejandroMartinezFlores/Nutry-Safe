import java.util.ArrayList;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import org.bson.types.ObjectId;

public class MongoDB {
    
    public static void Escribiendo(ArrayList<Usuario> usuarios){
        MongoCollection<Document> collection = getCollection();

        for (Usuario usuario : usuarios){
            try {
                collection.insertOne(usuarioToDoc(usuario));
            } catch (Exception e) {
                Document query = new Document("_id", new ObjectId(usuario.getId()));
                collection.deleteOne(query);
                collection.insertOne(usuarioToDoc(usuario));
            }
        }

    }

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

    public static ArrayList<Usuario> Leyendo(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");

        FindIterable<Document> mydatabaserecords = database.getCollection("usuarios").find();
        MongoCursor<Document> iterator = mydatabaserecords.iterator();

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            usuarios.add(docToUsuario(doc));
        }
        return usuarios;
    }
    

    public static Usuario getUsuario(String id){
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        return docToUsuario(collection.find(query).iterator().next());
    }

    public static void escribirUsuario(Usuario usuario, MongoCollection<Document> collection){
        // MongoCollection<Document> collection = getCollection();
            try {
                collection.insertOne(usuarioToDoc(usuario));
            } catch (Exception e) {
                Document query = new Document("_id", new ObjectId(usuario.getId()));
                collection.deleteOne(query);
                collection.insertOne(usuarioToDoc(usuario));
            }
    }

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

    public static boolean usuarioExiste(String nombre){
        MongoCollection<Document> collection = getCollection();

        long count = collection.countDocuments(new Document("nombre_usuario", new Document("$eq", nombre)));
        return count >= 1;
    }

    public static String actualizarDatos(String id, String nombre, int edad, int altura, int peso, int cal_obj) {
        MongoCollection<Document> collection = getCollection();

        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Usuario usuario = docToUsuario(doc);
        usuario.setDatos(nombre, edad, altura, peso, cal_obj);
        escribirUsuario(usuario, collection);
        return usuario.toString();
    }

    private static MongoCollection<Document> getCollection(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        
        return database.getCollection("usuarios");
    }

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

    public static Integer[] getCalorias(String id) {
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        Integer[] data = new Integer[3];
        data[0] = doc.getInteger("caloria_objetivo");
        data[2] = doc.getInteger("caloria_consumida");
        data[1] = data[0] - data[2];
        return data;
    }

    public static int calMetaUsuario(String id){
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();
        return doc.getInteger("caloria_objetivo");
    }
}
