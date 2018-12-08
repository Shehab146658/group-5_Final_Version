/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.util.ArrayList;

/**
 *
 * @author Omar
 */
public class OrderManager {
     ArrayList<Order> orders =new ArrayList<Order>();
    void addToOrders(Order o)
    {
        orders.add(o);
    }
    
   public void deleteFromOrders(int id)
    {
        orders.remove(id);
    }
    public void viewallOrders()
    {
        for (int i=0; i< orders.size();i++)
        {
            System.out.println("ID "+orders.get(i).getOrderID()+"status "+ orders.get(i).getOrderStatus()+"location "+orders.get(i).getLocation() );
        }
    }
}
