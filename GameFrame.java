package squarepg;


import java.awt.Graphics;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    private Entity Hero;
    private gameState state;
    
    public enum gameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    
    } 
    public GameFrame(){
        Hero = new Entity ();
    }
    
    public void setState(gameState state){
        this.state = state;
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

    
}
