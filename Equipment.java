package squarepg;

import java.util.ArrayList;

//List of all possible equipment in game
public class Equipment {
    private ArrayList<Item> list = new ArrayList<Item>();
    private Item sword = new Item (20, 5, 0, "Sword", "An ordinary sword for attacking", 1000, 500);
    private Item shield = new Item (0, 0, 100, "Shield", "An ordinary shield that increased defense", 1000, 500);
    private Item wand = new Item (10, 20, 0, "Wand", "A wand used by novice wizards", 1000, 500);
    private Item bow = new Item (30, 10, 0, "Bow", "A bow used buy novice archers", 1000, 500);
        
    private Item cuArmour = new Item (0, 10, 300, "Copper Armour", "Cheap set of armour made from copper", 2000, 500);
    private Item feArmour = new Item (0, 20, 400, "Iron Armour", "Mid-Tiered armour made for knights", 3000, 500);
    
    Equipment(){
        list.add(sword);
        list.add(shield);
        list.add(wand);
        list.add(bow);
        list.add(cuArmour);
        list.add(feArmour);
    }
    
    //Returns the equipment object in question
    public Item getEquipment (int listNum){
        return list.get(listNum);
    }
}
