
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author meran
 */
public interface CategoryDTOinterface extends Remote{
    public void insertCategory(CategoryDTOinterface c);
    public void deleteCategory(String name);
    public CategoryDTOinterface getCategoryByName(String name);
    public ArrayList<CategoryDTOinterface> getAllCategories();
    public void updateCategory(CategoryDTOinterface c);
    public void viewItemsDetails();
    }

