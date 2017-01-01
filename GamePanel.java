package squarepg;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener {
    private Hero hero;
    private Entity enemy;
    private GameState gameState = GameState.WORLDMAP;
    private Background background = new Background();
    private boolean isEnemyTurn = false;
    private int mapNumber = 9;
    
    private JPanel worldMapMenu = new JPanel();
    private JLabel mapMessage = new JLabel("");
    
    private Consumables consumablesList = new Consumables();
    private Equipment equipmentList = new Equipment();
    
    private JPanel shopMenu = new JPanel();
    private JLabel message = new JLabel("Hello there, what would you like to buy?");
    private JLabel itemsSale = new JLabel("");
    private int previousButtonPressed = 0;
    
    private final int RED = 0;
    private final int YELLOW = 1;
    private final int BLUE = 2;
    
    public GamePanel() {
        hero = new Hero();
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        changeMap();
        shopMenu.setPreferredSize(new Dimension (450, 100));
        shopMenu.setLayout(new GridLayout(0, 1));
        shopMenu.setBackground(Color.WHITE);
        shopMenu.setVisible(false);
        add(shopMenu);
        
        worldMapMenu.setPreferredSize(new Dimension(450, 300));
        worldMapMenu.setVisible(false);
        worldMapMenu.setLayout(new GridLayout(0, 1));
        worldMapMenu.setBackground(Color.WHITE);
        //worldMapMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(worldMapMenu);
        
    }
    
    public GameState getState(){
        return gameState;
    }
    
    public boolean createCharacter (String name, int chosenClass){
        hero.setName(name);
        
        switch(chosenClass){
            case RED: // Red
                hero.setMaxHealth(300);
                hero.setMaxMana(50);
                hero.setDamageMax(50);
                hero.setDamageMin(40);
                hero.setHeroAvatar(RED);
                break;
                
            case YELLOW: // Yellow
                hero.setMaxHealth(200);
                hero.setMaxMana(100);
                hero.setDamageMax(70);
                hero.setDamageMin(60);
                hero.setHeroAvatar(YELLOW);
                break;
                
            case BLUE: // Blue
                hero.setMaxHealth(100);
                hero.setMaxMana(300);
                hero.setDamageMax(60);
                hero.setDamageMin(50);
                hero.setHeroAvatar(BLUE);
                break;
                
            default: //Error
                return false;
        }
        
        hero.setCurrentHealth(hero.getMaxHealth());
        hero.setCurrentMana(hero.getMaxMana());
        hero.setPosX(100);
        hero.setPosY(100);
        init();
        
        return true;
    }
    
    public void init() {
        switch (gameState) {
            case COMBAT:
                
                // Sample enemy for test purposes
                enemy = new Enemy("Enemy", 100, 20, 20, 15, 100);
                
                break;
            case SHOP:
                shopMenu.removeAll();
                message.setFont(new Font(message.getFont().getName(), Font.PLAIN, 20));
                shopMenu.add(message);
                shopMenu.setVisible(true);
                break;
            case WORLDMAP:
                this.requestFocus(true);
                break;
        }
    }
    
    public void update(int action, int buttonLayer) {
        if (action == 4 && buttonLayer == 1) {
            shopMenu.setVisible(false);
            worldMapMenu.setVisible(false);
            switch (gameState) {
                case COMBAT: case SHOP:
                    gameState = GameState.WORLDMAP;
                    hero.setGameState(GameState.WORLDMAP);
                    break;
                case WORLDMAP:
                    gameState = GameState.SHOP;
                    hero.setGameState(GameState.SHOP);
                    break;
            }
            init();
        } else {
            switch (gameState) {
                case COMBAT:
                    switch (action) {
                    case 1:
                        hero.setBattleState(BattleState.ATTACKING);
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
                    } if (enemy.isFinishedAttacking()) {
                        enemy.stopAttacking();
                        hero.inflict(enemy.getDamage());
                    } if (isEnemyTurn) {
                        enemy.setBattleState(BattleState.ATTACKING);
                        isEnemyTurn = false;
                    }
                    hero.update();
                    enemy.update();
                    if (enemy.getCurrentHealth() == 0){
                        hero.gainGold(enemy.getGold());
                        gameState = GameState.WORLDMAP;
                        hero.setGameState(GameState.WORLDMAP);
                        init();
                    }
                    if (hero.getCurrentHealth() == 0){
                        System.out.println(hero.getName() + " is DEAD!");
                        System.exit(0);
                    }
                    break;
                case SHOP:
                    switch (action) {
                    case 1:
                        shopMenu.removeAll();
                        if (buttonLayer == 1){
                            itemsSale = new JLabel("Buy consumables: " + "        gold: " + hero.getGold());
                            shopMenu.add(itemsSale);
                            for (int i = 0; i < consumablesList.getList().size(); i++){
                                itemsSale = new JLabel(consumablesList.getItem(i).getName() + "  -" + consumablesList.getItem(i).getBuyPrice() + " gold");
                                shopMenu.add(itemsSale);
                            }
                        }
                        shopMenu.setVisible(true);
                        break;
                    case 2:
                        shopMenu.removeAll();
                        if (buttonLayer ==1){
                            itemsSale = new JLabel("Sell items:");
                            shopMenu.add(itemsSale);
                            for (int i = 0; i < consumablesList.getList().size(); i++){
                                itemsSale= new JLabel(hero.getConsumables().getItem(i).getName() + "   x " + hero.getConsumables().getItem(i).getStock());
                                shopMenu.add(itemsSale);
                            }
                        }
                        shopMenu.setVisible(true);
                        break;
                    case 3:
                        shopMenu.removeAll();
                        if (buttonLayer == 1){
                            itemsSale.setText("Case 3");
                            shopMenu.add(itemsSale);
                        }
                        break;
                    case 4:
                        shopMenu.removeAll();
                        shopMenu.add(message);
                        shopMenu.setVisible(true);
                        break;
                }
                    break;
                case WORLDMAP:
                    this.requestFocus(true);
                    switch (action){
                        case 1:
                            worldMapMenu.removeAll();
                            mapMessage = new JLabel ("Character Name: " + hero.getName());
                            worldMapMenu.add(mapMessage);
                            mapMessage = new JLabel ("Health: " + hero.getCurrentHealth() + " /" + hero.getMaxHealth());
                            worldMapMenu.add(mapMessage);
                            mapMessage = new JLabel ("Mana: " + hero.getCurrentMana() + " /" + hero.getMaxMana());
                            worldMapMenu.add(mapMessage);
                            mapMessage = new JLabel ("Equipment: ");
                            worldMapMenu.add(mapMessage);
                            for (int i = 0; i < hero.getEquipment().getList().size(); i++){
                                if (hero.getEquipment().getItem(i).getStock() > 0){
                                    mapMessage = new JLabel (hero.getEquipment().getItem(i).getName());
                                }
                            }
                            worldMapMenu.setVisible(true);
                            break;
                        case 2:
                            worldMapMenu.removeAll();
                            mapMessage = new JLabel("Items: ");
                            worldMapMenu.add(mapMessage);
                            for (int i = 0; i < hero.getConsumables().getList().size(); i++){
                                if (hero.getConsumables().getItem(i).getStock() > 0){
                                    mapMessage = new JLabel(hero.getConsumables().getItem(i).getName() + "   x " + hero.getConsumables().getItem(i).getStock());
                                    worldMapMenu.add(mapMessage);
                                }
                            }
                            worldMapMenu.setVisible(true);                    
                            break;
                        case 3:
                            break;
                        case 4:
                            worldMapMenu.setVisible(false);
                            break;
                    }
                    break;
            }
        }
        if (action != 0)
            previousButtonPressed = action;
    }
    
    //
    public void changeMap() {
        background.setBackground("map"+mapNumber);
    }
    
    //
    public void up() {
        if (hero.getPosY() <= 0 && (mapNumber >= 4)) {
            mapNumber -= 3;
            hero.setPosY(465);
            changeMap();
        }
        else if (hero.getPosY() > 0) {
            hero.setPosY(hero.getPosY() - 5);
        }
        
        if (stepTrigger()) {
            gameState = GameState.COMBAT;
            hero.setGameState(GameState.COMBAT);
            init();
        }
    }
    
    //
    public void down() {
        if (hero.getPosY() >=465 &&(mapNumber <7)){
            mapNumber += 3;
            hero.setPosY(0);
            changeMap();
        }
        else if (hero.getPosY() < 465){
            hero.setPosY(hero.getPosY() + 5);
        }
        
        if (stepTrigger()){
            gameState = GameState.COMBAT;
            hero.setGameState(GameState.COMBAT);
            init();
        }
    }
    
    //
    public void left() {
        if (hero.getPosX() <= 0 &&(mapNumber %3 != 1)){
            mapNumber--;
            hero.setPosX(445);
            changeMap();
        }
        else if (hero.getPosX() > 0 ){
            hero.setPosX(hero.getPosX() - 5);
        }
        
        if (stepTrigger()){
            gameState = GameState.COMBAT;
            hero.setGameState(GameState.COMBAT);
            init();
        }
    }
    
    //
    public void right() {
        if (hero.getPosX() >= 445 &&(mapNumber% 3 != 0)){
            mapNumber++;
            hero.setPosX(0);
            changeMap();
        }
        else if (hero.getPosX() < 445){
            hero.setPosX(hero.getPosX() + 5);
        }
        
        if (stepTrigger()){
            gameState = GameState.COMBAT;
            hero.setGameState(GameState.COMBAT);
            init();
        }
    }
    
    //
    public void keyPressed (KeyEvent e){
        if (gameState == GameState.WORLDMAP){
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
        
        background.draw(g);
        switch (gameState) {
            case COMBAT:
                enemy.draw(g);
                break;
            case SHOP:
                background.setBackground("shop");
                break;
            case WORLDMAP:
                background.setBackground("map"+mapNumber);
                break;
        }
        hero.draw(g);
    }
    
    private boolean stepTrigger (){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
        
        if (randomNum < 5){ 
            return true;
        }
        return false;
    }
}
