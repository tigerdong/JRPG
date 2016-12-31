package SquarePG;

public class Item {
    private int gainHealth, gainMP;
    private int ATK, MAG, DEF; // ATK raises maxdamage, MAG raises maxdamage and mana, DEF raises maxhealth
    private String name;
    private String description;
    private int buyPrice, sellPrice;
    private int stock = 0;
    
    Item(){
        gainHealth = 0;
        ATK = MAG = DEF = 0;
        name = "Default Item";
        description = "NONE";
    }
    
    //for consumables
    Item (int gainHealth, int gainMP, String name, String description, int buyPrice, int sellPrice){
        this.gainHealth = gainHealth;
        this.gainMP = gainMP;
        this.name = name;
        this.description = description;
        ATK = MAG = DEF = 0;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
    
    //For Weapons and Armor
    Item (int ATK, int MAG, int DEF, String name, String description, int buyPrice, int sellPrice){
        this.ATK = ATK;
        this.MAG = MAG;
        this.DEF = DEF;
        this.name = name;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
    
    public int getStock (){
        return stock;
    }
    
    public boolean changeStock (int change){
        if (stock + change >= 0){
            stock += change;
        }
        else {
            return false;
        }
        return true;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getBuyPrice (){
        return buyPrice;
    }
    
    public int getSellPrice(){
        return sellPrice;
    }
    
    public int getGainHealth(){
        return gainHealth;
    }
    
    public int getGainMP(){
        return gainMP;
    }
    
    public int getATK (){
        return ATK;
    }
    
    public int getDEF (){
        return DEF;
    }
    
    public int getMAG () {
        return MAG;
    }
}
