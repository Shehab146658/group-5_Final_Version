
package mongoDB;

import gameonlinestoresystem.Category;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private ArrayList< ListCollectionsIterable<Document>> collections;
    private Gson gson = new Gson();
    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("GS"); // Database name
        collection = database.getCollection("category"); // Collection name
    }

    public void insertCategory(Category c) {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Category inserted.");
    }

    public void deleteCategory(String name) {
        boolean result = collection.deleteOne(Filters.eq("name", name)).wasAcknowledged();
        if (result) {
            System.out.println("Category Deleted.");
        } else {
            System.out.println("Category wasn't found.");
        }
    }

    public Category getCategoryByName(String name) {
        Document doc = collection.find(Filters.eq("name", name)).first();
        Category result = gson.fromJson(doc.toJson(), Category.class);
        return result;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Category.class));
        }
        return result;
    }

    public void updateCategory(Category c) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collection.replaceOne(Filters.eq("name", c.getCategoryName()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Category Updated.");
        } else {
            System.out.println("Category wasn't found.");
        }
    }

    public void close() {
        client.close();
    }

}
