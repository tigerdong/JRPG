// Authors: Tiger Dong, Cathy Hua
// Date: when we finish
// Description: Cathy you can do this

import java.util.Random;

public class Entity {
	// Variable declaration
	private String name;
	private int maxHealth, currentHealth;
	private int maxMana, currentMana;
	private int damageMax, damageMin;
	private int posX, posY;
	private random = new Random();

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
	}
	
	//
	public boolean useMana(int manaUsed) {
		currentMana -= manaUsed;
		
		if (currenMana > maxMana)
			currentMana = maxMana;
		else if (currentMana < 0)
			currentMana = 0;
		
		return (currentMana == 0) ? (false) : (true);
	}
	
	//
	public int attack() {
		return (damageMin+random.nextInt(damageMax-damageMin));
	}
	
	//
	public String getName() {
		return name;
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
	public void setPosX (int posX){
		this.posX = posX;
	}
		
	//
	public void setPosY (int posY){
		this.posY = posY;
	}
}
