package com.in28minutes.learnspringframework.game;

public class MarioGame implements GamingConsole {
    public void up() {
        System.out.println("Jumping");
    }

    public void down() {
        System.out.println("Ducking");
    }

    public void left() {
        System.out.println("Walking back");
    }

    public void right() {
        System.out.println("Advancing");
    }
}
