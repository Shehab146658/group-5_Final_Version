
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author meran
 */
public interface customerDTOinterface extends Remote{
    public void insertCustomer(Customer c);
    public void deleteCustomer(String id);
    public Customer getCustomerByID(String id);
    public ArrayList<Customer> getAllCustomers();
    public void updateCustomer(Customer c,String id);
}
