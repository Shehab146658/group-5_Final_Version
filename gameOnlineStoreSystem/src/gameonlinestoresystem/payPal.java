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
public class payPal implements paymentMethod{
    private String PayPalNum;
    private boolean isPayed;
    private float balance;
    
    public String check() {
        if(PayPalNum.length()!=16)
            return "Invalid Number";
        else
        {
            return PayPalNum;
        }
    }

    @Override
    public void pay(int amount) {
        System.out.println("you have paid "+amount+" via paybal");
    }
}
