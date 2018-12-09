/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import mongoDB.DB;

/**
 *
 * @author shrouk
 */
public class dbManager extends UnicastRemoteObject implements dbManagerINT{
    private static dbManager Manager;
    DB db=new DB();

    public dbManager()throws RemoteException {}
    public static dbManager getInstanceOfdbManager() throws RemoteException
    {
        if(Manager==null)
        {
            Manager= new dbManager();
        }
        return Manager;
    }
    
    @Override
    public String addNewItem(int price,String name)throws RemoteException
    {
        Item item1 = new Item(price,name);
        db.insertItem(item1);
        return "item inserted successfully";
    }
    public String getAllCategories() throws RemoteException
    {
        db.getAllCategories();
        return"categories are reviewed";
    }

  
}
