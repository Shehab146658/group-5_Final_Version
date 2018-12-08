/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;

/**
 *
 * @author Dell
 */
public interface itemInterface extends Remote{
    
    public String  addnewItem(int price, String name);
    public String  updateItem(int price, String name);
    public String deleteItem(int price, String name);
    
}
