// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SquarePG extends JFrame {
    private JPanel menuPanel = new JPanel();
    private JButton playButton = new JButton("Play");
    private JButton optionsButton = new JButton("Options");
    private JButton aboutButton = new JButton("About");
    private JButton backButton = new JButton("Back");
    
    //private GamePanel gamePanel;
    //private InteractionsPanel interactionsPanel;
    
    private JPanel optionsPanel = new JPanel();
    private JLabel replaceMe = new JLabel("OPTIONS WILL GO HERE ;-)");
    
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
        contentPane.setLayout(new BorderLayout());
        
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replaceMe.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        menuPanel.add(playButton);
        menuPanel.add(optionsButton);
        menuPanel.add(aboutButton);
        
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.PAGE_AXIS));
        optionsPanel.add(replaceMe);
        optionsPanel.add(backButton);
        
        contentPane.add(menuPanel, BorderLayout.CENTER);
        
        ActionHandler actionHandler = new ActionHandler();
        playButton.addActionListener(actionHandler);
        optionsButton.addActionListener(actionHandler);
        aboutButton.addActionListener(actionHandler);
    }
    
    // Runs game loop
    private void runGameLoop() {
        Thread loop = new Thread() {
            public void run() {
                gameLoop();
            }
        };
        loop.start();
    }
    
    // Actual game loop
    private void gameLoop() {
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
    }
    
    // Private inner class for ActionListener event handling
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == playButton) {
                state = State.GAME;
                isRunning = true;
                remove(menuPanel);
                //add(gamePanel, BorderLayout.CENTER);
                //add(interactionsPanel, BorderLayout.SOUTH);
                validate();
                repaint();
                runGameLoop();
            }
            if (event.getSource() == optionsButton) {
                state = State.OPTIONS;
                remove(menuPanel);
                add(optionsPanel, BorderLayout.CENTER);
                validate();
                repaint();
            }
            if (event.getSource() == aboutButton) {
                state = State.ABOUT;
                remove(menuPanel);
                validate();
                repaint();
            }
        }
    }
}
