/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

/**
 *
 * @author Dell
 */
public class Order implements OrderState{
    public String OrderID;
    public String OrderStatus;
    public String location;

    public Order(String OrderID, String OrderStatus, String location) {
        this.OrderID = OrderID;
        this.OrderStatus = OrderStatus;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
    
    public void trackOrder(int orderID)
    {
        OrderState trackOrder = new Customer();
        trackOrder.getOrderStatus( orderID );
    }
    public void updateStatus(String status)
    {
        this.OrderStatus = status;
        notifyObserver();    
    }
    public void addObserver()
    {       
    }
    public void removeObserver()
    {      
    }
    public void notifyObserver()
    { 
    }

    @Override
    public String getOrderStatus(int orderID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
