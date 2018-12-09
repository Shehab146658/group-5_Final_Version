/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

/**
 *
 * @author shebo
 */
public class cashOnDelivery implements paymentMethod{
   


    @Override
    public void pay(int amount) {
       System.out.println( "Pay on Delivery" + amount);
    }
    
}
