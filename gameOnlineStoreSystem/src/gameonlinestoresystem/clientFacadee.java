/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;
import API.UnirestTest;
import gameonlinestoresystem.Category;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import RMI.ClientFacade;
import java.util.Observable;
import java.util.Scanner;
import mongoDB.DB;

/**
 *
 * @author Dell
 */
public class clientFacadee extends UnicastRemoteObject implements ClientFacade {

    
    private final Vendor vendor;
    private final systemAdmin admin;
    private final customerService service;
    private final AccountManager manager;
   
    public clientFacadee(AccountManager manager,Vendor vendor,systemAdmin admin,customerService service) throws RemoteException {
        this.manager=manager;
        this.vendor=vendor;
        this.admin=admin;
        this.service=service;
    }


  
       @Override
    public String notify(String customerID, String vendorID, String customerServiceID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    


    @Override
    public String update() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verifyLogin(int category, int id, String password) {
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
    }    }
   

    
    


