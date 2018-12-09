
package gameonlinestoresystem;
import RMI.itemInterface;
import com.mongodb.client.model.Filters;
import mongoDB.*;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.bson.Document;
/**
 *
 * @author meran
 */
public class CategoryDTO extends UnicastRemoteObject implements CategoryDTOinterface  {
    private static CategoryDTO category;
    DB db = new DB();
    Category c;

    CategoryDTO() throws RemoteException {
    }
    public static CategoryDTO getInstanceOfItem() throws RemoteException
    {
        if(category==null)
        {
            category= new CategoryDTO();
        }
        return category;
    }
    public void insertCategory(Category c)
    {
       db.insertCategory(c);
    }
    public void deleteCategory(String name) {
        db.deleteCategory(name);
    }

    public Category getCategoryByName(String name) {
        return db.getCategoryByName(name);
    }

    public ArrayList<Category> getAllCategories() {
        return db.getAllCategories();
    }

    public void updateCategory(Category c) {
        db.updateCategory(c);
    }
    public void viewItemsDetails()
    {
        c.viewItemsDetails();
    }
}
