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
    public void insertcustomerService(customerService c);
    public void deletecustomerService(int id);
    public customerService getcustomerServiceBySSN(int id);
    public ArrayList<customerService> getAllcustomerService();
    public void updatecustomerService(customerService c,int id);
}
