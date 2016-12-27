import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class InteractionPanel extends JPanel{
    
    private JButton LTButton = new JButton (); //1
    private JButton LBButton = new JButton(); //2
    private JButton RTButton = new JButton(); //3
    private JButton RBButton = new JButton(); //4
    private gameState state = gameState.COMBAT;
    private int buttonPressed = 0; //Action communication with Gamepanel, number depends on button number pressed
    
    public enum gameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    InteractionPanel(){
        setLayout (new GridLayout(0,2));
        setPreferredSize(new Dimension (500, 200));
        
        add(LTButton);
        add(LBButton);
        add(RTButton);
        add(RBButton);
        
        init();
    }
    
    public void setState(gameState state){
        this.state = state;
    }
    
    public gameState getState(){
        return state;
    }
    
    public void clearButtonPressed (){
        this.buttonPressed = 0 ;
    }
    
    public int getButtonPressed (){
        return buttonPressed;
    }
    
    public void init() {
        switch (state){
            case COMBAT:
                LTButton.setText("Attack");
                LBButton.setText("Abilities");
                RTButton.setText("Items");
                RBButton.setText("Flee");
                
                CombatAction combatAction = new CombatAction();
                LTButton.addActionListener(combatAction);
                LBButton.addActionListener(combatAction);
                RTButton.addActionListener(combatAction);
                RBButton.addActionListener(combatAction);
                break;
            case SHOP:
                LTButton.setText("Items");
                LBButton.setText("Armour");
                RTButton.setText("Abilities");
                RBButton.setText("World Map");
                
                ShopAction shopAction = new ShopAction();
                LTButton.addActionListener(shopAction);
                LBButton.addActionListener(shopAction);
                RTButton.addActionListener(shopAction);
                RBButton.addActionListener(shopAction);
                break;
            case WORLDMAP:
                LTButton.setText("Shop");
                LBButton.setText("Items");
                RTButton.setText("Character");
                RBButton.setText("Skill Tree");
                
                WorldAction worldAction = new WorldAction();
                LTButton.addActionListener(worldAction);
                LBButton.addActionListener(worldAction);
                RTButton.addActionListener(worldAction);
                RBButton.addActionListener(worldAction);
                break;
        }
    }
    
    
    public void update(){
        switch (state){
            case COMBAT:
                    
                break;
            case SHOP:                
                break;
            case WORLDMAP:
                break;
        
        }
    
    }
    
    public void draw(){
        switch(state){
            case COMBAT:
                break;
            case SHOP:
                break;
            case WORLDMAP:
                break;
        
        
        }
    
    }
    
    private class CombatAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == LTButton) {//Attack button
                buttonPressed = 1;
            }
            if (event.getSource() == LBButton) {// Abilities button
                buttonPressed = 2;
            }
            if (event.getSource() == RTButton) {// Items button
                buttonPressed = 3;
            }
            if (event.getSource() == RBButton){//Flee button
                buttonPressed = 4;
                state = gameState.WORLDMAP;
            }
        }
    }
    
    private class ShopAction implements ActionListener {
        public void actionPerformed (ActionEvent event){
        if (event.getSource() == LTButton) {//Items button
                buttonPressed = 1;
            }
            if (event.getSource() == LBButton) {//Armour button
                buttonPressed = 2;
            }
            if (event.getSource() == RTButton) {//Abilities button
                buttonPressed = 3;
            }
            if (event.getSource() == RBButton){//Return to WorldMap button
                buttonPressed = 4;
                state = gameState.WORLDMAP;
            }
        }
    }
    
    
    private class WorldAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == LTButton) {//Shop button
                buttonPressed = 1;
                state = gameState.SHOP;
            }
            if (event.getSource() == LBButton) {//Items button
                buttonPressed = 2;
            }
            if (event.getSource() == RTButton) {//Characters button
                buttonPressed = 3;
            }
            if (event.getSource() == RBButton){//Skill Tree button
                buttonPressed = 4;
            }
        }
    }
    
}

