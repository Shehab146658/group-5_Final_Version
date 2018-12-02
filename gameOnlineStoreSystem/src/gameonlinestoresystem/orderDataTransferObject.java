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
public class orderDataTransferObject extends Remote {
    private String orderID;
    private String status;

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
