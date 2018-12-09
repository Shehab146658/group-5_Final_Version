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
import gameonlinestoresystem.dbManagerINT;


import gameonlinestoresystem.dbManagerINT;
import javax.swing.JOptionPane;
import remotefacadeClient.AdminForm;
import remotefacadeClient.CustomerItems;
import remotefacadeClient.CustomerItemsView;
import remotefacadeClient.LoginGUI;
import remotefacadeClient.VendorForm;
import remotefacadeClient.customerServiceForm;
import remotefacadeClient.ItemsGUI;

import remotefacadeClient.Payment;




public class MainWindowController {

    LoginGUI gui;
    CustomerItemsView cv;
    Registry r;
    ItemsGUI items;
    VendorForm vendor;
    Payment pay;
    CustomerItems ci;
   AdminForm admin;
      public MainWindowController(LoginGUI gui,CustomerItemsView cv, CustomerItems ci,Registry r,Payment pay)
    {
        this.ci=ci;
        this.gui=gui;
        this.r=r;
        this.cv=cv;
        this.pay=pay;
        this.admin=admin;
        // This registers the button with our action listener below (the inner class)
       gui.getjButton1().addActionListener(new GetCustomerBtnAction());
       gui.getButton2().addActionListener(new Cancelbtn());
       cv.getjButton1().addActionListener(new CategoriesBtn());
       cv.getjButton2().addActionListener(new CategoriesBtn());
       cv.getjButton3().addActionListener(new CategoriesBtn());
       cv.getjButton4().addActionListener(new CategoriesBtn());
       cv.getjButton5().addActionListener(new CategoriesBtn());
       cv.getjButton6().addActionListener(new CategoriesBtn());
       ci.jButton3().addActionListener(new PaymentBtn());
       admin.getButton4().addActionListener(null);
       admin.getButton1().addActionListener(new additemBtn());
      // pay.jButton1().addActionListener(new Order());
    }
     
    
      public MainWindowController(LoginGUI gui, Registry r, ItemsGUI items,Payment pay, VendorForm vendor)
    { 
        this.gui=gui;
        this.r=r;
        this.items = items;
        this.vendor = vendor;
        this.pay=pay;
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

    class AdminViewItemBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           
        }
        
    }
    class additemBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
               
               
               
               dbManagerINT di=( dbManagerINT)r.lookup("add item");
                                                         
                              admin.getLabel1().setText(   di.addNewItem(12,"fatma"));
                            System.out.println("item added");
                              JOptionPane.showMessageDialog(admin, "item added successfully");

                               
                   
            }catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
      class PaymentBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
        if (ci.jRadioButton1().isSelected()||ci.jRadioButton2().isSelected()||ci.jRadioButton3().isSelected()||ci.jRadioButton4().isSelected()||ci.jRadioButton5().isSelected()||ci.jRadioButton6().isSelected()||ci.jRadioButton7().isSelected()||ci.jRadioButton8().isSelected()||ci.jRadioButton9().isSelected())
            {
            //Payment pay=new Payment();
            pay.setLocationRelativeTo(null);
                  pay.setVisible(true);
                  ci.dispose();
            }
        else{
            JOptionPane.showMessageDialog(ci, "You must select an item ");
            
        }
        }
          
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


      public void CategoryBtn()
      {
         // if(cv.getjButton1().)
             {
                 CustomerItems ci= new CustomerItems();
                 ci.setLocationRelativeTo(null);
                  ci.setVisible(true);
                  cv.dispose();
             }
          
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

      class CategoriesBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
             CategoryBtn();
        }
      }

      
      class GetCustomerBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
               ClientFacade facade= (ClientFacade)r.lookup("username");
                ClientFacade facade1= (ClientFacade)r.lookup("password");


                 // gui.getjLabel5().setTciext(facade.Login());
               

                
                 // gui.getjLabel5().setText(facade.Login());

              
              if(gui.jRadioButton1().isSelected())
              {
                String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                
                 gui.getjLabel2().setText(facade.verifyLogin(username, password));
               
                  cv.setLocationRelativeTo(null);
                 cv.setVisible(true);
                 gui.dispose();
                
                 //JOptionPane.showMessageDialog(gui, "Login Successful, Welcome ");
                 System.out.println("Customer Logged in sucessfully");
              }
              else if (gui.jRadioButton2().isSelected())
              {
                   String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                 gui.getjLabel2().setText(facade.verifyLogin(username, password));
                 VendorForm vf= new VendorForm();
                 vf.setLocationRelativeTo(null);
                  vf.setVisible(true);
                  gui.dispose();
                 System.out.println("Vendor Logged in sucessfully");
                  
              }else if(gui.jRadioButton3().isSelected())
              {
                    String username= gui.getjTextField1().getText();
                String password=String.valueOf(gui.getJpasswordField().getPassword());
                 gui.getjLabel2().setText(facade.verifyLogin(username, password));
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
                 gui.getjLabel2().setText(facade.verifyLogin(username, password));
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
