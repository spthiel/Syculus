package me.elspeth.dino.world.entities;

public class Player extends Entitiy{

    public Player() {
        super(100, 100, 100, 200);
    }

    private enum PlayerState {

        ONGROUND,
        JUMP,
        INAIR,
        DASHING

    }

    @Override
    void update() {



    }
}
