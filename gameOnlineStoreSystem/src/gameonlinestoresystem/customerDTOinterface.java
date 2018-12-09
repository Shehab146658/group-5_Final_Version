
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
    public void deleteCustomer(int id);
    public Customer getCustomerByID(int id);
    public ArrayList<Customer> getAllCustomers();
    public void updateCustomer(Customer c,int id);
}
