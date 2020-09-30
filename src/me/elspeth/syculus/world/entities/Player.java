package me.elspeth.syculus.world.entities;

public class Player extends Entity {

    public Player() {
        super(100, 100, 100, 200, true);
    }

    private enum PlayerState {

        ONGROUND,
        JUMP,
        INAIR,
        DASHING

    }

    @Override
    public void update() {
        super.update();
        System.out.println(getBounds().y);

    }

    @Override
    public void onCollide() {

    }
}
