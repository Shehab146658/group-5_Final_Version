
package mongoDB;

import gameonlinestoresystem.Category;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import gameonlinestoresystem.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collectionCategory;
    private MongoCollection<Document> collectionCustomer;
    private MongoCollection<Document> collectionOrder;
    private MongoCollection<Document> collectionVendor;
    private MongoCollection<Document> collectioncustomerService;
    private MongoCollection<Document> collectionsysAdmin;
    private MongoCollection<Document> collectionItem;
    private MongoCollection<Document> collectionTicket;
    private MongoCollection<Document> collectionshoppingCart;
    private Gson gson = new Gson();
    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        // Database name
        database = client.getDatabase("GS"); 
        
        //collections
        collectionCategory = database.getCollection("category"); 
        collectionCustomer = database.getCollection("Customer"); 
        collectionOrder = database.getCollection("Order"); 
        collectionVendor = database.getCollection("Vendor"); 
        collectioncustomerService = database.getCollection("customerService"); 
        collectionsysAdmin = database.getCollection("systemAdmin"); 
        collectionItem = database.getCollection("Item"); 
        collectionTicket = database.getCollection("Ticket"); 
        collectionshoppingCart = database.getCollection("shoppingCart"); 
        
        ArrayList<MongoCollection<Document>>allCollections=new ArrayList<>();
        //MongoIterable<String>collectionNames=database.listCollectionNames();
        
    }

    public void insertCategory(Category c) {
        collectionCategory.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Category inserted.");
    }

    public void deleteCategory(String name) {
        boolean result = collectionCategory.deleteOne(Filters.eq("categoryName", name)).wasAcknowledged();
        if (result) {
            System.out.println("Category Deleted.");
        } else {
            System.out.println("Category wasn't found.");
        }
    }

    public Category getCategoryByName(String name) {
        Document doc = collectionCategory.find(Filters.eq("categoryName", name)).first();
        Category result = gson.fromJson(doc.toJson(), Category.class);
        return result;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> result = new ArrayList();
        ArrayList<Document> docs = collectionCategory.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Category.class));
        }
        return result;
    }

    public void updateCategory(Category c) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionCategory.replaceOne(Filters.eq("categoryName", c.getCategoryName()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Category Updated.");
        } else {
            System.out.println("Category wasn't found.");
        }
    }

    
    
    public void insertCustomer(Customer c) {
        collectionCustomer.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Customer inserted.");
    }

    public void deleteCustomer(int id) {
        boolean result = collectionCustomer.deleteOne(Filters.eq("customerID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Customer Deleted.");
        } else {
            System.out.println("Customer wasn't found.");
        }
    }

    public Customer getCustomerByID(int id) {
        Document doc = collectionCustomer.find(Filters.eq("customerID", id)).first();
        Customer result = gson.fromJson(doc.toJson(), Customer.class);
        return result;
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> result = new ArrayList();
        ArrayList<Document> docs = collectionCustomer.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Customer.class));
        }
        return result;
    }

    public void updateCustomer(Customer c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionCustomer.replaceOne(Filters.eq("customerID", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("Customer Updated.");
        } else {
            System.out.println("Customer wasn't found.");
        }
    }
    
    
    
    public void insertOrder(Order c) {
        collectionOrder.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Order inserted.");
    }

    public void deleteOrder(int id) {
        boolean result = collectionOrder.deleteOne(Filters.eq("OrderID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Order Deleted.");
        } else {
            System.out.println("Order wasn't found.");
        }
    }

    public Order getOrderByID(int id) {
        Document doc = collectionOrder.find(Filters.eq("OrderID", id)).first();
        Order result = gson.fromJson(doc.toJson(), Order.class);
        return result;
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> result = new ArrayList();
        ArrayList<Document> docs = collectionOrder.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Order.class));
        }
        return result;
    }

    public void updateOrder(Order c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionOrder.replaceOne(Filters.eq("OrderID", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("Order Updated.");
        } else {
            System.out.println("Order wasn't found.");
        }
    }
    
    
    public void insertVendor(Vendor c) {
        collectionVendor.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Vendor inserted.");
    }

    public void deleteVendor(int id) {
        boolean result = collectionVendor.deleteOne(Filters.eq("OrderID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Vendor Deleted.");
        } else {
            System.out.println("Vendor wasn't found.");
        }
    }

    public Order getVendorBySSN(int id) {
        Document doc = collectionVendor.find(Filters.eq("SSN", id)).first();
        Order result = gson.fromJson(doc.toJson(), Order.class);
        return result;
    }

    public ArrayList<Vendor> getAllVendors() {
        ArrayList<Vendor> result = new ArrayList();
        ArrayList<Document> docs = collectionVendor.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Vendor.class));
        }
        return result;
    }

    public void updateVendor(Vendor c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionVendor.replaceOne(Filters.eq("SSN", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("Vendor Updated.");
        } else {
            System.out.println("Vendor wasn't found.");
        }
    }
    
    
    public void insertcustomerService(customerService c) {
        collectioncustomerService.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("customer Service inserted.");
    }

    public void deletecustomerService(int id) {
        boolean result = collectioncustomerService.deleteOne(Filters.eq("SSN", id)).wasAcknowledged();
        if (result) {
            System.out.println("customerService Deleted.");
        } else {
            System.out.println("customerService wasn't found.");
        }
    }

    public customerService getcustomerServiceBySSN(int id) {
        Document doc = collectioncustomerService.find(Filters.eq("SSN", id)).first();
        customerService result = gson.fromJson(doc.toJson(), customerService.class);
        return result;
    }

    public ArrayList<customerService> getAllcustomerService() {
        ArrayList<customerService> result = new ArrayList();
        ArrayList<Document> docs = collectioncustomerService.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), customerService.class));
        }
        return result;
    }

    public void updatecustomerService(customerService c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectioncustomerService.replaceOne(Filters.eq("SSN", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("customerService Updated.");
        } else {
            System.out.println("customerService wasn't found.");
        }
    }
    
    
    public void insertsystemAdmin(systemAdmin c) {
        collectionsysAdmin.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("system Admin inserted.");
    }

    public void insertItem(Item c) {
        collectionCategory.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Item inserted.");
    }

    public void deleteItem(int id) {
        boolean result = collectionCategory.deleteOne(Filters.eq("itemID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Item Deleted.");
        } else {
            System.out.println("Item wasn't found.");
        }
    }

    public Item getItemByID(int id) {
        Document doc = collectionCategory.find(Filters.eq("itemID", id)).first();
        Item result = gson.fromJson(doc.toJson(), Item.class);
        return result;
    }

    public ArrayList<Item> getAllItems() {
        ArrayList<Item> result = new ArrayList();
        ArrayList<Document> docs = collectionItem.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Item.class));
        }
        return result;
    }

    public void updateItem(Item c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionItem.replaceOne(Filters.eq("itemID", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("Item Updated.");
        } else {
            System.out.println("Item wasn't found.");
        }
    }
    
    
    
    
    public void insertTicket(Ticket c) {
        collectionTicket.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Ticket inserted.");
    }

    public void deleteTicket(Ticket id) {
        boolean result = collectionTicket.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Ticket Deleted.");
        } else {
            System.out.println("Ticket wasn't found.");
        }
    }

    public Ticket getTicketByID(int id) {
        Document doc = collectionTicket.find(Filters.eq("ID", id)).first();
        Ticket result = gson.fromJson(doc.toJson(), Ticket.class);
        return result;
    }

    public ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> result = new ArrayList();
        ArrayList<Document> docs = collectionTicket.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Ticket.class));
        }
        return result;
    }

    public void updateTicket(Ticket c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionTicket.replaceOne(Filters.eq("ID", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("Ticket Updated.");
        } else {
            System.out.println("Ticket wasn't found.");
        }
    }
    
    
    public void insertshoppingCart(shoppingCart c) {
        collectionTicket.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("shoppingCart inserted.");
    }

    public boolean deleteshoppingCart(int id) {
        boolean result = collectionshoppingCart.deleteOne(Filters.eq("cartID", id)).wasAcknowledged();
        if (result) {
            System.out.println("shoppingCart Deleted.");
            return true;
        } else {
            System.out.println("shoppingCart wasn't found.");
            return false;
        }
    }

    public shoppingCart getshoppingCartByID(int id) {
        Document doc = collectionTicket.find(Filters.eq("cartID", id)).first();
        shoppingCart result = gson.fromJson(doc.toJson(), shoppingCart.class);
        return result;
    }

    public ArrayList<shoppingCart> getAllshoppingCart() {
        ArrayList<shoppingCart> result = new ArrayList();
        ArrayList<Document> docs = collectionTicket.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), shoppingCart.class));
        }
        return result;
    }

    public void updateshoppingCart(shoppingCart c,int id) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collectionshoppingCart.replaceOne(Filters.eq("cartID", id), doc).wasAcknowledged();
        if (result) {
            System.out.println("shoppingCart Updated.");
        } else {
            System.out.println("shoppingCart wasn't found.");
        }
    }
    
    
    public void close() {
        client.close();
    }
    
    
    

}
