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
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RemoteFacadeMain {
     public static void main(String[] args) throws RemoteException, AlreadyBoundException{
         AccountManager manager=new AccountManager();
        Vendor vendor=new Vendor();
        systemAdmin admin= systemAdmin.getInstanceOfAdmin();
        customerService service=new customerService();
        
      
        
        // Set data
        service.notify();
        
        // Publish to client
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("facade", new clientFacadee(manager,vendor,admin,service));
        
        System.out.println("Server is ready");
        
    }
    
    
}
