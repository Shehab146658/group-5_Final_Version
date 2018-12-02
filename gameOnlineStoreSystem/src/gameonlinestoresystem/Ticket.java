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
public class Ticket {
    public String ID;
    public String Description;

    public Ticket(String ID, String Description) {
        this.ID = ID;
        this.Description = Description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public void addTickects(String ID , String Description)
    {
        AddTicket add = new customerService();
        Ticket t = new Ticket(ID,Description);
        add.setTickect(t);  
    }  
    public void getTickectsByID(int TicketID)
    {
        customerService c = new customerService();
        c.getTickectsByID(TicketID);
    }
    public void retriveAll(){
        customerService c = new customerService();
         c.getTickects();     
    }
}
