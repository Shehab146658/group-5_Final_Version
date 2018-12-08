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
import gameonlinestoresystem.Item;
import java.util.*;
public class shoppingCart {
    ArrayList<Item> items=new ArrayList<Item>();
    public String itemID;
    public String cartID;
    public String customerID;
    public String notes;
    public paymentMethod x;

    public shoppingCart(String itemID, String cartID, String customerID, String notes) {
        this.itemID = itemID;
        this.cartID = cartID;
        this.customerID = customerID;
        this.notes = notes;
    }

    public shoppingCart() {
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public paymentMethod getX() {
        return x;
    }

    public void setX(paymentMethod x) {
        this.x = x;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public void checkOut()
    {
        
    }
    public void placeOrder()
    {
        
    }
    public void addToCart()
    {
        //return object of cart look at the class diagram
    }
    
}
