/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squarepg;

/**
 *
 * @author Cathy
 */
import java.util.ArrayList;

//List of the full set of possible consumables available in game;
public class Consumables {
    private ArrayList<Item> list = new ArrayList<Item>();
    
    Consumables(){
        Item potion = new Item (10, 0, "Potion", "Restores a little bit of health");
        Item elixir = new Item (0, 10, "Elixir", "Restores a little bit of mana");
        Item Mipotion = new Item (100, 0, "Mid Potion", "Restores a fair amount of health");
        Item Mielixir = new Item (0, 100, "Mid Elixir", "Restores a fair amount of mana");
        Item Restore = new Item (200, 200, "Mid Restore", "Restores health and mana");
        
        list.add(potion);
        list.add(elixir);
        list.add(Mipotion);
        list.add(Mielixir);
        list.add(Restore);
    }
    
    //returns the item to be looked up
    public Item getItem (int ListNum){
        return list.get(ListNum);
    } 

}
