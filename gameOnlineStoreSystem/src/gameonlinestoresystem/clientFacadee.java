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

    private final Customer customer;
    private final Vendor vendor;
    private final systemAdmin admin;
    private final customerService service;
   
    public clientFacadee(Customer customer,Vendor vendor,systemAdmin admin,customerService service) throws RemoteException {
        this.customer=customer;
        this.vendor=vendor;
        this.admin=admin;
        this.service=service;
    }

   

    @Override
    public void viewItems(String itemID) {
        View_item viewer = systemAdmin.getInstanceOfAdmin();
        viewer.viewItems();    
    }

    @Override
    public void createTickect(String customerID, String Description) {
        
    }

    @Override
    public void update(Observable o, Object o1) {
    }

    @Override
    public void notify(String customerID, String vendorID, String customerServiceID) {
    }

    @Override
    public void addAccounts(String customerID, String vendorID, String customerServiceID) {
    }

    @Override
    public void removeAccounts(String customerID, String vendorID, String customerServiceID) {
    }

    @Override
    public void updateAccounts(String customerID, String vendorID, String customerServiceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(String itemID, Item I) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(String itemID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void approveItem(String itemID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOrderInfo(String orderID, String orderStatus) {
        
    }

    @Override
    public String getOrderInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void placeOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTocart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewItemsDetails(Item i, Category c) {
         c.getCategoryID();
        i.getItemID();
        i.getRate();
    }

    @Override
    public void rateItem(Item i, int rate) {
          i.getItemID();
        switch(rate)
        {
            case 1:
              
                System.out.println("very bad");
                break;
            case 2:
                System.out.println("bad");
                break;
            case 3:
                System.out.println("Good");
                break;
            case 4:
                System.out.println("very good");
                break;
            case 5:
                System.out.println("Perfect");
                break;
        }
    }

    @Override
    public void rate(Item i) {
        int rate;
       Scanner S=new Scanner(System.in); 
       rate=S.nextInt();
       i.rateItem(i,rate);
    }

    @Override
    public Item getChild(Item i, Category c) {
         i.viewItemsDetails(i, c);
           return i;
    }
}
