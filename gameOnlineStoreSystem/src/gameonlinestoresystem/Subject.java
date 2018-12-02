/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;

import java.util.ArrayList;

/**
 *
 * @author shebo
 */
public interface Subject {
    ArrayList<Observer> observers=new ArrayList<>();
    
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
