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


//List of all possible equipment in game
public class Equipment {
    private ArrayList<Item> list = new ArrayList<Item>();
    
    Equipment(){
        Item Sword = new Item (20, 5, 0, "Sword", "An ordinary sword for attacking");
        Item Shield = new Item (0, 0, 20, "Shield", "An ordinary shield that increased defense");
        Item Wand = new Item (10, 20, 0, "Wand", "A wand used by novice wizards");
        
        Item CuArmour = new Item (0, 10, 30, "Copper Armour", "Cheap set of armour made from copper");
        Item FeArmour = new Item (0, 20, 40, "Iron Armour", "Mid-Tiered armour made for knights");
        
        list.add(Sword);
        list.add(Shield);
        list.add(Wand);
        list.add(CuArmour);
        list.add(FeArmour);
    }
    
    //Returns the equipment object in question
    public Item getEquipment (int listNum){
        return list.get(listNum);
    }
    
}
