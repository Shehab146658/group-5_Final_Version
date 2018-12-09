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
public class systemAdmin extends Person implements Observer , View_item , item_adder , delete_items{
    private static systemAdmin Admin;
    private static int observeridtracker;
    private int observerid;
    ArrayList<Item> items = new ArrayList<Item>();

    private systemAdmin(int observerid, String address, String firstName, String lastName, String mobileNumber, String email, String username, String password) {
        super(address, firstName, lastName, mobileNumber, email, username, password);
        this.observerid = observerid;
    }
    
    public static systemAdmin getInstanceOfAdmin()
    {
        if(Admin==null)
        {
            Admin= new systemAdmin(1,"cairo","ahmed","ahmed","+100000002","admin@bue","admin","admin");
        }
        return Admin;
    }


    public void addAccount(int accType,String address, String firstName, String lastName, String mobileNumber, String email, String username, String password,int customerID,int ssn)
    {
        DB db=new DB();
        switch (accType){
        case 1:
                Customer cust = new Customer(customerID,address,firstName,lastName,mobileNumber,email,username,password);
                db.insertCustomer(cust);
                break;
        case 2: 
                Vendor vend = new Vendor(ssn,address,firstName,lastName,mobileNumber,email,username,password);
                db.insertVendor(vend);
                break;
        case 3:
            customerService cs= new customerService( ssn,  address,  firstName,  lastName,  mobileNumber,  email,  username,  password);
            db.insertcustomerService(cs);
            break;
        default:
            break;
        }
    }
    
    

   public void updateAccPass(int accType,int CustomerID, int vendorSSN, int csID,String newPass)
   {
       DB db = new DB();
       switch (accType){
        case 1:
                Customer cust =db.getCustomerByID(CustomerID);
                cust.setPassword(newPass);
                db.deleteCustomer(CustomerID);
                db.insertCustomer(cust);
                break;
        case 2: 
               Vendor vend =db.getVendorBySSN(vendorSSN);
               vend.setPassword(newPass);
               db.deleteVendor(vendorSSN);
               db.insertVendor(vend);
                break;
        case 3:
            customerService custser =db.getcustomerServiceBySSN(csID);
            custser.setPassword(newPass);
            db.deletecustomerService(csID);
            db.insertcustomerService(custser);
            break;
        default:
            break;
        }
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
