package me.elspeth.dino;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private static Updater repaint, update;

    public static void main(String[] args) {
        var frame = new Frame();
        repaint = new Updater(100);
        repaint.on(frame::repaint);

        update = new Updater(60);
        update.on(() -> {

        });

    }

    public static String getUpdateString() {
        return "FPS: " + repaint.getUPS() + "/ UPS: " + update.getUPS();
    }


}
