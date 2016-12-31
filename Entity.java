package SquarePG;

// Authors: Tiger Dong, Cathy Hua
// Date: when we finish
// Description: 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Entity {
    // Variable declaration
    private String name;
    private int maxHealth, currentHealth;
    private int maxMana, currentMana;
    private int damageMax, damageMin;
    private int posX, posY;
    private int gold;
    private int state = 0;
    private boolean finishedAttacking = false;
    private Random random = new Random();
    private Consumables consumables = new Consumables();
    private Equipment equipment = new Equipment();
    
    // Default constructor
    Entity() {
        name = "Untitled";
        maxHealth = 1;
        maxMana = 0;
        damageMax = 0;
        damageMin = 0;
        posX = 100;
        posY = 100;
        gold = 1000;
    }
    
    // Also constructor
    Entity(String name, int maxHealth, int maxMana, int damageMax, int damageMin, int posX, int posY, int gold) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.maxMana = maxMana;
        this.damageMax = damageMax;
        this.damageMin = damageMin;
        this.posX = posX;
        this.posY = posY;
        this.gold = gold;
    }
    
    //buying equipment will automatically be equipt, only one of each kind can be bought
    public boolean buyEquipment (int equipNum, int numBought){
        if (equipment.getItem(equipNum).getBuyPrice()> gold || equipment.getItem(equipNum).getStock() > 0 || numBought != 1){
            return false;
        }
        else{
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
    public boolean inflict(int damageTaken) {
        currentHealth -= damageTaken;
        
        if (currentHealth > maxHealth)
            currentHealth = maxHealth;
        else if (currentHealth < 0)
            currentHealth = 0;
        
        return (currentHealth == 0) ? (false) : (true);
    }
    
    //
    public boolean heal(int amountHealed) {
        inflict(-amountHealed);
        return true;
    }
    
    //
    public boolean useMana(int manaUsed) {
        currentMana -= manaUsed;
        
        if (currentMana > maxMana)
            currentMana = maxMana;
        else if (currentMana < 0)
            currentMana = 0;
        
        return (currentMana == 0) ? (false) : (true);
    }
    
    public Consumables getConsumables(){
        return consumables;
    }
    
    public Item getConsumables(int itemNum){
        return consumables.getItem(itemNum);
    }
    
    public Equipment getEquipment(){
        return equipment;
    }
    
    public Item getEquipment(int itemNum){
        return equipment.getItem(itemNum);
    }
    //
    public int getDamage() {
        return (damageMin+random.nextInt(damageMax-damageMin));
    }
    
    //
    public String getName() {
        return name;
    }
    
    //
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    //
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int getCurrentMana(){
        return currentMana;
    }
    
    //
    public int getMaxMana() {
        return maxMana;
        
    }
    
    //
    public int getPosX() {
        return posX;
    }
    
    //
    public int getPosY() {
        return posY;
    }
    
    public int getGold(){
        return gold;
    }
    
    //
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    
    public void setCurrentMana(int currentMana){
        this.currentMana = currentMana;
    }
    
    //
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth; 
    }
    
    //
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    
    //
    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }
    
    //
    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
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
    public void setState(int state) {
        this.state = state;
        if (state == 1) {
            finishedAttacking = false;
        }
    }
    
    public boolean isFinishedAttacking() {
        return finishedAttacking;
    }
    
    public void stopAttacking() {
        finishedAttacking = false;
    }
    
    public void update() {
        switch (state) {
            case 0: // Idle in battle
                break;
            case 1:
                state = 0;
                finishedAttacking = true;
                break; // Attack animation in battle
            case 2:
                break;
        }
    }
    
    //
    public void draw(Graphics g) {
        
    }
}
