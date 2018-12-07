/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotefacadeClient;

/**
 *
 * @author Dell
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.ClientFacade;

public class RemoteFacadeClient {
     public static void main(String[] args) throws RemoteException, NotBoundException {

        // Connect to RMI Registry
        Registry reg = LocateRegistry.getRegistry(1099);

        // Get the remote facade reference
        
        ClientFacade Admin= (ClientFacade) reg.lookup("Admin");
        ClientFacade customerService = (ClientFacade) reg.lookup("customer service");
        ClientFacade vendor = (ClientFacade) reg.lookup("vendor");
        // Print items
          System.out.println("items viewed by Admin:");
          System.out.println(Admin.viewItem());
          System.out.println("items added by Admin:");
          System.out.println(Admin.addItem());
          System.out.println("items deleted by Admin:");
          System.out.println(Admin.deleteItem());
          System.out.println("items updated by Admin:");
          System.out.println(Admin.update());

       

    }

    
}
