package me.elspeth.syculus;

import me.elspeth.syculus.world.World;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel() {
        setBackground(Color.yellow);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawString(Main.getUpdateString(), 5, 15);
        World.instance.draw(g);
    }
}
