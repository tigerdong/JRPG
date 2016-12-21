// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class SquarePG extends JFrame {
    private boolean isRunning;
    private int FPS;

    public static void main(String args[]) {
        SquarePG game = new SquarePG();
        game.run();
        System.exit(0);
    }
    
    // Constructor
    public SquarePG() {
        super("SquarePG");
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        FPS = 30;
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
            
            update();
            draw();
            
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setVisible(true);
    }
    
    // Input check, movement
    void update() {
        //gamePanel.repaint();
    }
    
    // Draws everything
    void draw() {
        //gamePanel.repaint();
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
