/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoDB;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import gameonlinestoresystem.Category;
import org.bson.Document;

/**
 *
 * @author usfng
 */
public class DB {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("BUE"); // Database name
        collection = database.getCollection("srs"); // Collection name
    }

    public void insertStudent(Student s) {
        collection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Student inserted.");
    }

    public void deleteStudent(String email) {
        boolean result = collection.deleteOne(Filters.eq("email", email)).wasAcknowledged();
        if (result) {
            System.out.println("Student Deleted.");
        } else {
            System.out.println("Student wasn't found.");
        }
    }

    public Student getStudentByMail(String email) {
        Document doc = collection.find(Filters.eq("email", email)).first();
        Student result = gson.fromJson(doc.toJson(), Student.class);
        return result;
    }

    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("year", year)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
        }
        return result;
    }

    public ArrayList<Student> getStudentsByYearLT(int year) {
        ArrayList<Student> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.lt("year", year)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
        }
        return result;
    }

    public ArrayList<Student> getStudentsByCourse(String courseID) {
        ArrayList<Student> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("courses.courseID", courseID)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
        }
        return result;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
        }
        return result;
    }

    public void updateStudent(Category s) {
        Document doc = Document.parse(gson.toJson(s));
        boolean result = collection.replaceOne(Filters.eq("email", s.getEmail()), doc).wasAcknowledged();
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
