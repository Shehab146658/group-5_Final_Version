/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem ;
import mongoDB.*;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author meran
 */
public class vendorTransferObject extends UnicastRemoteObject {
    private static vendorTransferObject vendor;
    DB db = new DB();

    private vendorTransferObject() throws RemoteException {
    }
    public static vendorTransferObject getInstanceOfVendor() throws RemoteException
    {
        if(vendor==null)
        {
            vendor= new vendorTransferObject();
        }
        return vendor;
    }
    public void insertVendor(Vendor c)
    {
        db.insertVendor(c);
    }
    public void deleteVendor(int id) 
    {
        db.deleteVendor(id);
    }
    public void updateVendor(Vendor c,int id)
    {
        db.updateVendor(c, id);
    }
  

}
