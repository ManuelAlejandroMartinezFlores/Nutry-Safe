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
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        
        
        MongoCollection<Document> collection = database.getCollection("usuarios");
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

    public static String nuevoId(){
        return new ObjectId().toHexString();
    }
    

    public static Usuario getUsuario(String id){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");

        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document query = new Document("_id", new ObjectId(id));
        return docToUsuario(collection.find(query).iterator().next());
    }

    public static void escribirUsuario(Usuario usuario){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                        .applyConnectionString(connectionString)
                                                        .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        
        
        MongoCollection<Document> collection = database.getCollection("usuarios");
            try {
                collection.insertOne(usuarioToDoc(usuario));
            } catch (Exception e) {
                Document query = new Document("_id", new ObjectId(usuario.getId()));
                collection.deleteOne(query);
                collection.insertOne(usuarioToDoc(usuario));
            }
    }

    public static String getIdUsuario(String nombre){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");

        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document query = new Document("nombre_usuario", nombre);
        Document doc =  collection.find(query).iterator().next();
        return doc.getObjectId("_id").toHexString();
    }

    public static boolean usuarioExiste(String nombre){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@nutrysafe.htrby.mongodb.net/NutrySafe?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                                                            .applyConnectionString(connectionString)
                                                            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Usuarios");

        MongoCollection<Document> collection = database.getCollection("usuarios");

        long count = collection.countDocuments(new Document("nombre_usuario", new Document("$eq", nombre)));
        return count >= 1;
    }
}
