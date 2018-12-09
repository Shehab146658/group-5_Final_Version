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
import gameonlinestoresystem.dbManagerINT;

public class RemoteFacadeClient {
    
     public static void main(String[] args) throws RemoteException, NotBoundException {

        // Connect to RMI Registry
        Registry reg = LocateRegistry.getRegistry(1099);
     //   dbManagerINT manageDB=(dbManagerINT)reg.lookup("database");
        // Get the remote facade reference
        
        //ClientFacade Admin= (ClientFacade) reg.lookup("facade");
        
        // Print items
        
        // Get the remote facade reference
       ClientFacade facade = (ClientFacade ) reg.lookup("facade");
        
        
        System.out.println(facade.verifyLogin(1, 1,"1234"));

        // Edit the address and print the new one
     //   myAddress.setAddress("Ahmed Tayseer St", "Heliopolis", "Cairo", "Egypt");
      //  System.out.println(myAddress.getAddress());
         
       

    }

    
}
