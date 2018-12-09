
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author meran
 */
public interface orderDTOinterface extends Remote{
    public void insertOrder(Order c);
    public void deleteOrder(String id);
    public Order getOrderByID(String id);
    public ArrayList<Order> getAllOrders();
    public void updateOrder(Order c,String id);
}
