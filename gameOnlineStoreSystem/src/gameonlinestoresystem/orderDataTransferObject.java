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
public class orderDataTransferObject extends UnicastRemoteObject implements orderDTOinterface{
    private static orderDataTransferObject order;
    DB db = new DB();

    private orderDataTransferObject() throws RemoteException {
    }
    
    public static orderDataTransferObject getInstanceOfItem() throws RemoteException
    {
        if(order==null)
        {
            order= new orderDataTransferObject();
        }
        return order;
    }
    
    public void insertOrder(Order c)
    {
        db.insertOrder(c);
    }
    public void deleteOrder(int id)
    {
        db.deleteOrder(id);
    }
    public Order getOrderByID(int id)
    {
        return db.getOrderByID(id);
    }
    public ArrayList<Order> getAllOrders()
    {
        return db.getAllOrders();
    }
    public void updateOrder(Order c,int id)
    {
        db.updateOrder(c, id);
    } 
    
}
