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
public class CreditCard implements paymentMethod{
    private String creditCardNumber;
    private float amount;
    private boolean isPayed;
    private float balance;
    @Override
    public void pay(int amount) {
       System.out.println(""+amount+"have my withdrwan from your criedt");
    }
    public boolean validateCard()
    {
        return true;
    }
    
}
