/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotefacadeClient;

/**
 *
 * @author Dell
 */
import Controller.MainWindowController;
import RMI.ClientFacade;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RemoteControllerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws RemoteException,NotBoundException  {
        LoginGUI GUI=new LoginGUI();
        
        GUI.setLocationRelativeTo(null); // This makes the window appears centered
        GUI.setVisible(true); // This shows the gui
        
       // vf.setVisible(true);
        // TODO code application logic here
          // Connect to RMI Registry
        Registry reg = LocateRegistry.getRegistry(1099);
         // Get the remote facade reference
       MainWindowController control = new MainWindowController(GUI, reg);
       
        
        // Print 
       // System.out.println("The items are: ");
         
       

       
        
    }
    
}
