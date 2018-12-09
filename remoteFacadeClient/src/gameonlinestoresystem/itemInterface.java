/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

/**
 *
 * @author meran
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface itemInterface extends Remote{
    public void addnewItem(int price, String name);
    public void deleteItem(itemInterface id);
    public void updateItem(itemInterface c,String id);  
}
