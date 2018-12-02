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
    public void viewItems(String itemID)throws RemoteException;
    public void createTickect(String customerID, String Description)throws RemoteException;
    public void update(Observable o, Object o1)throws RemoteException;
    public void notify(String customerID,String vendorID,String customerServiceID)throws RemoteException;
    public void addAccounts(String customerID,String vendorID,String customerServiceID)throws RemoteException;
    public void removeAccounts(String customerID,String vendorID,String customerServiceID)throws RemoteException;
    public void updateAccounts(String customerID,String vendorID,String customerServiceID)throws RemoteException;
    public void updateItem(String itemID,Item I)throws RemoteException;
    public void deleteItem(String itemID)throws RemoteException;
    public void approveItem(String itemID)throws RemoteException;
    public void setOrderInfo(String orderID,String orderStatus)throws RemoteException;
    public String getOrderInfo()throws RemoteException;
    public void updateStatus(String status)throws RemoteException;
    public void pay()throws RemoteException;
    public void checkOut()throws RemoteException;
    public void placeOrder()throws RemoteException;
    public void addTocart()throws RemoteException;
    public void viewCart()throws RemoteException;
    public void viewItemsDetails(Item i, Category c)throws RemoteException;
    public void rateItem(Item i, int rate)throws RemoteException;
    public void rate(Item i)throws RemoteException;
    public Item getChild(Item i,Category c)throws RemoteException;
     
    
    
 
}
