package me.elspeth.syculus.world;

import me.elspeth.syculus.utils.Vec2;
import me.elspeth.syculus.world.entities.Entity;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class World {

    public static World instance = new World();
    public static Vec2 origin;

    private final List<Entity> entities = new LinkedList<>();

    private World() {
        origin = new Vec2();
        origin.x = 0;
        origin.y = 0;
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void draw(Graphics g) {
        g.translate(origin.x, origin.y);
        entities.forEach(entity -> entity.draw(g));
    }

    public void registerEntitiy(Entity entity) {
        entities.add(entity);
    }

    public void unregisterEntity(Entity entity) {
        entities.remove(entity);
    }

    public boolean checkIntersects(Entity entity) {
        return entities.stream().filter(entity1 -> !Objects.equals(entity1, entity)).anyMatch(entity1 -> entity1.getBounds().intersects(entity.getBounds()));
    }

}
