
package testcase;
/**
 *
 * @author meran
 */
import static org.junit.Assert.*;  
import gameonlinestoresystem.*;  
import java.util.ArrayList;
import mongoDB.*;
import org.junit.*;  

public class TestCase {
    public void getCategoryByNameTESTING(Category c)
    {
        DB d1= new DB();
        assertEquals(c.getCategoryName(),d1.getCategoryByName(c.getCategoryName()));
                               
    } 
         @Test
    public void updateTicketTESTING(Ticket c,String id)
    {
        DB db= new DB();
        assertEquals(c,db.getTicketByID(id));
    }
        @Test
    //public void deleteshoppingCartTESTING(shoppingCart s)
    //{
    //    DB db= new DB();
     //   db.deleteshoppingCart(s);
     //   assertNull(s);
    //}
        
         @Test
    public void GetTicketTESTING(Ticket c,String id)
    {
        DB db= new DB();
        assertEquals(c,db.getTicketByID(id));
    }
    
        @Test
    public void deleteshoppingCartTESTING(shoppingCart s)
    {
        DB db= new DB();            
        assertEquals(true,db.deleteshoppingCart(s) ); 

    }
    
   @Test
   public void insertItemTESTING(Item i)
   {
       DB db= new DB();

       db.insertItem(i);
       assertNotNull(i);
   }
    

       //int x = i.getItemID(); 
       //assertNotNull(db.getItemByID(x)); 
   }
   

}
