// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SquarePG extends JFrame {
    private JButton playButton = new JButton("Play");
    private JButton optionsButton = new JButton("Options");
    private JButton aboutButton = new JButton("About");
    //private GamePanel gamePanel;
    //private InteractionsPanel interactionsPanel;
    
    private boolean isRunning = false;
    private int FPS = 30;
    private State state = State.MENU;
    
    public enum State {
        MENU,
        GAME,
        OPTIONS,
        ABOUT;
    }

    public static void main(String args[]) {
        SquarePG game = new SquarePG();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1000, 750);
        game.setVisible(true);
    }
    
    // Constructor
    public SquarePG() {
        super("SquarePG");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        
        contentPane.add(playButton);
        contentPane.add(optionsButton);
        contentPane.add(aboutButton);
        
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        ActionHandler actionHandler = new ActionHandler();
        playButton.addActionListener(actionHandler);
        optionsButton.addActionListener(actionHandler);
        aboutButton.addActionListener(actionHandler);
    }
    
    // Runs game loop
    private void run(){
        while(isRunning){
            long time = System.currentTimeMillis();
            //gamePanel.update();
            //gamePanel.draw();
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
    
    // Private inner class for ActionListener event handling
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == playButton) {
                state = State.GAME;
                isRunning = true;
                removeAll();
                setLayout(new BorderLayout());
                //add(gamePanel, BorderLayout.CENTER);
                //add(interactionsPanel, BorderLayout.SOUTH);
                revalidate();
                repaint();
                run();
            }
            if (event.getSource() == optionsButton) {
                state = State.OPTIONS;
                removeAll();
                // add stuff to container
                revalidate();
                repaint();
            }
            if (event.getSource() == aboutButton) {
                state = State.ABOUT;
                removeAll();
                // add stuff to container
                revalidate();
                repaint();
            }
        }
    }
}
