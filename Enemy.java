//
//
//

package squarepg;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

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

        g2d.setPaint(Color.WHITE);
        g2d.fill(new Rectangle2D.Double(25, 40, 175, 45));
        g2d.setPaint(Color.GRAY);
        g2d.fill(new Rectangle2D.Double(35, 60, 155, 15));
        g2d.setPaint(Color.RED);
        g2d.fill(new Rectangle2D.Double(35, 60, (currentHealth*1.0/maxHealth*155), 15));
        g2d.setPaint(Color.BLACK);
        g2d.drawString(name, 35, 55);
        g2d.drawString((currentHealth+"/"+maxHealth+" HP"), 37, 72);
        g2d.drawImage(enemyAvatar.getImage(), 100, 250, null);
    }
}
