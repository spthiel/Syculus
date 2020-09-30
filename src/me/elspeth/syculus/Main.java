package me.elspeth.syculus;

import me.elspeth.syculus.world.World;
import me.elspeth.syculus.world.entities.Player;

public class Main {

    private static Updater repaint, update;

    public static void main(String[] args) {
        World w = World.instance;
        var frame = new Frame();
        repaint = new Updater(100);
        repaint.on(frame::repaint);


        update = new Updater(60);
        update.on(World.instance::update);

        w.registerEntitiy(new Player());

    }

    public static String getUpdateString() {
        return "FPS: " + repaint.getUPS() + "/ UPS: " + update.getUPS();
    }


}
