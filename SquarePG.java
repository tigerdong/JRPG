// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class SquarePG extends JFrame {
    private boolean isRunning;
    private int FPS;
    private State state;
    
    public enum State {
        MENU, COMBAT;
    }

    public static void main(String args[]) {
        SquarePG game = new SquarePG();
        game.run();
        System.exit(0);
    }
    
    // Constructor
    public SquarePG() {
        super("SquarePG");
        // set layout here
        
        FPS = 30;
        state = State.MENU;
        isRunning = true;
        
        MouseHandler mouseHandler = new MouseHandler(); 
        addMouseListener(mouseHandler); 
        addMouseMotionListener(mouseHandler);
        
        KeyHandler keyHandler = new KeyHandler(); 
        addKeyListener(keyHandler); 
    }
    
    // Runs game loop
    public void run(){
        
        initialize();
        
        while(isRunning){
            long time = System.currentTimeMillis();
            
            update(state);
            draw(state);
            
            // Delay for each frame
            time = (1000/FPS) - (System.currentTimeMillis()-time);
            
            if (time > 0){
                try{
                    Thread.sleep(time);
                }
                catch (Exception e){}
            }
        }
        setVisible(false);
    }
    
    // Initial setup
    void initialize() {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 1000, 750 );
        setVisible( true );
    }
    
    // Input check, movement
    void update(State state) {
         switch (state) {
             case MENU:
                 break;
             case COMBAT:
                 break;
             default:
                 break;
         }
    }
    
    // Draws everything
    void draw(State state) {
         switch (state) {
             case MENU:
                 break;
             case COMBAT:
                 break;
             default:
                 break;
         }
    }
    
    // Inner class for handling mouse events
    private class MouseHandler extends MouseAdapter {
        // Handle event when mouse pressed
        public void mousePressed(MouseEvent event) {
        }
        
        // Handle event when mouse released after dragging
        public void mouseReleased(MouseEvent event) {
        }
    }
    
    // 
    private class KeyHandler extends KeyAdapter {
        //
        public void keyPressed(KeyEvent event) {
        }
    }
}
