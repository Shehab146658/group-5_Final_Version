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
import RMI.ClientFacade;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import mongoDB.DB;
public class RemoteFacadeMain {
     public static void main(String[] args) throws RemoteException, AlreadyBoundException{
         //Customer cust=new Customer(123,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234");
         // public Customer(int customerID, String address, String firstName, String lastName, String mobileNumber, String email, String username, String password) {
        DB db = new DB();
        //db.insertCustomer(cust);
        AccountManager manager=new AccountManager();
        manager.createAccount(1,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234",123,1);
        Vendor vendor=new Vendor(11,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234");
        systemAdmin admin= systemAdmin.getInstanceOfAdmin();
        customerService service=new customerService(111,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234");
       
      
        
        //Set data
        //service.notify();
        
        // Publish to client
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("facade", new clientFacadee(manager,vendor,admin,service,db.getCustomerByID(123)));
        
        System.out.println("Server is ready");
        
    }
    
    
}
