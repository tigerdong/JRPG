import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class InteractionPanel extends JPanel{
    
    private JButton LTButton; //1
    private JButton LBButton; //2
    private JButton RTButton; //3
    private JButton RBButton; //4
    private gameState state = gameState.COMBAT;
    private int action = 0; //Action communication with Gamepanel, number depends on button number pressed
    
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
                break;
            case WORLDMAP:
                LTButton.setText("World Map");
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
                
            }
            if (event.getSource() == LBButton) {// Abilities button
                
            }
            if (event.getSource() == RTButton) {// Items button
                
            }
            if (event.getSource() == RBButton){//Flee button
                
            }
        }
    }
    
    private class WorldAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == LTButton) {//World map button
                
            }
            if (event.getSource() == LBButton) {//Items button
                
            }
            if (event.getSource() == RTButton) {//Characters button
                
            }
            if (event.getSource() == RBButton){//Skill Tree button
            
            }
        }
    }
    
}



