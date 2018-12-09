
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
    @Test
    public void insertCustomer()
    {
        DB db= new DB();
        systemAdmin x= systemAdmin.getInstanceOfAdmin();
        boolean result= x.addAccount(1, "cairo", "meran", "sharawy", "232431114", "meran148368@bue", "meran", "87y3uhawd", 148368, 563);
        assertEquals(true,result);

    }

        @Test
    public void GetOrderTESTING()
    {
        DB db= new DB();
        Order x= db.getOrderByID(2);
        assertEquals("pending",x.getOrderStatus());
    }
    
        @Test
    public void deleteshoppingCartTESTING()
    {
        DB db= new DB();    
        shoppingCart x= db.getshoppingCartByID(1);
        assertEquals(1,x.itemID ); 

    }
    
}


