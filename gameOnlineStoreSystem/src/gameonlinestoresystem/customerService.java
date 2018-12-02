/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

/**
 *
 * @author Dell
 */
import java.util.*;
public class customerService implements Observer , AddTicket  {
    public String SSN;
    ArrayList<Ticket> Tickets = new ArrayList<Ticket>();
    ArrayList<Item> items = new ArrayList<Item>();
    public customerService(String SSN) {
        this.SSN = SSN;
    }

    public customerService() {
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void getTickects() 
    {  
        for (int i = 0; i < Tickets.size();i++ )
        {
            System.out.println(Tickets.get(i).ID + "  " +Tickets.get(i).getDescription() );
        }
    }
    public void getTickectsByID(int id) 
    {
        System.out.println(Tickets.get(id).ID + "  " +Tickets.get(id).getDescription() );
    }

    
    @Override
    public void setTickect( Ticket t) {
        Tickets.add(t);
    }
    public void closeTicket(int id)
    {
        Tickets.remove(id);
    }
    public void update()
    {
        
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
