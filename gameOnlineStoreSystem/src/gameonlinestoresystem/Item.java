package gameonlinestoresystem;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Dell
*/
//shehab testing
public class Item implements ItemComponent  {

public String itemID;
public int rate;
public shoppingCart s1;

public Item(String itemID, int rate) {
    this.itemID = itemID;
    this.rate = rate;
}

public String getItemID() {
    return itemID;
}

public void setItemID(String itemID) {
    this.itemID = itemID;
}

public int getRate() {
    return rate;
}

public void setRate(int rate) {
    this.rate = rate;
}



public void rateItem(Item i, int rate)
{
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

public void rate(Item i)
{
   i.rateItem(i, rate);
}

public void viewItemsDetails(Item i, Category c) {
    c.getCategoryID();
    i.getItemID();
    i.getRate();
}
}

