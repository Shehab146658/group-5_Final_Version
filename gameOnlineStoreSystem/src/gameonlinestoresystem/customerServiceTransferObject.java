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
public class customerServiceTransferObject extends Remote{
    private String csutomerServiceID;
    private String Message;
    private customerService x;

    public customerServiceTransferObject(String csutomerServiceID, String Message) {
        this.csutomerServiceID = csutomerServiceID;
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
//    public String getOrderID(){
//        
//    }
//    public String getStatus()
//    {
//      
//    }    
}
