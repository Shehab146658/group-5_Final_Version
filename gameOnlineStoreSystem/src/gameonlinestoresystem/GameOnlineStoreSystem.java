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

   // private static void dbInsertion() {
      /*  DB db = new DB();
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
        AccountManager manager=new AccountManager();
        Vendor vendor=new Vendor();
        systemAdmin admin= systemAdmin.getInstanceOfAdmin();
        customerService service=new customerService();
        
        ClientFacade facade=new clientFacadee(manager,vendor,admin,service);
         // An RMI Registry initialized on port 1099
        Registry reg = LocateRegistry.createRegistry(1099);
        
        // Our remote object facade is binded to the name "customer"
        reg.bind("username",facade );
        reg.bind("password", facade);
        reg.bind("Cancel", facade);
        
        
        
        dbManager manageDB=dbManager.getInstanceOfdbManager();
        reg.bind("database", manageDB);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        //dbInsertion();

      /*  DB db = new DB();
       
        ArrayList<Category> Category = db.getAllCategories();
=======
>>>>>>> 4291db015be86f15b33c6b3eeb6555261a97f3ee
        
        
    }*/
    

}
}
