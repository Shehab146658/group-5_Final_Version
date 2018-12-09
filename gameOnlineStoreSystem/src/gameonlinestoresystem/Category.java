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
import mongoDB.DB;
public class Category implements ItemComponent {
private String categoryID;
private String categoryName;
private final DB db=new DB();
private ArrayList<Item> items=db.getAllItems();

    

//private ArrayList<Item> items=new ArrayList<Item>();


  
final ItemComponent item;

    public Category(String categoryID, String categoryName, ItemComponent item) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.item = item;
        item= new ItemComponent() {

            @Override
            public void rateItem(Item i, int rate) {}
            @Override
            public void viewItemsDetails(Item i, Category c)
            {
                
            }
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public void addAnItem(Item item)
    {
      Category.add(item);
    }   
 
    public void removeItem(Item i) {
          if(i.getItemID()!=0)
          {
             Category.remove(i);
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
            }

            @Override
            public void rate(Item i) {
                 i.rateItem(i, i.getRate());
            }

    //@Override
   /* public String toString() {
        
        String result = "categoryID=" + categoryID 
                + ",  categoryName=" + categoryName
                + ", items=" + items
                + ", item=" + item + '}';
        for (int i = 0; i < items.size(); i++) {
            result += "\n   Course ID: " + items.get(i).getItemID()
                    + "\n   Course Name: " + items.get(i).getName()
                    + "\n";
        }
        return result;
    }*/

           

           
}
