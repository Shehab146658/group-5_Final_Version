
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author meran
 */
public interface CategoryDTOinterface extends Remote{
    public void insertCategory(Category c);
    public void deleteCategory(String name);
    public Category getCategoryByName(String name);
    public ArrayList<Category> getAllCategories();
    public void updateCategory(Category c);
    public void viewItemsDetails();
    }

