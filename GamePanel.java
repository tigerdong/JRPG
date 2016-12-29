//
//
//

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener{
    private Entity hero;
    private Entity enemy;
    private GameState state = GameState.WORLDMAP;
    
    private boolean isEnemyTurn = false;
    private final int RED = 0;
    private final int YELLOW = 1;
    private final int BLUE = 2;
    
    private Image test;
    private int mapNumber = 5;
    
    public GamePanel(){
        hero = new Entity();
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public GameState getState(){
        return state;
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
        
        hero.setPosX(100);
        hero.setPosY(100);
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
                this.requestFocus(true);
                break;
        }
    }
    
    public void update(int action) {
        if (action == 4){
            switch (state){
                case COMBAT: case SHOP:
                    state = GameState.WORLDMAP;
                    break;
                case WORLDMAP:
                    state = GameState.SHOP;
                    break;
            }
            init();        
        }
        else {
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
                if (enemy.getCurrentHealth() == 0){
                    state = GameState.WORLDMAP;
                    init();
                }
                if (hero.getCurrentHealth() == 0){
                    System.out.println(hero.getName() + " is DEAD!");
                    System.exit(0);
                }
                break;
            case SHOP:
                switch (action){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                }
                break;
            case WORLDMAP:
                this.requestFocus(true);
                switch (action){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                }
                break;
            }
        }
    }
    
    public void up (){
        if (hero.getPosY() <= 0 &&(mapNumber >=4)){
            mapNumber -= 3;
            hero.setPosY(450);
        }
        else if (hero.getPosY() > 0){
            hero.setPosY(hero.getPosY() - 50);
        }

        if (stepTrigger()){
            state = GameState.COMBAT;
            init();
        }
    }
    
    public void down(){
        if (hero.getPosY() >=450 &&(mapNumber <7)){
            mapNumber += 3;
            hero.setPosY(0);
        }
        else if (hero.getPosY() < 450){
            hero.setPosY(hero.getPosY() + 50);
        }
        
        if (stepTrigger()){
            state = GameState.COMBAT;
            init();
        }
    }
    public void left(){
        if (hero.getPosX() <= 0 &&(mapNumber %3 != 1)){
            mapNumber--;
            hero.setPosX(450);
        }
        else if (hero.getPosX() >= 50){
            hero.setPosX(hero.getPosX() - 50);
        }
        
        if (stepTrigger()){
            state = GameState.COMBAT;
            init();
        }
    }
    public void right (){
        if (hero.getPosX() >= 450 &&(mapNumber% 3 != 0)){
            mapNumber++;
            hero.setPosX(0);
        }
        else if (hero.getPosX() < 450){
            hero.setPosX(hero.getPosX() + 50);
        }
        
        if (stepTrigger()){
            state = GameState.COMBAT;
            init();
        }
    }
    
    public void keyPressed (KeyEvent e){
        if (state == GameState.WORLDMAP){
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
                up();
            }
            if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
                down();
            }
            if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
                left();
            }
            if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
                right();
            }
        }
    }
    
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

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
                ImageIcon map;
                Graphics2D g2d = (Graphics2D)g;
                switch(mapNumber){
                    case 1:
                        map = new ImageIcon(this.getClass().getResource("Test1.png"));
                        break;
                    case 2:
                        map = new ImageIcon(this.getClass().getResource("Test2.png"));
                        break;
                    case 3:
                        map = new ImageIcon(this.getClass().getResource("Test3.png"));
                        break;
                    case 4:
                        map = new ImageIcon(this.getClass().getResource("Test4.png"));
                        break;
                    case 5:
                        map = new ImageIcon(this.getClass().getResource("Test5.png"));
                        break;
                    case 6:
                        map = new ImageIcon(this.getClass().getResource("Test6.png"));
                        break;
                    case 7:
                        map = new ImageIcon(this.getClass().getResource("Test7.png"));
                        break;
                    case 8:
                        map = new ImageIcon(this.getClass().getResource("Test8.png"));
                        break;
                    case 9:
                        map = new ImageIcon(this.getClass().getResource("Test9.png"));
                        break;
                    default:
                        map = new ImageIcon(this.getClass().getResource("Test1.png"));
                }
                g2d.drawImage(map.getImage(), 0, 0, this);
                
                ImageIcon thing = new ImageIcon(this.getClass().getResource("Test.png"));
                test = thing.getImage();
        

                g2d.drawImage(test, hero.getPosX(), hero.getPosY(), this);
                break;
        }
    }
    
    private boolean stepTrigger (){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
        
        if (randomNum < 20){
            return true;
        }
        return false;
    }
}

