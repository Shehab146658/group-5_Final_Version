/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.rmi.RemoteException;

/**
 *
 * @author shrouk
 */
public interface dbManagerINT {
    public String addNewItem(int price,String name)throws RemoteException;
        public String getAllCategories()throws RemoteException;
}
