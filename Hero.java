//
//
//

package SquarePG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hero extends Entity {
    private ImageIcon heroAvatar;
    private GameState gameState = GameState.WORLDMAP;
    private Consumables consumables = new Consumables();
    private Equipment equipment = new Equipment();
    private int posX, posY;
    
    Hero() {
        super();
        posX = 100;
        posY = 100;
    }
    
    Hero(String name, int maxHealth, int maxMana, int damageMax, int damageMin, int posX, int posY, int gold) {
        super(name, maxHealth, maxMana, damageMax, damageMin, gold);
        this.posX = posX;
        this.posY = posY;
    }
    
    // buying equipment will automatically be equipped, only one of each kind can be bought
    public boolean buyEquipment (int equipNum, int numBought){
        if (equipment.getItem(equipNum).getBuyPrice() > gold || equipment.getItem(equipNum).getStock() > 0 || numBought != 1){
            return false;
        } else {
            equipment.getItem(equipNum).changeStock(numBought);
            gold -= equipment.getItem(equipNum).getBuyPrice();
            maxHealth += equipment.getItem(equipNum).getDEF();
            damageMax += equipment.getItem(equipNum).getATK();
            damageMin += equipment.getItem(equipNum).getATK();
            maxMana += equipment.getItem(equipNum).getMAG();
        }
        return true;
    }
    
    public boolean sellEquipment(int equipNum){
        if (equipment.getItem(equipNum).getStock() < 1){
            System.out.println("How do you sell something you don't have?");
            return false;
        }
        else {
            maxHealth -= equipment.getItem(equipNum).getDEF();
            damageMax -= equipment.getItem(equipNum).getATK();
            damageMin -= equipment.getItem(equipNum).getATK();
            maxMana -= equipment.getItem(equipNum).getMAG();
            equipment.getItem(equipNum).changeStock(-1);
            gold += equipment.getItem(equipNum).getSellPrice();
        }
        return true;
    }
    
    public boolean buyConsumables(int itemNum, int numBought){
        if (numBought*consumables.getItem(itemNum).getBuyPrice() > gold){
            System.out.println("Sorry, debt does not exist in this game");
            return false;
        }
        else {
            consumables.getItem(itemNum).changeStock(numBought);
            gold -= consumables.getItem(itemNum).getBuyPrice()*numBought;
        }
        return true;
    }
    
    public boolean sellConsumables(int itemNum, int numSell){
        if (numSell > consumables.getItem(itemNum).getStock()){
            System.out.println("Can't sell something you don't have");
            return false;
        }
        else {
            consumables.getItem(itemNum).changeStock(-1*numSell);
            gold += consumables.getItem(itemNum).getSellPrice()*numSell;
        }
        return true;
    }
    
    public boolean gainGold (int income){
        if (gold + income >= 0){
            gold += income;
        }
        else {
            gold = 0;
            return false;
        }
        return true;
    }
    
    //
    public void setHeroAvatar(int colour) {
        switch (colour) {
            case 0:
                heroAvatar = new ImageIcon(this.getClass().getResource("red.png"));
                break;
            case 1:
                heroAvatar = new ImageIcon(this.getClass().getResource("yellow.png"));
                break;
            case 2:
                heroAvatar = new ImageIcon(this.getClass().getResource("blue.png"));
                break;
        }
    }
    
    //
    public Consumables getConsumables(){
        return consumables;
    }
    
    //
    public Item getConsumables(int itemNum){
        return consumables.getItem(itemNum);
    }
    
    //
    public Equipment getEquipment(){
        return equipment;
    }
    
    //
    public Item getEquipment(int itemNum){
        return equipment.getItem(itemNum);
    }
    
    // 
    public void setPosX(int posX) {
        this.posX = posX;
    }
    
    //
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    //
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    
    //
    public int getPosX() {
        return posX;
    }
    
    //
    public int getPosY() {
        return posY;
    }
    
    //
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        switch (gameState) {
            case COMBAT:
                g2d.drawImage(heroAvatar.getImage(), 350, 250, null);
                break;
            case WORLDMAP:
                g2d.drawImage(heroAvatar.getImage(), posX, posY, null);
                break;
        }
    }
}
