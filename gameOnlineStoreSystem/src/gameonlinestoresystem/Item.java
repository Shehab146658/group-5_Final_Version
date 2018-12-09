package gameonlinestoresystem;

import mongoDB.DB;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Dell
*/
public class Item implements ItemComponent  {

private static int itemID;
private String name; 
private int rate;
private int price;

public Item(int price, String name) {
    this.itemID = itemID+1;
    this.price = price;
    this.name = name;
}

public int getItemID() {
    return itemID;
}

public void setItemID(int itemID) {
    this.itemID = itemID;
}

public int getRate() {
    return rate;
}

public void setRate(int rate) {
    this.rate = rate;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




public void rate(int id, int rating) 
{
    DB db = new DB();
    Item item =db.getItemByID(id);
    item.setRate(rating);
    db.deleteItem(id);
    db.insertItem(item);
}



    @Override
    public void viewItemsDetails()
    {
        
    }


}
