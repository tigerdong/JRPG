// Authors: Tiger Dong, Cathy Hua
// Date: when we finish
// Description: 

package squarepg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

abstract class Entity {
    // Variable declaration
    protected String name;
    protected int maxHealth, currentHealth;
    protected int maxMana, currentMana;
    protected int damageMax, damageMin;
    protected int gold;
    private BattleState battleState;
    private boolean finishedAttacking = false;
    private Random random = new Random();
    
    // Default constructor
    Entity() {
        name = "Untitled";
        maxHealth = 1;
        maxMana = 0;
        damageMax = 0;
        damageMin = 0;
        gold = 1000;
        battleState = BattleState.IDLE;
    }
    
    // Also constructor
    Entity(String name, int maxHealth, int maxMana, int damageMax, int damageMin, int gold) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.maxMana = maxMana;
        this.damageMax = damageMax;
        this.damageMin = damageMin;
        this.gold = gold;
        this.battleState = BattleState.IDLE;
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
    
    public int getCurrentMana(){
        return currentMana;
    }
    
    //
    public int getMaxMana() {
        return maxMana;
    }
    
    //
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
    public void setBattleState(BattleState battleState) {
        this.battleState = battleState;
        if (battleState == BattleState.ATTACKING) {
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
        switch (battleState) {
            case IDLE: // Idle in battle
                break;
            case ATTACKING: // Attack animation in battle
                battleState = BattleState.IDLE;
                finishedAttacking = true;
                break; 
        }
    }
    
    //
    public abstract void draw(Graphics g);
}
