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
public class Item implements ItemComponent  {

private int itemID=0;
private int rate;
private String name;
private shoppingCart s1;
private int price;

    public Item( int price , String name) {
        this.itemID = itemID+1;
        this.price = price;
        this.name = name;
    }




public int getItemID() {
    return itemID;
}

public int getRate() {
    return rate;
}

public void setRate(int rate) {
    this.rate = rate;
}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    i.getPrice();
}
}

