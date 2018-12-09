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
        UnirestTest ap=new UnirestTest();
        String encPass= ap.api(password);
        switch (accType){
        case 1:
                Customer cust = new Customer(customerID,address,firstName,lastName,mobileNumber,email,username,encPass);
                db.insertCustomer(cust);
                return true;
        case 2: 
            Vendor vend = new Vendor(ssn,address,firstName,lastName,mobileNumber,email,username,encPass);
            db.insertVendor(vend);
            return true;
        default:
            return true;
            
        }
    }
       
    
}
