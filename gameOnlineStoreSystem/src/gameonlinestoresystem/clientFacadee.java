/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;
import gameonlinestoresystem.Category;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import RMI.ClientFacade;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class clientFacadee extends UnicastRemoteObject implements ClientFacade {

    
  /*  private final Vendor vendor;
    private final systemAdmin admin;
    private final customerService service;
    private final AccountManager manager;
   
    public clientFacadee(AccountManager manager,Vendor vendor,systemAdmin admin,customerService service) throws RemoteException {
        this.manager=manager;
        this.vendor=vendor;
        this.admin=admin;
        this.service=service;
    }*/

    public clientFacadee() throws RemoteException {
        
    }

  
       @Override
    public String notify(String customerID, String vendorID, String customerServiceID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String verifyLogin() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Login() throws RemoteException {
           return "Logged In Sucessfully";
    }


    @Override
    public String update() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
