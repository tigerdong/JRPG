package squarepg;


import java.awt.Graphics;


public class GameFrame {
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
    
    public void isState(gameState state){
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
    
    public void repaint(Graphics g){
        
    
    }
    
}
