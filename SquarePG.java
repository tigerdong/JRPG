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
    private JButton back1Button = new JButton("Back");
    private JButton back2Button = new JButton("Back");
    
    //private GamePanel gamePanel;
    //private InteractionsPanel interactionsPanel;
    
    private JPanel optionsPanel = new JPanel();
    private JLabel replaceMe = new JLabel("OPTIONS WILL GO HERE ;-)");
    
    private JPanel aboutPanel = new JPanel();
    private JLabel aboutLabel = new JLabel("<html><center>ABOUT<br><br>Authors:<br>Tiger Dong, Cathy Hua<br><br>Last Revised:<br>DATE HERE<br><br>Compiler:<br>JDK 1.8.0_101<br><br>Version:<br>Java SE 8</html>");
    
    private boolean isRunning = false;
    private int FPS = 30;

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
        replaceMe.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        back1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        back2Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        menuPanel.add(playButton);
        menuPanel.add(optionsButton);
        menuPanel.add(aboutButton);
        
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.PAGE_AXIS));
        optionsPanel.add(replaceMe);
        optionsPanel.add(back1Button);
        
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
        aboutPanel.add(aboutLabel);
        aboutPanel.add(back2Button);
        
        contentPane.add(menuPanel, BorderLayout.CENTER);
        
        ActionHandler actionHandler = new ActionHandler();
        playButton.addActionListener(actionHandler);
        optionsButton.addActionListener(actionHandler);
        aboutButton.addActionListener(actionHandler);
        back1Button.addActionListener(actionHandler);
        back2Button.addActionListener(actionHandler);
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
                isRunning = true;
                remove(menuPanel);
                //add(gamePanel, BorderLayout.CENTER);
                //add(interactionsPanel, BorderLayout.SOUTH);
                validate();
                repaint();
                runGameLoop();
            }
            if (event.getSource() == optionsButton) {
                remove(menuPanel);
                add(optionsPanel, BorderLayout.CENTER);
                validate();
                repaint();
            }
            if (event.getSource() == aboutButton) {
                remove(menuPanel);
                add(aboutPanel, BorderLayout.CENTER);
                validate();
                repaint();
            }
            if (event.getSource() == back1Button) {
                remove(optionsPanel);
                add(menuPanel, BorderLayout.CENTER);
                validate();
                repaint();
            }
            if (event.getSource() == back2Button) {
                remove(aboutPanel);
                add(menuPanel, BorderLayout.CENTER);
                validate();
                repaint();
            }
        }
    }
}
