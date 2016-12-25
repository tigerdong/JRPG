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
    
    public enum gameState {
        COMBAT,
        SHOP,
        WORLDMAP;
    } 
    
    
    
    //private GamePanel gamePanel;
    //private InteractionsPanel interactionsPanel;
    
    private JPanel optionsPanel = new JPanel();
    private JLabel replaceMe = new JLabel("OPTIONS WILL GO HERE ;-)");
    
    private JPanel aboutPanel = new JPanel();
    private JLabel aboutLabel = new JLabel("<html><center>ABOUT<br><br>Authors:<br>Tiger Dong, Cathy Hua<br><br>Last Revised:<br>DATE HERE<br><br>Compiler:<br>JDK 1.8.0_101<br><br>Version:<br>Java SE 8</html>");
    
    private JPanel selectionPanel = new JPanel();
    private JPanel characterPanel = new JPanel();
    private JPanel namePanel = new JPanel();
    private JLabel selectionLabel = new JLabel("Yeah, why not?");
    private JLabel nameLabel = new JLabel("Square's Name:");
    private JTextField nameTextField = new JTextField(15);
    private JToggleButton redButton = new JToggleButton("Red");
    private JToggleButton yellowButton = new JToggleButton("Yellow");
    private JToggleButton blueButton = new JToggleButton("Blue");
    private JButton startButton = new JButton("Start!");
    
    private boolean isRunning = false;
    private int FPS = 30;
    private int playerClass = 0;
    private String playerName = "";

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
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
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
        
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.PAGE_AXIS));
        characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.LINE_AXIS));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        characterPanel.add(redButton);
        characterPanel.add(yellowButton);
        characterPanel.add(blueButton);
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        selectionPanel.add(selectionLabel);
        selectionPanel.add(characterPanel);
        selectionPanel.add(namePanel);
        selectionPanel.add(startButton);
        startButton.setEnabled(false);
        nameTextField.setEditable(false);
        nameTextField.setMaximumSize(nameTextField.getPreferredSize());
        
        contentPane.add(menuPanel);
        
        ActionHandler actionHandler = new ActionHandler();
        playButton.addActionListener(actionHandler);
        optionsButton.addActionListener(actionHandler);
        aboutButton.addActionListener(actionHandler);
        back1Button.addActionListener(actionHandler);
        back2Button.addActionListener(actionHandler);
        redButton.addActionListener(actionHandler);
        yellowButton.addActionListener(actionHandler);
        blueButton.addActionListener(actionHandler);
        startButton.addActionListener(actionHandler);
        nameTextField.addActionListener(actionHandler);
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
                add(selectionPanel);
                validate();
                repaint();
                runGameLoop();
            } if (event.getSource() == optionsButton) {
                remove(menuPanel);
                add(optionsPanel);
                validate();
                repaint();
            } if (event.getSource() == aboutButton) {
                remove(menuPanel);
                add(aboutPanel);
                validate();
                repaint();
            } if (event.getSource() == back1Button) {
                remove(optionsPanel);
                add(menuPanel);
                validate();
                repaint();
            } if (event.getSource() == back2Button) {
                remove(aboutPanel);
                add(menuPanel);
                validate();
                repaint();
            } if (event.getSource() == redButton) {
                playerClass = 0;
                nameTextField.setEditable(true);
                yellowButton.setSelected(false);
                blueButton.setSelected(false);
            } if (event.getSource() == yellowButton) {
                playerClass = 1;
                nameTextField.setEditable(true);
                redButton.setSelected(false);
                blueButton.setSelected(false);
            } if (event.getSource() == blueButton) {
                playerClass = 2;
                nameTextField.setEditable(true);
                redButton.setSelected(false);
                yellowButton.setSelected(false);
            } if (event.getSource() == nameTextField && event.getActionCommand().length() > 0) {
                playerName = event.getActionCommand();
                startButton.setEnabled(true);
            } if (event.getSource() == startButton) {
                //gamePanel.functionName(playerName, playerClass);
            }
        }
    }
}
