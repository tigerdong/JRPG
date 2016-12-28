// Authors: Tiger Dong, Cathy Hua
// Date: when we finish
// Description: 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Entity {
    // Variable declaration
    private String name;
    private int maxHealth, currentHealth;
    private int maxMana, currentMana;
    private int damageMax, damageMin;
    private int posX, posY;
    private int state = 0;
    private boolean finishedAttacking = false;
    private Random random = new Random();
    //private ArrayList inventory = new ArrayList();
    
    // Default constructor
    Entity() {
        name = "Untitled";
        maxHealth = 1;
        maxMana = 0;
        damageMax = 0;
        damageMin = 0;
        posX = 0;
        posY = 0;
    }
    
    // Also constructor
    Entity(String name, int maxHealth, int maxMana, int damageMax, int damageMin, int posX, int posY) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.maxMana = maxMana;
        this.damageMax = damageMax;
        this.damageMin = damageMin;
        this.posX = posX;
        this.posY = posY;
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
    
    //
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
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
