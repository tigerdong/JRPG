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
public class Item {
    private int gainHealth, gainMP;
    private int ATK, MAG, DEF;
    private String name;
    private String description;
    
    Item(){
        gainHealth = 0;
        ATK = MAG = DEF = 0;
        name = "Default Item";
        description = "NONE";
    }
    
    //for consumables
    Item (int gainHealth, int gainMP, String name, String description){
        this.gainHealth = gainHealth;
        this.gainMP = gainMP;
        this.name = name;
        this.description = description;
        ATK = MAG = DEF = 0;
    }
    
    //For Weapons and Armor
    Item (int ATK, int MAG, int DEF, String name, String description){
        this.ATK = ATK;
        this.MAG = MAG;
        this.DEF = DEF;
        this.name = name;
        this.description = description;
    }
    
}
