
package gameonlinestoresystem;
import mongoDB.*;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author meran
 */
public class ItemDataTransferObject  extends UnicastRemoteObject {
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
  
    public void addnewItem(int price, String name)
    {
        Item i = new Item(price,name);
        db.insertItem(i);
    }
    
}
