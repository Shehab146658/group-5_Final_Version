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
import RMI.dbManagerINT;
import javax.swing.JOptionPane;
import remotefacadeClient.AdminForm;
import remotefacadeClient.LoginGUI;
import remotefacadeClient.VendorForm;
import remotefacadeClient.customerServiceForm;
import remotefacadeClient.ItemsGUI;


public class MainWindowController {

    LoginGUI gui;
    Registry r;
    ItemsGUI items;
    VendorForm vendor;
    
      public MainWindowController(LoginGUI gui, Registry r, ItemsGUI items, VendorForm vendor)
    { 
        this.gui=gui;
        this.r=r;
        this.items = items;
        this.vendor = vendor;
        // This registers the button with our action listener below (the inner class)
      gui.getjButton1().addActionListener(new GetCustomerBtnAction());
      gui.getButton2().addActionListener(new Cancelbtn());
      vendor.getjButton1().addActionListener(new GetVendorBtnAction());
      vendor.getjButton3().addActionListener(new GetVendorBtnAction());
      vendor.getjButton6().addActionListener(new GetVendorBtnAction());

    }

    public MainWindowController(Registry r) {
        this.r = r;
    }
      
    class GetVendorBtnAction implements ActionListener
            {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(vendor.getjButton1().isSelected())
            {
                ItemsGUI items = new ItemsGUI();
                
                
            }
            else if(vendor.getjButton3().isSelected())
            {
                ItemsGUI items = new ItemsGUI();
                items.setVisible(true);
                vendor.setVisible(false); 
            }
            else if(vendor.getjButton6().isSelected())
            {
                vendor.setVisible(false); 
                gui.setVisible(true);
            }
            
        }
                
    }

    
      public String Cancel()
      {
          System.exit(0);
          return " ";
      }
      
      public void addItemManager() throws RemoteException, NotBoundException
      {
          dbManagerINT dbMan=(dbManagerINT)r.lookup("database");
          dbMan.addNewItem(1000, "test");
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
