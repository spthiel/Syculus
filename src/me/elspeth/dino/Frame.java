package me.elspeth.dino;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel panel;

    public Frame() {
        super("Dino");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setBounds(200, 200, 600, 600);

        panel = new Panel();

        add(panel);

    }
}
