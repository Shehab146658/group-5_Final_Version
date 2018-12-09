/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Dell
 */
public class Customer extends Person implements Observer,paymentMethod, OrderState {
    private int customerID;
    shoppingCart sc = new shoppingCart();

    public Customer(int customerID, String address, String firstName, String lastName, String mobileNumber, String email, String username, String password) {
        super(address, firstName, lastName, mobileNumber, email, username, password);
        this.customerID = customerID;
    }

    
    

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
   
    public void viewItems()
    {
        View_item viewer = systemAdmin.getInstanceOfAdmin();
        viewer.viewItems();
    }
    public void createTicket(String customerID,String Description)
    {
//        AddTicket add = new customerService();
        Ticket t = new Ticket(customerID,Description);
      //  add.setTickect(t);
        
    }
    
    public void update()//observer
    {
        
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pay(int x) {
                     CreditCard c= new CreditCard();
                     payPal p= new payPal();
                     cashOnDelivery cash=new cashOnDelivery();
                     System.out.println("press 1 for credit card payment , press 2 for pay pal payment ,press 3 for cash on delivery payment");
                     switch(x)
                     {    
                         case 1:
                             c.pay(x);
                             System.out.println("payment of credit card is done");
                             break;
                         case 2:
                             p.pay(x);
                              System.out.println("payment of pay pal is done");
                             break;
                         case 3:
                             cash.pay(x);
                              System.out.println("payment of cash on delivery is done");
                             break;
                         default:
                            break;
                             
                     }
    }

    @Override
    public String getOrderID() {
               Order o=new Order();
               return "order id is "+o.getOrderID();
        }

    @Override
    public String getOrderStatus(int orderID) {
          Order o=new Order();
               return "order id is "+o.getOrderStatus();
    }
}
