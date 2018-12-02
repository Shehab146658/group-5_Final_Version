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
import java.util.*;
public class AccountManager {
    ArrayList<Person> client= new ArrayList<Person>();
    public String username;
    public String password;
    
    public Boolean verifyLogin()
    {
        for (int i=0; i< client.size() ; i++)
        {
            if (username == client.get(i).username && password == client.get(i).password)
            {
                return true;
            }
            else
            {
                System.out.print("incorrect username or password, please try again");
                return false;
                
            }
        }
        return null;
    }
}
