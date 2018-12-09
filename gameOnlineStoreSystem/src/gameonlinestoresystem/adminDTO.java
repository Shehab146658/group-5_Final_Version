package gameonlinestoresystem;
import mongoDB.*;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author meran
 */
public class adminDTO extends UnicastRemoteObject{
    private static adminDTO admin;
    DB db = new DB();

    private adminDTO() throws RemoteException {
    }
    
    public static adminDTO getInstanceOfItem() throws RemoteException
    {
        if(admin==null)
        {
            admin= new adminDTO();
        }
        return admin;
    }
    
    public void insertsystemAdmin(systemAdmin c)
    {
        db.insertsystemAdmin(c); 
    }
    
}
