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
import RMI.clientFacadee;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import mongoDB.DB;
public class GameOnlineStoreSystem {

    /**
     * @param args the command line arguments
     */

   /* private static void dbInsertion() {
        DB db = new DB();
        Category action = new Category("1", "action");
        Category arcade = new Category("2", "arcade");
        Category sports = new Category("3", "sports");
        Category fps = new Category("4", "fps");
        
        Item fifa19 = new Item(1200,"fifa19");
        Item BF5 = new Item(1000,"BF5");
        Item spiderman = new Item(900,"spiderman");
        Item mortalkombat = new Item(1100,"mortalkombat");
        
        fps.add(BF5);
        action.add(mortalkombat);
        sports.add(fifa19);
        arcade.add(spiderman);
        
        db.insertCategory(action);
        db.insertCategory(arcade);
        db.insertCategory(sports);
        db.insertCategory(fps);
        
        db.close();
    }*/

    public static void main(String[] args)throws RemoteException, AlreadyBoundException  {
        // TODO code application logic here
        Customer cust=new Customer(1,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234");
         // public Customer(int customerID, String address, String firstName, String lastName, String mobileNumber, String email, String username, String password) {
         DB db = new DB();
         db.insertCustomer(cust);
         AccountManager manager=new AccountManager();
        Vendor vendor=new Vendor(11,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234");
        systemAdmin admin= systemAdmin.getInstanceOfAdmin();
        customerService service=new customerService(111,"nasr city","fatma","mekhemer","0455544665","fatma147380@bue.edu.eg","fatma","1234");
       

      ClientFacade facade=new clientFacadee(manager,vendor,admin,service,cust);
        dbManager dd= dbManager.getInstanceOfdbManager();
         // An RMI Registry initialized on port 1099
        Registry reg = LocateRegistry.createRegistry(1099);
        
        //Our remote object facade is binded to the name "customer"
        reg.bind("username",facade );
        reg.bind("password", facade);
        reg.bind("Cancel", facade);
        reg.bind("add item",dd);
        
      
        
        // Set data
//        service.notify();
        
        // Publish to client
       
       // reg.bind("facade", new gameonlinestoresystem.clientFacadee(manager,vendor,admin,service));
       reg.bind("dd",new gameonlinestoresystem.dbManager() );
        
        System.out.println("Server is ready");
        
        
        
        dbManager manageDB=dbManager.getInstanceOfdbManager();
        reg.bind("database", manageDB);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        //dbInsertion();


       
        ArrayList<Category> Category = db.getAllCategories();

        
    }
    

}

