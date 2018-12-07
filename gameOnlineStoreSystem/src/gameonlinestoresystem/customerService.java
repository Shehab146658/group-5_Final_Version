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
    private static int observeridtracker;
    private int observerid;
    private Subject s = new Order();
    ArrayList<Ticket> Tickets = new ArrayList<Ticket>();
    ArrayList<Item> items = new ArrayList<Item>();
    public customerService(String SSN) {
        this.SSN = SSN;
    }

    public customerService(Subject sub) {
        this.s = sub;
        this.observerid = ++observeridtracker;
        s.addObserver(this);
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
    public void update(String orderstatus) {
        OrderState stat = new Order();
        
        

    }

   
}
