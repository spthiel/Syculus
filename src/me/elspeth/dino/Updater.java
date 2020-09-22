package me.elspeth.dino;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Updater {

    private int maxups;
    private List<Runnable> callbacks;
    private Queue<Long> updates;

    public Updater(int maxups) {
        this.maxups = maxups;
        callbacks = new LinkedList<>();
        loop();
    }

    public void setMaxups(int maxups) {
        this.maxups = maxups;
    }

    public int getUPS() {
        while (updates.size() > 0 && (updates.peek() + 1000 < System.currentTimeMillis())) {
            updates.remove();
        }
        return updates.size();
    }

    public void on(Runnable callback) {
        this.callbacks.add(callback);
    }

    public void loop() {
        Thread t = new Thread(() -> {

            long current;
            long last = System.currentTimeMillis();
            float delta;
            float timeperframe = 1000.0f/ maxups;
            float timer = 0;

            updates = new LinkedList<>();

            while(true) {

                current = System.currentTimeMillis();
                delta = current - last;
                last = current;
                timer += delta;

                if(timer >= timeperframe) {
                    updates.add(System.currentTimeMillis());
                    callbacks.forEach(Runnable::run);
                    timer -= timeperframe;
                }
            }

        });

        t.start();
    }

}
