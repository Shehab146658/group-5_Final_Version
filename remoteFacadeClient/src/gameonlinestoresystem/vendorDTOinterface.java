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
public interface vendorDTOinterface extends Remote {
    public void insertVendor(vendorDTOinterface c);
    public void deleteVendor(vendorDTOinterface id);
    public void updateVendor(vendorDTOinterface c,String id);
}
