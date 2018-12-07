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
import javax.swing.JOptionPane;
import remotefacadeClient.AdminForm;
import remotefacadeClient.LoginGUI;
import remotefacadeClient.VendorForm;
import remotefacadeClient.customerServiceForm;

public class MainWindowController {

    LoginGUI gui;
    Registry r;
    
      public MainWindowController(LoginGUI gui, Registry r)
    {
        
        this.gui=gui;
        this.r=r;
        // This registers the button with our action listener below (the inner class)
      gui.getjButton1().addActionListener(new GetCustomerBtnAction());
     gui.getButton2().addActionListener(new Cancelbtn());
    }
      public String Cancel()
      {
          System.exit(0);
          return " ";
      }
      class Cancelbtn implements ActionListener
        {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                ClientFacade facade2=(ClientFacade)r.lookup("Cancel");
                                gui.getjLabel2().setText(Cancel());
                   
            }catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
          
      }
      class GetCustomerBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
               ClientFacade facade= (ClientFacade)r.lookup("username");
                ClientFacade facade1= (ClientFacade)r.lookup("password");
                 // gui.getjLabel5().setText(facade.Login());
            
              
              if(gui.jRadioButton1().isSelected())
              {
                String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                 gui.getjLabel2().setText(facade.Login());
                 JOptionPane.showMessageDialog(gui, "Login Successful, Welcome ");
                 System.out.println("Customer Logged in sucessfully");
              }
              else if (gui.jRadioButton2().isSelected())
              {
                   String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                 gui.getjLabel2().setText(facade.Login());
                 VendorForm vf= new VendorForm();
                 vf.setLocationRelativeTo(null);
                  vf.setVisible(true);
                  gui.dispose();
                 System.out.println("Vendor Logged in sucessfully");
                  
              }else if(gui.jRadioButton3().isSelected())
              {
                    String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                 gui.getjLabel2().setText(facade.Login());
                 AdminForm ad= new AdminForm();
                 ad.setLocationRelativeTo(null);
                  ad.setVisible(true);
                  gui.dispose();
                  System.out.println("Admin Logged in sucessfully");

              }
              else if(gui.jRadioButton4().isSelected())
              {
                    String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                 gui.getjLabel2().setText(facade.Login());
                 customerServiceForm vf= new customerServiceForm();
                 vf.setLocationRelativeTo(null);
                  vf.setVisible(true);
                  gui.dispose();
                 System.out.println("Customer Service Logged in sucessfully");

                  
              }
              else{
                   JOptionPane.showMessageDialog(gui, "Account does not exist");

              }

                
                
            }catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
          
      }
      
      
}
