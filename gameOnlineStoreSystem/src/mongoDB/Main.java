
package mongoDB;

import mongoDB.DB;
import java.util.ArrayList;
import gameonlinestoresystem.*;

public class Main {
    

    
    private static void dbInsertion() {

        DB db = new DB();
        /* Category action = new Category("1", "action");
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
        */
        AccountManager am=new AccountManager();
        
        if(am.createAccount(1,"nasr city","omar","ashraf","0455544665","fatma147380@bue.edu.eg","fatma","1234",3,1))
        {
            Customer c1= db.getCustomerByID(3);
            
        }
        
        db.close();
    }
    
    public static void main(String[] args) {
        //dbInsertion();

        DB db = new DB();
       
        ArrayList<Category> Category = db.getAllCategories();
        
        for (int i = 0; i < Category.size(); i++) {
            System.out.println(Category.get(i).toString());
        }
    }
    
}
