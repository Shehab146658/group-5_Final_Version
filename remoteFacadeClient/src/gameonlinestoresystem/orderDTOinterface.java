
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author meran
 */
public interface orderDTOinterface extends Remote{
    public void insertOrder(orderDTOinterface c);
    public void deleteOrder(String id);
    public orderDTOinterface getOrderByID(String id);
    public ArrayList<orderDTOinterface> getAllOrders();
    public void updateOrder(orderDTOinterface c,String id);
}
