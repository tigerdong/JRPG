
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
    private CombatAction combatAction = new CombatAction();
    private ShopAction shopAction = new ShopAction();
    private WorldAction worldAction = new WorldAction();
    
    public enum gameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    InteractionPanel(){
        setLayout (new GridLayout(0,2));
        setPreferredSize(new Dimension (500, 200));
        
        add(LTButton);
        add(RTButton);
        add(LBButton);
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
        buttonPressed = 0 ;
    }
    
    public int getButtonPressed (){
        return buttonPressed;
    }
    
    public void init() {
        LTButton.setEnabled(true);
        LBButton.setEnabled(true);
        RTButton.setEnabled(true);
        RBButton.setEnabled(true);
        
        clearButtonPressed();
        
        switch (state){
            case COMBAT:
                LTButton.setText("Attack");
                LBButton.setText("Abilities");
                RTButton.setText("Items");
                RBButton.setText("Flee");
                
                LTButton.addActionListener(combatAction);
                LBButton.addActionListener(combatAction);
                RTButton.addActionListener(combatAction);
                RBButton.addActionListener(combatAction);
                break;
            case SHOP:
                LTButton.setText("Consumables");
                LBButton.setText("Sell Items");
                RTButton.setText("Equipment");
                RBButton.setText("World Map");
                
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
                    LTButton.setText("Use");
                    RTButton.setText ("Info");
                    LBButton.setText("Back");
                    RBButton.setText("");
                    RBButton.setEnabled(false);
                
                break;
            case SHOP:
                
                    switch(buttonPressed){
                        case 1:
                            LTButton.setText("case 1");
                            break;
                        case 3:
                            LTButton.setText("case 3");
                            break;
                        case 2:
                            LTButton.setText("case 2");
                            break;
                    }
                    LBButton.setText("Back");
                    RTButton.setText("Info");
                    RBButton.setText("");
                    RBButton.setEnabled(false);
                break;
            case WORLDMAP:
                
                break;
        
        }
    }
    
    private void removeListener (){
        switch(state){
            case COMBAT:
                LBButton.removeActionListener(combatAction);
                LTButton.removeActionListener(combatAction);
                RTButton.removeActionListener(combatAction);
                RBButton.removeActionListener(combatAction);
                break;
            case SHOP:
                LBButton.removeActionListener(shopAction);
                LTButton.removeActionListener(shopAction);
                RBButton.removeActionListener(shopAction);
                RTButton.removeActionListener(shopAction);
                break;
            case WORLDMAP:
                LBButton.removeActionListener(worldAction);
                LTButton.removeActionListener(worldAction);
                RBButton.removeActionListener(worldAction);
                RTButton.removeActionListener(worldAction);
                break;
        }
    }
    
    private class CombatAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == LTButton) {//Attack button
                if (buttonPressed == 0){
                    buttonPressed = 1;
                    update();
                }
            }
            if (event.getSource() == LBButton) {// Abilities button
                if (buttonPressed == 0){
                    buttonPressed = 2;
                    update();
                }
                else {
                    init();
                }
            }
            if (event.getSource() == RTButton) {// Items button
                if(buttonPressed == 0){
                    buttonPressed = 3;
                    update();
                }
            }
            if (event.getSource() == RBButton){//Flee button
                buttonPressed = 4;
                removeListener();
                state = gameState.WORLDMAP;
                init();
            }
        }
    }
    
    private class ShopAction implements ActionListener {
        public void actionPerformed (ActionEvent event){
        if (event.getSource() == LTButton) {//Buy Consumables button
                if (buttonPressed == 0){
                    buttonPressed = 1;
                    update();
                }
            }
            if (event.getSource() == LBButton) {//Sell button
                if (buttonPressed == 0){
                    buttonPressed = 2;
                    update();
                }
                else {
                    init();
                }
            }
            if (event.getSource() == RTButton) {//Equipment buy button
                if (buttonPressed == 0){
                    buttonPressed = 3;
                    update();
                }
            }
            if (event.getSource() == RBButton){//Return to WorldMap button
                buttonPressed = 4;
                removeListener();
                state = gameState.WORLDMAP;
                init();
            }
        }
    }
    
    private class WorldAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == LTButton) {//Shop button
                buttonPressed = 1;
                removeListener();
                state = gameState.SHOP;
                init();
            }
            if (event.getSource() == LBButton) {//Items button
                buttonPressed = 2;
                update();
            }
            if (event.getSource() == RTButton) {//Characters button
                buttonPressed = 3;
                update();
            }
            if (event.getSource() == RBButton){//Skill Tree button
                buttonPressed = 4;
                update();
            }
        }
    } 
}

