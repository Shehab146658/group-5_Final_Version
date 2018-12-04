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
public class Vendor implements Observer {
    public String SSN; 
   
    public Vendor(String SSN) {
        this.SSN = SSN;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    

    
    
    public void notifyCustomerService(String custID,String msg)
    {
        
    }
    public void addItem(String itemID)
    {
        item_adder add = systemAdmin.getInstanceOfAdmin();
        add.addItems();
    }
    public void updateItem(String itemID)
    {
        
    }
    public void deleteItem(String itemID)
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
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
