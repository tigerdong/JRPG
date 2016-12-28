//
//
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    private Entity hero;
    private Entity enemy;
    private GameState state = GameState.COMBAT;
    
    private boolean isEnemyTurn = false;
    private final int RED = 0;
    private final int YELLOW = 1;
    private final int BLUE = 2;
    
    public enum GameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    public GamePanel(){
        hero = new Entity();
        setBackground(Color.WHITE);
    }
    
    public boolean createCharacter (String name, int chosenClass){
        hero.setName(name);
        
        switch(chosenClass){
            case RED: // Red
                hero.setMaxHealth(300);
                hero.setMaxMana(50);
                hero.setDamageMax(50);
                hero.setDamageMin(40);
                hero.setCurrentHealth(hero.getMaxHealth());
                break;
                
            case YELLOW: // Yellow
                hero.setMaxHealth(200);
                hero.setMaxMana(100);
                hero.setDamageMax(70);
                hero.setDamageMin(60);
                hero.setCurrentHealth(hero.getMaxHealth());
                break;
                
            case BLUE: // Blue
                hero.setMaxHealth(100);
                hero.setMaxMana(300);
                hero.setDamageMax(60);
                hero.setDamageMin(50);
                hero.setCurrentHealth(hero.getMaxHealth());
                break;
                
            default: //Error
                return false;
        }
        
        hero.setPosX(0);
        hero.setPosY(0);
        init();
        
        return true;
    }
    
    public void init() {
        switch (state) {
            case COMBAT:
                
                // Sample enemy for test purposes
                enemy = new Entity("Enemy", 100, 20, 20, 15, 10, 100);
                
                break;
            case SHOP:
                break;
            case WORLDMAP:
                break;
        }
    }
    
    public void update(int action) {
        switch (state) {
            case COMBAT:
                switch (action) {
                case 1:
                    hero.setState(1);
                    isEnemyTurn = true;
                    break;
                case 2:
                    //
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
                if (hero.isFinishedAttacking()) {
                    hero.stopAttacking();
                    enemy.inflict(hero.getDamage());
                    System.out.println("Enemy is now at " + enemy.getCurrentHealth() + " HP");
                }
                if (enemy.isFinishedAttacking()) {
                    enemy.stopAttacking();
                    hero.inflict(enemy.getDamage());
                    System.out.println("Hero is now at " + hero.getCurrentHealth() + " HP");
                }
                if (isEnemyTurn) {
                    enemy.setState(1);
                    isEnemyTurn = false;
                }
                hero.update();
                enemy.update();
                break;
            case SHOP:                
                break;
            case WORLDMAP:
                break;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (state) {
            case COMBAT:
                hero.draw(g);
                enemy.draw(g);
                break;
            case SHOP:
                break;
            case WORLDMAP:
                break;
        }
    }
}
