/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Dell
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import RMI.ClientFacade;
import remotefacadecustomerclient.CustomerLoginGUI;

public class MainWindowController {

    CustomerLoginGUI gui;
    Registry r;
    
      public MainWindowController(CustomerLoginGUI gui, Registry r)
    {
        
        this.gui=gui;
        this.r=r;
        // This registers the button with our action listener below (the inner class)
     //  gui.getjButton1().addActionListener();
    }
      class GetCustomerBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
                ClientFacade facade= (ClientFacade)r.lookup("customer");
               String customer = gui.getjTextField1().getText();

                
                
            }catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
          
      }
      
      
}
