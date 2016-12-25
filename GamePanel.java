package squarepg;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;


public class GamePanel extends JPanel {
    private Entity Hero;
    private Entity Enemy;
    private gameState state = gameState.CHARACTERSELECTION;
    
    private JPanel gameScreen;
    private JPanel bottompanel;
    private JPanel toppanel;
    
    private JButton NButton;
    private JButton WButton;    
    private JButton EButton;
    private JButton SButton;
    private JButton CButton;

    private JLabel nameChoose = new JLabel("Enter Character Name: ");    
    private JTextField name = new JTextField (20);
    
    private JLabel classChoice = new JLabel ("Please choose a class: "); 
    private JRadioButton warrior = new JRadioButton ("Warrior");
    private JRadioButton archer = new JRadioButton ("Archer");
    private JRadioButton mage = new JRadioButton ("Mage");
    
    
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
        gameScreen = new JPanel (new GridLayout(0, 1));
        toppanel = new JPanel ();
        bottompanel = new JPanel (new BorderLayout());
    }
    
    public void setState(gameState state){
        this.state = state;
    }
    
    public void init() {
        switch (state){
            case CHARACTERSELECTION:
                
                ButtonGroup group = new ButtonGroup();
                group.add(warrior);
                group.add(archer);
                group.add(mage);
                
                NButton = new JButton ("Enter");
                NButton.setSize(new Dimension(100, 100));
                
                gameScreen.add(nameChoose);
                gameScreen.add(name);
                gameScreen.add(classChoice);
                gameScreen.add(warrior);
                gameScreen.add(archer);
                gameScreen.add(mage);
                gameScreen.add(NButton);
                
                
                break;
            case COMBAT:
                addComponentsToPane (bottompanel, "Status", "Items", "Fight", "Flight", "Defend");
                //draw the initial top panel
                gameScreen.add(toppanel);
                gameScreen.add(bottompanel);
                
                //Sample enemy for test purposes
                Enemy = new Entity("Enemy", 50, 20, 20, 15, 10, 100);
                
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
            if (event.getSource() == NButton) {//Status? button
                
            }
            if (event.getSource() == WButton) {// Item button
                
            }
            if (event.getSource() == EButton) {// Run button
                
            }
            if (event.getSource() == CButton){//Fight button
            
            }
            if (event.getSource() == SButton){//Defend button
            
            }
        }
    }
    
    
}
