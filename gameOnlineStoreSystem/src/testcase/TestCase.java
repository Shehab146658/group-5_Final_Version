
package testcase;
/**
 *
 * @author meran
 */
import static org.junit.Assert.*;  
import gameonlinestoresystem.*;  
import org.junit.*;  

public class TestCase {
    @Test
    public void loginTest(String username,String password)
    {
        AccountManager instance = new AccountManager();
        assertEquals(username,instance.username);
        assertEquals(password,instance.password);
    }
    
    @Test
    public void getTicketsByID(int id)
    {
       
        
        
        
    }
    
}
