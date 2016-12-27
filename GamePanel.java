//
//
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Set;

public class GamePanel extends JPanel {
    private Entity Hero;
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
        Hero = new Entity();
        setBackground(Color.WHITE);
    }
    
    public boolean createCharacter (String name, int choosenClass){
        Hero.setName(name);

        switch(choosenClass){
            case RED: // Red
                Hero.setMaxHealth(300);
                Hero.setMaxMana(50);
                Hero.setDamageMax(50);
                Hero.setDamageMin(40);
                break;
                
            case YELLOW: // Yellow
                Hero.setMaxHealth(200);
                Hero.setMaxMana(100);
                Hero.setDamageMax(70);
                Hero.setDamageMin(60);
                break;
                
            case BLUE: // Blue
                Hero.setMaxHealth(100);
                Hero.setMaxMana(300);
                Hero.setDamageMax(60);
                Hero.setDamageMin(50);
                break;
                
            default: //Error
                return false;
        }
        
        Hero.setPosX(0);
        Hero.setPosY(0);
        init();
        
        return true;
    }
    
    public void setState(gameState state) {
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
        switch (state){
            case COMBAT:
                if (action == 0){
                
                };
                break;
            case SHOP:                
                break;
            case WORLDMAP:
                break;
        }
    }
    
    public void paintComponent(Graphics g) {
        switch(state) {
            case COMBAT:
                break;
            case SHOP:
                break;
            case WORLDMAP:
                break;
        }
    }
}
