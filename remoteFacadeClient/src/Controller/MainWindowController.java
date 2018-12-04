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
import remotefacadeClient.LoginGUI;

public class MainWindowController {

    LoginGUI gui;
    Registry r;
    
      public MainWindowController(LoginGUI gui, Registry r)
    {
        
        this.gui=gui;
        this.r=r;
        // This registers the button with our action listener below (the inner class)
      gui.getjButton1().addActionListener(new GetCustomerBtnAction());
      gui.getButton2().addActionListener(new GetCustomerBtnAction());
    }
      class GetCustomerBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
               ClientFacade facade= (ClientFacade)r.lookup("username");
                ClientFacade facade1= (ClientFacade)r.lookup("password");
               ClientFacade facade2=(ClientFacade)r.lookup("Cancel");
              String username= gui.getjTextField1().getText();
              String password=gui.getjTextField2().getText();
                gui.getjLabel1().setText(facade.Login());

                
                
            }catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
          
      }
      
      
}
