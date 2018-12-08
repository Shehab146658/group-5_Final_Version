/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.util.ArrayList;
import java.util.Observable;
import mongoDB.DB;

/**
 *
 * @author Dell
 */
public class systemAdmin implements Observer , View_item , item_adder , delete_items{
    private static systemAdmin Admin;
    private static int observeridtracker;
    private int observerid;
    ArrayList<Item> items = new ArrayList<Item>();
    private systemAdmin(){}
    public static systemAdmin getInstanceOfAdmin()
    {
        if(Admin==null)
        {
            Admin= new systemAdmin();
        }
        return Admin;
    }

    public static systemAdmin getAdmin() {
        return Admin;
    }

    public static void setAdmin(systemAdmin Admin) {
        systemAdmin.Admin = Admin;
    }

   public void addAcc(Customer c, Vendor v,customerService cs)
   {
       if(c.getCustomerID()==null)
       {
           DB db = new DB();
           db.insertCustomer(c);
       }  
       if(v.getSSN()==null)
       {
           
           DB db = new DB();
           db.insertVendor(v);
       }  
       if(cs.SSN==null)
       {
           DB db = new DB();
           db.insertcustomerService(cs);
       }  
   }

   public void updateAcc(Customer c,Vendor v, customerService cs, int CustomerID, int vendorSSN, int csID)
   {
       DB db = new DB();
       db.updateCustomer(c, csID);
       db.updatecustomerService(cs, csID);
       db.updateVendor(v, csID);
   }
   

   public void updateItem(Item I,int itemID)
   {
      // items.get(itemID).setName(name);
       //items.get(itemID).setPrice(price);
        DB db = new DB();
        db.updateItem(I, itemID);
   }
   
    public void approveItem(String itemID)
    {
        
    }
    public void deleteItem(int itemsID)
    {
        
                items.remove(itemsID);
    }
     
    
  
    @Override
    public void viewItems() {
       /* for(int i = 0; i <  items.size();i++)
        {
            System.out.println("Item ID " + items.get(i).getItemID() + "Item Price" + items.get(i).getPrice());
        }*/
        DB db= new DB();
        db.getAllItems();
    }

    @Override
    public void update(String orderstatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addItems(Item i) {
            DB db=new DB();
            db.insertItem(i);
        }
  
    
   

   

    
    
}
