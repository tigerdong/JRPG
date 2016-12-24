package squarepg;


import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private Entity Hero;
    private gameState state;
    
    public enum gameState {
        CHARACTERSELECTION,
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    
    public GamePanel(){
        Hero = new Entity ();
    }
    
    public void setState(gameState state){
        this.state = state;
    }
    
    
    public void update(){
        switch (state){
            case CHARACTERSELECTION:
                JPanel CharSelection = new JPanel();
                
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
    
}