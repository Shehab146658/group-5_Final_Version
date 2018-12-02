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
    public float amount;
    public Boolean isPaid;


    @Override
    public void pay() {
       System.out.println( "Pay on Delivery" + this.amount);
    }
    
}
