/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author Dell
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observable;
public interface systemFunctions extends Remote{
    
     public String addToCart()throws RemoteException; 
   public String viewCart()throws RemoteException;
   public String deleteItem()throws RemoteException;
   public String updateItem()throws RemoteException;
  
    
}
