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
public class customerDTO extends UnicastRemoteObject implements customerDTOinterface{
    private static customerDTO c;
    DB db = new DB();

    public customerDTO() throws RemoteException {
    }
    
    public static customerDTO getInstanceOfItem() throws RemoteException
    {
        if(c==null)
        {
            c= new customerDTO();
        }
        return c;
    }
    
    public void insertCustomer(Customer c)
    {
        db.insertCustomer(c);
    }
    public void deleteCustomer(String id)
    {
        db.deleteCustomer(id);
    }
    public Customer getCustomerByID(String id)
    {
        return db.getCustomerByID(id);
    }
    public ArrayList<Customer> getAllCustomers()
    {
        return db.getAllCustomers();
    }
    public void updateCustomer(Customer c,String id)
    {
        db.updateCustomer(c, id);
    }
    
}
