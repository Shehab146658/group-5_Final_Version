/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem ;

/**
 *
 * @author meran
 */
public class vendorTransferObject extends Remote {
    private String itemID;
    private String Description;
    private String vendorID;
    private Vendor v;

    public vendorTransferObject(String itemID, String Description, String vendorID, Vendor v) {
        this.itemID = itemID;
        this.Description = Description;
        this.vendorID = vendorID;
        this.v = v;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
    
}
