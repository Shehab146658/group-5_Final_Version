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
import API.UnirestTest;
import java.util.*;
import mongoDB.DB;
public class AccountManager {
     
     
    public AccountManager() {
    }
    
     
    
    public boolean createAccount(int accType,String address, String firstName, String lastName, String mobileNumber, String email, String username, String password,int customerID,int ssn)
    {
        DB db=new DB();
        switch (accType){
        case 1:
                Customer cust = new Customer(customerID,address,firstName,lastName,mobileNumber,email,username,password);
                db.insertCustomer(cust);
                return true;
        case 2: 
            Vendor vend = new Vendor(ssn,address,firstName,lastName,mobileNumber,email,username,password);
            db.insertVendor(vend);
            return true;
        default:
            return true;
            
        }
    }
       
    public Boolean verifyLogin(int category,int id, String password)
    {
        DB db=new DB();
        UnirestTest ap=new UnirestTest();
        String encPass= ap.api(password);
        System.out.println("enter 1 for customer, 2 for vendor, 3 for admin, 4 for customer service");
        switch(category)
        {
            
            case 1:
                Customer cust = db.getCustomerByID(id);
                if(cust==null)
                {
                    System.out.println("wrong id");
                    return false;
                }
                else if (cust.getPassword()==encPass)
                {
                    System.out.println("login ok");
                    return true;
                } 
                break;
            case 2:
                Vendor vend = db.getVendorBySSN(id);
                if(vend==null)
                {
                    System.out.println("wrong id");
                    return false;
                }
                else if (vend.getPassword()==encPass)
                {
                    System.out.println("login ok");
                    return true;
                } 
                break;
            case 3:
                systemAdmin admin = db.getAdmin();
                if(admin==null)
                {
                    System.out.println("wrong id");
                    return false;
                }
                else if (admin.getPassword()==encPass)
                {
                    System.out.println("login ok");
                    return true;
                } 
                break;
            case 4:
                customerService custserv = db.getcustomerServiceBySSN(id);
                if(custserv==null)
                {
                    System.out.println("wrong id");
                    return false;
                }
                if (custserv.getPassword()==encPass)
                {
                    System.out.println("login ok");
                    return true;
                } 
                break;
            default:
                break;
        }
            
        return true;
    }
}
