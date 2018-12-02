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
    private float amount;
    private boolean isPayed;
    private float balance;
    
    public void pay(String num) {
        PayPalNum= num;
        
    }
    public String check() {
        if(PayPalNum.length()!=16)
            return "Invalid Number";
        else
        {
            return PayPalNum;
        }
    }

    @Override
    public void pay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
