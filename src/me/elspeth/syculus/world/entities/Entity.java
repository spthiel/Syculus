package me.elspeth.syculus.world.entities;

import me.elspeth.syculus.utils.DRectangle;
import me.elspeth.syculus.world.World;

import java.awt.*;


public abstract class Entity {

    public static double GRAVITY = .01d;
    public static double MINVY = 20d;

    private final DRectangle bounds = new DRectangle();
    private final boolean solid;
    private double vx, vy;

    public Entity(int x, int y, int width, int height, boolean solid) {
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
        this.solid = solid;
    }

    public DRectangle getBounds() {
        return bounds;
    }

    public boolean collides(Entity other) {
        return bounds.intersects(other.bounds);
    }

    public boolean isSolid() {
        return solid;
    }

    public void update() {
        vy -= GRAVITY;
        if(vy < -MINVY) {
            vy = -MINVY;
        }
        bounds.x += vx;
        bounds.y -= vy;
        boolean cant = World.instance.checkIntersects(this);
        if(cant) {
            bounds.x -= vx;
            bounds.y -= vy;
            vx = 0;
            vy = 0;
        }
    };

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)bounds.x, (int)bounds.y, (int)bounds.width, (int)bounds.height);
    }

    public abstract void onCollide();

}
