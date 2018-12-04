/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Dell
 */
public class systemAdmin implements Observer , View_item , item_adder , delete_items{
    private static systemAdmin Admin;
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
           addAcc(c,null,null);
       }  
       if(v.getSSN()==null)
       {
           addAcc(null,v,null);
       }  
       if(cs.SSN==null)
       {
           addAcc(null,null,cs);
       }  
   }

   public void updateAcc(Customer c,Vendor v, customerService cs, String CustomerID, String vendorSSN, String csID)
   {
       c.getCustomerID();
       Admin.updateAcc(c, v, cs, CustomerID, null, null);
       v.getSSN();
       Admin.updateAcc(c, v, cs, null, vendorSSN, null);
       cs.getSSN();
       Admin.updateAcc(c, v, cs, null, null, csID);     
   }
   

   public void updateItem(String itemID,Item i)
   {
       if(i.itemID == itemID)
       {
           i.setItemID(null);
           i.setRate(0);
       }
   }
    public void approveItem(String itemID)
    {
        
    }
    public void deleteItem(String itemsID)
    {
        for(int i =0; i < items.size();i++)
        {
            if(items.get(i).itemID == itemsID  )
            {
                items.remove(i);
            }
        }
    }
     
    
    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addItems() 
    {
       
    }
    
}
