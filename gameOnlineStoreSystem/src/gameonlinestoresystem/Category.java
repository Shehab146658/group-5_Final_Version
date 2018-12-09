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
        ArrayList<Item> items = new ArrayList<Item>();
        item= new ItemComponent() {

            
           
           

            @Override
            public void viewItemsDetails() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void rate(int id, int rating) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
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
      DB db = new DB();
      db.insertItem(item);
    }   
 
    public void removeItem(Item i) 
    {
        int id = i.getItemID();
        DB db = new DB();
        db.deleteItem(id);
    }

  public Item getChild(Item i,Category c)
  {
     i.viewItemsDetails();
      return i;
  }

    

 @Override
 public void viewItemsDetails()
{
    for(int i=0;i<items.size();i++)
    {
        System.err.println("Name"+items.get(i).getName()+" "+"price"+items.get(i).getPrice()+"  "+"Customers Rating "+items.get(i).getRate());
    }
 }

@Override
public void rate(int id, int rating) 
{
    DB db = new DB();
    Item item =db.getItemByID(id);
    item.setRate(rating);
    db.deleteItem(id);
    db.insertItem(item);
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
