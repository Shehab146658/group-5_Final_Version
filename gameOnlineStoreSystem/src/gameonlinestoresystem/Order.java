/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Order implements OrderState , Subject{
    private String OrderID;
    private String OrderStatus;
    private String location;
    private ArrayList<Observer> observers ;
    private OrderManager mang = new OrderManager();
    

    public Order(String OrderID, String OrderStatus, String location) {
        this.OrderID = OrderID;
        this.OrderStatus = OrderStatus;
        this.location = location;
        observers = new ArrayList<Observer>();  
    }

    public Order() {
    }
    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyObserver(); 
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }
    
    public void notifyObserver()
    {
        for (Observer observer : observers )
        {
            observer.update(this.OrderStatus);
        }
    }

    public String getOrderStatus() {
        return OrderStatus;
        
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
        notifyObserver();
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
    public void addObserver(Observer o)
    {
        observers.add(o);
    }
    public void removeObserver(Observer o)
    {
        int observerindex = observers.lastIndexOf(o);
        observers.remove(observerindex);
    }

    @Override
    public String getOrderStatus(int orderID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
