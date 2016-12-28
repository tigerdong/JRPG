
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
    private int buttonPressed; //Action communication with Gamepanel, number depends on button number pressed
    private int buttonLayer;
    private CombatAction combatAction = new CombatAction();
    
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
        
        LTButton.addActionListener(combatAction);
        LBButton.addActionListener(combatAction);
        RTButton.addActionListener(combatAction);
        RBButton.addActionListener(combatAction);
        
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
        buttonLayer = 0;
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
                break;
            case SHOP:
                LTButton.setText("Consumables");
                LBButton.setText("Sell Items");
                RTButton.setText("Equipment");
                RBButton.setText("World Map");
                break;
            case WORLDMAP:
                LTButton.setText("Skill Tree");
                LBButton.setText("Items");
                RTButton.setText("Character");
                RBButton.setText("Shop");
                break;
        }
    }
    
    
    public void update(){
        if (buttonLayer == 0){
            buttonLayer =1;
            switch (state){
                case COMBAT:
                    if (buttonPressed != 4){
                        LTButton.setText("Use");
                        RTButton.setText ("Info");
                        RBButton.setText("Back");
                        LBButton.setText("");
                        LBButton.setEnabled(false);
                    }
                    else {
                        state = gameState.WORLDMAP;
                        init();
                    }
                break;
            case SHOP:
                RBButton.setText("Back");
                RTButton.setText("Info");
                LBButton.setText("");
                LBButton.setEnabled(false);
                switch(buttonPressed){
                    case 1: case 3:
                        LTButton.setText("Buy");
                        break;
                    case 2:
                        LTButton.setText("Sell");
                        break;
                    case 4:
                        state = gameState.WORLDMAP;
                        init();
                }
                break;
            case WORLDMAP:
                switch(buttonPressed){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        state = gameState.SHOP;
                        init();
                        break;
                }
                break;
            }        
        }
        else if (buttonLayer == 1 && buttonPressed == 4){
            init();
        }
    }
    
    private class CombatAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == LTButton) {//Attack button
                buttonPressed = 1;
                update();  
            }
            if (event.getSource() == LBButton) {// Abilities button
                buttonPressed = 2;
                update(); 
            }
            if (event.getSource() == RTButton) {// Items button
                buttonPressed = 3;
                update(); 
            }
            if (event.getSource() == RBButton){//Flee button
                buttonPressed = 4;
                update();
            }
        }
    }
}

