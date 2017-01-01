//
//
//

package SquarePG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Enemy extends Entity {
    private ImageIcon enemyAvatar;
    
    Enemy() {
        super();
        enemyAvatar = new ImageIcon(this.getClass().getResource("enemy.png"));
    }
    
    Enemy(String name, int maxHealth, int maxMana, int damageMax, int damageMin, int gold) {
        super(name, maxHealth, maxMana, damageMax, damageMin, gold);
        enemyAvatar = new ImageIcon(this.getClass().getResource("enemy.png"));
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(enemyAvatar.getImage(), 100, 250, null);
    }
}
