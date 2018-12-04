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
        ClientFacade facade=new clientFacadee();
         // An RMI Registry initialized on port 1099
        Registry reg = LocateRegistry.createRegistry(1099);
        
        // Our remote object facade is binded to the name "customer"
        reg.bind("customer",facade );
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
    }
    
}
