/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author meran
 */
public interface customerServiceInterface extends Remote{
    public void insertcustomerService(customerServiceInterface c);
    public void deletecustomerService(customerServiceInterface id);
    public customerServiceInterface getcustomerServiceBySSN(String id);
    public ArrayList<customerServiceInterface> getAllcustomerService();
    public void updatecustomerService(customerServiceInterface c,String id);
}
