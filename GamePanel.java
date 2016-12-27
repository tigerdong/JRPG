//
//
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Set;

public class GamePanel extends JPanel {
    private Entity hero;
    private Entity Enemy;
    private gameState state = gameState.COMBAT;
    
    private final int RED = 0;
    private final int YELLOW = 1;
    private final int BLUE = 2;
    
    public enum gameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    public GamePanel(){
        hero = new Entity();
        setBackground(Color.WHITE);
    }
    
    public boolean createCharacter (String name, int choosenClass){
        hero.setName(name);

        switch(choosenClass){
            case RED: // Red
                hero.setMaxHealth(300);
                hero.setMaxMana(50);
                hero.setDamageMax(50);
                hero.setDamageMin(40);
                break;
                
            case YELLOW: // Yellow
                hero.setMaxHealth(200);
                hero.setMaxMana(100);
                hero.setDamageMax(70);
                hero.setDamageMin(60);
                break;
                
            case BLUE: // Blue
                hero.setMaxHealth(100);
                hero.setMaxMana(300);
                hero.setDamageMax(60);
                hero.setDamageMin(50);
                break;
                
            default: //Error
                return false;
        }
        
        hero.setPosX(0);
        hero.setPosY(0);
        init();
        
        return true;
    }
    
    private void setState(gameState state) {
        this.state = state;
    }
    
    public void init() {
        switch (state) {
            case COMBAT:
                
                // Sample enemy for test purposes
                Enemy = new Entity("Enemy", 50, 20, 20, 15, 10, 100);
                
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
                    //hero.setState(1);
                    break;
                case 2:
                    //
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
                break;
            case SHOP:                
                break;
            case WORLDMAP:
                break;
        }
    }
    
    public void paintComponent(Graphics g) {
        switch (state) {
            case COMBAT:
                break;
            case SHOP:
                break;
            case WORLDMAP:
                break;
        }
    }
}
