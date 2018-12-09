
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

public class customerServiceDataTransferObject extends UnicastRemoteObject implements customerServiceInterface {
    private static customerServiceDataTransferObject CS;
    DB db = new DB();
    
    public static customerServiceDataTransferObject getInstanceOfCS() throws RemoteException
    {
        if(CS==null)
        {
            CS= new customerServiceDataTransferObject();
        }
        return CS;
    }

    public customerServiceDataTransferObject() throws RemoteException {
    }
    
    public void insertcustomerService(customerService c)
    {
        db.insertcustomerService(c);
    }
    public void deletecustomerService(customerService id)
    {
        db.deletecustomerService(id);
    }
    public customerService getcustomerServiceBySSN(String id)
    {
        return db.getcustomerServiceBySSN(id);    
    }
    public ArrayList<customerService> getAllcustomerService()
    {
        return db.getAllcustomerService();
    }
    public void updatecustomerService(customerService c,String id) {
        db.updatecustomerService(c, id);
    }
    
}
