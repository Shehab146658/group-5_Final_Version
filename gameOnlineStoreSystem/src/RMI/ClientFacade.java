/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author Dell
 */
import gameonlinestoresystem.Category;
import gameonlinestoresystem.Item;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observable;
public interface ClientFacade extends Remote {
   

    public String notify(String customerID,String vendorID,String customerServiceID)throws RemoteException; //customer service, admin, vendor
    public Boolean verifyLogin(int category,int id, String password) throws RemoteException;
    public String update() throws RemoteException; //customer service, admin, vendor 
    
}
