
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author meran
 */
public interface adminDTOinterface extends Remote {
    public void insertsystemAdmin(systemAdmin c);
}
