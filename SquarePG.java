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
    private JLabel aboutLabel = new JLabel("<html><center>ABOUT<br><br>Authors:<br>Tiger Dong, Cathy Hua<br><br>Last Revised:<br>DATE HERE<br><br>Compiler:<br>JDK 1.8.0_101<br><br>Version:<br>Java SE 8<br> <br></html>");
    
    private JPanel selectionPanel = new JPanel();
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
    
    private GamePanel gamePanel = new GamePanel();
    private InteractionPanel interactionPanel = new InteractionPanel();
    
    
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
        
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 0, 0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;        
        c.gridx = 0;
        c.gridy = 0;
        menuPanel.add(playButton, c);
        c.gridy = 1;
        menuPanel.add(optionsButton, c);
        c.gridy = 2;
        menuPanel.add(aboutButton, c);
            
        
        optionsPanel.setLayout(new GridBagLayout());
        c.gridy = 0;
        optionsPanel.add(replaceMe, c);
        c.fill = GridBagConstraints.NONE;
        c.gridy = 2;
        optionsPanel.add(back1Button, c);
        
        aboutPanel.setLayout(new GridBagLayout());
        c.gridy = 0;
        aboutPanel.add(aboutLabel, c);
        c.gridy = 2;
        aboutPanel.add(back2Button, c);
                
               
        
        selectionPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 1;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;
        selectionPanel.add(selectionLabel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridx = 0;
        selectionPanel.add(redButton, c);
        c.gridx = 1;
        selectionPanel.add(yellowButton,c);
        c.gridx = 2;
        selectionPanel.add(blueButton,c);
        c.gridy = 2;
        c.gridx = 0;
        selectionPanel.add(nameLabel, c);
        c.gridx = 1;
        c.gridwidth = 2;
        selectionPanel.add(nameTextField, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        selectionPanel.add(startButton, c);
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
                remove(menuPanel);
                add(selectionPanel);
            } if (event.getSource() == optionsButton) {
                remove(menuPanel);
                add(optionsPanel);
            } if (event.getSource() == aboutButton) {
                remove(menuPanel);
                add(aboutPanel);
            } if (event.getSource() == back1Button) {
                remove(optionsPanel);
                add(menuPanel);
            } if (event.getSource() == back2Button) {
                remove(aboutPanel);
                add(menuPanel);
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
                isRunning = true;
                gamePanel.createCharacter(playerName, playerClass);
                
                remove(selectionPanel);
                add(gamePanel);
                add(interactionPanel);
                
                //runGameLoop();
            }
            validate();
            repaint();
        }
    }
}
