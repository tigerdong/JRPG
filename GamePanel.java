package squarepg;


import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;


public class GamePanel extends JPanel {
    private Entity Hero;
    private gameState state;
    private JPanel gameScreen;
    private JPanel bottompanel;
    private JPanel toppanel;
    private JButton NButton;
    private JButton WButton;    
    private JButton EButton;
    private JButton SButton;
    private JButton CButton;
     
    public enum gameState {
        CHARACTERSELECTION,
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    //Creates N/E/S/W panels of size W: 1000, H: 300 pixels
    public void addComponentsToPane(Container panel, String North, String West, String Centre, String East, String South){
        NButton = new JButton (North);
        NButton.setPreferredSize (new Dimension(1000, 100));
        panel.add(NButton, BorderLayout.PAGE_START);
        
        
        CButton = new JButton(Centre);
        CButton.setPreferredSize(new Dimension(333, 100));
        panel.add(CButton, BorderLayout.CENTER);

        WButton = new JButton(West);
        WButton.setPreferredSize(new Dimension(300, 100));
        panel.add(WButton, BorderLayout.LINE_START);

        WButton = new JButton(South);
        WButton.setPreferredSize (new Dimension(1000, 100));
        panel.add(WButton, BorderLayout.PAGE_END);

        EButton = new JButton(East);
        EButton.setPreferredSize(new Dimension(333, 100));
        panel.add(EButton, BorderLayout.LINE_END);
    }
    
    public GamePanel(){
        Hero = new Entity ();
        gameScreen = new JPanel ();
        
        
        toppanel = new JPanel ();
        bottompanel = new JPanel (new BorderLayout());
    }
    
    public void setState(gameState state){
        this.state = state;
    }
    
    public void init() {
        switch (state){
            case CHARACTERSELECTION:
                
                
                break;
            case COMBAT:
                addComponentsToPane (bottompanel, "Status", "Items", "Fight", "Flight", "Defend");
                //draw the initial top panel
                gameScreen.add(toppanel);
                gameScreen.add(bottompanel);
                
                CombatAction combatAction = new CombatAction();
                NButton.addActionListener(combatAction);
                EButton.addActionListener(combatAction);
                CButton.addActionListener(combatAction);
                WButton.addActionListener(combatAction);
                SButton.addActionListener(combatAction);

                
                
                break;
            case SHOP:
                break;
            case WORLDMAP:
                break;
        }
    }
    
    
    public void update(){
        switch (state){
            case CHARACTERSELECTION:
                
                
                break;
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
            case CHARACTERSELECTION:
                
                break;
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
            if (event.getSource() == NButton) {
                
            }
            if (event.getSource() == WButton) {
                
            }
            if (event.getSource() == EButton) {
                
            }
            if (event.getSource() == CButton){
            
            }
            if (event.getSource() == SButton){
            
            }
        }
    }
    
    
}
