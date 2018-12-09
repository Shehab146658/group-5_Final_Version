
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author meran
 */
public interface customerDTOinterface extends Remote{
    public void insertCustomer(customerDTOinterface c);
    public void deleteCustomer(String id);
    public customerDTOinterface getCustomerByID(String id);
    public ArrayList<customerDTOinterface> getAllCustomers();
    public void updateCustomer(customerDTOinterface c,String id);
}
