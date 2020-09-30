package me.elspeth.dino.world.entities;

import java.awt.*;

public abstract class Entitiy {

    private final Rectangle bounds = new Rectangle();

    public Entitiy(int x, int y, int width, int height) {
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
    }

    protected Rectangle getBounds() {
        return bounds;
    }

    public boolean collides(Entitiy other) {
        return bounds.intersects(other.bounds);
    }

    abstract void update();

}
