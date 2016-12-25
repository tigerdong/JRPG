/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squarepg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cathy
 */
public class InteractionPanel {
    private JButton LTButton;
    private JButton LBButton;    
    private JButton RTButton;
    private JButton RBButton;
    private JPanel Interactions;
    
    public enum gameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    InteractionPanel(){
        Interactions = new JPanel (new GridLayout(0, 2));
    
    }
    
    
    public void init(gameState state) {
        switch (state){
            case COMBAT:
                LTButton = new JButton ("Attack");
                LBButton = new JButton ("Abilities");
                RTButton = new JButton ("Items");
                RBButton = new JButton ("Flee");
                
                Interactions.add(LTButton);
                Interactions.add(LBButton);
                Interactions.add(RTButton);
                Interactions.add(RBButton);
                
                
                CombatAction combatAction = new CombatAction();
                LTButton.addActionListener(combatAction);
                LBButton.addActionListener(combatAction);
                RTButton.addActionListener(combatAction);
                RBButton.addActionListener(combatAction);

                break;
            case SHOP:
                break;
            case WORLDMAP:
                LTButton = new JButton ("World Map");
                LBButton = new JButton ("Items");
                RTButton = new JButton ("Character");
                RBButton = new JButton ("Skill Tree");
                
                Interactions.add(LTButton);
                Interactions.add(LBButton);
                Interactions.add(RTButton);
                Interactions.add(RBButton);
                
                
                WorldAction worldAction = new WorldAction();
                LTButton.addActionListener(worldAction);
                LBButton.addActionListener(worldAction);
                RTButton.addActionListener(worldAction);
                RBButton.addActionListener(worldAction);
                
                break;
        }
    }
    
    
    public void update(gameState state){
        switch (state){
            case COMBAT:
                
                break;
            case SHOP:                
                break;
            case WORLDMAP:
                break;
        
        }
    
    }
    
    public void draw(gameState state){
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

