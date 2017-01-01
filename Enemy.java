//
//
//

package SquarePG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Enemy extends Entity {
    Enemy() {
        super();
    }
    
    Enemy(String name, int maxHealth, int maxMana, int damageMax, int damageMin, int gold) {
        super(name, maxHealth, maxMana, damageMax, damageMin, gold);
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
    }
}