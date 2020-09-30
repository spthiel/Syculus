package me.elspeth.syculus;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyStates implements KeyListener {

    private static final boolean[] pressed = new boolean[500];

    public static boolean isPressed(int keycode) {
        return pressed[keycode];
    }

    public static int mapKeyCode(int code) {

        if(code <= 0x107) {
            return code;
        }

        if(code <= 0x20d) {
            return code - 0x200 + 0x108;
        }

        if(code <= 0xf00b) {
            return code - 0xf000 + 0x108 + 0xe;
        }

        if(code <= 0xffff) {
            return code - 0xff00 + 0x108 + 0xe + 0xc;
        }

        return 0;
    }

    public static int unmapKeyCode(int code) {
        if(code <= 0x107) {
            return code;
        }

        if(code <= 0x108 + 0xd) {
            return code + 0x200 - 0x108;
        }

        if(code <= 0x108 + 0xe + 0xb) {
            return code + 0xf000 - 0x108 - 0xe;
        }

        return code + 0xff00 - 0x108 - 0xe - 0xc;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[mapKeyCode(e.getKeyCode())] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[mapKeyCode(e.getKeyCode())] = false;
    }
}
