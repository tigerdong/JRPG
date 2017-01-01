//
//
//
package SquarePG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Background {
    ImageIcon background;
    
    Background() {
        background = new ImageIcon(this.getClass().getResource("map1.png"));
    }
    
    Background(String imageName) {
        setBackground(imageName);
    }
    
    public void setBackground(String imageName) {
        background = new ImageIcon(this.getClass().getResource(imageName+".png"));
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(background.getImage(), 0, 0, null);
    }
}