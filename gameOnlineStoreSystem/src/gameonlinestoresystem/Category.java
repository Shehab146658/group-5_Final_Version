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
public class Category implements ItemComponent {
public String categoryID;
ArrayList<Item> items=new ArrayList<Item>();

final ItemComponent item;
    public Category(String categoryID) {
        this.categoryID = categoryID;
        item= new ItemComponent() {

            @Override
            public void rateItem(Item i, int rate) {}
            @Override
            public void viewItemsDetails(Item i, Category c) {}
            @Override
            public void rate(Item i) {}
        };
       
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void add(Item i) {
       if(i.getItemID()==0)
       {
           add(i);
       }
    }

   
   
    
    public void remove(Item i) {
          if(i.getItemID()!=0)
          {
              remove(i);
          }
        
    }

  public Item getChild(Item i,Category c)
  {
     i.viewItemsDetails(i, c);
      return i;
  }

    @Override
            public void rateItem(Item i, int rate) {
                  i.getItemID();
        switch(rate)
        {
            case 1:
              
                System.out.println("very bad");
                break;
            case 2:
                System.out.println("bad");
                break;
            case 3:
                System.out.println("Good");
                break;
            case 4:
                System.out.println("very good");
                break;
            case 5:
                System.out.println("Perfect");
                break;
        }
            }

            @Override
            public void viewItemsDetails(Item i, Category c) {
              c.getCategoryID();
              i.getItemID();
              i.getRate();
              i.getPrice();
              
            }

            @Override
            public void rate(Item i) {
                 i.rateItem(i, i.getRate());
            }

           

           
}
