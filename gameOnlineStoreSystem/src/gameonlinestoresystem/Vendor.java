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
import java.util.*;
import java.util.Scanner;
public class Vendor extends Person implements Observer {
    private String SSN; 
    private static int observeridtracker;
    private int observerid;
   
    public Vendor(String SSN , String address, String firstName, String lastName, String mobileNumber, String email, String username, String password) {
        
        super(address, firstName, lastName, mobileNumber, email, username, password);
        this.SSN = SSN;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Vendor() {
    }

    

    
    
    public void notifyCustomerService(String custID,String msg)
    {
        
    }
    
    
    
    public void addItem()
    {
        item_adder add = systemAdmin.getInstanceOfAdmin();
        System.out.println("Enter product price");
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        System.out.println("Enter product name");
        String n = sc.nextLine();
        Item i = new Item(p,n);
        add.addItems(i);
    }
    public void updateItem(int itemID)
    {
        
    }
    public void deleteItem(int itemID)
    {
        delete_items deleter = systemAdmin.getInstanceOfAdmin();
        deleter.deleteItem(itemID);
    }
    public void viewItems(String itemID)
    {
        View_item viewer = systemAdmin.getInstanceOfAdmin();
        viewer.viewItems();
    }

    @Override
    public void update(String orderstatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
