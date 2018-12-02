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
public class ProxyOrder extends Order{

    public ProxyOrder(String OrderID, String OrderStatus, String location) {
        super(OrderID, OrderStatus, location);
    }   
    
    public String getOrderID() 
    {
      Order O = null;
      return O.getOrderID();
    }
    
    public String getOrderStatus() {
        Order O =null;
        return O.getOrderStatus();
    }
    
}
