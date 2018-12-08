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
    
     public ArrayList<Person> client= new ArrayList<Person>();

    public ArrayList<Person> getClient() {
        return client;
    }

    public AccountManager() {
    }
    
     
    
    public Boolean verifyLogin(String username, String password)
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
