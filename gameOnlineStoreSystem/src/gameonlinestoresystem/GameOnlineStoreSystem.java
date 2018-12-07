/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

/**
 *
 * @author Dell
 */
import RMI.ClientFacade;
import RMI.clientFacadee;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class GameOnlineStoreSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws RemoteException, AlreadyBoundException  {
        // TODO code application logic here
        AccountManager manager=new AccountManager();
        Vendor vendor=new Vendor(" ");
        systemAdmin admin= systemAdmin.getInstanceOfAdmin();
        customerService service=new customerService();
        
        ClientFacade facade=new clientFacadee(manager,vendor,admin,service);
         // An RMI Registry initialized on port 1099
        Registry reg = LocateRegistry.createRegistry(1099);
        
        // Our remote object facade is binded to the name "customer"
        reg.bind("username",facade );
        reg.bind("password", facade);
        reg.bind("Cancel", facade);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
    }
    
}
