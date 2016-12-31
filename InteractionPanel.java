package SquarePG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class InteractionPanel extends JPanel{
    
    private JButton LTButton = new JButton (); //1
    private JButton LBButton = new JButton(); //2
    private JButton RTButton = new JButton(); //3
    private JButton RBButton = new JButton(); //4
    private GameState state = GameState.WORLDMAP;
    private int buttonPressed =0; //Action communication with Gamepanel, number depends on button number pressed
    private int buttonLayer =0;
    private CombatAction combatAction = new CombatAction();
    
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
    
    public void setState(GameState state){
        if (this.state != state || buttonPressed == 4){
            this.state = state;
            init();
        }
    }
    
    public GameState getState(){
        return state;
    }
    
    public void clearButtonPressed (){
        buttonPressed = 0 ;
    }
    
    public int getButtonPressed (){
        return buttonPressed;
    }
    
    public int getButtonLayer(){
        return buttonLayer;
    }
    
    
    public void init() {
        LTButton.setEnabled(true);
        LBButton.setEnabled(true);
        RTButton.setEnabled(true);
        RBButton.setEnabled(true);
        
        clearButtonPressed();
        buttonLayer = 0;
        
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
                RBButton.setText("Map");
                break;
            case WORLDMAP:
                LTButton.setText("Character");
                LBButton.setText("Items");
                RTButton.setText("World Map");
                RBButton.setText("Shop");
                break;
        }
    }
    
    
    private void update(){
        if (buttonLayer == 0){
            switch (state){
                case COMBAT:
                    /*if (buttonPressed != 4){
                        LTButton.setText("Use");
                        RTButton.setText ("Info");
                        RBButton.setText("Back");
                        LBButton.setText("");
                        LBButton.setEnabled(false);
                    }
                    */
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
                }
                break;
            case WORLDMAP:
                switch(buttonPressed){
                    case 1:
                        RBButton.setText("Back");
                        LBButton.setText("");
                        LTButton.setText("");
                        RTButton.setText("");
                        LBButton.setEnabled(false);
                        LTButton.setEnabled(false);
                        RTButton.setEnabled(false);
                        break;
                    case 2:
                        RBButton.setText("Back");
                        LTButton.setText("Use");
                        RTButton.setText("Info");
                        LBButton.setText("");
                        LBButton.setEnabled(false);
                        break;
                    case 3:
                        break;
                }
                break;
            }
            buttonLayer++;
        }
        else if (buttonPressed == 4){
            buttonLayer--;
        }
        else {
            buttonLayer++;
        }
        /*
        else if (buttonLayer > 0 && buttonPressed == 4){
            init();
        }*/
        
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

