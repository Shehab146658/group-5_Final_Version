
package gameonlinestoresystem;
import RMI.itemInterface;
import mongoDB.*;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author meran
 */
public class ItemDataTransferObject  extends UnicastRemoteObject implements itemInterface {
    private static ItemDataTransferObject item;
    DB db = new DB();
    
    private ItemDataTransferObject () throws RemoteException 
    {
          
    }

    public static ItemDataTransferObject getInstanceOfItem() throws RemoteException
    {
        if(item==null)
        {
            item= new ItemDataTransferObject();
        }
        return item;
    }
  
    public String addnewItem(int price, String name,int itemID)
    {
        Item i = new Item(price,name);
        db.insertItem(i);
        return"item Inserted Successfully";
    }
    public String updateItem(int price, String name,int itemID)
    {
         Item i = new Item(price,name);
        db.updateItem(i, price);
        return"item updated successfully";
    }
    public String deleteItem(int price, String name,int itemID){
         Item i = new Item(price,name);
         db.deleteItem(itemID);
         return"item deleted Successfully";
        
    }

    
    
}
