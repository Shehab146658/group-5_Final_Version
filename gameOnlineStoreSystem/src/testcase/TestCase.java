
package testcase;
/**
 *
 * @author meran
 */
import static org.junit.Assert.*;  
import gameonlinestoresystem.*;  
import mongoDB.*;
import org.junit.*;  

public class TestCase {
    @Test
    public void loginTESTING(String username,String password)
    {
        AccountManager instance = new AccountManager();
        assertEquals(username,instance.username);
        assertEquals(password,instance.password);
    }
    
    @Test
    public void getCategoryByNameTESTING(Category c)
    {
        DB d1= new DB();
        assertEquals(c.getCategoryName(),d1.getCategoryByName(c.getCategoryName()));
                               
    }
    
    @Test 
    public void updateCategoryTESTING (Category c1)
    {
        DB d2= new DB();
        //assertEquals(c1, d2.updateCategory(c1));
    }
    
}
