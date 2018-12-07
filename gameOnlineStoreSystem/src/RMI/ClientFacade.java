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
   public String verifyLogin() throws RemoteException;
   public String Login() throws RemoteException; //customer ,admin, customer service, vendor
   public String update() throws RemoteException; //customer service, admin, vendor 
   public String addItem()throws RemoteException; //vendor, admin
   public String viewItem()throws RemoteException;//customer,vendor,system admin
   public String deleteItem()throws RemoteException;//vendor,admin
   public String updateItem()throws RemoteException;//vendor,admin
}
